package com.vuthanhvt.musicplayer.database.data;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.model.Artist;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface ArtistDAO.
 */
public interface ArtistDAO {

    @Query("SELECT * FROM " + Constants.Artist.ARTIST_TABLE)
    List<Artist> getAllAlbums();

    @Query("SELECT *" +
            " FROM " + Constants.Artist.ARTIST_TABLE +
            " WHERE " + Constants.Artist.ARTIST_NAME + " LIKE " + " :artistName" +
            " ORDER BY " + Constants.Artist.ARTIST_NAME + " ASC")
    Artist findArtistByName(String artistName);

    @Insert
    void insertAll(Artist... artist);

    @Delete
    void delete(Artist artist);
}
