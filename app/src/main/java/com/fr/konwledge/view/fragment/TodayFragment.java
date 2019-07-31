package com.fr.konwledge.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fr.konwledge.R;
import com.fr.konwledge.databinding.FragmentTodayBinding;
import com.fr.konwledge.utils.DialogHelper;
import com.fr.konwledge.utils.Utils;
import com.fr.konwledge.view.IView.ITodayView;
import com.fr.konwledge.view.adapter.RVBeanAdapter;
import com.fr.konwledge.base.BaseFragment;
import com.fr.konwledge.view.listener.OnItemClickListener;
import com.fr.konwledge.bean.TodayBean;
import com.fr.konwledge.viewmodel.TodayViewModel;
import com.fr.konwledge.webview.H5WebActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.concurrent.Delayed;

import static com.fr.konwledge.constant.MainConstant.LoadData.FIRST_LOAD;

public class TodayFragment extends BaseFragment<FragmentTodayBinding> implements ITodayView, XRecyclerView.LoadingListener, OnItemClickListener<TodayBean> {

    private RVBeanAdapter mTodayAdapter;
    private TodayViewModel viewModel;

    public static Fragment getInstance() {
        return new TodayFragment();
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_today;
    }

    @Override
    public void initData() {
        binding.recyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
        binding.recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
        binding.recyclerView.setArrowImageView(R.mipmap.pull_down_arrow);
        binding.recyclerView.setLoadingListener(this);

        mTodayAdapter = new RVBeanAdapter(getActivity());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(mTodayAdapter);

        viewModel = new TodayViewModel(this, mTodayAdapter);

        mTodayAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        viewModel.loadRefreshData();
    }

    @Override
    public void onLoadMore() {
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
        binding.recyclerView.loadMoreComplete();
        binding.recyclerView.refreshComplete();
    }

    @Override
    public void loadFailure(String message) {
        DialogHelper.getInstance().close();
        binding.recyclerView.loadMoreComplete();
        binding.recyclerView.refreshComplete();
        Utils.ToastShort(getContext(), message);
    }

    @Override
    public void onItemClickClick(View view, TodayBean bean) {
        Bundle bundle = new Bundle();
        bundle.putString("url", bean.getUrl());
        bundle.putString("title", bean.getDesc());
        startActivity(H5WebActivity.class, bundle);
    }
}
