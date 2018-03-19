package com.example.aquibjawed.schoolmanager.utility;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.WindowManager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.aquibjawed.schoolmanager.R;

/**
 * Created by saddam on 16/3/18.
 */

public class ResponseManager {
    private final String TAG="ResponseManager";
    private String URL;
    private String response;
    private ResponseManager object;
    private ProcessFinish processFinish;
    private ProgressDialog progressDialog;
    private boolean isfinished;
    public ResponseManager(String url,ProcessFinish processFinish){
        this.URL=url;
        this.object=this;
        this.processFinish=processFinish;
        this.progressDialog=new ProgressDialog(AppController.getContext());
        this.isfinished=false;
        new MyAsynckTask().execute(this.URL);
    }

    private class MyAsynckTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
            progressDialog.dismiss();
           // progressDialog.setTitle(AppController.getContext().getString(R.string.loading_title));
            progressDialog.setMessage(AppController.getContext().getString(R.string.loading_msg));
            progressDialog.setCancelable(false);
            progressDialog.show();
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
            isfinished=true;
           progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}
