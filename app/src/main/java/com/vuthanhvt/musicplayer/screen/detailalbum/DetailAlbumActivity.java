package com.vuthanhvt.musicplayer.screen.detailalbum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.databinding.ActivityDetailAlbumBinding;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Song;
import com.vuthanhvt.musicplayer.screen.detailalbum.adapter.SongInAlbumAdapter;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 28/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class DetailAlbumActivity.
 */
public class DetailAlbumActivity
        extends BaseDataBindingActivity<ActivityDetailAlbumBinding, DetailAlbumPresenter>
        implements DetailAlbumView {

    public static final String TAG = "DetailAlbumActivity";

    private Album mDetailAlbum;

    private SongInAlbumAdapter mAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_detail_album;
    }

    @Override
    public void initData() {
        mPresenter = new DetailAlbumPresenter(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "initData: intent = " + intent);
            }
            Bundle bundle = intent.getBundleExtra(Constants.SendIntent.BUNDLE_SEND_DETAIL_ALBUM);
            mDetailAlbum = bundle.getParcelable(Constants.SendIntent.SEND_DETAIL_ALBUM);
        }
        if (mDetailAlbum != null) {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "initData: mDetailAlbum = " + mDetailAlbum);
            }
            setupActionBar(mDetailAlbum);
            setAlbumDetails(mDetailAlbum);
        }
    }

    private void setAlbumDetails(Album album) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "setAlbumDetails: ");
        }
        mPresenter.mArtistName.set(album.getArtistName());
        if (album.getYear() == 0) {
            mPresenter.mYear.set("<unknow>");
        } else {
            mPresenter.mYear.set(String.valueOf(album.getYear()));
        }
        mPresenter.mTrackNumber.set((String.valueOf(album.getNumberSong())));
        mAdapter = new SongInAlbumAdapter(this);
        mAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<Song>() {
            @Override
            public void onItemClick(int position, Song data) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "onItemClick: ");
                }
            }
        });
        mBinding.setAdapter(mAdapter);
        mPresenter.getAllSongsInAlbum(album.getID());
    }

    private void setupActionBar(Album album) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "setupActionBar: ");
        }
        Toolbar mToolbar = mBinding.getRoot().findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.toolbarLayout.setTitle(album.getTitle());
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.detail_album_sort_by, menu);
        getMenuInflater().inflate(R.menu.detail_album_other_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onOptionsItemSelected: item = " + item);
        }
        switch (item.getItemId()) {
            case R.id.action_search:
                mPresenter.onClickItemSearch();
                break;

            case R.id.action_share:
                mPresenter.onClickItemShare();
                break;

            case R.id.action_shuffle_all:
                mPresenter.onClickItemShuffleAll();
                break;

            case R.id.detail_album_sort_by_az:
                mPresenter.onClickItemSortByAZ();
                break;

            case R.id.detail_album_sort_by_za:
                mPresenter.onClickItemSortByZA();
                break;

            case R.id.detail_album_sort_by_year:
                mPresenter.onClickItemSortByYear();
                break;

            case R.id.detail_album_sort_by_number_songs:
                mPresenter.onClickItemSortByTrackNumber();
                break;

            case R.id.detail_album_sort_by_duration:
                mPresenter.onClickItemSortByDuration();
                break;

            case R.id.detail_album_about_artist:
                mPresenter.onClickItemAboutArtist();
                break;

            case R.id.detail_album_add_queue:
                mPresenter.onClickItemAddQueue();
                break;

            case R.id.detail_album_add_playlist:
                mPresenter.onClickItemAddPlaylist();
                break;

            case R.id.action_equalizer:
                mPresenter.onClickItemEqualizer();
                break;

            case R.id.action_settings:
                mPresenter.onClickItemSettings();
                break;

            case android.R.id.home:
                onBackPressed();

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadSongsListSuccess(List<Song> object) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadSongsListSuccess: ");
        }
        mAdapter.setData(object);
    }
}
