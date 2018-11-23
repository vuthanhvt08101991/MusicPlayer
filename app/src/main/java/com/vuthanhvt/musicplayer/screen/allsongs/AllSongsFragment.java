package com.vuthanhvt.musicplayer.screen.allsongs;

import android.content.Context;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingFragment;
import com.vuthanhvt.musicplayer.databinding.FragmentSongBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllSongsFragment.
 */
public class AllSongsFragment
        extends BaseDataBindingFragment<FragmentSongBinding, AllSongsPresenter>
        implements AllSongsView {

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    protected void initData() {

    }

    @Override
    public Context context() {
        return getActivity();
    }
}
