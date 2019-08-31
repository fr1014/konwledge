package com.fr.knowledge.bean;

import java.util.List;

/**
 * 创建时间：2019/8/25
 * 作者：范瑞
 * 博客：https://www.jianshu.com/u/408f3c1b46a9
 */
public class WanAndroidListBean<T> {


    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":" JD-CP","chapterId":375,"chapterName":"Flutter","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9014,"link":"https://juejin.im/post/5d5f3521e51d453b1e478ad6","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1566619893000,"superChapterId":375,"superChapterName":"跨平台","tags":[],"title":"基于Flutter实现的仿开眼视频App","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"androad","chapterId":200,"chapterName":"https","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9013,"link":"https://juejin.im/post/5d5e5cd8f265da03cc08c1e1","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1566494586000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"Android网络编程-HTTP/HTTPS","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"猩程变","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9012,"link":"https://juejin.im/post/5d5e6c48f265da03bf0f4953","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1566494513000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"再探Gradle","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":360,"chapterName":"小编发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9011,"link":"https://www.wanandroid.com/blog/show/2659","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406686000,"superChapterId":298,"superChapterName":"原创文章","tags":[],"title":"为了感谢经常访问的同学，我们上线了积分机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"连理枝__","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9010,"link":"https://www.jianshu.com/p/95907802e10b","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406567000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"面试官：\u201c你重写过 hashcode 和 equals 么，为什么重写equals时必须重写hashCode方法？\u201d","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 的一幕","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9009,"link":"https://www.jianshu.com/p/cf2169630f5e","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406544000,"superChapterId":93,"superChapterName":"自定义控件","tags":[],"title":"一分钟搞定触手app主页酷炫滑动切换效果","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"波波维奇c","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9008,"link":"https://www.jianshu.com/p/5d0a1879fd6f","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406520000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"View.Post () 的身世大揭秘","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lovesosoi","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9007,"link":"https://www.jianshu.com/p/c0e00bca6cba","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406490000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 如何更优雅的打Log","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MxsQ","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9006,"link":"https://www.jianshu.com/p/92dc4f16cfc5","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406464000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"JVM 方法到底如何执行","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 爱情小傻蛋 ","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9005,"link":"https://www.jianshu.com/p/543d438c67e9","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406444000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"同步屏障CyclicBarrier的实现原理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"JohnnyShieh","chapterId":227,"chapterName":"注解","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9004,"link":"https://www.jianshu.com/p/d32a2453786e","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406420000,"superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"AspectJ in Android （三），AspectJ 两种用法以及常见问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"灯不利多","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9003,"link":"https://juejin.im/post/5d5aa36af265da03963b9913","niceDate":"2019-08-21","origin":"","prefix":"","projectLink":"","publishTime":1566319394000,"superChapterId":184,"superChapterName":"热门专题","tags":[],"title":"探索 Android 启动优化方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"就找个细节考察下 Gradle 相关知识吧。\r\n每个项目中，gradle 都会帮助我们生成一个 BuildConfig，那么：\r\n\r\n这个类有何用处？\r\n是在项目的编译期间，那个环节、如何生成的？\r\n\r\n欢迎了解多少说多少，不了解学了过来总结一下。","envelopePic":"","fresh":false,"id":8985,"link":"https://www.wanandroid.com/wenda/show/8985","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566314853000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 今天聊一下Gradle 相关，BuildConfig这个类是如何生成的？","type":0,"userId":2,"visible":1,"zan":13},{"apkLink":"","author":"却把清梅嗅","chapterId":124,"chapterName":"Fragment","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9001,"link":"https://juejin.im/post/5d5a62c0e51d4561ba48fde0","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233526000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"反思|Android LayoutInflater机制的设计与实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 青蛙要fly","chapterId":124,"chapterName":"Fragment","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9000,"link":"https://juejin.im/post/5cda8b81f265da034c704ab1","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233512000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"Android技能树 \u2014 Fragment总体小结","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"ZY5A59","chapterId":488,"chapterName":"Java8+","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8999,"link":"https://juejin.im/post/5d5950806fb9a06b0a277412","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233488000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"聊聊 Java8 以后各个版本的新特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Hanking","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8998,"link":"https://juejin.im/post/5d57d5fef265da03ef7a10c3","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233449000,"superChapterId":184,"superChapterName":"热门专题","tags":[],"title":"android高级进阶之12条代码优化以及性能优化方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wanderingguy","chapterId":487,"chapterName":"ViewModel","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8997,"link":"https://juejin.im/post/5d5a3cd9f265da03c23ed40a","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233424000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"Android ViewModel，再学不会你砍我","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"binaryshao","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"玩 Android 客户端，采用 kotlin 语言，Material Design 风格，根据 MVVM 架构使用 Jetpack 架构组件搭建了整套框架\r\n","envelopePic":"https://www.wanandroid.com/blogimgs/10491b74-b534-48b1-a5fe-d2ac00e20d2d.png","fresh":false,"id":8996,"link":"http://www.wanandroid.com/blog/show/2658","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"https://github.com/binaryshao/WanAndroid-MVVM","publishTime":1566233222000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"玩 Android 客户端 MVVM 架构使用 Jetpack 架构组件 ","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"binaryshao","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"玩 Android 客户端，采用 React-Native 开发，适配了 Android 和 iOS，几乎对接了玩安卓的所有 API，内容比较完整\r\n","envelopePic":"https://www.wanandroid.com/blogimgs/f01805b1-041e-466b-8212-9e491b9fafea.png","fresh":false,"id":8994,"link":"http://www.wanandroid.com/blog/show/2656","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"https://github.com/binaryshao/WanAndroid_RN","publishTime":1566233202000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"玩 Android 客户端 React-Native 开发","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":351,"size":20,"total":7011}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean<T> data;
    private int errorCode;
    private String errorMsg;

