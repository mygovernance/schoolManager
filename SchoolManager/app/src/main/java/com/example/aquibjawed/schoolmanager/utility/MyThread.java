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
   new MyAsynckTask().execute(this.URL);

    }

    private class MyAsynckTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            MyLog.d(TAG,"URL="+strings[0]);
NetworkApiManager.getInstance(AppController.getContext()).sendGetRequest(strings[0], new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                MyLog.d(TAG,"response="+response);
                object.response=response;
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             MyLog.e(TAG,"Error response from server");
             MyLog.e(TAG,"volley error="+error.toString());
            }
        }
);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

}
