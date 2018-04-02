package com.example.aquibjawed.schoolmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aquibjawed.schoolmanager.utility.SchoolManager;
import com.example.aquibjawed.schoolmanager.utility.StudentManager;
import com.example.aquibjawed.schoolmanager.utility.TeacherManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentManagerTest();
        SchoolManagerTest();
        TeacherManagerTest();


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
        sm.getSchoolList(new UpdateUI() {
            @Override
            public void updateUI(Object object) {
                List<School> schoolList=( List<School>)object;
            }
        });
        sm.getSchool(91, new UpdateUI() {
            @Override
            public void updateUI(Object object) {
                School school=(School) object;
            }
        });
    }

    private void TeacherManagerTest(){
        TeacherManager tm = TeacherManager.getInstance();
        tm.getTeacherList(91, new UpdateUI() {
            @Override
            public void updateUI(Object object) {
                List<Teacher> teacherList=( List<Teacher>)object;
            }
        });
        tm.getTeacher(146, new UpdateUI() {
            @Override
            public void updateUI(Object object) {
               Teacher teacher=(Teacher) object;
            }
        });

    }
}
