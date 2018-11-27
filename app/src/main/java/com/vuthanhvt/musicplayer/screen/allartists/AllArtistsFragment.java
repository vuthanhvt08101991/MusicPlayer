package com.vuthanhvt.musicplayer.screen.allartists;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingFragment;
import com.vuthanhvt.musicplayer.databinding.FragmentArtistBinding;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.screen.allartists.adapter.AllArtistsAdapter;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllArtistsFragment.
 */
public class AllArtistsFragment
        extends BaseDataBindingFragment<FragmentArtistBinding, AllArtistsPresenter>
        implements AllArtistsView {

    public static final String TAG = "AllArtistsFragment";

    private AllArtistsAdapter mAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_artist;
    }

    @Override
    protected void initData() {
        mPresenter = new AllArtistsPresenter(this);
        mAdapter = new AllArtistsAdapter(context());
        mBinding.setAdapter(mAdapter);
        mPresenter.getAllArtists();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void loadArtistsListSuccess(List<Artist> artists) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadArtistsListSuccess: ");
        }
        mAdapter.setData(artists);
    }
}
