package com.school.manager.app;

import com.school.manager.app.utility.MyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class Parent{
    private final String TAG="Parent";
    private int node_id,occupation_id,address_id,gender_id;
    private String id,name,dob;
    private List<Integer> mob,qualification_id;
    private boolean is_alumuni;

    public Parent(int node_id, int occupation_id, int address_id, int gender_id, String id, String name, String dob, List<Integer> mob, List<Integer> qualification_id, boolean is_alumuni) {
        this.node_id = node_id;
        this.occupation_id = occupation_id;
        this.address_id = address_id;
        this.gender_id = gender_id;
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.mob = mob;
        this.qualification_id = qualification_id;
        this.is_alumuni = is_alumuni;
    }
    public void print(){
        MyLog.d(TAG,"node_id="+node_id+"occupation_id="+occupation_id+"address_id="+address_id+"gender_id="+gender_id+"id="+id+"name="+name+"dob="+dob+"mob="+mob+"quaification_id="+qualification_id+"is_alumuni="+is_alumuni);
    }
    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public int getOccupation_id() {
        return occupation_id;
    }

    public void setOccupation_id(int occupation_id) {
        this.occupation_id = occupation_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
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

    public boolean isIs_alumuni() {
        return is_alumuni;
    }

    public void setIs_alumuni(boolean is_alumuni) {
        this.is_alumuni = is_alumuni;
    }

}
