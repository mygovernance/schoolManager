package com.example.aquibjawed.schoolmanager;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class Teacher {
    private Person teacher;
    private String ID;
    private String qualification_id;
    private String subject_id;
    private String school_id;


    public Teacher(Person teacher, String ID) {
        this.teacher = teacher;
        this.ID = ID;
    }

    public Teacher(Person teacher, String ID, String qualification_id, String subject_id, String school_id) {
        this.teacher = teacher;
        this.ID = ID;
        this.qualification_id = qualification_id;
        this.subject_id = subject_id;
        this.school_id = school_id;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(String qualification_id) {
        this.qualification_id = qualification_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }
}
