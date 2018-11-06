package com.vuthanhvt.musicplayer.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Artist.
 */
public class Artist {

    private int mNumberAlbum;
    private long mID;
    private int mNumberSong;
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
