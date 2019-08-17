package com.fr.knowledge.view.IView;

import com.fr.knowledge.base.IBaseView;

import java.util.List;

/**
 * 创建时间：2019/7/20
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public interface ITodayView<T> extends IBaseView {
    void showResult(List<T> list);
}
