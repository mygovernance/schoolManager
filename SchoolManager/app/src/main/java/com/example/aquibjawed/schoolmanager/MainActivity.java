package com.example.aquibjawed.schoolmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aquibjawed.schoolmanager.utility.SchoolManager;
import com.example.aquibjawed.schoolmanager.utility.StudentManager;
import com.example.aquibjawed.schoolmanager.utility.TeacherManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TeacherManagerTest();

    }
    private  void StudentManagerTest(){
        Student student= StudentManager.getInstance().getStudent(150);
       // student.print();
    }


    private void SchoolManagerTest(){
        SchoolManager sm = SchoolManager.getInsance();
        sm.getSchoolList();
    }

    private void TeacherManagerTest(){
        TeacherManager tm = TeacherManager.getInstance();
        tm.getTeacher(83);
    }
}
