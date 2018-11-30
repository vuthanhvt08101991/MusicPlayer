package com.vuthanhvt.musicplayer;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Constant.
 */
public class Constants {

    public static class DBConstant {
        public static final String DATABASE_NAME = "MUSIC.DB";
        public static final int VERSION = 1;
    }

    public static class Song {
        public static final String SONG_TABLE = "SONG_TABLE";
        public static final String SONG_ID = "SONG_ID";
        public static final String SONG_ALBUM_ID = "SONG_ALBUM_ID";
        public static final String SONG_ALBUM_NAME = "SONG_ALBUM_NAME";
        public static final String SONG_ARTIST_ID = "SONG_ARTIST_ID";
        public static final String SONG_ARTIST_NAME = "SONG_ARTIST_NAME";
        public static final String SONG_DURATION = "SONG_DURATION";
        public static final String SONG_TITLE = "SONG_TITLE";
        public static final String SONG_TRACK_NUMBER = "SONG_TRACK_NUMBER";
    }

    public static class Album {
        public static final String ALBUM_TABLE = "ALBUM_TABLE";
        public static final String ALBUM_ID = "ALBUM_ID";
        public static final String ALBUM_ARTIST_ID = "ALBUM_ARTIST_ID";
        public static final String ALBUM_ARTIST_NAME = "ALBUM_ARTIST_NAME";
        public static final String ALBUM_NUMBER_SONGS = "ALBUM_NUMBER_SONGS";
        public static final String ALBUM_TITLE = "ALBUM_TITLE";
        public static final String ALBUM_YEAR = "ALBUM_YEAR";
    }

    public static class Artist {
        public static final String ARTIST_TABLE = "ARTIST_TABLE";
        public static final String ARTIST_ID = "ARTIST_ID";
        public static final String ARTIST_NAME = "ARTIST_NAME";
        public static final String ARTIST_NUMBER_ALBUMS = "ARTIST_NUMBER_ALBUMS";
        public static final String ARTIST_NUMBER_SONGS = "ARTIST_NUMBER_SONGS";
    }

    public static class Playlist {
        public static final String PLAYLIST_TABLE = "PLAYLIST_TABLE";
        public static final String PLAYLIST_ID = "PLAYLIST_ID";
        public static final String PLAYLIST_NAME = "PLAYLIST_NAME";
        public static final String PLAYLIST_NUMBER_SONGS = "PLAYLIST_NUMBER_SONGS";
    }

    public static class SearchHistory {
        public static final String SEARCH_HISTORY_TABLE = "SEARCH_HISTORYONG_TABLE";
        public static final String SEARCH_ID = "SEARCH_ID";
        public static final String SEARCH_STRING = "SEARCH_STRING";
        public static final String SEARCH_TIME = "SEARCH_TIME";
        public static final int MAX_ITEM = 15;
    }

    public static class SendIntent {
        public static final String SEND_DETAIL_ALBUM = "SEND_DETAIL_ALBUM";
        public static final String BUNDLE_SEND_DETAIL_ALBUM = "BUNDLE_SEND_DETAIL_ALBUM";
        public static final String SEND_DETAIL_ARTIST = "SEND_DETAIL_ARTIST";
        public static final String BUNDLE_SEND_DETAIL_ARTIST = "BUNDLE_SEND_DETAIL_ARTIST";
    }
}
