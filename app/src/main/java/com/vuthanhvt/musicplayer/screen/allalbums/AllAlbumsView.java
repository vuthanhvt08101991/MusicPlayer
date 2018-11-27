package com.vuthanhvt.musicplayer.screen.allalbums;

import com.vuthanhvt.musicplayer.base.BaseView;
import com.vuthanhvt.musicplayer.model.Album;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface AllAlbumsView.
 */
public interface AllAlbumsView extends BaseView<AllAlbumsPresenter> {

    void loadAlbumsListSuccess(List<Album> mAlbums);
}
