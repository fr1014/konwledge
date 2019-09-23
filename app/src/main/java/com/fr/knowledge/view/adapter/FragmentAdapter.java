package com.fr.knowledge.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTitles;

    /**
     *普通，主页使用
     * behavior:
     * 1.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT (指示仅当前片段将处于Lifecycle.State.RESUMED状态)
     * 2.BEHAVIOR_SET_USER_VISIBLE_HINT (不建议使用此常数。此行为取决于不推荐使用的Fragment.setUserVisibleHint（boolean）API。
     * 使用BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT切换到其替换片段FragmentTransaction.setMaxLifecycle（Fragment，Lifecycle.State）)
     */
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> mFragments) {
        super(fm, behavior);
        this.mFragments = mFragments;
    }

    /**
     * 接收首页传递的标题
     */
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments, List<String> titles) {
        super(fm, behavior);
        mFragments = fragments;
        mTitles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    /**
     * 显示的title
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles != null ? mTitles.get(position) : "";
    }

    public void addFragmentList(List<Fragment> fragments){
        this.mFragments.clear();
        this.mFragments = null;
        this.mFragments = fragments;
        notifyDataSetChanged();
    }
}
