package com.vuthanhvt.musicplayer.database.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface SongDAO.
 */
@Dao
public interface SongDAO {

    @Query("SELECT * FROM " + Constants.Song.SONG_TABLE)
    List<Song> getAllSongs();

    @Query("SELECT *" +
            " FROM " + Constants.Song.SONG_TABLE +
            " WHERE " + Constants.Song.SONG_TITLE + " LIKE " + " :songName" +
            " ORDER BY " + Constants.Song.SONG_TITLE + " ASC")
    Song findSongByName(String songName);

    @Insert
    void insertAll(Song... song);

    @Delete
    void delete(Song song);

    @Query("DELETE FROM " + Constants.Song.SONG_TABLE)
    void deleteAll();

    /*@Query("SELECT DISTINCT " + Constants.Song.SONG_TABLE +
            " FROM " + Constants.DBConstant.DATABASE_NAME +
            " WHERE " + Constants.Song.SONG_TABLE + " = " + Constants.Song.SONG_TABLE)
    boolean checkExist();*/
}
