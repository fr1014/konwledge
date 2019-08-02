package com.fr.konwledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fr.konwledge.BR;
import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseFragment;
import com.fr.konwledge.databinding.FragmentMineBinding;
import com.fr.konwledge.model.UserModel;
import com.fr.konwledge.view.activity.LoginActivity;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class MineFragment extends BaseFragment<FragmentMineBinding> {
    private UserModel userModel;

    public static Fragment getInstance() {
        return new MineFragment();
    }

    @Override
    public void initData() {
        userModel = new UserModel();
        binding.setVariable(BR.userbean, userModel.getCurUserInfo());
        initClick();
    }

    private void initClick() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.out_login:
                        //share删除文件只有退出程序后才完成
                        userModel.cacheUserInfo(null);  //覆盖user文件
                        Platform qq = ShareSDK.getPlatform(QQ.NAME);
                        qq.removeAccount(true);//退出登录
                        startActivity(LoginActivity.class);
                        getActivity().finish();
                        break;
                }
            }
        });
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_mine;
    }


}
