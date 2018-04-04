package com.school.manager.app.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by saddam on 17/3/18.
 */

public class MySharedPreferences {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private  final String PREFS_NAME="school_prefs";
    private final int URLS_COUNT_SIZE=50;
    private final String URL_COUNT="URL_COUNT";
    public final String TERMS_RESPONSE="TERMS_RESPONSE";
    public static MySharedPreferences getInstance() {
        if(instance==null) instance=new MySharedPreferences();
        return instance;
    }

    private static MySharedPreferences instance;
    private MySharedPreferences(){
        this.pref= AppController.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.editor=this.pref.edit();

    }
    public void setUrlResponse(String URL,String response){
       
    }
    public  void remove(String KEY){
        editor.remove(KEY);
        editor.commit();
    }
    public String get(String KEY){

        return this.pref.getString(KEY,null);
    }
    public void set(String KEY,String value){
        this.editor.putString(KEY,value);
        this.editor.apply();

    }

}
