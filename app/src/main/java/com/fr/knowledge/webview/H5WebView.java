package com.fr.knowledge.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fr.knowledge.network.download.httpdowonload.DownInfo;
import com.fr.knowledge.network.version_update.service.DownloadService;
import com.fr.knowledge.network.version_update.utils.Constants;
import com.fr.knowledge.utils.NetStatusUtil;

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

        //调用JS方法
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportMultipleWindows(true);

        webSettings.setBuiltInZoomControls(true);  //原网页基础上缩放
        webSettings.setSupportZoom(true);  //支持缩放，默认为true

        //设置自适应屏幕，两者合用
        webSettings.setLoadWithOverviewMode(true); //缩放至屏幕的大小
        webSettings.setUseWideViewPort(true);    //将图片调整到适合webview的大小

        webSettings.setDefaultTextEncodingName("utf-8"); //设置编码格式
        webSettings.setLoadsImagesAutomatically(true);   //支持自动加载图片

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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.canGoBack()) {
            this.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //利用浏览器下载文件
    public static class MyDownloadListener implements DownloadListener{
        private DownInfo downInfo;
        private Context context;

        public MyDownloadListener(Context context){
            this.context = context;
        }

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
//            downInfo = new DownInfo(url);
//            String fileName = url.substring(url.lastIndexOf("/") + 1, url.length());
//            File file = new File(context.getExternalCacheDir(), fileName);
//            downInfo.setSavePath(file.getAbsolutePath());
//            downInfo.setState(DownInfo.DownState.START);
            goToDownload(context, url);
        }

        /**
         * 启动服务传递下载地址进行下载
         *
         * @param context     activity
         * @param downloadUrl 下载地址
         */
        private static void goToDownload(Context context, String downloadUrl) {
            Intent intent = new Intent(context.getApplicationContext(), DownloadService.class);
            intent.putExtra(Constants.APK_DOWNLOAD_URL, downloadUrl);
            context.startService(intent);
        }

    }
}
