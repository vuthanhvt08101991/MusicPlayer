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
 * Class Playlist.
 */
@Entity(tableName = Constants.Playlist.PLAYLIST_TABLE)
public class Playlist {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.Playlist.PLAYLIST_ID)
    @NonNull
    private long mID;

    @ColumnInfo(name = Constants.Playlist.PLAYLIST_NAME)
    @NonNull
    private String mName;

    @ColumnInfo(name = Constants.Playlist.PLAYLIST_NUMBER_SONGS)
    @NonNull
    private int mNumberSong;

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getNumberSong() {
        return mNumberSong;
    }

    public void setNumberSong(int mNumberSong) {
        this.mNumberSong = mNumberSong;
    }

    public Playlist() {
        this.mID = -1;
        this.mName = "";
        this.mNumberSong = -1;
    }

    public Playlist(long _id, String _name, int _songCount) {
        this.mID = _id;
        this.mName = _name;
        this.mNumberSong = _songCount;
    }
}
