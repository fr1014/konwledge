package com.fr.konwledge.viewmodel;

import android.os.Handler;
import android.os.Looper;

import com.fr.konwledge.bean.UserBean;
import com.fr.konwledge.model.UserModel;
import com.fr.konwledge.view.listener.CallBackListener;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * 创建时间：2019/7/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class UserViewModel implements PlatformActionListener {

    private PlatformDb platDB; //平台授权数据DB
    private CallBackListener mCallBackListener;
    private UserModel mUserModel;

    public UserViewModel(CallBackListener callBackListener){
        this.mCallBackListener = callBackListener;
        mUserModel = new UserModel();
    }

    public void qqLogin(){
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        authorize(qq);
    }

    public void wechatLogin(){
        // 微信登录
//      Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
//      authorize(wechat);
    }

    //第三方登录授权
    private void authorize(Platform plat) {

        if (plat == null){
            return;
        }

        // SSO授权方式，简单来说就是使用目标平台客户端来完成授权。
        // true不使用SSO授权，false使用SSO授权
        plat.setPlatformActionListener(this);
        plat.SSOSetting(false);
//        plat.authorize();
        //获取用户资料
        plat.showUser(null);
    }

    /**
     * onComplete在非主线程中，使用Toast需要切换到UI线程
     * @param plat  plat
     * @param i     action
     * @param hashMap   hashMap包含第三方用户信息
     */
    @Override
    public void onComplete(Platform plat, int i, HashMap<String, Object> hashMap) {
        UserBean userBean = new UserBean();

        if (i == Platform.ACTION_USER_INFOR) {

            platDB = plat.getDb(); // 获取平台数据DB

            if (plat.getName().equals(QQ.NAME)) {
                // QQ登录
                userBean.setToken(platDB.getToken());
                userBean.setUserId(platDB.getUserId());
                userBean.setName(hashMap.get("nickname").toString());// 名字
                userBean.setGender(hashMap.get("gender").toString());// 年龄
                userBean.setHeadImageUrl(hashMap.get("figureurl_qq_2").toString());// 头像figureurl_qq_2 中等图，figureurl_qq_1缩略图
                mUserModel.cacheUserInfo(userBean);
            }

            //切换到主线程
            new Handler(Looper.getMainLooper()).post(() -> mCallBackListener.onComplete());
        }
    }

    //授权出错回调
    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        mCallBackListener.onError(throwable.getMessage());
    }

    //取消授权回调
    @Override
    public void onCancel(Platform platform, int i) {
        mCallBackListener.onCancel();
    }

    public UserBean getUserInfo(){
        return mUserModel.getCurUserInfo();
    }

    public String getUserId(){
        return mUserModel.getUserId();
    }
}
