package com.vuthanhvt.musicplayer.screen.allartists;

import android.content.Context;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingFragment;
import com.vuthanhvt.musicplayer.databinding.FragmentArtistBinding;

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

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_artist;
    }

    @Override
    protected void initData() {

    }

    @Override
    public Context context() {
        return getActivity();
    }
}
