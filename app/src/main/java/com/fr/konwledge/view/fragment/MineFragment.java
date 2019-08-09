package com.fr.konwledge.view.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.fr.konwledge.BR;
import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseFragment;
import com.fr.konwledge.databinding.FragmentMineBinding;
import com.fr.konwledge.model.UserModel;
import com.fr.konwledge.network.download.httpdowonload.DownInfo;
import com.fr.konwledge.network.download.httpdowonload.HttpDownManager;
import com.fr.konwledge.network.download.listener.HttpProgressOnNextListener;
import com.fr.konwledge.view.activity.LoginActivity;

import java.io.File;

public class MineFragment extends BaseFragment<FragmentMineBinding> {
    private UserModel userModel;
    private ProgressBar mProgressBar;
    private DownInfo mDownInfo;


    public static Fragment getInstance() {
        return new MineFragment();
    }

    @Override
    protected void initView() {
        initClick();
    }

    @Override
    public void initData() {
        userModel = new UserModel();
        binding.setVariable(BR.userbean, userModel.getCurUserInfo());
        updateInfo();
    }

    private void initClick() {
        binding.setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.out_login:
                    userModel.logout();
                    startActivity(LoginActivity.class);
                    this.getActivity().finish();
                    break;
                case R.id.update:
                    update();
                    break;
            }
        });
    }

    private void update() {
        HttpDownManager.getInstance().startDown(mDownInfo, new HttpProgressOnNextListener<DownInfo>() {
            @Override
            public void onNext(DownInfo downInfo) {

            }

            @Override
            public void updateProgress(long readLength, long countLength) {

            }
        });
    }

    private void updateInfo() {
        String downloadUrl = "";
        mDownInfo = new DownInfo(downloadUrl);
        String apkName = downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1, downloadUrl.length());
        File apkFile = new File(getActivity().getExternalCacheDir(), apkName);
        mDownInfo.setSavePath(apkFile.getAbsolutePath());
        mDownInfo.setState(DownInfo.DownState.START);
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_mine;
    }


}
