package com.vuthanhvt.musicplayer.screen.detailalbum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemSongInDetailAlbumBinding;
import com.vuthanhvt.musicplayer.model.Song;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * SongInAlbumAdapter
 */
public class SongInAlbumAdapter
        extends BaseRecyclerViewAdapterBinding<SongInAlbumAdapter.SongInAlbumHolder, Song> {

    public SongInAlbumAdapter(Context context) {
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
    protected SongInAlbumHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new SongInAlbumHolder(ItemSongInDetailAlbumBinding.inflate(inflater,
                parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        ((SongInAlbumHolder) holder).bindData(getData().get(position));
        ((SongInAlbumHolder) holder).mBinding.setNumberOrder(String.valueOf(position + 1) + ".");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class SongInAlbumHolder
            extends BaseViewHolderBinding<ItemSongInDetailAlbumBinding, Song> {

        public SongInAlbumHolder(ItemSongInDetailAlbumBinding binding) {
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

