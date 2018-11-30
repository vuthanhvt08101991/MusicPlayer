package com.vuthanhvt.musicplayer.screen.detailalbum;

import com.vuthanhvt.musicplayer.base.BaseView;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 28/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface DetailAlbumView.
 */
public interface DetailAlbumView extends BaseView<DetailAlbumPresenter> {

    void loadSongsListSuccess(List<Song> object);
}
