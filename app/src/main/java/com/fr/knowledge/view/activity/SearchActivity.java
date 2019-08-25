package com.fr.knowledge.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseActivity;
import com.fr.knowledge.databinding.ActivitySearchBinding;
import com.fr.knowledge.view.fragment.ClassifiedChildFragment;

public class SearchActivity extends BaseActivity<ActivitySearchBinding> {

    private ClassifiedChildFragment fragment;
    private String mCategory;
    private SearchView mSearchView;
    private Toolbar mToolbar;
    private static final int SEARCH_CODE = 1;

    @Override
    protected void initData(Bundle savedInstanceState) {
        mSearchView = binding.searchView;

        mToolbar = binding.toolbar;
        setSupportActionBar(mToolbar);//不加入，图标点击无效

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {//点击提交按钮时
                mCategory = query;
                mSearchView.clearFocus();   //可以收起键盘
                if (savedInstanceState != null) {
                    fragment = (ClassifiedChildFragment) getSupportFragmentManager().getFragment(savedInstanceState, "ClassifiedChildFragment");
                } else {
                    fragment = new ClassifiedChildFragment(mCategory, SEARCH_CODE);
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.search_fragment, fragment)
                        .commit();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {//搜索框内容变化时
                return false;
            }
        });
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_search;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 当活动被回收时，存储当前的状态。
     *
     * @param outState 状态数据。
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 存储 Fragment 的状态。
        getSupportFragmentManager().putFragment(outState, "ClassifiedChildFragment", fragment);
    }
}
