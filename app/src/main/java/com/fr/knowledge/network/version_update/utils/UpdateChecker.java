package com.fr.knowledge.network.version_update.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import com.fr.knowledge.R;
import com.fr.knowledge.network.version_update.entity.VersionInfo;
import com.fr.knowledge.network.version_update.request.ApiService;
import com.fr.knowledge.network.version_update.request.OkHttpUtils;
import com.fr.knowledge.network.version_update.request.RequestSubscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class UpdateChecker {
    /**
     * 对话框检测
     *
     * @param mContext context
     * @param dialog   加载框
     */
    public static void checkForDialog(final Context mContext, final Dialog dialog) {
        dialog.show();
        Observable<Response<VersionInfo>> observable = OkHttpUtils.getRetrofit().create(ApiService.class).checkVersion();
        Observer<Response<VersionInfo>> observer = new RequestSubscriber<Response<VersionInfo>>() {
            @Override
            protected void onSuccess(Response<VersionInfo> versionInfoResponse) {
                dialog.dismiss();
                if (versionInfoResponse.isSuccessful()) {
                    VersionInfo versionInfo = versionInfoResponse.body();
                    if (versionInfo != null) {
                        int apkCode = versionInfo.getVersionCode();
                        int versionCode = AppUtils.getVersionCode(mContext);
                        if (apkCode > versionCode) {
                            UpdateDialog.show(mContext, versionInfo.getUpdateMessage(), versionInfo.getDownloadUrl());
                        } else {
                            Toast.makeText(mContext, mContext.getString(R.string.android_auto_update_toast_no_new_update), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(mContext, "请求失败了", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "请求失败了", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected void onFailure(String msg) {
                dialog.dismiss();
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        };
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 通知栏通知
     *
     * @param mContext context
     */
    public static void checkForNotification(final Context mContext) {
        Observable<Response<VersionInfo>> observable = OkHttpUtils.getRetrofit().create(ApiService.class).checkVersion();
        Observer<Response<VersionInfo>> observer = new RequestSubscriber<Response<VersionInfo>>() {
            @Override
            protected void onSuccess(Response<VersionInfo> versionInfoResponse) {
                if (versionInfoResponse.isSuccessful()) {
                    VersionInfo versionInfo = versionInfoResponse.body();
                    if (versionInfo != null) {
                        int apkCode = versionInfo.getVersionCode();
                        int versionCode = AppUtils.getVersionCode(mContext);
                        if (apkCode > versionCode) {
                            new NotificationHelper(mContext).showNotification(versionInfo.getUpdateMessage(), versionInfo.getDownloadUrl());
                        } else {
//                            Toast.makeText(mContext, mContext.getString(R.string.android_auto_update_toast_no_new_update), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(mContext, "更新查询没有成功", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "更新查询没有成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected void onFailure(String msg) {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        };
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
