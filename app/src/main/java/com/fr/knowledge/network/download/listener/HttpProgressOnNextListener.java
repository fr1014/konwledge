package com.fr.knowledge.network.download.listener;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 *
 * 下载过程中的回调处理
 */
public abstract class HttpProgressOnNextListener<T>{

    /**
     * 成功后回调方法
     *
     * @param t 下载成功之后文件信息
     */
    public abstract void onNext(T t);


    /**
     * 完成下载
     * 主动调用，更加灵活
     */
    public void onComplete(){

    }


    /**
     * 下载进度
     *
     * @param readLength  当前下载进度
     * @param countLength 文件总长度
     */
    public abstract void updateProgress(long readLength, long countLength);

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     *
     * @param e 下载失败异常
     */
    public void onError(Throwable e) {

    }

    ///**
    //* 开始下载
    //  */
    //public abstract void onStart();

     //  * 暂停下载
     //  */
// public void onPuase() {
//
// }
//
// /**
//  * 停止下载销毁
//  */
// public void onStop() {
//
// }
}
