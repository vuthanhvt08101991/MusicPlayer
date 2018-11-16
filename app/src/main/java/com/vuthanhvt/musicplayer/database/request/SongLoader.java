package com.vuthanhvt.musicplayer.database.request;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.vuthanhvt.musicplayer.model.Song;

import java.util.ArrayList;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SongLoader.
 */
public class SongLoader {

    public static Cursor makeSongCursor(Context context, String condition, String[] parameter) {
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST_ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.TITLE
        };
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                condition,
                parameter,
                MediaStore.Audio.Media.TITLE);

        return cursor;
    }

    public static ArrayList<Song> getSongsForCursor(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if ((cursor != null) && (cursor.moveToFirst()))
            do {
                long id = cursor.getLong(0);
                long albumId = cursor.getLong(1);
                String album = cursor.getString(2);
                long artistId = cursor.getInt(3);
                String artist = cursor.getString(4);
                int duration = cursor.getInt(5);
                String title = cursor.getString(6);

                arrayList.add(new Song(id, albumId, album, artistId, artist, duration, title));
            }
            while (cursor.moveToNext());
        if (cursor != null)
            cursor.close();
        return arrayList;
    }
}
