package com.fr.konwledge.network.download.httpdowonload;

/**
 * 创建时间：2019/8/9
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 *
 * 成功回调处理
 */
public interface DownloadProgressListener {
    /**
     * 下载进度
     * @param read 进度
     * @param count 总长度
     */
    void update(long read, long count, boolean done);
}
