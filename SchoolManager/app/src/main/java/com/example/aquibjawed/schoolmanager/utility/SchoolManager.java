package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.School;

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

    private List<School> schools=null;
    private School school=null;


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

    public List<School> createSchool(String response){
        List<School> schoollist=new ArrayList<School>();
        return schoollist;
    }

    public List<School> getSchoolList(){
        ResponseManager responseManager = new ResponseManager(URLManager.getSchoolURL(), new ProcessFinish(){
            @Override
            public void onResponseReceived(String response) {
                // create schoollist
                schools=null;
                schools= createSchoolList(response);
            }
        });

        // may return null , because it is in different thread.
        return schools;
    }

    public School getSchool(int node_id){
        school=null;
        String url = URLManager.getSchoolURL()+node_id;
        ResponseManager responseManager = new ResponseManager(url, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                school= createSchoolList(response).get(0);
            }
        });
        return school;
    }

    private List<School> createSchoolList(String response) {
        List<School> schools = new ArrayList<School>();

        try {
            JSONArray schools_json = new JSONArray(response);
            for (int i = 0; i < schools_json.length(); i++) {
                // for each school.
                School school = null;
                int node_id = -1;
                String id = null;
                String registration_id = null;
                String board_id = null;
                String address_id = null;
                String name;

                // getting all the field of a school.
                JSONObject school_json = schools_json.getJSONObject(i);
                node_id = Integer.parseInt(school_json.getString("node_id"));

                //  Id is string need to change in future;
                id = school_json.getString("id");
                registration_id = school_json.getString("registration_id");
                board_id = school_json.getString("board_id");
                name = school_json.getString("name");
                address_id = school_json.getString("address_id");

                // new School
                school = new School(node_id, id, registration_id, board_id, address_id);
                schools.add(school);
            }
        } catch (JSONException e) {
            //
        }
        return schools;
    }

}
