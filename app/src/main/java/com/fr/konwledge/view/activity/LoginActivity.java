package com.fr.konwledge.view.activity;

import android.os.Bundle;

import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseActivity;
import com.fr.konwledge.databinding.ActivityLoginBinding;
import com.fr.konwledge.utils.Utils;
import com.fr.konwledge.view.listener.CallBackListener;
import com.fr.konwledge.viewmodel.UserViewModel;

import static com.fr.konwledge.view.anim.anims.initAnimator;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements CallBackListener {
    private UserViewModel mUserViewModel;

    @Override
    protected void initData() {
        initAnimator(this,binding.icon);
        initClick();
        mUserViewModel = new UserViewModel();
        mUserViewModel.setCallBackListener(this);
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
