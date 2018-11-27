package com.vuthanhvt.musicplayer.screen.allartists.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.base.adapter.BaseRecyclerViewAdapterBinding;
import com.vuthanhvt.musicplayer.base.adapter.BaseViewHolderBinding;
import com.vuthanhvt.musicplayer.databinding.ItemArtistBinding;
import com.vuthanhvt.musicplayer.model.Artist;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 26/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AllArtistsAdapter.
 */
public class AllArtistsAdapter
        extends BaseRecyclerViewAdapterBinding<AllArtistsAdapter.ArtistViewHolder, Artist> {

    public AllArtistsAdapter(Context context) {
        super(context);
    }

    @Override
    protected ArtistViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new ArtistViewHolder(ItemArtistBinding.inflate(inflater, parent, false));
    }

    @Override
    public BaseViewHolderBinding onCreateViewHolder(ViewGroup parent, int viewType) {
        super.onCreateViewHolder(parent, viewType);
        BaseViewHolderBinding viewHolderBinding = getViewHolder(parent,
                LayoutInflater.from(parent.getContext()));
        return viewHolderBinding;
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        ((AllArtistsAdapter.ArtistViewHolder) holder).bindData(getData().get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ArtistViewHolder extends BaseViewHolderBinding<ItemArtistBinding, Artist> {

        public ArtistViewHolder(ItemArtistBinding binding) {
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
        public void bindData(Artist artist) {
            super.bindData(artist);
            mBinding.setItemArtist(artist);
        }
    }
}
