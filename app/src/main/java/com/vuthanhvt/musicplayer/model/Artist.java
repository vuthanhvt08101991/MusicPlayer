package com.vuthanhvt.musicplayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

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
public class Artist implements Parcelable {

    @PrimaryKey
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

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public int getNumberAlbum() {
        return mNumberAlbum;
    }

    public void setNumberAlbum(int mNumberAlbum) {
        this.mNumberAlbum = mNumberAlbum;
    }

    public int getNumberSong() {
        return mNumberSong;
    }

    public void setNumberSong(int mNumberSong) {
        this.mNumberSong = mNumberSong;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String toStringFromNumberSong() {
        return mNumberSong <= 1 ? String.valueOf(mNumberSong) + " song" :
                String.valueOf(mNumberSong) + " songs";
    }

    public String toStringFromNumberAlbum() {
        return mNumberAlbum <= 1 ? String.valueOf(mNumberAlbum) + " album" :
                String.valueOf(mNumberAlbum) + " albums";
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mID);
        dest.writeInt(mNumberAlbum);
        dest.writeInt(mNumberSong);
        dest.writeString(mName);
    }

    protected Artist(Parcel in) {
        mID = in.readLong();
        mNumberAlbum = in.readInt();
        mNumberSong = in.readInt();
        mName = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
