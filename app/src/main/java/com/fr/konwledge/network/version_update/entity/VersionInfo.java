package com.fr.konwledge.network.version_update.entity;

import java.io.Serializable;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 *
 * 版本更新实体类
 */
public class VersionInfo implements Serializable {

    /**
     * downloadUrl : app-release.apk
     * versionCode : 1
     * versionName : 1.0
     * updateMessage :
     */

    private String downloadUrl;
    private int versionCode;
    private String versionName;
    private String updateMessage;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }
}
