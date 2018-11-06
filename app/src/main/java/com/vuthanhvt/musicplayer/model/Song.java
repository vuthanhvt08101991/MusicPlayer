package com.vuthanhvt.musicplayer.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Song.
 */
public class Song {

    private long mAlbumId;
    private String mAlbumName;
    private long mArtistID;
    private String mArtistName;
    private int mDuration;
    private long mID;
    private String mTitle;
    private int mTrackNumber;

    public Song() {
        this.mID = -1;
        this.mAlbumId = -1;
        this.mArtistID = -1;
        this.mTitle = "";
        this.mArtistName = "";
        this.mAlbumName = "";
        this.mDuration = -1;
        this.mTrackNumber = -1;
    }

    public Song(long _id, long _albumId, long _artistId, String _title, String _artistName,
                String _albumName, int _duration, int _trackNumber) {
        this.mID = _id;
        this.mAlbumId = _albumId;
        this.mArtistID = _artistId;
        this.mTitle = _title;
        this.mArtistName = _artistName;
        this.mAlbumName = _albumName;
        this.mDuration = _duration;
        this.mTrackNumber = _trackNumber;
    }
}
