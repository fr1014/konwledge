package com.fr.konwledge.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 创建时间：2019/7/19
 * 作者：范瑞
 */
public class BaseViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private B mBinding;

    public BaseViewHolder(B binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public B getBinding(){
        return mBinding;
    }
}
