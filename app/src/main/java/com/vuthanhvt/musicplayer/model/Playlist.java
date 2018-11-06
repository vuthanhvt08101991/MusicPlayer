package com.vuthanhvt.musicplayer.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Playlist.
 */
public class Playlist {

    private long mID;
    private String mName;
    private int mNumberSong;

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
