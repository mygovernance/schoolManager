package com.example.aquibjawed.schoolmanager.utility;
/**
 * Created by saddam on 14/3/18.
 */

public class URLManager {
    private static final String BASE_URL="http://geotechenergy.in/";
   //url related to student
   public static String getStudentURL(){
       return BASE_URL+"student/";
   }
   public static String getStudentListURL(){
        return BASE_URL+"studentlist/";
   }
   public static String getTermsURL(){return BASE_URL+"term/";}

   //url related to school
   public static String getSchoolURL(){
       return BASE_URL+ "school/";
   }

    public static String getClassURL(){
       return BASE_URL;
   }
    public static String getTeacherURL(){
       return BASE_URL +"teacher/";
   }
    public static String getTeacherListURL(){
        return BASE_URL+"teacherlist/";
    }
    public static String getAddressURL(){return  BASE_URL+"address/";}
    public static String getParrentURL(){
       return BASE_URL;
 }
}
