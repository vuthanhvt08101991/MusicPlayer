package com.vuthanhvt.musicplayer.database.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vuthanhvt.musicplayer.Constants;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SearchHistory.
 */
public class SearchHistory {

    private static SearchHistory sInstance = null;

    private MusicDB mMusicDB = null;

    public SearchHistory(final Context context) {
        mMusicDB = MusicDB.getInstance(context);
    }

    public static final synchronized SearchHistory getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new SearchHistory(context.getApplicationContext());
        }
        return sInstance;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Constants.SearchHistory.TABLE_SEARCH_HISTORY
                + " ("
                + Constants.SearchHistory.SEARCH_STRING + " STRING NOT NULL, "
                + Constants.SearchHistory.SEARCH_TIME + " LONG NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do not something.
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.SearchHistory.TABLE_SEARCH_HISTORY);
        onCreate(db);
    }

    public void addSearchString(final String searchString) {
        if (searchString == null) {
            return;
        }

        String trimmedString = searchString.trim();
        if (trimmedString.isEmpty()) {
            return;
        }

        final SQLiteDatabase database = mMusicDB.getWritableDatabase();
        database.beginTransaction();
        try {
            //delete all searched string in history equal trimmedString.
            database.delete(Constants.SearchHistory.TABLE_SEARCH_HISTORY,
                    Constants.SearchHistory.SEARCH_STRING + " = ? COLLATE NOCASE",
                    new String[]{trimmedString});

            //insert data
            final ContentValues values = new ContentValues(2);
            values.put(Constants.SearchHistory.SEARCH_STRING, trimmedString);
            values.put(Constants.SearchHistory.SEARCH_TIME, System.currentTimeMillis());
            database.insert(Constants.SearchHistory.TABLE_SEARCH_HISTORY, null, values);

            Cursor oldest = null;
            try {
                //sort by time searched.
                database.query(Constants.SearchHistory.TABLE_SEARCH_HISTORY,
                        new String[]{Constants.SearchHistory.SEARCH_TIME}, null, null, null, null,
                        Constants.SearchHistory.SEARCH_TIME + " ASC");

                //delete all item out of max item.
                if (oldest != null && oldest.getCount() > Constants.SearchHistory.MAX_ITEM) {
                    oldest.moveToPosition(oldest.getCount() - Constants.SearchHistory.MAX_ITEM);
                    long timeOfRecordToKeep = oldest.getLong(0);

                    database.delete(Constants.SearchHistory.TABLE_SEARCH_HISTORY,
                            Constants.SearchHistory.SEARCH_TIME + " < ?",
                            new String[]{String.valueOf(timeOfRecordToKeep)});

                }
            } finally {
                if (oldest != null) {
                    oldest.close();
                    oldest = null;
                }
            }
        } finally {
            database.setTransactionSuccessful();
            database.endTransaction();
        }
    }
}
