package com.fr.konwledge.model;

import android.util.Log;

import com.fr.konwledge.base.BaseLoadListener;
import com.fr.konwledge.bean.CategoryListBean;
import com.fr.konwledge.bean.CategoryListBean.ResultsBean;
import com.fr.konwledge.network.RetrofitManager;
import com.fr.konwledge.network.schedulers.SchedulerProvider;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

public class CategoryModel {

    public static void getCategoryListBean(String category, int count, int page, BaseLoadListener<ResultsBean> loadListener) {
        RetrofitManager
                .getRequest()
                .getCategoryBean(category, count, page)
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(new DisposableObserver<Response<CategoryListBean>>() {

                    @Override
                    protected void onStart() {
                        loadListener.loadStart();
                    }

                    @Override
                    public void onNext(Response<CategoryListBean> categoryListBeanResponse) {
                        if (categoryListBeanResponse != null && !categoryListBeanResponse.body().isError()){
                            loadListener.loadSuccess(categoryListBeanResponse.body().getResults());
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
