package com.vuthanhvt.musicplayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.vuthanhvt.musicplayer.Constants;

import io.reactivex.annotations.NonNull;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Artist.
 */
@Entity(tableName = Constants.Artist.ARTIST_TABLE)
public class Artist {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.Artist.ARTIST_ID)
    @NonNull
    private long mID;

    @ColumnInfo(name = Constants.Artist.ARTIST_NUMBER_ALBUMS)
    @NonNull
    private int mNumberAlbum;

    @ColumnInfo(name = Constants.Artist.ARTIST_NUMBER_SONGS)
    @NonNull
    private int mNumberSong;

    @ColumnInfo(name = Constants.Artist.ARTIST_NAME)
    @NonNull
    private String mName;

    public Artist() {
        this.mID = -1;
        this.mName = "";
        this.mNumberSong = -1;
        this.mNumberAlbum = -1;
    }

    public Artist(long _id, String _name, int _albumCount, int _songCount) {
        this.mID = _id;
        this.mName = _name;
        this.mNumberSong = _songCount;
        this.mNumberAlbum = _albumCount;
    }

}
