package com.vuthanhvt.musicplayer.screen.main;

import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.base.BasePresenter;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MainPresenter.
 */
public class MainPresenter implements BasePresenter {

    public static final String TAG = "MainPresenter";

    private MainView mMainView;

    public MainPresenter(MainView mMainView) {
        this.mMainView = mMainView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void onClickItemSearch() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSearch: ");
        }
    }

    public void onClickItemShare() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemShare: ");
        }
    }

    public void onClickItemShuffleAll() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemShuffleAll: ");
        }
    }

    public void onClickItemSortBy() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSortBy: ");
        }
    }

    public void onClickItemEqualizer() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemEqualizer: ");
        }
    }

    public void onClickItemSettings() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSettings: ");
        }
    }

    public void onClickNaviLibrary() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickNaviLibrary: ");
        }
    }

    public void onClickNaviPlayLists() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickNaviPlayLists: ");
        }
    }

    public void onClickNaviFolder() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickNaviFolder: ");
        }
    }

    public void onClickNaviPlayingQueue() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickNaviPlayingQueue: ");
        }
    }

    public void onClickNaviNowPlaying() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickNaviNowPlaying: ");
        }
    }

    public void onClickNaviAbout() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickNaviAbout: ");
        }
    }

    public void onClickNaviSupport() {
        Log.d(TAG, "onClickNaviSupport: ");
    }
}
