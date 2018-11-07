package com.vuthanhvt.musicplayer.database.data;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.model.Playlist;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface PlaylistDAO.
 */
public interface PlaylistDAO {

    @Query("SELECT * FROM " + Constants.Playlist.PLAYLIST_TABLE)
    List<Playlist> getAllAlbums();

    @Query("SELECT *" +
            " FROM " + Constants.Playlist.PLAYLIST_TABLE +
            " WHERE " + Constants.Playlist.PLAYLIST_NAME + " LIKE " + " :playlistName" +
            " ORDER BY " + Constants.Playlist.PLAYLIST_NAME + " ASC")
    Playlist findArtistByName(String playlistName);

    @Insert
    void insertAll(Playlist... playlist);

    @Delete
    void delete(Playlist playlist);
}
