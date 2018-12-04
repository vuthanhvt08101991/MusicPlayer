package com.vuthanhvt.musicplayer.screen.detailartist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemSongInDetailArtistBinding;
import com.vuthanhvt.musicplayer.model.Song;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SongsOfArtistAdapter.
 */
public class SongsOfArtistAdapter
        extends BaseRecyclerViewAdapterBinding<SongsOfArtistAdapter.SongsOfArtistHolder, Song> {

    private Context mContext;

    public SongsOfArtistAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public BaseViewHolderBinding onCreateViewHolder(ViewGroup parent, int viewType) {
        super.onCreateViewHolder(parent, viewType);
        BaseViewHolderBinding viewHolderBinding = getViewHolder(parent,
                LayoutInflater.from(parent.getContext()));
        return viewHolderBinding;
    }

    @Override
    protected SongsOfArtistHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new SongsOfArtistHolder(ItemSongInDetailArtistBinding.inflate(inflater,
                parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        ((SongsOfArtistHolder) holder).bindData(getData().get(position));
        ((SongsOfArtistHolder) holder).mBinding.setNumberOrder(String.valueOf(position + 1) + ".");
        ((SongsOfArtistHolder) holder).mBinding.songAlbum
                .setText(mContext.getString(R.string.album_in_item_song) + " " +
                        ((SongsOfArtistHolder) holder).mBinding.getItemSong().getAlbumName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class SongsOfArtistHolder
            extends BaseViewHolderBinding<ItemSongInDetailArtistBinding, Song> {

        public SongsOfArtistHolder(ItemSongInDetailArtistBinding binding) {
            super(binding);
            mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemListener != null) {
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
