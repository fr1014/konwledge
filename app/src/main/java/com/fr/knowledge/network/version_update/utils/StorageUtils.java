package com.fr.knowledge.network.version_update.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class StorageUtils {

    /**
     * 获取应用的缓存目录
     * 路径需要root以后，用Root Explorer 文件管理器才能看到
     */
    public static File getCacheDirectory(Context context) {
        File appCacheDir = context.getCacheDir();
        if (appCacheDir == null) {
            Log.w("StorageUtils", "Can't define system cache directory! The app should be re-installed.");
        }
        return appCacheDir;
    }

    /**
     * 获取应用的缓存目录 路径在手机里可以直接看到
     * apk下载路径为:SDCard/Android/data/com.winfo.update/cache/
     */
    public static File getExternalCacheDirectory(Context context) {
        File appCacheDir = context.getExternalCacheDir();
        if (appCacheDir == null) {
            Log.w("StorageUtils", "Can't define system cache directory! The app should be re-installed.");
        }
        return appCacheDir;
    }

    /**
     * 在cache下新增自定义缓存路径
     * apk下载路径为:SDCard/Android/data/com.fr.knowledge/cache/update_file/
     */
    public static File getExternalCacheCustomDirectory(Context context) {
        //在SDCard/Android/data/com.fr.knowledge/cache/update_file创建文件夹
        File appCacheDir = new File(context.getExternalCacheDir(), "update");
        //如果不存在就创建
        if (!appCacheDir.exists()) {
            if (appCacheDir.mkdirs()) {//创建成功就返回SDCard/Android/data/com.fr.knowledge/cache/update_file/
                return appCacheDir;
            } else {
                //创建失败就返回默认的SDCard/Android/data/com.fr.knowledge/cache/
                return context.getExternalCacheDir();
            }
        } else {
            //存在直接返回
            return appCacheDir;
        }
    }
}
