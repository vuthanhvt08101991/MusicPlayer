package com.vuthanhvt.musicplayer.screen.allalbums;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingFragment;
import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.databinding.FragmentAlbumBinding;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.screen.allalbums.adapter.AllAlbumsAdapter;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllAlbumsFragment.
 */
public class AllAlbumsFragment
        extends BaseDataBindingFragment<FragmentAlbumBinding, AllAlbumsPresenter>
        implements AllAlbumsView {

    public static final String TAG = "AllAlbumsFragment";

    private AllAlbumsAdapter mAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    protected void initData() {
        mPresenter = new AllAlbumsPresenter(this);
        mAdapter = new AllAlbumsAdapter(context());
        mAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<Album>() {
            @Override
            public void onItemClick(int position, Album data) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "onItemClick: ");
                    mPresenter.goToDetailAlbum(data);
                }
            }
        });
        mBinding.setAdapter(mAdapter);
        mPresenter.getAllAlbums();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void loadAlbumsListSuccess(List<Album> mAlbums) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadAlbumsListSuccess: ");
        }
        mAdapter.setData(mAlbums);
    }
}
