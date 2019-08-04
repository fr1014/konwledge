package com.fr.konwledge.view.IView;

import com.fr.konwledge.base.IBaseView;

import java.util.List;

/**
 * 创建时间：2019/7/20
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public interface ITodayView<T> extends IBaseView {
    void showResult(List<T> list);
}
