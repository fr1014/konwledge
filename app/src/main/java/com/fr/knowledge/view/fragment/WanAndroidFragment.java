package com.fr.knowledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseFragment;
import com.fr.knowledge.base.IBaseView;
import com.fr.knowledge.bean.WanAndroidItemBean;
import com.fr.knowledge.databinding.FragmentWanandroidBinding;
import com.fr.knowledge.model.WanAndroidBeanModel;
import com.fr.knowledge.utils.DialogHelper;
import com.fr.knowledge.utils.Utils;
import com.fr.knowledge.view.adapter.RVWanAndroidBeanAdapter;
import com.fr.knowledge.view.listener.OnItemClickListener;
import com.fr.knowledge.viewmodel.WanAndroidViewModel;
import com.fr.knowledge.webview.H5WebActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import static com.fr.knowledge.constant.MainConstant.LoadData.FIRST_LOAD;
import static com.fr.knowledge.view.anim.anims.initRVAnim;

/**
 * 创建时间：2019/8/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class WanAndroidFragment extends BaseFragment<FragmentWanandroidBinding> implements IBaseView, XRecyclerView.LoadingListener, OnItemClickListener<WanAndroidBeanModel> {
    private WanAndroidViewModel viewModel;
    private RVWanAndroidBeanAdapter mAdapter;
    private XRecyclerView mXRecyclerView;

    public static Fragment getInstance() {
        return new WanAndroidFragment();
    }

    @Override
    protected void initView() {
        mXRecyclerView = binding.recyclerView;
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
        mXRecyclerView.setArrowImageView(R.mipmap.pull_down_arrow);
        mXRecyclerView.setLoadingListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mXRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new RVWanAndroidBeanAdapter(getActivity());
        mAdapter.setOnItemClickListener(this);
        mXRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        viewModel = new WanAndroidViewModel(this, this, mAdapter);
    }

    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_wanandroid;
    }

    @Override
    public void loadStart(int loadType) {
        if (loadType == FIRST_LOAD) {
            DialogHelper.getInstance().show(getContext(), "加载中...");
        }
    }

    @Override
    public void loadComplete() {
        DialogHelper.getInstance().close();
        binding.recyclerView.refreshComplete();
        binding.recyclerView.loadMoreComplete();
    }

    @Override
    public void loadFailure(String message) {
        DialogHelper.getInstance().close();
        binding.recyclerView.loadMoreComplete();
        binding.recyclerView.refreshComplete();
        Utils.ToastShort(getContext(), message);
    }

    @Override
    public void onRefresh() {
        //下拉刷新
        viewModel.loadRefreshData();
    }

    @Override
    public void onLoadMore() {
        //上拉加载更多
        viewModel.loadMoreData();
    }

    public void initRecyclerViewAnim(List<WanAndroidItemBean> list) {
        initRVAnim(getContext(), mXRecyclerView);
        if (list != null && list.size() > 0) {
            getActivity().runOnUiThread(() -> mAdapter.refreshData(list));
        }
    }

    @Override
    public void onItemClickClick(View view, WanAndroidBeanModel bean) {
        Bundle bundle = new Bundle();
        bundle.putString("url", bean.getUrl());
        bundle.putString("title", bean.getTitle());
        startActivity(H5WebActivity.class, bundle);
    }
}
