package com.vuthanhvt.musicplayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.utils.SongUtils;

import io.reactivex.annotations.NonNull;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Song.
 */

@Entity(tableName = Constants.Song.SONG_TABLE)
public class Song {

    @PrimaryKey
    @ColumnInfo(name = Constants.Song.SONG_ID)
    @NonNull
    private long mID;

    @ForeignKey(entity = Artist.class,
            parentColumns = Constants.Artist.ARTIST_ID,
            childColumns = Constants.Song.SONG_ARTIST_ID)
    @ColumnInfo(name = Constants.Song.SONG_ALBUM_ID)
    @NonNull
    private long mAlbumId;

    @ColumnInfo(name = Constants.Song.SONG_ALBUM_NAME)
    @NonNull
    private String mAlbumName;

    @ForeignKey(
            entity = Album.class,
            parentColumns = Constants.Album.ALBUM_ID,
            childColumns = Constants.Song.SONG_ALBUM_ID
    )
    @ColumnInfo(name = Constants.Song.SONG_ARTIST_ID)
    @NonNull
    private long mArtistID;

    @ColumnInfo(name = Constants.Song.SONG_ARTIST_NAME)
    @NonNull
    private String mArtistName;

    @ColumnInfo(name = Constants.Song.SONG_DURATION)
    @NonNull
    private long mDuration;

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

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long mDuration) {
        this.mDuration = mDuration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String convertDuration() {
        return SongUtils.convertDurationOfSong(getDuration());
    }

    public Song() {
        this.mID = -1;
        this.mAlbumId = -1;
        this.mAlbumName = "";
        this.mArtistID = -1;
        this.mArtistName = "";
        this.mDuration = -1;
        this.mTitle = "";
    }

    public Song(long _id, long _albumId, String _albumName,  long _artistId, String _artistName,
                int _duration, String _title) {
        this.mID = _id;
        this.mAlbumId = _albumId;
        this.mAlbumName = _albumName;
        this.mArtistID = _artistId;
        this.mArtistName = _artistName;
        this.mDuration = _duration;
        this.mTitle = _title;
    }
}
