package com.vuthanhvt.musicplayer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.vuthanhvt.musicplayer.R;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseActivity.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (enableTransaction()) {
            overridePendingTransition(R.anim.enter_from_right, 0);
        }
        super.onCreate(savedInstanceState);
    }

    public abstract boolean enableTransaction();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (enableTransaction()) {
            overridePendingTransition(0, R.anim.exit_to_right);
        }
    }

    public void startAnimationFinish() {
        overridePendingTransition(0, R.anim.exit_to_right);
    }
}