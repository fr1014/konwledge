package com.fr.konwledge.viewmodel;

import com.fr.konwledge.bean.UserBean;
import com.fr.konwledge.model.UserModel;
import com.fr.konwledge.view.listener.CallBackListener;

/**
 * 创建时间：2019/7/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class UserViewModel {
    private UserModel mUserModel;

    public UserViewModel(){
        mUserModel = new UserModel();
    }

    public void setCallBackListener(CallBackListener callBackListener){
        mUserModel.setCallBackListener(callBackListener);
    }

    public UserBean getUserInfo(){
        return mUserModel.getCurUserInfo();
    }

    public String getUserId(){
        return mUserModel.getUserId();
    }

    public void qqLogin(){
        mUserModel.qqLogin();
    }

    public void wechatLogin(){
        mUserModel.wechatLogin();
    }
}
