package com.fr.knowledge.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fr.knowledge.BR;
import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseViewHolder;
import com.fr.knowledge.base.RVBaseAdapter;
import com.fr.knowledge.databinding.ItemBeanBinding;
import com.fr.knowledge.model.GankBeanModel;
import com.fr.knowledge.bean.ItemBean;

/**
 * 创建时间：2019/7/19
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class RVBeanAdapter extends RVBaseAdapter<ItemBean, GankBeanModel,BaseViewHolder<ItemBeanBinding>> {

    public RVBeanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<ItemBeanBinding> onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_bean,parent,false);
        return new BaseViewHolder<>((ItemBeanBinding) dataBinding);
    }

    @Override
    public void onBindVH(BaseViewHolder<ItemBeanBinding> holder, int position) {
        ItemBeanBinding binding = holder.getBinding();
        GankBeanModel bean = new GankBeanModel(mList.get(position), position);
        binding.setVariable(BR.bean,bean);
        binding.executePendingBindings();
        binding.setOnClickListener(view -> mOnItemClickListener.onItemClickClick(view,bean));
    }

}
