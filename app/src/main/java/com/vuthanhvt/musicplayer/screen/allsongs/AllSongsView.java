package com.vuthanhvt.musicplayer.screen.allsongs;

import com.vuthanhvt.musicplayer.base.BaseView;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface AllSongsView.
 */
public interface AllSongsView extends BaseView<AllSongsPresenter> {

    void loadSongsListSuccess(List<Song> object);
}
