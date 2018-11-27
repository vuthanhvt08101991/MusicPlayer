package com.vuthanhvt.musicplayer.screen.allartists;

import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;
import com.vuthanhvt.musicplayer.model.Artist;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllArtistsPresenter.
 */
public class AllArtistsPresenter implements BasePresenter {

    public static final String TAG = "AllArtistsPresenter";

    private AllArtistsView mAllArtistsView;

    private UserRepository mUserRepository;

    public AllArtistsPresenter(AllArtistsView mAllArtistsView) {
        this.mAllArtistsView = mAllArtistsView;
        mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void getAllArtists() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllArtists: ");
        }
        List<Artist> artists = mUserRepository.getAllArtists(mAllArtistsView.context());
        mAllArtistsView.loadArtistsListSuccess(artists);
    }
}
