package com.fr.konwledge.bean;

import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

import com.fr.konwledge.utils.Utils;

import java.util.Date;
import java.util.List;
import com.fr.konwledge.bean.TodayListBean.ResultsBean.Bean;

public class TodayBean extends BaseObservable {
    private Bean bean;
    public ObservableField<Integer> imageViewVisibility;
    private int mPosition;


    public TodayBean(Bean bean, int position) {
        this.bean = bean;
        this.mPosition = position;
        initData();

    }

    public String getDesc() {
        return bean.getDesc();
    }

    public List<String> getImageUrls() {
        return bean.getImages();
    }

    public String getImageUrl() {
        if (bean.getImages()!=null)
            return bean.getImages().get(0);
        else
            imageViewVisibility.set(View.GONE);
            return null;
    }

    public Date getDate(){
        return Utils.StrToDate(bean.getPublishedAt());
    }

    public String getUrl(){
        return bean.getUrl();
    }

    public String getType(){
        return bean.getType();
    }

    private void initData() {
        imageViewVisibility = new ObservableField<>();
        imageViewVisibility.set(View.VISIBLE);
    }
}
