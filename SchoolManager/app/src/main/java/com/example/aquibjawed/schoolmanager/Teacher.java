package com.example.aquibjawed.schoolmanager;

import com.example.aquibjawed.schoolmanager.utility.MyLog;

import java.util.List;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class Teacher {
   private final String TAG="Teacher" ;
   private int node_id,gender_id,address_id,school_id;
   private String id,name,dob;
   private List<Integer> mob,qualification_id,subject_id;

    public Teacher(int node_id, int gender_id, int address_id, int school_id, String id, String name, String dob, List<Integer> mob, List<Integer> qualification_id, List<Integer> subject_id) {
        this.node_id = node_id;
        this.gender_id = gender_id;
        this.address_id = address_id;
        this.school_id = school_id;
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.mob = mob;
        this.qualification_id = qualification_id;
        this.subject_id = subject_id;
    }
    public void print(){
        MyLog.d(TAG,"node_id="+this.node_id+"gender_id="+this.gender_id+"address_id="+this.address_id+"school_id="+this.school_id+"id="+this.id+"name="+this.id+"name="+this.name+"dob="+this.dob+"mob="+this.mob+"qualification_id"+this.qualification_id+"subject_id="+this.subject_id);
    }
    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Integer> getMob() {
        return mob;
    }

    public void setMob(List<Integer> mob) {
        this.mob = mob;
    }

    public List<Integer> getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(List<Integer> qualification_id) {
        this.qualification_id = qualification_id;
    }

    public List<Integer> getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(List<Integer> subject_id) {
        this.subject_id = subject_id;
    }
}
