package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.Address;
import com.example.aquibjawed.schoolmanager.Assignment;
import com.example.aquibjawed.schoolmanager.UpdateUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saddam on 18/3/18.
 */

public class AssignmentManager {
private final String TAG="AssignmentManager";
private static AssignmentManager instance;
private AssignmentManager(){}
public static AssignmentManager getInstance(){
    if(instance==null)
        instance=new AssignmentManager();
    return instance;
}
public void downloadAssignment(Assignment assignment,UpdateUI updateUI){
   updateUI.updateUI(null);
}
public void getAssignment(int node_id_of_assignment, final UpdateUI updateUI){
    ResponseManager responseManager=new ResponseManager(URLManager.getAssigmnetInfoURL()+node_id_of_assignment, new ProcessFinish() {
        @Override
        public void onResponseReceived(String response) {
            List<Assignment> assignmentList=createAssignment(response);
            if(assignmentList!=null && assignmentList.size()>0)
            updateUI.updateUI(assignmentList.get(0));
            else updateUI.updateUI(null);

        }
    });
}
public void getClassAssignmentList(int node_id_of_class, final UpdateUI updateUI){
        ResponseManager responseManager=new ResponseManager(URLManager.getClassAssigmnetListURL()+node_id_of_class, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                List<Assignment> assignmentList=createAssignment(response);
                    updateUI.updateUI(assignmentList);

            }
        });
    }
public void getSchoolAssignmentList(int node_id_of_school, final UpdateUI updateUI){
        ResponseManager responseManager=new ResponseManager(URLManager.getSchoolAssigmnetListURL()+node_id_of_school, new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                List<Assignment> assignmentList=createAssignment(response);
                updateUI.updateUI(assignmentList);

            }
        });
    }
private List<Assignment> createAssignment(String response){
    List<Assignment> assignmentList=new ArrayList<>();
    try{
        JSONArray json  =  new JSONArray(response);
        int n=json.length();
        for(int i=0;i<n;i++){
            int node_id,class_id;
            String title,file_url,image_url;
            JSONObject object=json.getJSONObject(i);
            node_id=Integer.parseInt(object.getString("node_id"));
            class_id=Integer.parseInt(object.getString("class_id"));
            title=object.getString("title");
            file_url=object.getString("file_url");
            image_url=object.getString("image_url");
            Assignment assignment=new Assignment(node_id,class_id,title,file_url,image_url);
            assignmentList.add(assignment);
            assignment.print();
        }

    }catch(JSONException e){MyLog.d(TAG,"Error " + e.toString());}
    return assignmentList;
}
}
