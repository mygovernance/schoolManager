package com.example.aquibjawed.schoolmanager;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class PersonName {
    private String first_name;
    private String middle_name;
    private String last_name;

    public PersonName(String first_name, String middle_name, String last_name) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
    }

    public PersonName(String first_name) {
        this.first_name=first_name;
        this.middle_name="";
        this.last_name="";
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
