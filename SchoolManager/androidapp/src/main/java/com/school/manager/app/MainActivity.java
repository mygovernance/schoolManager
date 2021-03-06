package com.school.manager.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.school.manager.app.utility.AddressManager;
import com.school.manager.app.utility.AppController;
import com.school.manager.app.utility.AssignmentManager;
import com.school.manager.app.utility.SchoolManager;
import com.school.manager.app.utility.StudentManager;
import com.school.manager.app.utility.TeacherManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentManagerTest();
        SchoolManagerTest();
        TeacherManagerTest();
        AddressManagerTest();
        AssignmentManagerTest();

    }
    private void AssignmentManagerTest(){
        final AssignmentManager am=AssignmentManager.getInstance();
       am.getAssignment(5088, new UpdateUI() {
           @Override
           public void updateUI(Object object) {
               Assignment assignment=(Assignment)object;
               am.downloadAssignment(assignment, new UpdateUI() {
                   @Override
                   public void updateUI(Object object) {
                       Toast.makeText(AppController.getContext(),"Download sucessfull",Toast.LENGTH_SHORT).show();

                   }
               });

           }
       });

       am.getClassAssignmentList(5025, new UpdateUI() {
           @Override
           public void updateUI(Object object) {
               List<Assignment> assignmentList=(List<Assignment>)object;
               for(Assignment assignment:assignmentList)
                   am.downloadAssignment(assignment, new UpdateUI() {
                       @Override
                       public void updateUI(Object object) {

                       }
                   });
           }
       });
    }

    private void AddressManagerTest(){
        AddressManager am=AddressManager.getInstance();
        am.getAddress(88, new UpdateUI() {
            @Override
            public void updateUI(Object object) {
                Address address=(Address)object;
            }
        });

        am.getAddressList(new UpdateUI() {
            @Override
            public void updateUI(Object object) {
                List<Address> addressList=(List<Address>)object;
            }
        });
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
