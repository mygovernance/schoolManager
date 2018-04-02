package com.example.aquibjawed.schoolmanager;

import com.example.aquibjawed.schoolmanager.utility.MyLog;

import java.util.List;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class Class
{   private final String TAG="Class";
    private int node_id;
    private int teacher_id;
    private int school_id;
     private String id,std,section;
     private List<Integer> main_subject_id,optional_subject_id;

    public Class(int node_id,int school_id, int teacher_id, String id, String std, String section, List<Integer> main_subject_id, List<Integer> optional_subject_id) {
        this.node_id = node_id;
        this.teacher_id = teacher_id;
        this.id = id;
        this.std = std;
        this.section = section;
        this.main_subject_id = main_subject_id;
        this.optional_subject_id = optional_subject_id;
    }
public void print(){
    MyLog.d(TAG,"node_id="+node_id+"teacher_id="+teacher_id+"id="+id+"std="+std+"section="+section+"main_subject_id="+main_subject_id+"optional_subject_id="+optional_subject_id);
}
    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }
    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Integer> getMain_subject_id() {
        return main_subject_id;
    }

    public void setMain_subject_id(List<Integer> main_subject_id) {
        this.main_subject_id = main_subject_id;
    }

    public List<Integer> getOptional_subject_id() {
        return optional_subject_id;
    }

    public void setOptional_subject_id(List<Integer> optional_subject_id) {
        this.optional_subject_id = optional_subject_id;
    }
}
