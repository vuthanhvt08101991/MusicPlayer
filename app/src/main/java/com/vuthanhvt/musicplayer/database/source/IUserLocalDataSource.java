package com.vuthanhvt.musicplayer.database.source;

import android.content.Context;

import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

import io.reactivex.Observable;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface IUserLocalDataSource.
 */
public interface IUserLocalDataSource {

    void loadDataFirstStart(Context context);

    List<Song> getAllSongs(Context context);
}
