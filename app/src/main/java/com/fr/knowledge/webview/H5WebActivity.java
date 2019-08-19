package com.fr.knowledge.webview;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.fr.knowledge.R;
import com.fr.knowledge.databinding.ActivityWebBinding;
import com.fr.knowledge.utils.Utils;
import com.fr.knowledge.base.BaseActivity;

public class H5WebActivity extends BaseActivity<ActivityWebBinding> {

    private String mUrl;
    private FrameLayout mLayout;
    private H5WebView mWebView;
    private String mTitle;
    private Toolbar mToolbar;
    private Boolean mIsFavor = false;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_web;
    }

    @Override
    protected void initData() {
        getParameter();
        initWebView();
    }

    private void initWebView() {
        mLayout =  binding.webLayout;
        mToolbar = binding.toolbar;
        setSupportActionBar(mToolbar);//关联显示menu

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new H5WebView(getApplicationContext());
        mWebView.setLayoutParams(params);
        mLayout.addView(mWebView);
        mWebView.setWebChromeClient(new Html5WebChromeClient());
        mWebView.setWebViewClient(new HtmlWebClient());
        mWebView.setDownloadListener(new H5WebView.MyDownloadListener(mContext));
        mWebView.loadUrl(mUrl);
    }

    private class Html5WebChromeClient extends H5WebView.BaseWebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            //TODO 顶部显示网页加载进度
        }
    }

    private class HtmlWebClient extends H5WebView.BaseWebViewClient{
        /**
         * 多页面在同一个WebView中打开，就是不新建activity或者调用系统浏览器打开
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            final Uri newUrl = request.getUrl();
            view.loadUrl(String.valueOf(newUrl));
            return true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
        mWebView.pauseTimers();//暂停整个 H5WebView 所有布局、解析、JS
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        mWebView.resumeTimers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mWebView!=null){
            mWebView.clearHistory();
            ((ViewGroup)mWebView.getParent()).removeView(mWebView);
            mWebView.loadUrl("about:blank");
            mWebView.stopLoading();
            mWebView.setWebChromeClient(null);
            mWebView.setWebViewClient(null);
            mWebView.destroy();
            mWebView = null;
        }
    }

    public void getParameter() {
        Bundle bundle = getIntent().getBundleExtra("bundle");
        if (bundle != null) {
            mUrl = bundle.getString("url");
            mTitle = bundle.getString("title");
            binding.setTitle(mTitle);
        } else {
            mUrl = "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.web_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem favItem = menu.findItem(R.id.like);
        MenuItem unfavItem = menu.findItem(R.id.unlike);
        favItem.setVisible(mIsFavor);
        unfavItem.setVisible(!mIsFavor);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.like:
                if (mIsFavor){
                    mIsFavor = false;
                    //TODO 保存收藏状态
                    invalidateOptionsMenu();
                    Utils.ToastShort(this,"已取消收藏");
                }
                return true;
            case R.id.unlike:
                if (!mIsFavor){
                    mIsFavor = true;
                    //TODO 保存收藏状态
                    invalidateOptionsMenu();
                    Utils.ToastShort(this,"已添加收藏");
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
