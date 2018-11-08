package com.vuthanhvt.musicplayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.vuthanhvt.musicplayer.Constants;

import io.reactivex.annotations.NonNull;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Song.
 */

@Entity(tableName = Constants.Song.SONG_TABLE,
        foreignKeys = {
                @ForeignKey(
                        entity = Album.class,
                        parentColumns = Constants.Album.ALBUM_ID,
                        childColumns = Constants.Song.SONG_ALBUM_ID
                ),
                @ForeignKey(
                        entity = Artist.class,
                        parentColumns = Constants.Artist.ARTIST_ID,
                        childColumns = Constants.Song.SONG_ARTIST_ID
                )
        })
public class Song {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.Song.SONG_ID)
    @NonNull
    private long mID;

    @ColumnInfo(name = Constants.Song.SONG_ALBUM_ID)
    @NonNull
    private long mAlbumId;

    @ColumnInfo(name = Constants.Song.SONG_ALBUM_NAME)
    @NonNull
    private String mAlbumName;

    @ColumnInfo(name = Constants.Song.SONG_ARTIST_ID)
    @NonNull
    private long mArtistID;

    @ColumnInfo(name = Constants.Song.SONG_ARTIST_NAME)
    @NonNull
    private String mArtistName;

    @ColumnInfo(name = Constants.Song.SONG_DURATION)
    @NonNull
    private int mDuration;

    @ColumnInfo(name = Constants.Song.SONG_TITLE)
    @NonNull
    private String mTitle;

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public long getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(long mAlbumId) {
        this.mAlbumId = mAlbumId;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public void setAlbumName(String mAlbumName) {
        this.mAlbumName = mAlbumName;
    }

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

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Song() {
        this.mID = -1;
        this.mAlbumId = -1;
        this.mArtistID = -1;
        this.mTitle = "";
        this.mArtistName = "";
        this.mAlbumName = "";
        this.mDuration = -1;
    }

    public Song(long _albumId, long _artistId, String _title, String _artistName,
                String _albumName, int _duration) {
        this.mAlbumId = _albumId;
        this.mArtistID = _artistId;
        this.mTitle = _title;
        this.mArtistName = _artistName;
        this.mAlbumName = _albumName;
        this.mDuration = _duration;
    }
}
