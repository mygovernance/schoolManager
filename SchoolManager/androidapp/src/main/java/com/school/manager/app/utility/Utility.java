package com.school.manager.app.utility;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import java.io.File;

/**
 * Created by saddam on 3/4/18.
 */

public class Utility {
 private static final String TAG="Utility";
 private static  final String dir_name="/myschool/";
public static String getFileLocation(){
    return Environment.getExternalStorageDirectory().getAbsolutePath() +dir_name;
}
public static File createFile(String file_name){
    File sdcard = Environment.getExternalStorageDirectory();
    File dir = new File(sdcard.getAbsolutePath() +dir_name);
    dir.mkdir();
    File file = new File(dir,Utility.getFileName(file_name));
    return file;
}
public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }
public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

public static String getFileName(String url){
        String fileName = url.substring(url.lastIndexOf('/') + 1);
        return fileName;
    }
public static boolean isConnectedToInternet() {
        ConnectivityManager cm = (ConnectivityManager)AppController.getContext().getSystemService(AppController.getContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
