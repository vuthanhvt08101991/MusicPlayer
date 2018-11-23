package com.vuthanhvt.musicplayer.screen.allalbums;

import android.content.Context;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingFragment;
import com.vuthanhvt.musicplayer.databinding.FragmentAlbumBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllAlbumsFragment.
 */
public class AllAlbumsFragment extends BaseDataBindingFragment<FragmentAlbumBinding, AllAlbumsPresenter>
        implements AllAlbumsView {

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    protected void initData() {

    }

    @Override
    public Context context() {
        return getActivity();
    }
}
