package com.vuthanhvt.musicplayer.database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vuthanhvt.musicplayer.Constants;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MusicDB.
 */
public class MusicDB extends SQLiteOpenHelper {

    private static MusicDB sInstance = null;

    private final Context mContext;

    public MusicDB(final Context context) {
        super(context, Constants.DBConstant.DATABASE_NAME, null, Constants.DBConstant.VERSION);
        mContext = context;
    }

    public static final synchronized MusicDB getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new MusicDB(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: Update database
        /*MusicPlaybackState.getInstance(mContext).onCreate(db);
        RecentStore.getInstance(mContext).onCreate(db);
        SongPlayCount.getInstance(mContext).onCreate(db);*/
        SearchHistory.getInstance(mContext).onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Update database
        /*MusicPlaybackState.getInstance(mContext).onUpgrade(db, oldVersion, newVersion);
        RecentStore.getInstance(mContext).onUpgrade(db, oldVersion, newVersion);
        SongPlayCount.getInstance(mContext).onUpgrade(db, oldVersion, newVersion);*/
        SearchHistory.getInstance(mContext).onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Update database
        /*MusicPlaybackState.getInstance(mContext).onDowngrade(db, oldVersion, newVersion);
        RecentStore.getInstance(mContext).onDowngrade(db, oldVersion, newVersion);
        SongPlayCount.getInstance(mContext).onDowngrade(db, oldVersion, newVersion);*/
        SearchHistory.getInstance(mContext).onDowngrade(db, oldVersion, newVersion);
    }
}
