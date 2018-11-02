package com.vuthanhvt.musicplayer.base;

import android.support.v4.app.Fragment;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseFragment.
 */
public class BaseFragment extends Fragment {

    private boolean isBaseActivity() {
        return getActivity() != null
                && !getActivity().isFinishing()
                && getActivity() instanceof BaseActivity;
    }

    public BaseActivity getBaseActivity() {
        if (!isBaseActivity()) {
            return null;
        } else {
            return (BaseActivity) getActivity();
        }
    }

    public boolean onBackPressed() {
        return false;
    }
}
