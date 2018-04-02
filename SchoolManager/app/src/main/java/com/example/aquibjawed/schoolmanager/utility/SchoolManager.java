package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.School;
import com.example.aquibjawed.schoolmanager.Student;
import com.example.aquibjawed.schoolmanager.UpdateUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by saddam on 15/3/18.
 */

public class SchoolManager {
    // this class is singleton
    private static SchoolManager schoolManager=null;

    public static SchoolManager getInsance(){
        if(schoolManager==null){
            schoolManager = new SchoolManager();
        }
        return schoolManager;
    }

    private SchoolManager(){
        // nothing
        // schools is stored in schools on getSchoolList call
    }

    private List<School> createSchool(String response){
        List<School> schoolList=new ArrayList<>();
        try {
            JSONArray json = new JSONArray(response);
            int n=json.length();
            for(int i=0;i<n;i++){
                int node_id,address_id,board_id;
                String name=null,id=null,registration_id=null;
                JSONObject object=json.getJSONObject(i);
                node_id=Integer.parseInt(object.getString("node_id"));
                id=object.getString("id");
                name=object.getString("name");
                address_id=Integer.parseInt(object.getString("address_id"));
                board_id=Integer.parseInt(object.getString("board_id"));
                School school=new School(node_id,name,id,registration_id,board_id,address_id);
                schoolList.add(school);
                school.print();
            }

        }catch (JSONException e){
            ///
        }
        return schoolList;
    }

    public void getSchoolList(final UpdateUI updateUI){
        ResponseManager responseManager=new ResponseManager(URLManager.getSchoolURL(), new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                List<School> schoolList=createSchool(response);
                updateUI.updateUI(schoolList);
            }
        });
    }

    public void getSchool(int node_id_of_school,final UpdateUI updateUI){
        ResponseManager responseManager=new ResponseManager(URLManager.getSchoolURL()+node_id_of_school, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                List<School> schoolList=createSchool(response);
                if(schoolList!=null && schoolList.size()>0)
                updateUI.updateUI(schoolList.get(0));
                else
                    updateUI.updateUI(null);
            }
        });
    }


}
