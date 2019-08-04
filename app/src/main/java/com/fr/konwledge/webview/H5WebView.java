package com.fr.konwledge.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fr.konwledge.utils.NetStatusUtil;

import java.io.File;

public class H5WebView extends WebView {
    private Context mContext;

    public H5WebView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public H5WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public H5WebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        WebSettings webSettings = getSettings();
        webSettings.setSupportZoom(true);  //支持缩放，默认为true

        //设置自适应屏幕，两者合用
        webSettings.setLoadWithOverviewMode(true); //缩放至屏幕的大小
        webSettings.setUseWideViewPort(true);    //将图片调整到适合webview的大小

        webSettings.setDefaultTextEncodingName("utf-8"); //设置编码格式
        webSettings.setLoadsImagesAutomatically(true);   //支持自动加载图片
        //调用JS方法
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportMultipleWindows(true);

        //有时候网页需要自己保存一些关键数据,Android H5WebView 需要自己设置
        saveDate(webSettings);
        newWin(webSettings);

        setWebChromeClient(new BaseWebChromeClient());
        setWebViewClient(new BaseWebViewClient());
    }

    /**
     * 多窗口的问题
     */
    private void newWin(WebSettings webSettings) {
        //html中的_bank标签就是新建窗口打开，有时会打不开，需要加以下
        //然后 复写 WebChromeClient的onCreateWindow方法
        webSettings.setSupportMultipleWindows(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    /**
     * HTML5数据储存
     * H5缓存主要包括了App Cache、DOM Storage、Local Storage、Web SQL Database 存储机制等
     *
     * @param webSettings
     */
    private void saveDate(WebSettings webSettings) {
        //有时候网页需要自己保存一些关键数据,Android WebView 需要自己设置

        if (NetStatusUtil.isConnected(mContext)) {
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
        }
        File cacheDir = mContext.getCacheDir();
        if (cacheDir != null) {
            String appCachePath = cacheDir.getAbsolutePath();
            webSettings.setDomStorageEnabled(true);
            webSettings.setDatabaseEnabled(true);
            webSettings.setAppCacheEnabled(true);
            webSettings.setAppCachePath(appCachePath);
        }
    }

    /**
     * 实现一个基础的 WebViewClient ，如果有更多的需要，直接继承它
     */
    static class BaseWebViewClient extends WebViewClient {

    }

    /**
     * 实现一个基础的 WebChromeClient ，如果有更多的需要，直接继承它
     */
    static class BaseWebChromeClient extends WebChromeClient {
        //=========HTML5定位==========================================================
        //需要先加入权限
        //<uses-permission android:name="android.permission.INTERNET"/>
        //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        //<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback
                callback) {
            callback.invoke(origin, true, false);//注意个函数，第二个参数就是是否同意定位权限，第三个是是否希望内核记住
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
        //=========HTML5定位==========================================================


        //=========多窗口的问题==========================================================
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(view);
            resultMsg.sendToTarget();
            return true;
        }
        //=========多窗口的问题==========================================================
    }

}
