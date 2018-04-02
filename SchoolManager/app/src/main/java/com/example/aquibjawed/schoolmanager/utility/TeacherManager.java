package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.Student;
import com.example.aquibjawed.schoolmanager.Teacher;
import com.example.aquibjawed.schoolmanager.UpdateUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saddam on 15/3/18.
 */

public class TeacherManager {
    // Singleton class

    private static String TAG = "TeacherManager";
    private static TeacherManager inst= null;
    private Map<String,List<Teacher>> teachers;

    public static TeacherManager getInstance(){
        if(inst==null){
            inst= new TeacherManager();
        }
        return inst;
    }

    private TeacherManager(){
        //
        teachers=new HashMap<>();
    }
    //return copy of teacher list so that teacher list from school manager would never changed
    private List<Teacher> makeCopy(List<Teacher> teacherList) {
        if(teacherList==null)
            return null;

        List<Teacher> res=new ArrayList<>();
        for (Teacher teacher:teacherList)
            res.add(teacher);
        return res;
    }
    //return all teachers of given school with node_id
    public void getTeacherList(int node_id_of_school, final UpdateUI updateUI){
        if(this.teachers.get(node_id_of_school)!=null){
            List<Teacher> teacherList= this.makeCopy(this.teachers.get(node_id_of_school));
            updateUI.updateUI(teacherList);
            return;
        }
        ResponseManager responseManager=new ResponseManager(URLManager.getTeacherListURL() + node_id_of_school, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                List<Teacher> teacherList=createTeacherList(response);
                updateUI.updateUI(teacherList);
            }
        });
    }

    public void getTeacher(int node_id_of_teacher, final  UpdateUI updateUI){
        ResponseManager responseManager=new ResponseManager(URLManager.getTeacherURL() + node_id_of_teacher, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                final List<Teacher> teacherList=createTeacherList(response);
                if(teacherList!=null && teacherList.size()>0)
                    updateUI.updateUI(teacherList.get(0));
                else
                    updateUI.updateUI(null);
            }
        });
    }

    private List<Teacher> createTeacherList(String jsonResponse){
        List<Teacher> teachersList=new ArrayList<>();
        try{
            JSONArray teachers_json  =  new JSONArray(jsonResponse);
            int n=teachers_json.length();
            for(int i=0; i<n; i++){
              int node_id,gender_id,address_id,school_id;
              String id,name,dob;
              JSONArray mob,subject_id,qualification_id;
              List<Integer> mob_list,subject_id_list,qualification_id_list;
                JSONObject object = teachers_json.getJSONObject(i);
              node_id=Integer.parseInt(object.getString("node_id"));
              id=object.getString("id");
              name=object.getString("name");
              gender_id=Integer.parseInt(object.getString("gender_id"));
              dob=object.getString("dob");
              mob=object.getJSONArray("mob");
              mob_list=new ArrayList<>();
              for(int j=0;j<mob.length();j++)
                  mob_list.add(Integer.parseInt(mob.getString(j)));
              address_id=Integer.parseInt(object.getString("address_id"));
              qualification_id=object.getJSONArray("qualification_id");
                qualification_id_list=new ArrayList<>();
                for(int j=0;j<qualification_id.length();j++)
                    qualification_id_list.add(Integer.parseInt(qualification_id.getString(j)));

                school_id=Integer.parseInt(object.getString("school_id"));

                subject_id=object.getJSONArray("subject_id");
                subject_id_list=new ArrayList<>();
                for(int j=0;j<subject_id.length();j++)
                    subject_id_list.add(Integer.parseInt(subject_id.getString(j)));
               Teacher teacher=new Teacher(node_id,gender_id,address_id,school_id,id,name,dob,mob_list,qualification_id_list,subject_id_list);
               teachersList.add(teacher);
               teacher.print();

            }

        }catch(JSONException e){
            MyLog.d(TAG,"ERROr " + e.toString());
        }

        return teachersList;

    }

}
