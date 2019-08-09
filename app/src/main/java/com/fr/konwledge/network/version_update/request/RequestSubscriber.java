package com.fr.konwledge.network.version_update.request;

import android.text.TextUtils;
import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 *
 * 请求被订阅者
 */
public abstract class RequestSubscriber<T> implements Observer<T> {

    /**
     * 定义一个请求成功的抽象方法 子类必须实现并在实现中进行处理服务器返回的数据
     *
     * @param t 服务器返回的数据
     */
    protected abstract void onSuccess(T t);

    /**
     * 定义一个请求失败的抽象方法 子类必须实现并在实现中进行服务器返回数据的处理
     *
     * @param msg 服务器返回的错误信息
     */
    protected abstract void onFailure(String msg);

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        /*
         * 请求成功将数据发出去
         */
        onSuccess(t);
    }

    private static final String TAG = "RequestSubscriber";
    @Override
    public void onError(Throwable e) {
        String msg;
        if (e instanceof SocketTimeoutException) {
            msg = "请求超时。请稍后重试！";
        } else if (e instanceof ConnectException) {
            msg = "请求超时。请稍后重试！";
        } else {
            Log.d(TAG, "onError: "+ e);
            msg = "请求未能成功，请稍后重试！";
        }
        if (!TextUtils.isEmpty(msg)) {
            onFailure(msg);
        }
    }

    @Override
    public void onComplete() {

    }
}
