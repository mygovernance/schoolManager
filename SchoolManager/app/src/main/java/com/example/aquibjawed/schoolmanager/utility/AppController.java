package com.example.aquibjawed.schoolmanager.utility;

import android.app.Application;
import android.content.Context;

/**
 * Created by saddam on 14/3/18.
 */

public class AppController extends Application{private static AppController instance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
