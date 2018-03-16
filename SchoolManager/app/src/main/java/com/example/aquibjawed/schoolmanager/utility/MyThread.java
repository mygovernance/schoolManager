package com.example.aquibjawed.schoolmanager.utility;

import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by saddam on 14/3/18.
 */

public class MyThread  extends  Thread {
    private String URL;
    private String response;
    private MyThread object;
    private final String TAG="MyThread";

    public MyThread(String URL) {
        this.URL = URL;
        this.object=this;
    }
public String getResponse(){
        return object.response;
}
    @Override
    public void run() {

    }



}
