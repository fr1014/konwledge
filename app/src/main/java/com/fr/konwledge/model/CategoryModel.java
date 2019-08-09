package com.fr.konwledge.model;

import com.fr.konwledge.base.BaseLoadListener;
import com.fr.konwledge.bean.CategoryListBean;
import com.fr.konwledge.bean.ItemBean;
import com.fr.konwledge.network.http.RetrofitManager;
import com.fr.konwledge.network.http.schedulers.SchedulerProvider;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

public class CategoryModel {

    public static void getCategoryListBean(String category, int count, int page, BaseLoadListener<ItemBean> loadListener) {
        RetrofitManager
                .getRequest()
                .getCategoryBean(category, count, page)
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(new DisposableObserver<Response<CategoryListBean<ItemBean>>>() {

                    @Override
                    protected void onStart() {
                        loadListener.loadStart();
                    }

                    @Override
                    public void onNext(Response<CategoryListBean<ItemBean>> listResponse) {
                            loadListener.loadSuccess(listResponse.body().getResults());
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
