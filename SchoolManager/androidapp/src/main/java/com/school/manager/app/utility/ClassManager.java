package com.school.manager.app.utility;

import com.school.manager.app.Class;
import com.school.manager.app.Student;
import com.school.manager.app.UpdateUI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saddam on 16/3/18.
 */

public class ClassManager {
private final String TAG="ClassManager";
private static ClassManager instance;
private ClassManager(){}
public static ClassManager getInstance(){
    if(instance==null)
        instance=new ClassManager();
    return instance;
}
public void getClass(int node_id_of_class, final UpdateUI updateUI){
    ResponseManager responseManager=new ResponseManager(URLManager.getClassURL() + node_id_of_class, new ProcessFinish() {
        @Override
        public void onResponseReceived(String response) {
            final List<Class> classList=createClass(response);
            if(classList!=null && classList.size()>0)
                updateUI.updateUI(classList.get(0));
            else
                updateUI.updateUI(null);
        }
    });

}
public void getClassOfSchool(final int node_id_of_school, final UpdateUI updateUI){
    ResponseManager responseManager=new ResponseManager(URLManager.getClassURL(), new ProcessFinish() {
        @Override
        public void onResponseReceived(String response) {
            final List<Class> classList=createClass(response);
            List<Class> ans=new ArrayList<>();
            for(Class aClass:classList)
                if (aClass.getSchool_id()==node_id_of_school)
                    ans.add(aClass);
            if(ans!=null && ans.size()>0)
                updateUI.updateUI(ans);
            else
                updateUI.updateUI(null);
        }
    });
}
    private List<Class> createClass(String response){
    List<Class> classList=new ArrayList<>();
    try{
        JSONArray json  =  new JSONArray(response);
        int n=json.length();
        for(int i=0;i<n;i++){
            JSONObject object=json.getJSONObject(i);
            int node_id,teacher_id,school_id;
            String id,std,section;
            JSONArray main_subject_id,optional_subject_id;
            List<Integer> main_subject_id_list,optional_subject_id_list;
            node_id=Integer.parseInt(object.getString("node_id"));
            teacher_id=Integer.parseInt(object.getString("teacher_id"));
            id=object.getString("id");
            std=object.getString("std");
            section=object.getString("section");
            school_id=Integer.parseInt(object.getString("school_id"));
           main_subject_id=object.getJSONArray("main_subject_id");
           main_subject_id_list=new ArrayList<>();
           for(int j=0;j<main_subject_id.length();j++)
               main_subject_id_list.add(Integer.parseInt(main_subject_id.getString(j)));
           optional_subject_id=object.getJSONArray("optional_subject_id");
           optional_subject_id_list=new ArrayList<>();
           for(int j=0;j<optional_subject_id.length();j++)
               optional_subject_id_list.add(Integer.parseInt(optional_subject_id.getString(j)));
           Class aClass=new Class(node_id,school_id,teacher_id,id,std,section,main_subject_id_list,optional_subject_id_list);
           classList.add(aClass);
           aClass.print();
        }


    }catch (JSONException e){
        MyLog.d(TAG,"Error " + e.toString());
    }
    return classList;
    }
}
