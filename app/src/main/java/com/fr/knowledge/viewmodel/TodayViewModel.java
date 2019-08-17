package com.fr.knowledge.viewmodel;

import androidx.fragment.app.Fragment;

import com.fr.knowledge.base.BaseLoadListener;
import com.fr.knowledge.bean.ItemBean;
import com.fr.knowledge.constant.MainConstant;
import com.fr.knowledge.model.TodayModel;
import com.fr.knowledge.view.IView.ITodayView;
import com.fr.knowledge.view.adapter.RVBeanAdapter;
import com.fr.knowledge.view.fragment.TodayFragment;

import java.util.List;

import static com.fr.knowledge.constant.MainConstant.LoadData.FIRST_LOAD;

public class TodayViewModel extends BaseViewModel<RVBeanAdapter> implements BaseLoadListener<ItemBean>{

    private ITodayView mITodayView;
    private int mLoadType;
    private TodayFragment mTodayFragment;

    public TodayViewModel(Fragment fragment,ITodayView iTodayView, RVBeanAdapter adapter) {
        super(adapter);
        this.mTodayFragment = (TodayFragment) fragment;
        this.mITodayView = iTodayView;
        getData();
    }

    @Override
    protected void getData() {
        mLoadType = FIRST_LOAD;
        TodayModel.getToday(this);
    }

    public void loadRefreshData() {
        mLoadType = MainConstant.LoadData.REFRESH;
        TodayModel.getToday(this);
    }


    @Override
    public void loadSuccess(List<ItemBean> list) {
        mTodayFragment.initRecyclerViewAnim(list);
    }

    @Override
    public void loadFailure(String message) {
        mITodayView.loadFailure(message);
    }

    @Override
    public void loadStart() {
        mITodayView.loadStart(mLoadType);
    }

    @Override
    public void loadComplete() {
       mITodayView.loadComplete();
    }
}
