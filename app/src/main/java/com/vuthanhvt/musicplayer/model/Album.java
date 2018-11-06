package com.vuthanhvt.musicplayer.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Album.
 */
public class Album {

    private long mArtistID;
    private String mArtistName;
    private long mID;
    private int mNumberSong;
    private String mTitle;
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
