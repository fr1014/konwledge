package com.fr.knowledge.view.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fr.knowledge.BR;
import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseFragment;
import com.fr.knowledge.databinding.FragmentMineBinding;
import com.fr.knowledge.model.UserModel;
import com.fr.knowledge.network.version_update.utils.UpdateChecker;
import com.fr.knowledge.utils.permission.Permission;
import com.fr.knowledge.utils.permission.PermissionListener;
import com.fr.knowledge.utils.permission.PermissionUtils;
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
//                    //获取存储权限
//                    checkPermission();
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

    //申请权限
    private void checkPermission() {
        if (PermissionUtils.needRequestPermission()) {
            Permission.with(this)
                    .requestCode(100)
                    .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .callBack(new PermissionListener() {
                        @Override
                        public void onPermit(int requestCode, String... permission) {
                            //检查更新
//                            checkUpdate();
                        }

                        @Override
                        public void onCancel(int requestCode, String... permission) {
                            //确定后跳转至当前app的权限设置界面
                            PermissionUtils.goSetting(mContext);
                        }
                    })
                    .send();
        } else {
            checkUpdate();
        }
    }

    private void checkUpdate() {
        UpdateChecker.checkForNotification(mContext);
    }

    //必须添加，否则第一次请求成功权限不会走回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Permission.onRequestPermissionResult(requestCode, permissions, grantResults);
    }
}
