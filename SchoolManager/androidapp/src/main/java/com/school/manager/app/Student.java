package com.school.manager.app;

import com.school.manager.app.utility.MyLog;

import java.util.Date;
import java.util.List;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class Student {
private final String TAG="Student";
private int node_id,gender_id,address_id,school_id,class_id,parrent_id,guardian_id;
private String name,dob,enrollment_id,id;
private List<Integer> optional_subject_id_list;

public Student(int node_id,String id,String enrollment_id,String name,String dob,int gender_id,int address_id,List<Integer> optional_subject_id_list,int school_id,int class_id,int parrent_id,int guardian_id){
        this.node_id=node_id;
        this.id=id;
        this.enrollment_id=enrollment_id;
        this.name=name;
        this.dob=dob;
        this.gender_id=gender_id;
        this.address_id=address_id;
        this.optional_subject_id_list=optional_subject_id_list;
        this.school_id=school_id;
        this.class_id=class_id;
        this.parrent_id=parrent_id;
        this.guardian_id=guardian_id;
}
//only for debugging purpose to print student info
public void print(){
        MyLog.d(TAG,"node_id="+node_id+" id="+id+" enrollment_id="+enrollment_id+" name="+name+" dob="+dob+" gender_id="+gender_id+" address_id="+address_id+" optional_subject_id="+optional_subject_id_list+" school_id="+school_id+" class_id="+class_id+" parrent_id="+parrent_id+" guardian_id="+guardian_id);
}
//implement get and setter for student all fields
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

public int getClass_id() {
        return class_id;
}

public void setClass_id(int class_id) {
        this.class_id = class_id;
}

public int getParrent_id() {
        return parrent_id;
}

public void setParrent_id(int parrent_id) {
        this.parrent_id = parrent_id;
}

public int getGuardian_id() {
        return guardian_id;
}

public void setGuardian_id(int guardian_id) {
        this.guardian_id = guardian_id;
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

public String getEnrollment_id() {
        return enrollment_id;
}

public void setEnrollment_id(String enrollment_id) {
        this.enrollment_id = enrollment_id;
}

public String getId() {
        return id;
}

public void setId(String id) {
        this.id = id;
}

public List<Integer> getOptional_subject_id_list() {
        return optional_subject_id_list;
}

public void setOptional_subject_id_list(List<Integer> optional_subject_id_list) {
        this.optional_subject_id_list = optional_subject_id_list;
}


}
