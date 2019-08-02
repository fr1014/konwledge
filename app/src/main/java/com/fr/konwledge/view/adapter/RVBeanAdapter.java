package com.fr.konwledge.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fr.konwledge.BR;
import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseViewHolder;
import com.fr.konwledge.base.RVBaseAdapter;
import com.fr.konwledge.databinding.ItemBeanBinding;
import com.fr.konwledge.model.BeanModel;
import com.fr.konwledge.bean.TestBean;

/**
 * 创建时间：2019/7/19
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class RVBeanAdapter extends RVBaseAdapter<TestBean, BeanModel,BaseViewHolder<ItemBeanBinding>> {

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
        BeanModel bean = new BeanModel(mList.get(position), position);
        binding.setVariable(BR.bean,bean);
        binding.executePendingBindings();
        binding.setOnClickListener(view -> mOnItemClickListener.onItemClickClick(view,bean));
    }

}
