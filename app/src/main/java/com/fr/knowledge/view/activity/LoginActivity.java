package com.fr.knowledge.view.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseActivity;
import com.fr.knowledge.databinding.ActivityLoginBinding;
import com.fr.knowledge.utils.Utils;
import com.fr.knowledge.view.listener.CallBackListener;
import com.fr.knowledge.viewmodel.UserViewModel;

import static com.fr.knowledge.view.anim.anims.initAnimator;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements CallBackListener {
    private UserViewModel mUserViewModel;

    @Override
    protected void initData(Bundle savedInstanceState) {
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);

        initAnimator(this, binding.icon);
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
                    this.onComplete();
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
