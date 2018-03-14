package com.example.aquibjawed.schoolmanager.utility;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by saddam on 14/3/18.
 */

public class NetworkApiManager {
    private RequestQueue queue;
    private static NetworkApiManager instance;
    private static final String TAG="NetworkApiManager";
    private NetworkApiManager(Context con){
       this.queue= Volley.newRequestQueue(con);
       this.queue.start();
    }
    public static NetworkApiManager getInstance(Context con){
        if(con==null) return null;
        if(instance==null)
            instance=new NetworkApiManager(con);
        return instance;
    }
    public void sendGetRequest(String url, Response.Listener<String> responseListner,Response.ErrorListener errorListener){
        StringRequest urlRequest=new StringRequest(Request.Method.GET,url,responseListner,errorListener);
        if(this.queue!=null){
            this.queue.add(urlRequest);


        }
    }
}
