package com.fr.knowledge.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fr.knowledge.R;
import com.fr.knowledge.utils.SystemUtil;

public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity {

    protected V binding;
    protected Context mContext;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);

        SystemUtil.setStatusBarCharacterDarkColor(this);

        mContext = this;
        //初始化DataBinding和ViewModel方法
        initViewDataBinding(savedInstanceState);

        initData(savedInstanceState);
    }

    protected abstract void initData(Bundle savedInstanceState);

    private void initViewDataBinding(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));

    }

    public abstract int initContentView(Bundle savedInstanceState);

    /**
     * 跳转页面
     *
     * @param clz 所跳转目的的Activity类
     */
    public void startActivity(Class clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转目的的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }
}
