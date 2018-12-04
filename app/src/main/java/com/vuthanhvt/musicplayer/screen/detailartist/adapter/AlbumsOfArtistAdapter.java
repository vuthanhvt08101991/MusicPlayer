package com.vuthanhvt.musicplayer.screen.detailartist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemAlbumInDetailArtistBinding;
import com.vuthanhvt.musicplayer.model.Album;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AlbumsOfArtistAdapter.
 */
public class AlbumsOfArtistAdapter
        extends BaseRecyclerViewAdapterBinding<AlbumsOfArtistAdapter.AlbumOfArtistHolder, Album> {

    public AlbumsOfArtistAdapter(Context context) {
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
    protected AlbumOfArtistHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new AlbumOfArtistHolder(ItemAlbumInDetailArtistBinding.inflate(inflater,
                parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        ((AlbumOfArtistHolder) holder).bindData(getData().get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AlbumOfArtistHolder
            extends BaseViewHolderBinding<ItemAlbumInDetailArtistBinding, Album> {

        public AlbumOfArtistHolder(ItemAlbumInDetailArtistBinding binding) {
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
        public void bindData(Album album) {
            super.bindData(album);
            mBinding.setItemAlbum(album);
        }
    }
}
