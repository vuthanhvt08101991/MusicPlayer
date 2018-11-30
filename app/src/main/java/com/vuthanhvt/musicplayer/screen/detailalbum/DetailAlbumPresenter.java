package com.vuthanhvt.musicplayer.screen.detailalbum;

import android.databinding.ObservableField;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 28/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class DetailAlbumPresenter.
 */
public class DetailAlbumPresenter implements BasePresenter {

    public static final String TAG = "DetailAlbumPresenter";

    private DetailAlbumView mDetailAlbumView;

    private UserRepository mUserRepository;

    public ObservableField<String> mArtistName;

    public ObservableField<String> mYear;

    public ObservableField<String> mTrackNumber;

    public DetailAlbumPresenter(DetailAlbumView mDetailAlbumView) {
        this.mDetailAlbumView = mDetailAlbumView;
        this.mUserRepository = UserRepository.getInstance();
        mArtistName = new ObservableField<>();
        mYear = new ObservableField<>();
        mTrackNumber = new ObservableField<>();
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

    public void onClickItemSortByAZ() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSortByAZ: ");
        }
    }

    public void onClickItemSortByZA() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSortByZA: ");
        }
    }

    public void onClickItemSortByYear() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSortByYear: ");
        }
    }

    public void onClickItemSortByTrackNumber() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSortByTrackNumber: ");
        }
    }

    public void onClickItemSortByDuration() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemSortByDuration: ");
        }
    }

    public void onClickItemAboutArtist() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemAboutArtist: ");
        }
    }

    public void onClickItemAddQueue() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemAddQueue: ");
        }
    }

    public void onClickItemAddPlaylist() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onClickItemAddPlaylist: ");
        }
    }

    public void getAllSongsInAlbum(long albumID) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllSongsInAlbum: ");
        }
        List<Song> mSongs = mUserRepository.getAllSongsInAlbum(mDetailAlbumView.context(), albumID);
        mDetailAlbumView.loadSongsListSuccess(mSongs);
    }
}
