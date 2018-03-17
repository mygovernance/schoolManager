package com.example.aquibjawed.schoolmanager.utility;

import android.os.AsyncTask;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by saddam on 16/3/18.
 */

public class ResponseManager {
    private final String TAG="ResponseManager";
    private String URL;
    private String response;
    private ResponseManager object;
    private ProcessFinish processFinish;

    public ResponseManager(String url,ProcessFinish processFinish){
        this.URL=url;
        this.object=this;
        this.processFinish=processFinish;
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
                    processFinish.onResponseReceived(response);
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
            MyLog.d(TAG,"Asynck Task finished");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}
