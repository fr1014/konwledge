package com.fr.konwledge.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fr.konwledge.R;
import com.fr.konwledge.databinding.FragmentClassifiedBinding;
import com.fr.konwledge.view.adapter.FragmentAdapter;
import com.fr.konwledge.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ClassifiedFragment extends BaseFragment<FragmentClassifiedBinding> {
    private FragmentAdapter mFragmentAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitles;
    private List<Fragment> mFragments;

    public static Fragment getInstance() {
        return new ClassifiedFragment();
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_classified;
    }

    @Override
    public void initData() {
        mTabLayout = binding.tabs;
        mViewPager = binding.viewpager;
        mTitles = new ArrayList<>();
        mTitles.add("Android");
        mTitles.add("前端");
        mTitles.add("iOS");
        mTitles.add("App");

        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(i)));
            Fragment classifiedChildFragment = new ClassifiedChildFragment(mTitles.get(i));
            mFragments.add(classifiedChildFragment);
        }

        mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mFragments, mTitles);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
