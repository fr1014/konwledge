package com.fr.knowledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseFragment;
import com.fr.knowledge.databinding.FragmentClassifiedBinding;
import com.fr.knowledge.view.adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassifiedFragment extends BaseFragment<FragmentClassifiedBinding> {
    private FragmentAdapter mFragmentAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitles;
    private List<Fragment> mFragments;
    private final int CLASSIFIED_CODE = 0;

    public static Fragment getInstance() {
        return new ClassifiedFragment();
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_classified;
    }

    @Override
    protected void initView() {
        mTabLayout = binding.tabs;
        mViewPager = binding.viewpager;
        mTitles = new ArrayList<>();
        mTitles.addAll(Arrays.asList("推荐", "Android", "前端", "iOS", "App", "拓展资源", "瞎推荐"));
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(i)));
            Fragment fragment;
            if (i == 0)
                fragment = TodayFragment.getInstance();
            else
                fragment = ClassifiedChildFragment.getInstance(mTitles.get(i), CLASSIFIED_CODE);
            mFragments.add(fragment);
        }
        mTitles.size();
        mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mFragments, mTitles);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void initData() {

    }
}
