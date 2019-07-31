package com.fr.konwledge.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fr.konwledge.R;

/**
 * 创建时间：2019/8/1
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class Item_view extends LinearLayout {

    private ImageView imageView; //item的图标
    private TextView textView; //item的文字
    private ImageView bottomView;
    private boolean isBottom = true; //是否显示底部的下划线

    public Item_view(Context context) {
        this(context,null);     //注意：必须为this关键字
    }

    public Item_view(Context context, AttributeSet attrs) {
        this(context, attrs,0);     //注意：必须为this关键字
    }

    public Item_view(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //加载布局
        LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_view,this);

        //获取设置属性对象
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs,R.styleable.Fragment_item_view,defStyleAttr,0);

        //获取控件，设置属性值
        isBottom=ta.getBoolean(R.styleable.Fragment_item_view_show_bottom_line,true);
        bottomView = findViewById(R.id.item_bottom);
        imageView = findViewById(R.id.item_img);
        textView = findViewById(R.id.item_text);

        textView.setText(ta.getString(R.styleable.Fragment_item_view_show_text));
        imageView.setBackgroundResource(ta.getResourceId(R.styleable.Fragment_item_view_show_left_img,R.drawable.ic_setting));
        //回收属性对象
        ta.recycle();
        initView();
    }

    private void initView() {
        //如果isBottom为true，显示下划线，否则隐藏
        if(isBottom){
            bottomView.setVisibility(View.VISIBLE);
        }else{
            bottomView.setVisibility(View.GONE);
        }
    }
}
