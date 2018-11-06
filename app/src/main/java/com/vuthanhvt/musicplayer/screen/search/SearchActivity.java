package com.vuthanhvt.musicplayer.screen.search;

import android.content.Context;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.databinding.ActivitySearchBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 06/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SearchActivity.
 */
public class SearchActivity extends BaseDataBindingActivity<ActivitySearchBinding, SearchPresenter>
        implements SearchView {

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initData() {

    }

    @Override
    public Context context() {
        return this;
    }
}
