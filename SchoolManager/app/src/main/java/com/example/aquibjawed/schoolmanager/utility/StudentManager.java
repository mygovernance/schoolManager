package com.example.aquibjawed.schoolmanager.utility;
import android.util.Log;

import com.example.aquibjawed.schoolmanager.Class;
import com.example.aquibjawed.schoolmanager.School;
import com.example.aquibjawed.schoolmanager.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saddam on 14/3/18.
 */

public class StudentManager{
private final String TAG="StudentManager";
private static StudentManager instance;
private Map<String,List<Student>> students;

private StudentManager(){
this.students=new HashMap<>();
}

//return instance of this class
public static StudentManager getInstance(){
    if(instance==null) instance=new StudentManager();

    return instance;
}


//return copy of student list so that student list from school manager would never changed
private List<Student> makeCopy(List<Student> studentList) {
    if(studentList==null)
        return null;
    List<Student> res=new ArrayList<>();
    for (Student student:studentList)
        res.add(student);
    return res;

}
//return a student with given node_id
private Student student;
public Student getStudent(int node_id_of_student){
ResponseManager responseManager=new ResponseManager(URLManager.getStudentURL() + node_id_of_student, new ProcessFinish() {
    @Override
    public void onResponseReceived(String response) {
        final List<Student> studentList=createStudent(response);
        if(studentList!=null && studentList.size()>0)
            student=studentList.get(0);
    }
});

     return student;
}



//return all students of given school with node_id
List<Student> studentList;
public List<Student> getStudentList(int node_id_of_school){
        if(this.students.get(node_id_of_school)!=null)
         return this.makeCopy(this.students.get(node_id_of_school));
ResponseManager responseManager=new ResponseManager(URLManager.getStudentListURL() + node_id_of_school, new ProcessFinish() {
    @Override
    public void onResponseReceived(String response) {
        studentList=createStudent(response);

    }
});
    return studentList;
}


//return all students of given school and class
public List<Student> getStudentList(int node_id_of_school,int node_id_class){
    List<Student> studentList=this.getStudentList(node_id_of_school);
    List<Student> newstudentList=new ArrayList<Student>();
    for(Student student:studentList)
    {
        if(student.getClass_id()!=node_id_class)
              newstudentList.add(student);

    }
    return newstudentList;
}

//update given student information
//return true if updated sucessfully
public boolean updateStudent(Student student){

        return true;
}

//parse response and create list of students.
//return list of students
private List<Student> createStudent(String response){
List<Student> studentList=new ArrayList<Student>();
        try {
           JSONArray json = new JSONArray(response);
           int n=json.length();
           for(int i=0;i<n;i++){
               JSONObject object=json.getJSONObject(i);
               int node_id=-1,gender_id=-1,address_id=-1,school_id=-1,class_id=-1,parrent_id=-1,guardian_id=-1;
               String name=null,dob=null,enrollment_id=null,id=null;
               JSONArray optional_subject_id;
               List<Integer> optional_subject_id_list;
               node_id=Integer.parseInt(object.getString("node_id"));
               id=object.getString("id");
               enrollment_id=object.getString("enrollment_id");
               name=object.getString("name");
               dob=object.getString("dob");
               gender_id=Integer.parseInt(object.getString("gender_id"));
               address_id=Integer.parseInt(object.getString("address_id"));
               optional_subject_id=object.getJSONArray("optional_subject_id");
               optional_subject_id_list=new ArrayList<>();
               for(int j=0;j<optional_subject_id.length();j++)
               optional_subject_id_list.add(Integer.parseInt(optional_subject_id.getString(j)));
               school_id=Integer.parseInt(object.getString("school_id"));
               class_id=Integer.parseInt(object.getString("class_id"));
               parrent_id=Integer.parseInt(object.getString("parrent_id"));
               guardian_id=Integer.parseInt(object.getString("guardian_id"));

Student student=new Student(node_id,id,enrollment_id,name,dob,gender_id,address_id,optional_subject_id_list,school_id,class_id,parrent_id,guardian_id);
studentList.add(student);
           }

        }catch (JSONException e){}
    return studentList;
}
}
