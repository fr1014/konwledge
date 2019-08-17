package com.fr.knowledge.application;

import android.app.Application;
import android.content.Context;

import com.fr.knowledge.BuildConfig;
import com.fr.knowledge.network.http.RetrofitManager;
import com.mob.MobSDK;

public class BaseApplication extends Application {

    private static Context mContext;

    public BaseApplication() {
        mContext = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitManager.getInstance().init(BuildConfig.DEBUG);
        //初始化MobSDK
        MobSDK.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
