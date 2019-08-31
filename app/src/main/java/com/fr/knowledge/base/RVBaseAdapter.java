package com.fr.knowledge.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.fr.knowledge.view.listener.OnItemClickListener;


import java.util.ArrayList;
import java.util.List;

public abstract class RVBaseAdapter<T, M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected OnItemClickListener<M> mOnItemClickListener;
    protected Context mContext;
    protected List<T> mList; // 数据源
    protected LayoutInflater inflater;

    public RVBaseAdapter(Context context) {
        this.mContext = context;
        this.mList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener<M> onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateVH(parent, viewType);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindVH(holder, position);
    }

    /**
     * 创建 View Holder
     *
     * @param parent   parent
     * @param viewType item type
     * @return view holder
     */
    public abstract VH onCreateVH(ViewGroup parent, int viewType);

    /**
     * 绑定 View Holder
     *
     * @param holder   view holder
     * @param position position
     */
    public abstract void onBindVH(VH holder, int position);

    /**
     * 刷新数据
     *
     * @param data 数据源
     */
    public void refreshData(List<T> data) {
        mList.clear();
        mList.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param data 加载的新数据
     */
    public void loadMoreData(List<T> data) {
        mList.addAll(data);
        notifyDataSetChanged();
    }

}
