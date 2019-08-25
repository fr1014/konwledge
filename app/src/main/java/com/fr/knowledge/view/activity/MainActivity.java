package com.fr.knowledge.view.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fr.knowledge.BR;
import com.fr.knowledge.R;
import com.fr.knowledge.databinding.ActivityMainBinding;
import com.fr.knowledge.model.UserModel;
import com.fr.knowledge.network.version_update.utils.UpdateChecker;
import com.fr.knowledge.utils.Utils;
import com.fr.knowledge.utils.permission.Permission;
import com.fr.knowledge.utils.permission.PermissionListener;
import com.fr.knowledge.utils.permission.PermissionUtils;
import com.fr.knowledge.view.adapter.FragmentAdapter;
import com.fr.knowledge.base.BaseActivity;
import com.fr.knowledge.view.fragment.ClassifiedFragment;
import com.fr.knowledge.view.fragment.MineFragment;
import com.fr.knowledge.view.fragment.TodayFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private FragmentAdapter mFragmentAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private UserModel userModel;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mViewPager = binding.viewpager;
        mTabLayout = binding.tabs;

        initViewData();

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("分类");
        titles.add("我的");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(TodayFragment.getInstance());
        fragments.add(ClassifiedFragment.getInstance());
        fragments.add(MineFragment.getInstance());
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, titles);
        mViewPager.setAdapter(mFragmentAdapter);
        //将TabLayout和ViewPager关联起来
        mTabLayout.setupWithViewPager(mViewPager);

        //获取存储权限
        checkPermission();
    }

    private void initViewData() {
        userModel = new UserModel();
        binding.setVariable(BR.userbean, userModel.getCurUserInfo());
    }

    private void checkUpdate() {
        UpdateChecker.checkForNotification(mContext);
    }

    protected long exitTime; //记录第一次点击的时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Utils.ToastShort(this, "再按一次退出程序！");
                exitTime = System.currentTimeMillis();
            } else {
                MainActivity.this.finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void checkPermission() {
        if (PermissionUtils.needRequestPermission()) {
            Permission.with(this)
                    .requestCode(100)
                    .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .callBack(new PermissionListener() {
                        @Override
                        public void onPermit(int requestCode, String... permission) {
                            //检查更新
                            checkUpdate();
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

    //Fragment中无法回调onRequestPermissionsResult
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Permission.onRequestPermissionResult(requestCode, permissions, grantResults);

        // 获取到Activity下的Fragment
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments == null) {
            return;
        }
        // 查找在Fragment中onRequestPermissionsResult方法并调用
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                // 这里就会调用我们Fragment中的onRequestPermissionsResult方法
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    public void search(View view) {
        startActivity(SearchActivity.class);
    }
}
