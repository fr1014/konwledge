package com.fr.konwledge.bean;

import androidx.databinding.BaseObservable;

/**
 * 创建时间：2019/7/31
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class UserBean extends BaseObservable {
    private String headImageUrl = null;//头像
    private String userId;//userId
    private String token;//token
    private String gender;//性别
    private String name = null;//用户名

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "headImageUrl='" + headImageUrl + '\'' +
                ", userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
