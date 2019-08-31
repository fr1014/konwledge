package com.fr.knowledge.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fr.knowledge.BR;
import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseViewHolder;
import com.fr.knowledge.base.RVBaseAdapter;
import com.fr.knowledge.bean.WanAndroidItemBean;
import com.fr.knowledge.databinding.ItemWanandroidBeanBinding;
import com.fr.knowledge.model.WanAndroidBeanModel;

/**
 * 创建时间：2019/8/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class RVWanAndroidBeanAdapter extends RVBaseAdapter<WanAndroidItemBean, WanAndroidBeanModel, BaseViewHolder<ItemWanandroidBeanBinding>> {

    public RVWanAndroidBeanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<ItemWanandroidBeanBinding> onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_wanandroid_bean, parent, false);
        return new BaseViewHolder<>((ItemWanandroidBeanBinding) dataBinding);
    }

    @Override
    public void onBindVH(BaseViewHolder<ItemWanandroidBeanBinding> holder, int position) {
        ItemWanandroidBeanBinding binding = holder.getBinding();
        WanAndroidBeanModel bean = new WanAndroidBeanModel(mList.get(position), position);
        binding.setVariable(BR.wanbean, bean);
        binding.executePendingBindings();
        binding.setOnClickListener(view -> mOnItemClickListener.onItemClickClick(view, bean));
    }
}
