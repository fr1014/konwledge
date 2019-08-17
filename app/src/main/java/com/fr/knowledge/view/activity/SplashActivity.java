package com.fr.knowledge.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.fr.knowledge.R;
import com.fr.knowledge.base.BaseActivity;
import com.fr.knowledge.databinding.ActivitySplashBinding;
import com.fr.knowledge.viewmodel.UserViewModel;

import java.util.Timer;
import java.util.TimerTask;

import static com.fr.knowledge.view.anim.anims.initScaleAnim;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> implements View.OnClickListener {

    private int recLen = 3; //倒计时提示为3秒
    private static final long DELAYMILLIS = 3000;
    private TextView mTextView;
    Timer timer = new Timer();
    private Handler mHandler;
    private Runnable mRunnable;
    private UserViewModel mUserViewModel;

    @Override
    protected void initData() {
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);

        mTextView = binding.tv;
        mTextView.setOnClickListener(this);

        mUserViewModel = new UserViewModel();

        initScaleAnim(this,binding.icon);

        timer.schedule(task, 1000,1000);     //等待1秒，每停顿1秒执行task

        //正常情况下不点击跳过
        mHandler = new Handler();

        //从闪屏页跳转到登录界面或首页
        mHandler.postDelayed(mRunnable = () -> startActivity(), DELAYMILLIS);
    }

    // TimerTask类表示一个在指定时间内执行的task
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(() -> {       //在UI线程中进行
                recLen--;
                mTextView.setText("点击跳过" + recLen);
                if (recLen < 0) {
                    timer.cancel();
                    mTextView.setVisibility(View.GONE);
                }
            });
        }
    };

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                startActivity();
                if (mRunnable != null){
                    //防止内存泄漏
                    mHandler.removeCallbacks(mRunnable);
                }
                break;
            default:
                break;
        }
    }

    private void startActivity() {
        //判断是否为登录状态
        if (mUserViewModel.getUserInfo() != null) {
            startActivity(MainActivity.class);
        } else {
            startActivity(LoginActivity.class);
        }
        SplashActivity.this.finish();
    }

}
