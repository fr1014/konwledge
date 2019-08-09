package com.fr.konwledge.network.version_update.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresPermission;

import java.lang.reflect.Method;

import static android.Manifest.permission.EXPAND_STATUS_BAR;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class NotificationBarUtil {
    /**
     * 设置通知栏是否收起
     * @param context context
     * @param isVisible 是否收起
     */
    @RequiresPermission(EXPAND_STATUS_BAR)
    public static void setNotificationBarVisibility(Context context, boolean isVisible) {
        String methodName;
        if (isVisible) {
            methodName = (Build.VERSION.SDK_INT <= 16) ? "expand" : "expandNotificationsPanel";
        } else {
            methodName = (Build.VERSION.SDK_INT <= 16) ? "collapse" : "collapsePanels";
        }
        invokePanels(context, methodName);
    }

    private static void invokePanels(Context context, String methodName) {
        try {
            @SuppressLint("WrongConstant")
            Object service = context.getSystemService("statusbar");
            @SuppressLint("PrivateApi")
            Class<?> statusBarManager = Class.forName("android.app.StatusBarManager");
            Method expand = statusBarManager.getMethod(methodName);
            expand.invoke(service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
