package com.fr.knowledge.viewmodel;

import androidx.fragment.app.Fragment;

import com.fr.knowledge.base.BaseLoadListener;
import com.fr.knowledge.base.IBaseView;
import com.fr.knowledge.bean.WanAndroidItemBean;
import com.fr.knowledge.constant.MainConstant;
import com.fr.knowledge.model.WanAndroidModel;
import com.fr.knowledge.view.adapter.RVWanAndroidBeanAdapter;
import com.fr.knowledge.view.fragment.WanAndroidFragment;

import java.util.List;

/**
 * 创建时间：2019/8/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class WanAndroidViewModel extends BaseViewModel<RVWanAndroidBeanAdapter> implements BaseLoadListener<WanAndroidItemBean> {

    private IBaseView mIBaseView;
    private int mCurrPage = 1; //当前页面
    private int mLoadType; //加载数据的类型
    private WanAndroidFragment mWanAndroidFragment;

    public WanAndroidViewModel(Fragment fragment, IBaseView iBaseView, RVWanAndroidBeanAdapter adapter) {
        super(adapter);
        this.mIBaseView = iBaseView;
        this.mWanAndroidFragment = (WanAndroidFragment) fragment;
        getData();
    }

    /**
     * 第一次获取分类数据
     */
    @Override
    protected void getData() {
        mLoadType = MainConstant.LoadData.FIRST_LOAD;
        WanAndroidModel.getWanAndroidBean(mCurrPage, this);
    }


    public void loadRefreshData() {
        mLoadType = MainConstant.LoadData.REFRESH;
        mCurrPage = 1;
        WanAndroidModel.getWanAndroidBean(mCurrPage, this);
    }

    public void loadMoreData() {
        mLoadType = MainConstant.LoadData.LOAD_MORE;
        mCurrPage++;
        WanAndroidModel.getWanAndroidBean(mCurrPage, this);
    }

    @Override
    public void loadSuccess(List<WanAndroidItemBean> list) {
        if (mCurrPage > 1) {
            //上拉加载的数据
            adapter.loadMoreData(list);
        } else {
            //第一次加载或者下拉刷新的数据
//            adapter.refreshData(list);
            mWanAndroidFragment.initRecyclerViewAnim(list);
        }
    }

    @Override
    public void loadFailure(String message) {
        //加载失败后的提示
        if (mCurrPage > 1) {
            //加载失败需要回到加载前的页面
            mCurrPage--;
        }
        mIBaseView.loadFailure(message);
    }

    @Override
    public void loadStart() {
        mIBaseView.loadStart(mLoadType);
    }

    @Override
    public void loadComplete() {
        mIBaseView.loadComplete();
    }
}
