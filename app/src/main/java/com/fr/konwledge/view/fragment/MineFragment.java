package com.fr.konwledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseFragment;
import com.fr.konwledge.databinding.FragmentMineBinding;

public class MineFragment extends BaseFragment<FragmentMineBinding> {


    public static Fragment getInstance(){
        return new MineFragment();
    }

    @Override
    public void initData() {

    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_mine;
    }


}
