package com.fr.konwledge.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseFragmentVM;
import com.fr.konwledge.bean.CategoryBean;
import com.fr.konwledge.databinding.FragmentClassifiedChildBinding;
import com.fr.konwledge.utils.DialogHelper;
import com.fr.konwledge.utils.Utils;
import com.fr.konwledge.view.IView.ICategoryView;
import com.fr.konwledge.view.adapter.RVCategoryAdapter;
import com.fr.konwledge.view.listener.OnItemClickListener;
import com.fr.konwledge.viewmodel.CategoryViewModel;
import com.fr.konwledge.webview.H5WebActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import static com.fr.konwledge.constant.MainConstant.LoadData.FIRST_LOAD;

public class ClassifiedChildFragment extends BaseFragmentVM<FragmentClassifiedChildBinding,CategoryViewModel> implements ICategoryView, XRecyclerView.LoadingListener, OnItemClickListener<CategoryBean> {
    private String mClassified;

    public ClassifiedChildFragment(String classified){
        this.mClassified = classified;
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_classified_child;
    }

    @Override
    public void initData() {
        binding.recyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
        binding.recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
        binding.recyclerView.setArrowImageView(R.mipmap.pull_down_arrow);
        binding.recyclerView.setLoadingListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);

        RVCategoryAdapter mRVCategoryAdapter = new RVCategoryAdapter(getContext());
        binding.recyclerView.setAdapter(mRVCategoryAdapter);
        viewModel = new CategoryViewModel(this, mRVCategoryAdapter, mClassified);

        mRVCategoryAdapter.setOnItemClickListener(this);
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
    public void onItemClickClick(View view, CategoryBean bean) {
        Bundle bundle = new Bundle();
        bundle.putString("url", bean.getUrl());
        bundle.putString("title", bean.getDesc());
        startActivity(H5WebActivity.class, bundle);
    }

}
