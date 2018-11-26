package com.vuthanhvt.musicplayer.screen.allsongs;

import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllSongsPresenter.
 */
public class AllSongsPresenter implements BasePresenter {

    public static final String TAG = "AllSongsPresenter";

    private AllSongsView mAllSongsView;

    private UserRepository mUserRepository;

    public AllSongsPresenter(AllSongsView view) {
        this.mAllSongsView = view;
        mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void getAllSongs() {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "getAllSongs: ");
        }
        List<Song> mSongs = mUserRepository.getAllSongs(mAllSongsView.context());
        mAllSongsView.loadSongsListSuccess(mSongs);
    }
}
