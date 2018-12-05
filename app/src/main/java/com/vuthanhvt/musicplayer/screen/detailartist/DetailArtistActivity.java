package com.vuthanhvt.musicplayer.screen.detailartist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.databinding.ActivityDetailArtistBinding;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.model.Song;
import com.vuthanhvt.musicplayer.screen.detailartist.adapter.AlbumsOfArtistAdapter;
import com.vuthanhvt.musicplayer.screen.detailartist.adapter.SongsOfArtistAdapter;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class DetailArtistActivity.
 */
public class DetailArtistActivity
        extends BaseDataBindingActivity<ActivityDetailArtistBinding, DetailArtistPresenter>
        implements DetailArtistView {

    public static final String TAG = "DetailArtistActivity";

    private Artist mArtistChosen;

    private int mNumberAlbums;

    private int mNumberSongs;

    private AlbumsOfArtistAdapter mAlbumsOfArtistAdapter;

    private SongsOfArtistAdapter mSongsOfArtistAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_detail_artist;
    }

    @Override
    public void initData() {
        mPresenter = new DetailArtistPresenter(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Constants.SendIntent.BUNDLE_SEND_DETAIL_ARTIST);
        if (bundle != null) {
            mArtistChosen = bundle.getParcelable(Constants.SendIntent.SEND_DETAIL_ARTIST);
            mNumberAlbums = bundle.getInt(Constants.SendIntent.SEND_NUMBER_ALBUM);
            mNumberSongs = bundle.getInt(Constants.SendIntent.SEND_NUMBER_SONG);
            if (mArtistChosen != null) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "initData: mArtistChosen = " + mArtistChosen.toString());
                }
                setupActionBar(mArtistChosen);
                mBinding.numberAlbum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!mBinding.expandedAlbumView.isExpanded()) {
                            mBinding.icExpandingAlbumList.animate().rotation(180).setDuration(200);
                        } else {
                            mBinding.icExpandingAlbumList.animate().rotation(0).setDuration(200);
                        }
                        mBinding.expandedAlbumView.toggle();
                    }
                });
                mBinding.numberSong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!mBinding.expandedSongView.isExpanded()) {
                            mBinding.icExpandingSongList.animate().rotation(180).setDuration(200);
                        } else {
                            mBinding.icExpandingSongList.animate().rotation(0).setDuration(200);
                        }
                        mBinding.expandedSongView.toggle();
                    }
                });
                mPresenter.getDetailArtist(mArtistChosen, mNumberAlbums, mNumberSongs);
            }
        }
    }

    private void setupActionBar(Artist artist) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "setupActionBar: ");
        }
        Toolbar mToolbar = mBinding.getRoot().findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.toolbarLayout.setTitle(artist.getName());
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void getDetailArtistSuccess(List<Album> albums, List<Song> songs) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "getDetailArtistSuccess: ");
        }
        mPresenter.mNumberAlbum.set(getString(R.string.number_album, mNumberAlbums));
        mAlbumsOfArtistAdapter = new AlbumsOfArtistAdapter(this);
        mBinding.albumsList.addItemDecoration(new SpacesItemDecoration(getResources()
                .getDimensionPixelSize(R.dimen.spacing_album_list)));
        mAlbumsOfArtistAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<Album>() {
            @Override
            public void onItemClick(int position, Album data) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "mAlbumsOfArtistAdapter: onItemClick: ");
                }
                mPresenter.goToDetailAlbum(data);
            }
        });
        mBinding.setAlbumAdapter(mAlbumsOfArtistAdapter);
        mAlbumsOfArtistAdapter.setData(albums);

        mPresenter.mNumberSong.set(getString(R.string.number_song, mNumberSongs));
        mSongsOfArtistAdapter = new SongsOfArtistAdapter(this);
        mSongsOfArtistAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<Song>() {
            @Override
            public void onItemClick(int position, Song data) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "mSongsOfArtistAdapter: onItemClick: ");
                }
            }
        });
        mBinding.setSongAdapter(mSongsOfArtistAdapter);
        mSongsOfArtistAdapter.setData(songs);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            //the padding from left
            outRect.left = space;
        }
    }
}
