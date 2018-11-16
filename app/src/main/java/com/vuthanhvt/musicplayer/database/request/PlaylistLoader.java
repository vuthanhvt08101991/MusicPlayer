package com.vuthanhvt.musicplayer.database.request;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.vuthanhvt.musicplayer.model.Playlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 16/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class PlaylistLoader.
 */
public class PlaylistLoader {

    public static Cursor makePlaylistsCursor(Context context, String condition, String[] parameter) {
        String[] projection = {
                //TODO: chua xong
                /*MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS,
                MediaStore.Audio.Artists.NUMBER_OF_ALBUMS*/
        };

        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                projection,
                condition,
                parameter,
                MediaStore.Audio.Artists.ARTIST);
        return cursor;
    }

    public static List<Playlist> getPlaylistsForCursor(Cursor cursor) {
        List<Playlist> arrayList = new ArrayList();
        if ((cursor != null) && (cursor.moveToFirst()))
            do {
            //TODO: chua xong
                /*long id = cursor.getLong(0);
                String nameArtist = cursor.getString(1);
                int nbTracks = cursor.getInt(2);
                int nbAlbums = cursor.getInt(3);

                arrayList.add(new Playlist(id, nameArtist, nbAlbums, nbTracks));*/
            }
            while (cursor.moveToNext());
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }
}