    public DataBean<T> getData() {
        return data;
    }

    public void setData(DataBean<T> data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean<T> {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":" JD-CP","chapterId":375,"chapterName":"Flutter","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9014,"link":"https://juejin.im/post/5d5f3521e51d453b1e478ad6","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1566619893000,"superChapterId":375,"superChapterName":"跨平台","tags":[],"title":"基于Flutter实现的仿开眼视频App","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"androad","chapterId":200,"chapterName":"https","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9013,"link":"https://juejin.im/post/5d5e5cd8f265da03cc08c1e1","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1566494586000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"Android网络编程-HTTP/HTTPS","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"猩程变","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9012,"link":"https://juejin.im/post/5d5e6c48f265da03bf0f4953","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1566494513000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"再探Gradle","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":360,"chapterName":"小编发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9011,"link":"https://www.wanandroid.com/blog/show/2659","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406686000,"superChapterId":298,"superChapterName":"原创文章","tags":[],"title":"为了感谢经常访问的同学，我们上线了积分机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"连理枝__","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9010,"link":"https://www.jianshu.com/p/95907802e10b","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406567000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"面试官：\u201c你重写过 hashcode 和 equals 么，为什么重写equals时必须重写hashCode方法？\u201d","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 的一幕","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9009,"link":"https://www.jianshu.com/p/cf2169630f5e","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406544000,"superChapterId":93,"superChapterName":"自定义控件","tags":[],"title":"一分钟搞定触手app主页酷炫滑动切换效果","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"波波维奇c","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9008,"link":"https://www.jianshu.com/p/5d0a1879fd6f","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406520000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"View.Post () 的身世大揭秘","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lovesosoi","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9007,"link":"https://www.jianshu.com/p/c0e00bca6cba","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406490000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 如何更优雅的打Log","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MxsQ","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9006,"link":"https://www.jianshu.com/p/92dc4f16cfc5","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406464000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"JVM 方法到底如何执行","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 爱情小傻蛋 ","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9005,"link":"https://www.jianshu.com/p/543d438c67e9","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406444000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"同步屏障CyclicBarrier的实现原理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"JohnnyShieh","chapterId":227,"chapterName":"注解","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9004,"link":"https://www.jianshu.com/p/d32a2453786e","niceDate":"2019-08-22","origin":"","prefix":"","projectLink":"","publishTime":1566406420000,"superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"AspectJ in Android （三），AspectJ 两种用法以及常见问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"灯不利多","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9003,"link":"https://juejin.im/post/5d5aa36af265da03963b9913","niceDate":"2019-08-21","origin":"","prefix":"","projectLink":"","publishTime":1566319394000,"superChapterId":184,"superChapterName":"热门专题","tags":[],"title":"探索 Android 启动优化方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"就找个细节考察下 Gradle 相关知识吧。\r\n每个项目中，gradle 都会帮助我们生成一个 BuildConfig，那么：\r\n\r\n这个类有何用处？\r\n是在项目的编译期间，那个环节、如何生成的？\r\n\r\n欢迎了解多少说多少，不了解学了过来总结一下。","envelopePic":"","fresh":false,"id":8985,"link":"https://www.wanandroid.com/wenda/show/8985","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566314853000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 今天聊一下Gradle 相关，BuildConfig这个类是如何生成的？","type":0,"userId":2,"visible":1,"zan":13},{"apkLink":"","author":"却把清梅嗅","chapterId":124,"chapterName":"Fragment","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9001,"link":"https://juejin.im/post/5d5a62c0e51d4561ba48fde0","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233526000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"反思|Android LayoutInflater机制的设计与实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 青蛙要fly","chapterId":124,"chapterName":"Fragment","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9000,"link":"https://juejin.im/post/5cda8b81f265da034c704ab1","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233512000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"Android技能树 \u2014 Fragment总体小结","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"ZY5A59","chapterId":488,"chapterName":"Java8+","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8999,"link":"https://juejin.im/post/5d5950806fb9a06b0a277412","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233488000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"聊聊 Java8 以后各个版本的新特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Hanking","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8998,"link":"https://juejin.im/post/5d57d5fef265da03ef7a10c3","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233449000,"superChapterId":184,"superChapterName":"热门专题","tags":[],"title":"android高级进阶之12条代码优化以及性能优化方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wanderingguy","chapterId":487,"chapterName":"ViewModel","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8997,"link":"https://juejin.im/post/5d5a3cd9f265da03c23ed40a","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"","publishTime":1566233424000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"Android ViewModel，再学不会你砍我","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"binaryshao","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"玩 Android 客户端，采用 kotlin 语言，Material Design 风格，根据 MVVM 架构使用 Jetpack 架构组件搭建了整套框架\r\n","envelopePic":"https://www.wanandroid.com/blogimgs/10491b74-b534-48b1-a5fe-d2ac00e20d2d.png","fresh":false,"id":8996,"link":"http://www.wanandroid.com/blog/show/2658","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"https://github.com/binaryshao/WanAndroid-MVVM","publishTime":1566233222000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"玩 Android 客户端 MVVM 架构使用 Jetpack 架构组件 ","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"binaryshao","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"玩 Android 客户端，采用 React-Native 开发，适配了 Android 和 iOS，几乎对接了玩安卓的所有 API，内容比较完整\r\n","envelopePic":"https://www.wanandroid.com/blogimgs/f01805b1-041e-466b-8212-9e491b9fafea.png","fresh":false,"id":8994,"link":"http://www.wanandroid.com/blog/show/2656","niceDate":"2019-08-20","origin":"","prefix":"","projectLink":"https://github.com/binaryshao/WanAndroid_RN","publishTime":1566233202000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"玩 Android 客户端 React-Native 开发","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 351
         * size : 20
         * total : 7011
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<T> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<T> getDatas() {
            return datas;
        }

        public void setDatas(List<T> datas) {
            this.datas = datas;
        }

    }
}
