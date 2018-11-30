package com.vuthanhvt.musicplayer.screen.allsongs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemNoDataBinding;
import com.vuthanhvt.musicplayer.databinding.ItemSongBinding;
import com.vuthanhvt.musicplayer.model.Song;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllSongsAdapter.
 */
public class AllSongsAdapter
        extends BaseRecyclerViewAdapterBinding<AllSongsAdapter.SongViewHolder, Song> {

    public AllSongsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolderBinding onCreateViewHolder(ViewGroup parent, int viewType) {
        super.onCreateViewHolder(parent, viewType);
        BaseViewHolderBinding viewHolderBinding = getViewHolder(parent,
                LayoutInflater.from(parent.getContext()));
        return viewHolderBinding;
    }

    @Override
    protected SongViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new SongViewHolder(ItemSongBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        ((SongViewHolder) holder).bindData(getData().get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class SongViewHolder extends BaseViewHolderBinding<ItemSongBinding, Song> {

        public SongViewHolder(ItemSongBinding binding) {
            super(binding);
            mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mItemListener != null) {
                        mItemListener.onItemClick(getAdapterPosition(),
                                mList.get(getAdapterPosition()));
                    }
                }
            });
        }

        @Override
        public void bindData(Song itemSong) {
            super.bindData(itemSong);
            mBinding.setItemSong(itemSong);
        }
    }
}
