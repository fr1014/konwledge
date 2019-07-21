package com.fr.konwledge.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fr.konwledge.BR;
import com.fr.konwledge.R;
import com.fr.konwledge.base.BaseViewHolder;
import com.fr.konwledge.base.RVBaseAdapter;
import com.fr.konwledge.bean.CategoryListBean.ResultsBean;
import com.fr.konwledge.bean.CategoryBean;
import com.fr.konwledge.databinding.ItemCategorybeanBinding;

/**
 * 创建时间：2019/7/19
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class RVCategoryAdapter extends RVBaseAdapter<ResultsBean, CategoryBean,BaseViewHolder<ItemCategorybeanBinding>> {

    public RVCategoryAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<ItemCategorybeanBinding> onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_categorybean,parent,false);
        return new BaseViewHolder<>((ItemCategorybeanBinding) dataBinding);
    }

    @Override
    public void onBindVH(BaseViewHolder<ItemCategorybeanBinding> holder, int position) {
        ItemCategorybeanBinding binding = holder.getBinding();
        CategoryBean bean = new CategoryBean(mList.get(position), position);
        binding.setVariable(BR.categorybean,bean);
        binding.executePendingBindings();
        binding.setOnClickListener(view -> mOnItemClickListener.onItemClickClick(view,bean));
    }

}
