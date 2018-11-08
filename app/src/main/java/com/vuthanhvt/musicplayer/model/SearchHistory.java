package com.vuthanhvt.musicplayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.vuthanhvt.musicplayer.Constants;

import io.reactivex.annotations.NonNull;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SearchHistory.
 */
@Entity(tableName = Constants.SearchHistory.SEARCH_HISTORY_TABLE)
public class SearchHistory {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.SearchHistory.SEARCH_ID)
    @NonNull
    private int mID;

    @ColumnInfo(name = Constants.SearchHistory.SEARCH_STRING)
    @NonNull
    private String mSearchString;

    @ColumnInfo(name = Constants.SearchHistory.SEARCH_TIME)
    @NonNull
    private String mSearchTime;

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getSearchString() {
        return mSearchString;
    }

    public void setSearchString(String mSearchString) {
        this.mSearchString = mSearchString;
    }

    public String getSearchTime() {
        return mSearchTime;
    }

    public void setSearchTime(String mSearchTime) {
        this.mSearchTime = mSearchTime;
    }

    public SearchHistory() {
        this.mID = -1;
        this.mSearchString = "";
        this.mSearchTime = "";
    }

    public SearchHistory(final int id, final String searchString, final String searchTime) {
        this.mID = id;
        this.mSearchString = searchString;
        this.mSearchTime = searchTime;
    }
}
