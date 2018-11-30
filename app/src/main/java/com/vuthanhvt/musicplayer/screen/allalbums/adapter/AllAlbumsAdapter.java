package com.vuthanhvt.musicplayer.screen.allalbums.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemAlbumBinding;
import com.vuthanhvt.musicplayer.model.Album;

/**
 * Create by FRAMGIA\vu.anh.thanh on 27/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllAlbumsAdapter.
 */
public class AllAlbumsAdapter
        extends BaseRecyclerViewAdapterBinding<AllAlbumsAdapter.AlbumViewHolder, Album> {

    public AllAlbumsAdapter(Context context) {
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
    protected AlbumViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new AlbumViewHolder(ItemAlbumBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        ((AlbumViewHolder) holder).bindData(getData().get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AlbumViewHolder extends BaseViewHolderBinding<ItemAlbumBinding, Album> {

        public AlbumViewHolder(ItemAlbumBinding binding) {
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
        public void bindData(Album itemAlbum) {
            super.bindData(itemAlbum);
            mBinding.setItemAlbum(itemAlbum);
        }
    }
}

