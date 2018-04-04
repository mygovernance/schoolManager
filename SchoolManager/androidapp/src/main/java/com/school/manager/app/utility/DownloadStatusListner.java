package com.school.manager.app.utility;

/**
 * Created by saddam on 20/3/18.
 */

public interface DownloadStatusListner {

    void onProgress();
    void onDownloadComplete();
    void onDownlaodStatusChanged();
}
