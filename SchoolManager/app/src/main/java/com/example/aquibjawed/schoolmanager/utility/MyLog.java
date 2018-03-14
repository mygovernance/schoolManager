package com.example.aquibjawed.schoolmanager.utility;

import android.util.Log;

/**
 * Created by saddam on 14/3/18.
 */

public class MyLog {
  private static final boolean DEBUG=true;
  private static final String APP_NAME="SchoolManager";
  public static void d(String TAG,String message){
    if(DEBUG) Log.d(APP_NAME+" "+TAG,message);

  }
  public static void e(String TAG,String messsage){
    if(DEBUG) Log.e(APP_NAME+" "+TAG,messsage);
  }
}
