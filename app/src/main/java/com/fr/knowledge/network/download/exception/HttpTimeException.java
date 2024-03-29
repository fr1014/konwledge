package com.fr.knowledge.network.download.exception;

/**
 * 创建时间：2019/8/8
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 *
 * 自定义错误信息，统一处理返回处理
 */

public class HttpTimeException extends RuntimeException{

    public static final int NO_DATA = 0x2;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 转换错误数据
     *
     * @param code 错误吗
     * @return 错误信息
     */
    private static String getApiExceptionMessage(int code) {
        String message;
        switch (code) {
            case NO_DATA:
                message = "无数据";
                break;
            default:
                message = "error";
                break;
        }
        return message;
    }
}
