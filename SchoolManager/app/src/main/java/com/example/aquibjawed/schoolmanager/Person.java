package com.example.aquibjawed.schoolmanager;

import java.util.Date;

/**
 * Created by aquibjawed on 13/03/18.
 */

public class Person {
    private PersonName name;
    private Date dob;
    private String gender;

    public Person(PersonName name, Date dob, String gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

}
