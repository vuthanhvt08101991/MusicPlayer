package com.vuthanhvt.musicplayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.vuthanhvt.musicplayer.Constants;

import io.reactivex.annotations.NonNull;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Album.
 */

@Entity(tableName = Constants.Album.ALBUM_TABLE,
        foreignKeys = @ForeignKey(entity = Artist.class,
                                  parentColumns = Constants.Artist.ARTIST_ID,
                                  childColumns = Constants.Album.ALBUM_ARTIST_ID))
public class Album {

    @PrimaryKey
    @ColumnInfo(name = Constants.Album.ALBUM_ID)
    @NonNull
    private long mID;

    @ColumnInfo(name = Constants.Album.ALBUM_ARTIST_ID)
    @NonNull
    private long mArtistID;

    @ColumnInfo(name = Constants.Album.ALBUM_ARTIST_NAME)
    @NonNull
    private String mArtistName;

    @ColumnInfo(name = Constants.Album.ALBUM_NUMBER_SONGS)
    @NonNull
    private int mNumberSong;

    @ColumnInfo(name = Constants.Album.ALBUM_TITLE)
    @NonNull
    private String mTitle;

    @ColumnInfo(name = Constants.Album.ALBUM_YEAR)
    @NonNull
    private int mYear;

    public long getArtistID() {
        return mArtistID;
    }

    public void setArtistID(long mArtistID) {
        this.mArtistID = mArtistID;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String mArtistName) {
        this.mArtistName = mArtistName;
    }

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public int getNumberSong() {
        return mNumberSong;
    }

    public void setNumberSong(int mNumberSong) {
        this.mNumberSong = mNumberSong;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int mYear) {
        this.mYear = mYear;
    }

    public Album() {
        this.mID = -1;
        this.mTitle = "";
        this.mArtistName = "";
        this.mArtistID = -1;
        this.mNumberSong = -1;
        this.mYear = -1;
    }

    public Album(long _id, String _title, String _artistName, long _artistId, int _songCount, int _year) {
        this.mID = _id;
        this.mTitle = _title;
        this.mArtistName = _artistName;
        this.mArtistID = _artistId;
        this.mNumberSong = _songCount;
        this.mYear = _year;
    }


}
