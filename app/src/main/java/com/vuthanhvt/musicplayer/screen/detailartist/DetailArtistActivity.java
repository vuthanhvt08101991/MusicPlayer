package com.vuthanhvt.musicplayer.screen.detailartist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.databinding.ActivityDetailArtistBinding;
import com.vuthanhvt.musicplayer.model.Artist;

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
            int nbAlbum = bundle.getInt(Constants.SendIntent.SEND_NUMBER_ALBUM);
            int nbSong = bundle.getInt(Constants.SendIntent.SEND_NUMBER_SONG);
            if (mArtistChosen != null) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "initData: mArtistChosen = " + mArtistChosen.toString());
                }
                setupActionBar(mArtistChosen);
                mPresenter.setDetailArtist(mArtistChosen, nbAlbum, nbSong);
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
}
