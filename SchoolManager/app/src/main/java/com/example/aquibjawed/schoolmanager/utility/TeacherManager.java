package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.Person;
import com.example.aquibjawed.schoolmanager.PersonName;
import com.example.aquibjawed.schoolmanager.Teacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * Created by saddam on 15/3/18.
 */

public class TeacherManager {
    // Singleton class

    private static String TAG = "TeacherManager";
    private static TeacherManager inst= null;
    List<Teacher> teachers;
    Teacher teacher;

    public static TeacherManager getInstance(){
        if(inst==null){
            inst= new TeacherManager();
        }
        return inst;
    }

    private TeacherManager(){
        //
    }

    public List<Teacher> getTeacherList(){
        String url = URLManager.getTeacherURL();
        teachers=null;
        ResponseManager rm = new ResponseManager(url, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                teachers = createTeacherList(response);
            }
        });
        return teachers;
    }

    public Teacher getTeacher(int node_id){
        teacher=null;
        String url = URLManager.getTeacherURL()+node_id;
        ResponseManager rm=  new ResponseManager(url,new ProcessFinish(){
            @Override
            public void onResponseReceived(String response) {
                teacher = createTeacherList(response).get(0);
            }
        });
        return teacher;
    }

    private List<Teacher> createTeacherList(String jsonResponse){
        List<Teacher> teachersList=new ArrayList<>();

        SimpleDateFormat dateFormat  = new SimpleDateFormat("YYYY-MM-DD");
        try{
            JSONArray teachers_json  =  new JSONArray(jsonResponse);
            for(int i=0; i<teachers_json.length(); i++){
                JSONObject teacher_json = teachers_json.getJSONObject(i);

                //
                PersonName name;
                Date date=null;
                String id="";
                int node_id=-1;
                String gender_id="";
                String qualification_id="";
                String school_id="";
                String subject_id="";
                String dob_id="";

                name = new PersonName(teacher_json.getString("name"));

                // geting DOB
                dob_id = teacher_json.getString("dob");
                try {
                    date = dateFormat.parse(dob_id);
                }catch(ParseException d){
                    MyLog.d(TAG,"ParseException Error" );
                }

                // qualification, school, subject, gender,id
                qualification_id = teacher_json.getString("qualification_id");
                school_id = teacher_json.getString("school_id");
                gender_id = teacher_json.getString("gender_id");
                id = teacher_json.getString("id");
                school_id = teacher_json.getString("school_id");

                Person p = new Person(name,date,gender_id);
                Teacher t = new Teacher(p,id,qualification_id,subject_id,school_id);
                teachersList.add(t);
            }

        }catch(JSONException e){
            MyLog.d(TAG,"ERROr " + e.toString());
        }

        return teachersList;

    }

}
