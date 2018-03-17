package com.example.aquibjawed.schoolmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aquibjawed.schoolmanager.utility.StudentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentManagerTest();

    }
    private  void StudentManagerTest(){
        Student student= StudentManager.getInstance().getStudent(150);
       // student.print();
    }
}
