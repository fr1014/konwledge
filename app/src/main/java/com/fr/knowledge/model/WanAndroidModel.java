package com.fr.knowledge.model;

import com.fr.knowledge.base.BaseLoadListener;
import com.fr.knowledge.bean.WanAndroidItemBean;
import com.fr.knowledge.bean.WanAndroidListBean;
import com.fr.knowledge.network.http.RetrofitManager;
import com.fr.knowledge.network.http.schedulers.SchedulerProvider;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

/**
 * 创建时间：2019/8/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class WanAndroidModel {

    public static void getWanAndroidBean(int page, BaseLoadListener<WanAndroidItemBean> listener){
        RetrofitManager
                .getRequest()
                .getWanAndroidItemBean(page)
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(new DisposableObserver<Response<WanAndroidListBean<WanAndroidItemBean>>>() {

                    @Override
                    protected void onStart() {
                        listener.loadStart();
                    }

                    @Override
                    public void onNext(Response<WanAndroidListBean<WanAndroidItemBean>> response) {
                        listener.loadSuccess(response.body().getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.loadFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        listener.loadComplete();
                    }
                });
    }
}
