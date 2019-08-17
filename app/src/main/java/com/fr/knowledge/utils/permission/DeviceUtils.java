package com.fr.knowledge.utils.permission;

import android.os.Build;

/**
 * 创建时间：2019/8/12
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class DeviceUtils {
    /**
     * 获取设备厂商
     * 如 Xiaomi
     * @return 设备厂商
     */

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }
}
