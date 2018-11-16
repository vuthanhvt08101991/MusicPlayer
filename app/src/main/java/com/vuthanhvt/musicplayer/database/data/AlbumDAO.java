package com.vuthanhvt.musicplayer.database.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.model.Album;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface AlbumDAO.
 */
@Dao
public interface AlbumDAO {

    @Query("SELECT * FROM " + Constants.Album.ALBUM_TABLE)
    List<Album> getAllAlbums();

    @Query("SELECT *" +
            " FROM " + Constants.Album.ALBUM_TABLE +
            " WHERE " + Constants.Album.ALBUM_TITLE + " LIKE " + " :albumName" +
            " ORDER BY " + Constants.Album.ALBUM_TITLE + " ASC")
    Album findAlbumByName(String albumName);

    @Insert
    void insertAll(Album... album);

    @Delete
    void delete(Album album);

    @Query("DELETE FROM " + Constants.Album.ALBUM_TABLE)
    void deleteAll();
}
