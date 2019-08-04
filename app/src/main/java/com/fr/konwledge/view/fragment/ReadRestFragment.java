package com.fr.konwledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseFragment;
import com.fr.konwledge.databinding.FragmentReadrestBinding;

/**
 * 创建时间：2019/8/2
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class ReadRestFragment extends BaseFragment<FragmentReadrestBinding> {


    public static Fragment getInstance(){
        return new ReadRestFragment();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_readrest;
    }
}
