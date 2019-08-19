package com.fr.knowledge.network.version_update.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.fr.knowledge.R;
import com.fr.knowledge.network.version_update.service.DownloadService;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class NotificationHelper {
    private NotificationManager manager;

    private Context mContext;

    private static String CHANNEL_ID = "app_update";

    private static final int NOTIFICATION_ID = 0;

    public NotificationHelper(Context context) {
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "应用更新", NotificationManager.IMPORTANCE_HIGH);
            mChannel.setDescription("应用有新版本");
            mChannel.enableLights(true); //是否在桌面icon右上角展示小红点
            mChannel.setShowBadge(true);
            getManager().createNotificationChannel(mChannel);
        }
    }

    /**
     * 显示Notification
     */
    public void showNotification(String content, String apkUrl) {

        Intent myIntent = new Intent(mContext, DownloadService.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myIntent.putExtra(Constants.APK_DOWNLOAD_URL, apkUrl);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = getNotify(content)
                .setContentIntent(pendingIntent);

        getManager().notify(NOTIFICATION_ID, builder.build());
    }

    /**
     * 不断调用次方法通知通知栏更新进度条
     */
    public void updateProgress(int progress) {

        String text = mContext.getString(R.string.android_auto_update_download_progress, progress);

        PendingIntent pendingintent = PendingIntent.getActivity(mContext, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = getNotify(text)
                .setProgress(100, progress, false)
                .setContentIntent(pendingintent);

        getManager().notify(NOTIFICATION_ID, builder.build());
    }

    private NotificationCompat.Builder getNotify(String text) {
        NotificationCompat.Builder builder;

        //8.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(mContext.getApplicationContext(), CHANNEL_ID);
        } else {

            builder = new NotificationCompat.Builder(mContext);
            //8.0以下 && 7.0及以上 设置优先级
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                builder.setPriority(NotificationManager.IMPORTANCE_HIGH);
            } else {
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
            }
        }

        builder.setTicker(mContext.getString(R.string.android_auto_update_notify_ticker))
                .setContentTitle("版本更新")
                .setContentText(text)
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setWhen(System.currentTimeMillis())
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        return builder;
    }

    public void cancel() {
        getManager().cancel(NOTIFICATION_ID);
    }


    private NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }
}
