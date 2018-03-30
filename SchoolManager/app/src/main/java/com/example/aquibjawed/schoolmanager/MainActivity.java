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
        StudentManagerTest();

    }
    private  void StudentManagerTest(){
       StudentManager.getInstance().getStudent(143, new UpdateUI() {
           @Override
           public void updateUI(Object object) {
            Student student=(Student) object;
           }
       });


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
