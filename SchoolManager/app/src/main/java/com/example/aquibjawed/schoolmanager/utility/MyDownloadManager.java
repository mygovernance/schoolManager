package com.example.aquibjawed.schoolmanager.utility;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

/**
 * Created by saddam on 20/3/18.
 */

public class MyDownloadManager {
    private DownloadStatusListner listner;
    public MyDownloadManager(){

    }

public void download(DownloadStatusListner listner,String url){
    this.listner=listner;

}

private class DownaloadSynckTask extends AsyncTask<String,String,String>{
private long downlaodID;
private String getFileName(String url){
    String fileName = url.substring(url.lastIndexOf('/') + 1);
    return fileName;
}
private long getDownlaodID(String url){
    long downloadID=-1;
    Uri uri=Uri.parse(url);
    DownloadManager downloadManager=(DownloadManager) AppController.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
    DownloadManager.Request request=new DownloadManager.Request(uri);
    request.setDestinationInExternalFilesDir(AppController.getContext(), Environment.DIRECTORY_DOWNLOADS,getFileName(url));
    downloadID=downloadManager.enqueue(request);
    this.downlaodID=downloadID;
    return downloadID;
}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
     long downloadID=getDownlaodID(strings[0]);
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
}
