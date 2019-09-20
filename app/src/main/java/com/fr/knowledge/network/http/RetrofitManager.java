package com.fr.knowledge.network.http;

import android.content.Context;
import android.util.Log;

import com.fr.knowledge.application.BaseApplication;
import com.fr.knowledge.network.http.intercepter.CacheInterceptor;
import com.fr.knowledge.network.http.request.Request;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static final String TAG = "RetrofitManager";
    private static RetrofitManager mInstance;
    private static Retrofit retrofit;
    private static volatile Request request = null;
    private static final int CONNECT_TIMEOUT = 10;
    private static final int READ_TIMEOUT = 20;
    private static final int WRITE_TIMEOUT = 20;
    //缓存时间
    private static final int CACHE_TIMEOUT = 1024 * 1024 * 100;
    private static Context mContext = BaseApplication.getContext();

    private Cache cache = null;
    private File httpCacheDirectory;

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化必要对象和参数
     */
    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(com.fr.knowledge.network.http.request.Request.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
    }

    private OkHttpClient createOkHttpClient() {
        if (httpCacheDirectory == null) {
            httpCacheDirectory = new File(mContext.getCacheDir(), "http_cache");
        }
        try {
            if (cache == null) {
                cache = new Cache(httpCacheDirectory, CACHE_TIMEOUT);
            }
        } catch (Exception e) {
            Log.d(TAG, "Could not create http cache: " + e);
        }
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)  //连接超时时间阈值
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)   //数据获取时间阈值
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)  //写数据超时时间阈值
                .retryOnConnectionFailure(true)     //错误重连
                .cache(cache)
                .addInterceptor(new CacheInterceptor(mContext))
                .build();
    }

    public <T> T create(Class<T> service){
        if (service == null){
            throw new RuntimeException("Api service is null");
        }
        return retrofit.create(service);
    }

    public static Request getRequest() {
        if (request == null) {
            synchronized (Request.class) {
                request = retrofit.create(Request.class);
            }
        }
        return request;
    }

}
