package com.example.aquibjawed.schoolmanager.utility;
/**
 * Created by saddam on 14/3/18.
 */

public class URLManager {
    private static final String BASE_URL="http://localhost/schoolManager/";
   public static String getStudentURL(){
       return BASE_URL+"student/";
   }
   public static String getStudentListURL(){return BASE_URL+"/studentlist/";}
   public static String getSchoolURL(){
       return BASE_URL;
   }
   public static String getClassURL(){
       return BASE_URL;
   }
   public static String getTeacherURL(){
       return BASE_URL;
   }
 public static String getParrentURL(){
       return BASE_URL;
 }

}
