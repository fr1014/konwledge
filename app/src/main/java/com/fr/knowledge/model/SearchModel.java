package com.fr.knowledge.model;

import android.widget.Toast;

import com.fr.knowledge.application.BaseApplication;
import com.fr.knowledge.base.BaseLoadListener;
import com.fr.knowledge.bean.CategoryListBean;
import com.fr.knowledge.bean.ItemBean;
import com.fr.knowledge.network.http.RetrofitManager;
import com.fr.knowledge.network.http.schedulers.SchedulerProvider;
import com.fr.knowledge.utils.Utils;

import java.util.List;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

/**
 * 创建时间：2019/8/22
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class SearchModel {

    public static void getSearchListBean(String category, int count, int page, BaseLoadListener<ItemBean> listener){
        RetrofitManager
                .getRequest()
                .getSearchBean(category,count,page)
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(new DisposableObserver<Response<CategoryListBean<ItemBean>>>() {
                    @Override
                    public void onNext(Response<CategoryListBean<ItemBean>> response) {
                        List<ItemBean> beanList = response.body().getResults();
                        if (Utils.isEmpty(beanList)){
                            Utils.ToastShort(BaseApplication.getContext(),"未搜所到相关内容！");
                        }else {
                            listener.loadSuccess(beanList);
                        }
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
