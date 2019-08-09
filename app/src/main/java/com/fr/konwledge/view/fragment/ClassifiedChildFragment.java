package com.fr.konwledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseFragment;
import com.fr.konwledge.bean.ItemBean;
import com.fr.konwledge.model.BeanModel;
import com.fr.konwledge.databinding.FragmentClassifiedChildBinding;
import com.fr.konwledge.utils.DialogHelper;
import com.fr.konwledge.utils.Utils;
import com.fr.konwledge.view.IView.ICategoryView;
import com.fr.konwledge.view.adapter.RVBeanAdapter;
import com.fr.konwledge.view.listener.OnItemClickListener;
import com.fr.konwledge.viewmodel.CategoryViewModel;
import com.fr.konwledge.webview.H5WebActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import static com.fr.konwledge.constant.MainConstant.LoadData.FIRST_LOAD;
import static com.fr.konwledge.view.anim.anims.initRVAnim;

public class ClassifiedChildFragment extends BaseFragment<FragmentClassifiedChildBinding> implements ICategoryView, XRecyclerView.LoadingListener, OnItemClickListener<BeanModel> {
    private String mClassified;
    private CategoryViewModel viewModel;
    private RVBeanAdapter mAdapter;
    private XRecyclerView mXRecyclerView;

    public ClassifiedChildFragment(String classified){
        this.mClassified = classified;
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_classified_child;
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

        mAdapter = new RVBeanAdapter(getContext());
        mXRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);
    }

    public void initRecyclerViewAnim(List<ItemBean> list) {
        initRVAnim(getContext(),mXRecyclerView);
        if (list != null && list.size() > 0) {
            if (mAdapter == null) {
                mAdapter = new RVBeanAdapter(getActivity());
                mAdapter.setOnItemClickListener(this);
                getActivity().runOnUiThread(() -> {
                    mXRecyclerView.setAdapter(mAdapter);
                    mAdapter.refreshData(list);
                });
            } else{
                getActivity().runOnUiThread(() -> mAdapter.refreshData(list));
            }
        }
    }

    @Override
    public void initData() {
        viewModel = new CategoryViewModel(this,this, mAdapter, mClassified);
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
    public void onItemClickClick(View view, BeanModel bean) {
        Bundle bundle = new Bundle();
        bundle.putString("url", bean.getUrl());
        bundle.putString("title", bean.getDesc());
        startActivity(H5WebActivity.class, bundle);
    }

}
