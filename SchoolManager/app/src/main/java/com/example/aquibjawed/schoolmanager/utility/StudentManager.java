package com.example.aquibjawed.schoolmanager.utility;
import com.example.aquibjawed.schoolmanager.Class;
import com.example.aquibjawed.schoolmanager.School;
import com.example.aquibjawed.schoolmanager.Student;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saddam on 14/3/18.
 */

public class StudentManager{
private static StudentManager instance;
private Map<String,List<Student>> students;
private StudentManager(){
this.students=new HashMap<>();
}
public static StudentManager getInstance(){if(instance==null) instance=new StudentManager();
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
    public Student getStudent(int node_id_of_student){
        MyThread thread=new MyThread(URLManager.getStudentURL()+node_id_of_student);
        thread.start();
        try{
            thread.join();
        }catch(InterruptedException e){}
        List<Student> studentList=createStudent(thread.getResponse());
        if(studentList!=null && studentList.size()>0)
            return studentList.get(0);
     return null;
    }
    public List<Student> getStudentList(School school){
        if(this.students.get(school.getNode_id()+"")!=null)
            return this.makeCopy(this.students.get(school.getNode_id()+""));
    MyThread thread=new MyThread(URLManager.getStudentListURL()+school.getNode_id());
    thread.start();
    try{
        thread.join();
    } catch (InterruptedException e){}
    List<Student> studentList=createStudent(thread.getResponse());
    if(studentList!=null && studentList.size()>0)
        return studentList;
    return null;
    }
    public List<Student> getStudentList(School school,Class clas){
    List<Student> studentList=this.getStudentList(school);
    List<Student> newstudentList=new ArrayList<Student>();
    for(Student student:studentList)
    {
        if(student.getNode_id_of_class()!=clas.getNode_id())
              newstudentList.add(student);

    }
    this.students.put(school.getNode_id()+"",newstudentList);
    return this.makeCopy(newstudentList);
    }
    public boolean updateStudent(Student student){

        return true;
    }
    private List<Student> createStudent(String response){
        List<Student> studentList=new ArrayList<Student>();
        try {
           JSONArray json = new JSONArray(response);


        }catch (JSONException e){}
    return studentList;
    }
}
