package com.fr.konwledge.network.request;

import com.fr.konwledge.bean.CategoryListBean;
import com.fr.konwledge.bean.TestBean;
import com.fr.konwledge.bean.TodayListBean;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 请求接口的封装
 */
public interface Request {
    //https://gank.io/api/
    String BASE_URL = "https://gank.io/api/";

    //获取最新干货
    @GET("today")
    Observable<Response<TodayListBean<TestBean>>> getTodayBean();

    //获取分类干货
    @GET("data/{category}/{count}/{page}")
    Observable<Response<CategoryListBean<TestBean>>> getCategoryBean(@Path("category")String category, @Path("count") int count, @Path("page") int page);
}
