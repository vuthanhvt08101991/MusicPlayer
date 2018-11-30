package com.vuthanhvt.musicplayer.database.source;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.database.request.AlbumLoader;
import com.vuthanhvt.musicplayer.database.data.MusicDB;
import com.vuthanhvt.musicplayer.database.request.ArtistLoader;
import com.vuthanhvt.musicplayer.database.request.PlaylistLoader;
import com.vuthanhvt.musicplayer.database.request.SongLoader;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.model.Playlist;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class UserLocalDataSource.
 */
public class UserLocalDataSource implements IUserLocalDataSource {

    public static final String TAG = "UserLocalDataSource";
    
    private static UserLocalDataSource mInstance = new UserLocalDataSource();

    private UserLocalDataSource() {
    }

    public static UserLocalDataSource getInstance() {
        return mInstance;
    }

    @Override
    public void loadDataFirstStart(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadDataFirstStart: ");
        }
        MusicDB mDB = MusicDB.getMusicDB(context);

        //load all artists
        if (mDB.getArtistDAOAccess().getAllArtists().size() == 0) {
            List<Artist> mListArtists = ArtistLoader.getArtistsForCursor(
                    ArtistLoader.makeArtistCursor(context, null, null));
            int siteListArtists = mListArtists.size();
            for (int i = 0; i < siteListArtists; i++) {
                mDB.getArtistDAOAccess().insertAll(mListArtists.get(i));
            }
        }

        //load all albums
        if (mDB.getAlbumDAOAccess().getAllAlbums().size() == 0) {
            List<Album> mListAlbums = AlbumLoader.getAlbumsForCursor(
                    AlbumLoader.makeAlbumCursor(context, null, null));
            int siteListAlbums = mListAlbums.size();
            for (int i = 0; i < siteListAlbums; i++) {
                mDB.getAlbumDAOAccess().insertAll(mListAlbums.get(i));
            }
        }

        //load all songs
        if (mDB.getSongDAOAccess().getAllSongs().size() == 0) {
            List<Song> mListSongs = SongLoader.getSongsForCursor(
                    SongLoader.makeSongCursor(context, null, null));
            int siteListSongs = mListSongs.size();
            for (int i = 0; i < siteListSongs; i++) {
                mDB.getSongDAOAccess().insertAll(mListSongs.get(i));
            }
        }

        //load all playlists
        if (mDB.getPlaylistDAOAccess().getAllPlaylists().size() == 0) {
            List<Playlist> mListPlaylists = PlaylistLoader.getPlaylistsForCursor(
                    PlaylistLoader.makePlaylistsCursor(context, null, null));
            int sitePlaylists = mListPlaylists.size();
            for (int i = 0; i < sitePlaylists; i++) {
                mDB.getPlaylistDAOAccess().insertAll(mListPlaylists.get(i));
            }
        }
    }

    @Override
    public List<Song> getAllSongs(Context context) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "getAllSongs: ");
        }
        return MusicDB.getMusicDB(context).getSongDAOAccess().getAllSongs();
    }

    @Override
    public List<Album> getAllAlbums(Context context) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "getAllAlbums: ");
        }
        return MusicDB.getMusicDB(context).getAlbumDAOAccess().getAllAlbums();
    }

    @Override
    public List<Artist> getAllArtists(Context context) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "getAllArtists: ");
        }
        return MusicDB.getMusicDB(context).getArtistDAOAccess().getAllArtists();
    }

    @Override
    public List<Song> getAllSongsInAlbum(Context context, long albumID) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "getAllSongsInAlbum: ");
        }
        return MusicDB.getMusicDB(context).getSongDAOAccess().getAllSongsInAlbum(albumID);
    }
}
