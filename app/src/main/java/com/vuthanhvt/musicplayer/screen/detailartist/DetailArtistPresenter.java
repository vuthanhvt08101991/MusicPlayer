package com.vuthanhvt.musicplayer.screen.detailartist;

import android.content.Intent;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.model.Song;
import com.vuthanhvt.musicplayer.screen.detailalbum.DetailAlbumActivity;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class DetailArtistPresenter.
 */
public class DetailArtistPresenter implements BasePresenter {

    public static final String TAG = "DetailArtistPresenter";

    private UserRepository mUserRepository;

    private DetailArtistView mDetailArtistView;

    public ObservableField<String> mNumberAlbum;

    public ObservableField<String> mNumberSong;

    public DetailArtistPresenter(DetailArtistView mDetailArtistView) {
        this.mDetailArtistView = mDetailArtistView;
        this.mUserRepository = UserRepository.getInstance();
        mNumberAlbum = new ObservableField<>();
        mNumberSong = new ObservableField<>();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void getDetailArtist(Artist artist, int nbAlbum, int nbSong) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "setDetailArtist: ");
        }
        List<Album> albums = mUserRepository.getListAlbumsOfSpecialArtist(mDetailArtistView.context(),
                artist.getID());
        List<Song> songs = mUserRepository.getListSongsOfSpecialArtist(mDetailArtistView.context(),
                artist.getID());
        if (nbAlbum != albums.size() || nbSong != songs.size()) {
            return;
        }
        mDetailArtistView.getDetailArtistSuccess(albums, songs);
    }

    public void goToDetailAlbum(Album data) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "goToDetailAlbum: ");
        }
        Intent intent = new Intent(mDetailArtistView.context(), DetailAlbumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.SendIntent.SEND_DETAIL_ALBUM, data);
        intent.putExtra(Constants.SendIntent.BUNDLE_SEND_DETAIL_ALBUM, bundle);
        mDetailArtistView.context().startActivity(intent);
    }
}
