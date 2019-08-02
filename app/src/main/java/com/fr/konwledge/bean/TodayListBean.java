package com.fr.konwledge.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TodayListBean<T> {
    private boolean isError;
    private ResultsBean<T> results;
    private List<String> category;

    public boolean isError() {
        return isError;
    }

    public ResultsBean<T> getResults() {
        return results;
    }

    public List<String> getCategory() {
        return category;
    }

    public static class ResultsBean<T> {
        private List<T> Android;
        private List<T> App;
        private List<T> iOS;
        @SerializedName("休息视频")
        private List<T> Rest;
        @SerializedName("前端")
        private List<T> Web;
        @SerializedName("拓展资源")
        private List<T> More;
        @SerializedName("瞎推荐")
        private List<T> Casual;
        @SerializedName("福利")
        private List<T> Welfare;

        public List<T> getAndroid() {
            return Android;
        }

        public void setAndroid(List<T> android) {
            Android = android;
        }

        public List<T> getApp() {
            return App;
        }

        public void setApp(List<T> app) {
            App = app;
        }

        public List<T> getiOS() {
            return iOS;
        }

        public void setiOS(List<T> iOS) {
            this.iOS = iOS;
        }

        public List<T> getRest() {
            return Rest;
        }

        public void setRest(List<T> rest) {
            Rest = rest;
        }

        public List<T> getWeb() {
            return Web;
        }

        public void setWeb(List<T> web) {
            Web = web;
        }

        public List<T> getMore() {
            return More;
        }

        public void setMore(List<T> more) {
            More = more;
        }

        public List<T> getCasual() {
            return Casual;
        }

        public void setCasual(List<T> casual) {
            Casual = casual;
        }

        public List<T> getWelfare() {
            return Welfare;
        }

        public void setWelfare(List<T> welfare) {
            Welfare = welfare;
        }


    }
}
