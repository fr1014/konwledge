package com.fr.knowledge.network.download.http;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 创建时间：2019/8/8
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 *
 *  service统一接口数据
 */
public interface HttpService {

    //断点续传下载接口
    @Streaming//大文件需要加入这个判断，防止下载过程中写入到内存中
    @Headers("Content-type:application/octet-stream")
    @GET
    Observable<ResponseBody> download(@Header("RANGE") String start, @Url String url);
}
