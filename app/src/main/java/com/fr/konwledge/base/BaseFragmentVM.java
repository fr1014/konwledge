package com.fr.konwledge.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragmentVM<V extends ViewDataBinding,VM> extends Fragment{
    protected V binding;
    protected VM viewModel;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //避免重复调用 onCreateView
        if (mView == null){
            binding = DataBindingUtil.inflate(inflater, initContentView(inflater, container, savedInstanceState), container, false);
            mView = binding.getRoot();
            initData();
        }else {
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null){
                parent.removeView(mView);
            }
        }

        return mView;
    }

    public abstract void initData();

    public abstract int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 跳转页面
     * @param clz 所跳转目的的Activity类
     */
    public void startActivity(Class<?> clz){
        startActivity(new Intent(getContext(),clz));
    }

    /**
     * 跳转页面
     * @param clz 所跳转目的的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle){
        Intent intent = new Intent(getContext(),clz);
        if (bundle != null){
            intent.putExtra("bundle",bundle);
        }
        startActivity(intent);
    }

}
