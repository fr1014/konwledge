package com.fr.konwledge.network.response;

import android.util.Log;

import com.fr.konwledge.network.exception.CustomException;
import com.fr.konwledge.network.request.Response;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * 对返回的数据进行处理，区分异常的情况
 */
public class ResponseTransformer {

    public static <T> ObservableTransformer<Response<T>,T> handleResult(){
        return upstream -> upstream.onErrorResumeNext(new ErrorResumeFunction<>()).flatMap(new ResponseFunction<>());
    }

    /**
     * 非服务器产生的异常，比如本地无网络请求，json数据解析错误等
     * @param <T>
     */
    private static class ErrorResumeFunction<T> implements Function<Throwable,ObservableSource<? extends Response<T>>> {

        @Override
        public ObservableSource<? extends Response<T>> apply(Throwable throwable) throws Exception{
            return Observable.error(CustomException.handleException(throwable));
        }
    }

    private static final String TAG = "ResponseTransformer";
    /**
     * 服务器返回的数据解析
     * 正常服务器返回数据的exception
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<Response<T>,ObservableSource<T>>{

        @Override
        public ObservableSource<T> apply(Response<T> tResponse) throws Exception {
            boolean code = tResponse.isError();
            Log.d(TAG, "fan"+tResponse.isError());
            Log.d(TAG, "fan:"+tResponse.getData());
            if (!code){
                return Observable.just(tResponse.getData());
            }else {
                return Observable.error(Throwable::new);
//                return Observable.error(new ApiException(code,message));
            }
        }
    }
}
