package com.vuthanhvt.musicplayer.screen.allsongs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemSongBinding;
import com.vuthanhvt.musicplayer.model.Song;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllSongsAdapter.
 */
public class AllSongsAdapter extends BaseRecyclerViewAdapterBinding<AllSongsAdapter.SongViewHolder, Song> {


    public AllSongsAdapter(Context context) {
        super(context);
    }

    @Override
    protected SongViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return null;
    }

    public class SongViewHolder extends BaseViewHolderBinding<ItemSongBinding, Song> {

        public SongViewHolder(ItemSongBinding binding) {
            super(binding);
        }
    }
}
