package com.fr.knowledge.viewmodel;

import com.fr.knowledge.base.BaseLoadListener;
import com.fr.knowledge.bean.ItemBean;
import com.fr.knowledge.constant.MainConstant;
import com.fr.knowledge.model.CategoryModel;
import com.fr.knowledge.model.SearchModel;
import com.fr.knowledge.view.IView.ICategoryView;
import com.fr.knowledge.view.adapter.RVBeanAdapter;

import java.util.List;

/**
 * 创建时间：2019/8/22
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class SearchViewModel extends BaseViewModel<RVBeanAdapter> implements BaseLoadListener<ItemBean> {

    private ICategoryView mICategoryView;
    private String mCategory;
    private int mCurrPage = 1;//当前页面
    private int mLoadType;   //当前数据的类型


    public SearchViewModel(RVBeanAdapter adapter, ICategoryView iCategoryView, String category) {
        super(adapter);
        this.mICategoryView = iCategoryView;
        this.mCategory = category;
        getData();
    }

    @Override
    public void loadSuccess(List<ItemBean> list) {
        if (mCurrPage > 1){
            //上拉加载的数据
            adapter.loadMoreData(list);
        }else {
            //第一次加载或者下拉刷新的数据
            adapter.refreshData(list);
//            mClassifiedChildFragment.initRecyclerViewAnim(list);
        }
    }

    @Override
    public void loadFailure(String message) {
        //加载失败后的提示
        if (mCurrPage > 1){
            //加载失败需要回到加载前的页面
            mCurrPage--;
        }
        mICategoryView.loadFailure(message);
    }

    @Override
    public void loadStart() {
        mICategoryView.loadStart(mLoadType);
    }

    @Override
    public void loadComplete() {
        mICategoryView.loadComplete();
    }

    @Override
    protected void getData() {
        mLoadType = MainConstant.LoadData.FIRST_LOAD;
        SearchModel.getSearchListBean(mCategory,15,mCurrPage,this);
    }

    public void loadMoreData(){
        mLoadType = MainConstant.LoadData.LOAD_MORE;
        mCurrPage++;
        CategoryModel.getCategoryListBean(mCategory,15,mCurrPage,this);
    }
}
