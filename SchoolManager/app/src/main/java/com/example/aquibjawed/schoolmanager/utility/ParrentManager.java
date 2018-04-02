package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.Parent;
import com.example.aquibjawed.schoolmanager.Student;
import com.example.aquibjawed.schoolmanager.Teacher;
import com.example.aquibjawed.schoolmanager.UpdateUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saddam on 15/3/18.
 */

public class ParrentManager {
private final String TAG="ParrentManager";
private static ParrentManager instance;

private ParrentManager(){

}
public static ParrentManager getInstance(){
    if(instance==null)
        instance=new ParrentManager();
    return instance;
}
public void getParrent(int node_id_of_parrent,final UpdateUI updateUI){
    ResponseManager responseManager=new ResponseManager(URLManager.getParrentURL() + node_id_of_parrent, new ProcessFinish() {
        @Override
        public void onResponseReceived(String response) {
            final List<Parent> parentList=createParrent(response);
            if(parentList!=null && parentList.size()>0)
                updateUI.updateUI(parentList.get(0));
            else
                updateUI.updateUI(null);
        }
    });
}
public void getParrentList(){

}
    private List<Parent> createParrent(String response){
        List<Parent> parrentlist=new ArrayList<>();
        try{
            JSONArray teachers_json  =  new JSONArray(response);
            int n=teachers_json.length();
            for(int i=0; i<n; i++){
                int node_id,gender_id,address_id,occupation_id;
                String id,name,dob;
                boolean is_alumuni;
                JSONArray mob,qualification_id;
                List<Integer> mob_list,qualification_id_list;
                JSONObject object = teachers_json.getJSONObject(i);
                node_id=Integer.parseInt(object.getString("node_id"));
                id=object.getString("id");
                name=object.getString("name");
                gender_id=Integer.parseInt(object.getString("gender_id"));
                is_alumuni=Boolean.parseBoolean(object.getString("is_alumuni"));
                dob=object.getString("dob");
                occupation_id=Integer.parseInt(object.getString("occupation_id"));
                mob=object.getJSONArray("mob");
                mob_list=new ArrayList<>();
                for(int j=0;j<mob.length();j++)
                    mob_list.add(Integer.parseInt(mob.getString(j)));
                address_id=Integer.parseInt(object.getString("address_id"));
                qualification_id=object.getJSONArray("qualification_id");
                qualification_id_list=new ArrayList<>();
                for(int j=0;j<qualification_id.length();j++)
                    qualification_id_list.add(Integer.parseInt(qualification_id.getString(j)));
                Parent parent=new Parent(node_id,occupation_id,address_id,gender_id,id,name,dob,mob_list,qualification_id_list,is_alumuni);
                parrentlist.add(parent);
                parent.print();


            }

        }catch(JSONException e){
            MyLog.d(TAG,"ERROr " + e.toString());
        }
        return parrentlist;
    }
}
