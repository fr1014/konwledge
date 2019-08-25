package com.fr.knowledge.view.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fr.knowledge.BR;
import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseFragment;
import com.fr.knowledge.databinding.FragmentMineBinding;
import com.fr.knowledge.model.UserModel;
import com.fr.knowledge.network.version_update.utils.UpdateChecker;
import com.fr.knowledge.view.activity.LoginActivity;

public class MineFragment extends BaseFragment<FragmentMineBinding> {
    private UserModel userModel;
    private ProgressDialog dialog;


    public static Fragment getInstance() {
        return new MineFragment();
    }

    @Override
    protected void initView() {
        initClick();
        dialog = new ProgressDialog(getContext());
        dialog.setMessage(getString(R.string.android_auto_update_dialog_checking));
    }

    @Override
    public void initData() {
        userModel = new UserModel();
        binding.setVariable(BR.userbean, userModel.getCurUserInfo());
    }

    private void initClick() {
        binding.setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.out_login:
                    out_login();
                    break;
                case R.id.update:
                    UpdateChecker.checkForDialog(mContext, dialog);
                    break;
            }
        });
    }

    private void out_login() {
        new AlertDialog.Builder(mContext)
                .setTitle("退出登录")
                .setMessage("确定退出登录吗？")
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    userModel.logout();
                    startActivity(LoginActivity.class);
                    this.getActivity().finish();
                })
                .setNegativeButton("取消", (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_mine;
    }

    //必须添加，否则第一次请求成功权限不会走回调
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        Permission.onRequestPermissionResult(requestCode, permissions, grantResults);
//    }
}
