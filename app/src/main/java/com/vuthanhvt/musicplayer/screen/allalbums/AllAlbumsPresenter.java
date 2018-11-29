package com.vuthanhvt.musicplayer.screen.allalbums;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.screen.detailalbum.DetailAlbumActivity;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * CLass AllAlbumsPresenter.
 */
public class AllAlbumsPresenter implements BasePresenter {

    public static final String TAG = "AllAlbumsPresenter";

    private AllAlbumsView mAllAlbumsView;

    private UserRepository mUserRepository;

    public AllAlbumsPresenter(AllAlbumsView mAllAlbumsView) {
        this.mAllAlbumsView = mAllAlbumsView;
        this.mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void getAllAlbums() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllAlbums: ");
        }
        List<Album> mAlbums = mUserRepository.getAllAlbums(mAllAlbumsView.context());
        mAllAlbumsView.loadAlbumsListSuccess(mAlbums);
    }

    public void goToDetailAlbum(Album data) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "goToDetailAlbum: ");
        }
        Intent intent = new Intent(mAllAlbumsView.context(), DetailAlbumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.SendIntent.SEND_DETAIL_ALBUM, data);
        intent.putExtra(Constants.SendIntent.BUNDLE_SEND_DETAIL_ALBUM, bundle);
        mAllAlbumsView.context().startActivity(intent);
    }
}
