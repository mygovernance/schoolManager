package com.school.manager.app;

import com.school.manager.app.utility.MyLog;

/**
 * Created by saddam on 18/3/18.
 */

public class Assignment {
    private final String TAG="Assignment";
    private int node_id,class_id;
    private String title,file_url,image_url;

    public Assignment(int node_id, int class_id, String title, String file_url, String image_url) {
        this.node_id = node_id;
        this.class_id = class_id;
        this.title = title;
        this.file_url = file_url;
        this.image_url = image_url;
    }
   public void print(){
       MyLog.d(TAG,"node_id="+node_id+" class_id="+class_id+" title="+title+" file_url="+file_url+" image_url="+image_url);
   }
    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
