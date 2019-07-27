package com.fr.konwledge.view.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fr.konwledge.R;
import com.fr.konwledge.databinding.ActivityMainBinding;
import com.fr.konwledge.view.adapter.FragmentAdapter;
import com.fr.konwledge.base.BaseActivity;
import com.fr.konwledge.view.fragment.ClassifiedFragment;
import com.fr.konwledge.view.fragment.MineFragment;
import com.fr.konwledge.view.fragment.TodayFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private FragmentAdapter mFragmentAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mViewPager = binding.viewpager;
        mTabLayout = binding.tabs;
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
    }

}
