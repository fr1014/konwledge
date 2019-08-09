package com.fr.konwledge.network.version_update.request;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class OkHttpUtils {
    /**
     * okhttp
     */
    private static OkHttpClient okHttpClient;

    /**
     * Retrofit
     */
    private static Retrofit retrofit;

    /**
     * 获取Retrofit的实例
     *
     * @return retrofit
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://github.com/fr1014/konwledge/blob/master/app/release/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(15 * 1000, TimeUnit.SECONDS);
            builder.readTimeout(15 * 1000, TimeUnit.MILLISECONDS);//超时时间
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }
}
