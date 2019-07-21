package com.fr.konwledge.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fr.konwledge.BR;
import com.fr.konwledge.R;
import com.fr.konwledge.bean.TodayListBean.ResultsBean.Bean;
import com.fr.konwledge.base.BaseViewHolder;
import com.fr.konwledge.base.RVBaseAdapter;
import com.fr.konwledge.bean.TodayBean;
import com.fr.konwledge.databinding.ItemTodaybeanBinding;

public class RVBeanAdapter extends RVBaseAdapter<Bean, TodayBean,BaseViewHolder<ItemTodaybeanBinding>>{

    public RVBeanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<ItemTodaybeanBinding> onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_todaybean, parent, false);
        return new BaseViewHolder<>((ItemTodaybeanBinding) dataBinding);
    }

    @Override
    public void onBindVH(BaseViewHolder<ItemTodaybeanBinding> holder, int position) {
        ItemTodaybeanBinding binding;
        binding = holder.getBinding();
        TodayBean bean = new TodayBean(mList.get(position), position);
        binding.setVariable(BR.todaybean, bean);
        binding.executePendingBindings();
        binding.setOnClickListener(view -> mOnItemClickListener.onItemClickClick(view,bean));
    }

}
