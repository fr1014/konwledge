package com.fr.konwledge.network.version_update.request;

import com.fr.konwledge.network.version_update.entity.VersionInfo;
import com.fr.konwledge.network.version_update.utils.Constants;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public interface ApiService {
    /**
     * 版本检测
     */
    @GET(Constants.UPDATE_URL)
    Observable<Response<VersionInfo>> checkVersion();
}
