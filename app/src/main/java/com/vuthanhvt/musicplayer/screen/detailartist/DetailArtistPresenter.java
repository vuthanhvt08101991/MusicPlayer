package com.vuthanhvt.musicplayer.screen.detailartist;

import com.vuthanhvt.musicplayer.base.BasePresenter;
import com.vuthanhvt.musicplayer.database.UserRepository;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class DetailArtistPresenter.
 */
public class DetailArtistPresenter implements BasePresenter {

    public static final String TAG = "DetailArtistPresenter";

    private UserRepository mUserRepository;

    private DetailArtistView mDetailArtistView;

    public DetailArtistPresenter(DetailArtistView mDetailArtistView) {
        this.mDetailArtistView = mDetailArtistView;
        this.mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
