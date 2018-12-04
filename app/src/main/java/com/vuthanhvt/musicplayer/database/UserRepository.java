package com.vuthanhvt.musicplayer.database;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.database.source.IUserLocalDataSource;
import com.vuthanhvt.musicplayer.database.source.UserLocalDataSource;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

import io.reactivex.Observable;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class UserRepository.
 */
public class UserRepository implements IUserLocalDataSource {
    
    public static final String TAG = "UserRepository";

    private static UserRepository mInstance = new UserRepository(UserLocalDataSource.getInstance());

    private IUserLocalDataSource mUserLocalDataSource;

    private UserRepository(UserLocalDataSource userLocalDataSource) {
        this.mUserLocalDataSource = userLocalDataSource;
    }

    public static UserRepository getInstance() {
        return mInstance;
    }

    @Override
    public void loadDataFirstStart(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadDataFirstStart: ");
        }
        mUserLocalDataSource.loadDataFirstStart(context);
    }

    @Override
    public List<Song> getAllSongs(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllSongs: ");
        }
        return mUserLocalDataSource.getAllSongs(context);
    }

    @Override
    public List<Album> getAllAlbums(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllAlbums: ");
        }
        return mUserLocalDataSource.getAllAlbums(context);
    }

    @Override
    public List<Artist> getAllArtists(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllArtists: ");
        }
        return mUserLocalDataSource.getAllArtists(context);
    }

    @Override
    public List<Song> getAllSongsInAlbum(Context context, long albumID) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getAllSongsInAlbum: ");
        }
        return mUserLocalDataSource.getAllSongsInAlbum(context, albumID);
    }

    @Override
    public List<Album> getListAlbumsOfSpecialArtist(Context context, long artistID) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getListAlbumsOfSpecialArtist: ");
        }
        return mUserLocalDataSource.getListAlbumsOfSpecialArtist(context, artistID);
    }

    @Override
    public List<Song> getListSongsOfSpecialArtist(Context context, long artistID) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getListSongsOfSpecialArtist: ");
        }
        return mUserLocalDataSource.getListSongsOfSpecialArtist(context, artistID);
    }
}
