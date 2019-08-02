package com.fr.konwledge.viewmodel;

import com.fr.konwledge.base.BaseLoadListener;
import com.fr.konwledge.bean.ItemBean;
import com.fr.konwledge.constant.MainConstant;
import com.fr.konwledge.model.TodayModel;
import com.fr.konwledge.view.IView.ITodayView;
import com.fr.konwledge.view.adapter.RVBeanAdapter;

import java.util.List;

import static com.fr.konwledge.constant.MainConstant.LoadData.FIRST_LOAD;

public class TodayViewModel extends BaseViewModel<RVBeanAdapter> implements BaseLoadListener<ItemBean>{

    private ITodayView mITodayView;
    private int mLoadType;

    public TodayViewModel(ITodayView iTodayView, RVBeanAdapter adapter) {
        super(adapter);
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
        adapter.refreshData(list);
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
