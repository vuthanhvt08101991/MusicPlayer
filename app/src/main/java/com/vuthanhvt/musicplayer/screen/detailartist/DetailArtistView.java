package com.vuthanhvt.musicplayer.screen.detailartist;

import com.vuthanhvt.musicplayer.base.BaseView;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface DetailArtistView.
 */
public interface DetailArtistView extends BaseView<DetailArtistPresenter> {

    void getDetailArtistSuccess(List<Album> albums, List<Song> songs);
}
