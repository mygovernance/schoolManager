package com.school.manager.app.utility;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.school.manager.app.R;
import com.school.manager.app.UpdateUI;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by saddam on 20/3/18.
 */

public class MyDownloadManager {
private final String TAG="MyDownloadManager";
private ProgressDialog progressDialog;
private UpdateUI updateUI;
public MyDownloadManager(){
    progressDialog=new ProgressDialog(AppController.getContext());
    }
public void download(String url, UpdateUI updateUI){
this.updateUI=updateUI;
DownaloadAsynckTask task=new DownaloadAsynckTask();
task.execute(url);
}

private class DownaloadAsynckTask extends AsyncTask<String,String,String>{
private String downlaoding_file_name;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.dismiss();
        progressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        progressDialog.setTitle(AppController.getContext().getString(R.string.loading_title));
        progressDialog.setMessage(AppController.getContext().getString(R.string.loading_msg));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        int count;
        try {
            String file_name=Utility.getFileName(strings[0]);
            downlaoding_file_name=file_name;
            File file=Utility.createFile(file_name);
            URL url = new URL(strings[0]);
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            OutputStream output = new FileOutputStream(file);
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
            //Toast.makeText(AppController.getContext(),downlaoding_file_name+" file downaloaded sucessfully to "+Utility.getFileLocation(),Toast.LENGTH_SHORT).show();
            //updateUI.updateUI(null);

        } catch (Exception e) {
            progressDialog.dismiss();
           MyLog.e(TAG,"Error while downloading");
           MyLog.e(TAG,e.toString());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        progressDialog.setProgress(Integer.parseInt(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();

    }
}
}
