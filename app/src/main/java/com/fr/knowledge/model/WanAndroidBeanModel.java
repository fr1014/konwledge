package com.fr.knowledge.model;


import androidx.databinding.BaseObservable;
import com.fr.knowledge.bean.WanAndroidItemBean;

/**
 * 创建时间：2019/8/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class WanAndroidBeanModel extends BaseObservable {

    private WanAndroidItemBean bean;
    private int mPosition;

    public WanAndroidBeanModel(WanAndroidItemBean bean, int position) {
        this.bean = bean;
        this.mPosition = position;
    }

    public String getTitle() {
        return bean.getTitle();
    }

    public String getDesc() {
        return bean.getDesc();
    }

    public String getImageUrl() {
        return bean.getEnvelopePic();
    }

    public String getDate() {
        return bean.getNiceDate();
    }

    public String getUrl() {
        return bean.getLink();
    }
}
