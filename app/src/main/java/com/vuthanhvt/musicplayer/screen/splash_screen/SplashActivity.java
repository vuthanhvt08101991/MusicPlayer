package com.vuthanhvt.musicplayer.screen.splash_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.database.request.UserRepository;
import com.vuthanhvt.musicplayer.databinding.ActivitySplashBinding;
import com.vuthanhvt.musicplayer.screen.main.MainActivity;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SplashActivity.
 */
public class SplashActivity extends BaseDataBindingActivity<ActivitySplashBinding, SplashPresenter>
        implements SplashView {

    public static final int TIME_DELAY = 1000;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        mPresenter = new SplashPresenter(this, UserRepository.getInstance());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.loadData();
            }
        }, TIME_DELAY);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected void onDestroy() {
        mPresenter.unSubscribe();
        super.onDestroy();
    }

    @Override
    public void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
