package com.fr.knowledge.network.download.httpdowonload;

import com.fr.knowledge.network.download.http.HttpService;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class DownInfo {
    //存储位置
    private String savePath;
    //下载url
    private String url;
    //基础url
    private String baseUrl;
    //文件总长度
    private long countLength;
    //下载长度
    private long readLength;
    //下载唯一的HttpService
    private HttpService service;

    //超时设置
    private int DEFAULT_TIMEOUT = 6;
    //下载状态
    private DownState state;

    public DownState getState() {
        return state;
    }

    public void setState(DownState state) {
        this.state = state;
    }

    public DownInfo(String url) {
        setUrl(url);
        setBaseUrl(getBasUrl(url));
    }

    public DownInfo() {

    }

    public int getConnectionTime() {
        return DEFAULT_TIMEOUT;
    }

    public void setConnectionTime(int DEFAULT_TIMEOUT) {
        this.DEFAULT_TIMEOUT = DEFAULT_TIMEOUT;
    }

    public HttpService getService() {
        return service;
    }

    public void setService(HttpService service) {
        this.service = service;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        setBaseUrl(getBasUrl(url));
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public long getCountLength() {
        return countLength;
    }

    public void setCountLength(long countLength) {
        this.countLength = countLength;
    }


    public long getReadLength() {
        return readLength;
    }

    public void setReadLength(long readLength) {
        this.readLength = readLength;
    }

    /**
     * 读取baseurl
     */
    private String getBasUrl(String url) {
        String head = "";
        int index = url.indexOf("://");
        if (index != -1) {
            head = url.substring(0, index + 3);
            url = url.substring(index + 3);
        }
        index = url.indexOf("/");
        if (index != -1) {
            url = url.substring(0, index + 1);
        }
        return head + url;
    }

    /**
     * 下载状态
     */
    public enum DownState {
        START,
        DOWN,
        PAUSE,
        STOP,
        ERROR,
        FINISH,

    }
}
