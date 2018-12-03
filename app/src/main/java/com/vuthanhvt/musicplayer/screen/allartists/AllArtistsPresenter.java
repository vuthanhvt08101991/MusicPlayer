package com.vuthanhvt.musicplayer.screen.allartists;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.screen.detailartist.DetailArtistActivity;

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

    public void goToDetailArtist(Artist artist, int nbAlbum, int nbSong) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "goToDetailArtist: ");
        }
        Intent intent = new Intent(mAllArtistsView.context(), DetailArtistActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.SendIntent.SEND_DETAIL_ARTIST, artist);
        bundle.putInt(Constants.SendIntent.SEND_NUMBER_ALBUM, nbAlbum);
        bundle.putInt(Constants.SendIntent.SEND_NUMBER_SONG, nbSong);
        intent.putExtra(Constants.SendIntent.BUNDLE_SEND_DETAIL_ARTIST, bundle);
        mAllArtistsView.context().startActivity(intent);
    }
}
