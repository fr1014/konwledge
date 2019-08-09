package com.fr.konwledge.view.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;

import com.fr.konwledge.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * 创建时间：2019/8/8
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class anims {

    //RecyclerView入场动画
    public static void initRVAnim(Context context, View view) {
        //通过加载XML动画设置文件来创建一个Animation对象；
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_anim);
        //得到一个LayoutAnimationController对象；
        LayoutAnimationController lac = new LayoutAnimationController(animation);
        //设置控件显示的顺序；
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //设置控件显示间隔时间；
        lac.setDelay(0.3f);
        //为ListView设置LayoutAnimationController属性；
        ((XRecyclerView)view).setLayoutAnimation(lac);
    }

    //绕Y轴旋转
    public static void initAnimator(Context context,View view) {
        Animator animator = AnimatorInflater.loadAnimator(context, R.animator.rotation);
        animator.setTarget(view);
        animator.start();
    }

    //缩放动画
    public static void initScaleAnim(Context context,View view){
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(context, R.anim.scale_anim);
        view.startAnimation(scaleAnimation);
    }
}
