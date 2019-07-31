package com.fr.konwledge.model;

import com.fr.konwledge.bean.UserBean;
import com.fr.konwledge.utils.SPUtils;

import java.lang.ref.WeakReference;

/**
 * 创建时间：2019/7/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class UserModel {
    //用弱引用防止内存泄漏
    private static WeakReference<UserBean> curUserBean;

    public void cacheUserInfo(UserBean userBean){
        SPUtils.save("user",userBean);
        curUserBean = new WeakReference<>(userBean);
    }

    public UserBean getCurUserInfo(){
        if (curUserBean == null || curUserBean.get() ==null){
            UserBean userBean = SPUtils.getClassFromSp("user",UserBean.class);
            curUserBean = new WeakReference<>(userBean);
        }
        return curUserBean.get();
    }

    public String getUserId(){
        return getCurUserInfo().getUserId();
    }

    public void clearUserInfo(){
        SPUtils.clear("user");
    }


}
