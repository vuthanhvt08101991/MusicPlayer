package com.vuthanhvt.musicplayer.screen.allsongs;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingFragment;
import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.databinding.FragmentSongBinding;
import com.vuthanhvt.musicplayer.model.Song;
import com.vuthanhvt.musicplayer.screen.allsongs.adapter.AllSongsAdapter;

import java.util.List;

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

    public static final String TAG = "AllSongsFragment";

    private AllSongsAdapter mAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    protected void initData() {
        mPresenter = new AllSongsPresenter(this);
        mAdapter = new AllSongsAdapter(context());
        mAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<Song>() {
            @Override
            public void onItemClick(int position, Song data) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "onItemClick: ");
                }

            }
        });
        mBinding.setAdapter(mAdapter);
        mPresenter.getAllSongs();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void loadSongsListSuccess(List<Song> object) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadSongsListSuccess: ");
        }
        mAdapter.setData(object);
    }
}
