package com.fr.konwledge.model;

import com.fr.konwledge.base.BaseLoadListener;
import com.fr.konwledge.bean.TodayListBean;
import com.fr.konwledge.network.RetrofitManager;
import com.fr.konwledge.network.schedulers.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

public class TodayModel {

    private static List<TodayListBean.ResultsBean.Bean> beanList = new ArrayList<>();

    public static void getToday(BaseLoadListener<TodayListBean.ResultsBean.Bean> loadListener) {
        RetrofitManager.getRequest()
                .getTodayBean()
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(new DisposableObserver<Response<TodayListBean>>() {

                    @Override
                    protected void onStart() {
                        loadListener.loadStart();
                    }

                    @Override
                    public void onNext(Response<TodayListBean> todayListBeanResponse) {
                        if (todayListBeanResponse!=null && !todayListBeanResponse.body().isError()){
                            TodayListBean.ResultsBean resultsBean = todayListBeanResponse.body().getResults();
                            beanList.addAll(resultsBean.getAndroid());
                            beanList.addAll(resultsBean.getWeb());
                            beanList.addAll(resultsBean.getApp());
                            beanList.addAll(resultsBean.getIOS());
                            beanList.addAll(resultsBean.getMore());
                            beanList.addAll(resultsBean.getCasual());
                            beanList.addAll(resultsBean.getWelfare());
                            beanList.addAll(resultsBean.getRest());

                            loadListener.loadSuccess(beanList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener.loadFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        loadListener.loadComplete();
                    }
                });
    }

}
