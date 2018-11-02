package com.vuthanhvt.musicplayer.screen.main;

import android.util.Log;

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
        Log.d(TAG, "onClickItemSearch: ");
    }

    public void onClickItemShare() {
        Log.d(TAG, "onClickItemShare: ");
    }

    public void onClickItemShuffleAll() {
        Log.d(TAG, "onClickItemShuffleAll: ");
    }

    public void onClickItemSortBy() {
        Log.d(TAG, "onClickItemSortBy: ");
    }

    public void onClickItemEqualizer() {
        Log.d(TAG, "onClickItemEqualizer: ");
    }

    public void onClickItemSettings() {
        Log.d(TAG, "onClickItemSettings: ");
    }

    public void onClickNaviLibrary() {
        Log.d(TAG, "onClickNaviLibrary: ");
    }

    public void onClickNaviPlayLists() {
        Log.d(TAG, "onClickNaviPlayLists: ");
    }

    public void onClickNaviFolder() {
        Log.d(TAG, "onClickNaviFolder: ");
    }

    public void onClickNaviPlayingQueue() {
        Log.d(TAG, "onClickNaviPlayingQueue: ");
    }

    public void onClickNaviNowPlaying() {
        Log.d(TAG, "onClickNaviNowPlaying: ");
    }

    public void onClickNaviAbout() {
        Log.d(TAG, "onClickNaviAbout: ");
    }

    public void onClickNaviSupport() {
        Log.d(TAG, "onClickNaviSupport: ");
    }
}
