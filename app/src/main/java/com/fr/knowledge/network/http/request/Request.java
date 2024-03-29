package com.fr.knowledge.network.http.request;

import com.fr.knowledge.bean.CategoryListBean;
import com.fr.knowledge.bean.ItemBean;
import com.fr.knowledge.bean.TodayListBean;
import com.fr.knowledge.bean.WanAndroidItemBean;
import com.fr.knowledge.bean.WanAndroidListBean;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 请求接口的封装
 */
public interface Request {
    //https://gank.io/api/
    String BASE_URL = "http://gank.io/api/";

    //获取最新干货
    @GET("today")
    Observable<Response<TodayListBean<ItemBean>>> getTodayBean();

    //获取分类干货
    @GET("data/{category}/{count}/{page}")
    Observable<Response<CategoryListBean<ItemBean>>> getCategoryBean(@Path("category")String category, @Path("count") int count, @Path("page") int page);

    //搜素接口 http://gank.io/api/search/query/listview/category/Android/count/10/page/1
    @GET("search/query/{category}/category/all/count/{count}/page/{page}")
    Observable<Response<CategoryListBean<ItemBean>>> getSearchBean(@Path("category")String category, @Path("count") int count, @Path("page") int page);

    //WanAndroid首页文章接口https://www.wanandroid.com/article/list/0/json
    @GET("https://www.wanandroid.com/article/list/{page}/json")
    Observable<Response<WanAndroidListBean<WanAndroidItemBean>>> getWanAndroidItemBean(@Path("page")int page);
}
