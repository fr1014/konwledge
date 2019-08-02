package com.fr.konwledge.view.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;

import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseActivity;
import com.fr.konwledge.databinding.ActivityLoginBinding;
import com.fr.konwledge.utils.Utils;
import com.fr.konwledge.view.listener.CallBackListener;
import com.fr.konwledge.viewmodel.UserViewModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements CallBackListener {
    private CircleImageView mIcon;
    private UserViewModel mUserViewModel;

    @Override
    protected void initData() {
        initAnimator();
        initClick();
        mUserViewModel = new UserViewModel();
        mUserViewModel.setCallBackListener(this);

        //判断是否为登录状态
        if (mUserViewModel.getUserInfo() != null) {
            startActivity(MainActivity.class);
            finish();
        }
    }

    private void initClick() {
        binding.setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.iv_qq_login:
                    mUserViewModel.qqLogin();
                    break;
                case R.id.iv_wechat_login:
//                    mUserViewModel.wechatLogin();
                    Utils.ToastShort(mContext, "暂不支持微信登录！");
                    break;
            }
        });
    }

    private void initAnimator() {
        mIcon = binding.icon;
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotation);
        animator.setTarget(mIcon);
        animator.start();
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public void onComplete() {
        startActivity(MainActivity.class);
        finish();
        Utils.ToastShort(mContext, "登录成功！");

    }

    @Override
    public void onError(String message) {
        Utils.ToastShort(mContext, "登录失败：" + message);
    }

    @Override
    public void onCancel() {
        Utils.ToastShort(mContext, "第三方授权登录取消！");
    }

}
