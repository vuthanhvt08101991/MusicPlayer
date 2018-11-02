package com.vuthanhvt.musicplayer.screen.splash_screen;

import android.util.Log;

import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.request.UserRepository;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SplashPresenter.
 */
public class SplashPresenter implements BasePresenter {

    public static final String TAG = "SplashPresenter";

    private SplashView mSplashView;

    public CompositeDisposable mComposite;

    private UserRepository mUserRepository;

    public SplashPresenter(SplashView mSplashView, UserRepository userRepository) {
        this.mSplashView = mSplashView;
        this.mUserRepository = userRepository;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if (mComposite != null) {
            mComposite.clear();
        }
    }

    public void loadData() {
        Log.d(TAG, "loadData: ");
    }
}
