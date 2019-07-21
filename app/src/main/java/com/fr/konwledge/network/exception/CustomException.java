package com.fr.konwledge.network.exception;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * 本地异常处理，包括解析异常等其它异常
 */
public class CustomException {
    //未知错误
    private static final int UNKNOWN = 1000;

    //解析错误
    private static final int PARSE_ERROR = 1001;

    //网络错误
    private static final int NETWORK_ERROR = 1002;

    //协议错误
    private static final int HTTP_ERROR = 1003;

    public static ApiException handleException(Throwable e){
        ApiException aex;
        if (e instanceof JsonParseException||e instanceof JSONException || e instanceof ParseException){
            //解析错误
            aex = new ApiException(PARSE_ERROR,e.getMessage());
            return aex;
        }else if (e instanceof ConnectException){
            //网络错误
            aex = new ApiException(NETWORK_ERROR,e.getMessage());
            return aex;
        }else if (e instanceof UnknownHostException|| e instanceof SocketTimeoutException){
            //连接错误
            aex = new ApiException(NETWORK_ERROR,e.getMessage());
            return aex;
        }else {
            //未知错误
            aex = new ApiException(UNKNOWN,e.getMessage());
            return aex;
        }
    }
}
