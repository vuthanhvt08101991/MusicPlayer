package com.vuthanhvt.musicplayer.screen.detailartist;

import android.content.Context;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.databinding.ActivityDetailArtistBinding;

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

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_detail_artist;
    }

    @Override
    public void initData() {

    }

    @Override
    public Context context() {
        return this;
    }
}
