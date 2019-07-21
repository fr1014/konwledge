package com.fr.konwledge.bean;

import java.util.List;

public class CategoryListBean {

    /**
     * error : false
     * results : [{"_id":"5d2f24d19d2122031ea5223f","createdAt":"2019-07-17T13:38:25.504Z","desc":"状态切换，让View状态的切换和Activity彻底分离开。用builder模式来自由的添加需要的状态View，可以设置有数据，数据为空，加载数据错误，网络错误，加载中等多种状态，并且支持自定义状态的布局。","images":["http://img.gank.io/4b63f35c-f631-417b-9d88-916e70901634","http://img.gank.io/b7de0a96-0023-4c4c-b120-9fcbf8c6046c","http://img.gank.io/45f8f9b5-0be1-410b-a50d-b8d72046abb2","http://img.gank.io/89a0e411-1049-4322-80a1-9bd8d6dfb35e","http://img.gank.io/f3e3b597-0317-45cd-8288-d866888ce297"],"publishedAt":"2019-07-17T13:40:33.502Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCStateLayout/blob/master/README_CH.md","used":true,"who":"潇湘剑雨"},{"_id":"5d2c2ed89d21220321462163","createdAt":"2019-07-15T07:44:24.953Z","desc":"一个强大的侧滑框架，内置十多种侧滑效果：你知道微信侧滑返回的联动效果，但你见过开门效果、百叶窗效果吗？","publishedAt":"2019-07-17T13:39:51.470Z","source":"web","type":"Android","url":"https://github.com/luckybilly/SmartSwipe","used":true,"who":"潇湘剑雨"},{"_id":"5d2593289d2122031ea5222e","createdAt":"2019-07-10T07:26:32.0Z","desc":"AndroidBLE蓝牙框架，包括扫描、连接、设置通知、发送数据、读取、接收数据和OTA升级以及各种直观的回调，近乎一行代码植入项目，可扩展配置蓝牙相关操作。","images":["http://img.gank.io/4a57235f-2138-4e77-b3b9-aef99f10ca13"],"publishedAt":"2019-07-13T08:40:56.375Z","source":"web","type":"Android","url":"https://github.com/Alex-Jerry/Android-BLE","used":true,"who":"潇湘剑雨"},{"_id":"5d2593559d2122031b7980cf","createdAt":"2019-07-10T07:27:17.723Z","desc":"AopArms编写了Android开发中常用的一套注解，如日志、异步处理、缓存、SP、延迟操作、定时任务、重试机制、try-catch安全机制、过滤频繁点击、拦截等，后续还会有更多更强大的注解功能加入","publishedAt":"2019-07-13T08:40:32.56Z","source":"web","type":"Android","url":"https://github.com/AICareless/AopArms","used":true,"who":"潇湘剑雨"},{"_id":"5d24011b9d2122774f0cd8dd","createdAt":"2019-07-09T02:51:07.520Z","desc":"SharedPreferences 不为人知的秘密（下）","publishedAt":"2019-07-10T12:04:35.126Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/U75XuBCM6B5di0tTaPyxUg","used":true,"who":"潇湘剑雨"},{"_id":"5d1ea3f89d2122774f0cd8da","createdAt":"2019-07-05T01:12:24.992Z","desc":"真当Flutter不能热更新？QQ团队开源动态化Flutter","publishedAt":"2019-07-05T10:48:37.144Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/bH_SC2YHtXwrGGvQXt5FMg","used":true,"who":"潇湘剑雨"},{"_id":"5d19f32b9d2122774f0cd8d2","createdAt":"2019-07-01T11:48:59.726Z","desc":"2019 最前沿的几个 Flutter 实践：微信、咸鱼、美团 ","publishedAt":"2019-07-01T11:49:08.311Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/TyjwBASNvxnQNXtC3zCG1w","used":true,"who":"潇湘剑雨"},{"_id":"5d19f2d19d21220321462148","createdAt":"2019-07-01T11:47:29.85Z","desc":"Dart基础系统性的学习笔记总结","publishedAt":"2019-07-01T11:47:47.35Z","source":"web","type":"Android","url":"https://juejin.im/post/5d19dbf06fb9a07f014f0e46","used":true,"who":"潇湘剑雨"},{"_id":"5d1035ca9d2122031b7980b2","createdAt":"2019-06-24T02:30:34.222Z","desc":"Android 录屏 && 音轨剪辑（剔除环境声音），抗住百万级日活APP挑战，附带详细 Blog 实现思路，","publishedAt":"2019-06-27T02:38:12.271Z","source":"web","type":"Android","url":"https://github.com/nanchen2251/ScreenRecordHelper","used":true,"who":"潇湘剑雨"},{"_id":"5d11ba249d2122031b7980b5","createdAt":"2019-06-25T06:07:32.359Z","desc":"每日一问：从不一样的角度吐槽一下 DataBinding","publishedAt":"2019-06-26T02:49:35.15Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/GgDLJTU8x0txkSgGEtp6VA","used":true,"who":"潇湘剑雨"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5d2f24d19d2122031ea5223f
         * createdAt : 2019-07-17T13:38:25.504Z
         * desc : 状态切换，让View状态的切换和Activity彻底分离开。用builder模式来自由的添加需要的状态View，可以设置有数据，数据为空，加载数据错误，网络错误，加载中等多种状态，并且支持自定义状态的布局。
         * images : ["http://img.gank.io/4b63f35c-f631-417b-9d88-916e70901634","http://img.gank.io/b7de0a96-0023-4c4c-b120-9fcbf8c6046c","http://img.gank.io/45f8f9b5-0be1-410b-a50d-b8d72046abb2","http://img.gank.io/89a0e411-1049-4322-80a1-9bd8d6dfb35e","http://img.gank.io/f3e3b597-0317-45cd-8288-d866888ce297"]
         * publishedAt : 2019-07-17T13:40:33.502Z
         * source : web
         * type : Android
         * url : https://github.com/yangchong211/YCStateLayout/blob/master/README_CH.md
         * used : true
         * who : 潇湘剑雨
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
