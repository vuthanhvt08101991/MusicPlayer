package com.vuthanhvt.musicplayer.screen.allartists;

import com.vuthanhvt.musicplayer.base.BaseView;
import com.vuthanhvt.musicplayer.model.Artist;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface AllArtistsView.
 */
public interface AllArtistsView extends BaseView<AllArtistsPresenter> {

    void loadArtistsListSuccess(List<Artist> artists);
}
