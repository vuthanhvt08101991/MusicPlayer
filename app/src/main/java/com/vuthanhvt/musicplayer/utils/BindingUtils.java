package com.vuthanhvt.musicplayer.utils;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BindingUtils.
 */
public class BindingUtils {

    public static final String TAG = "BindingUtils";

    /**
     * Set adapter for ViewPager.
     * @param viewPager {@link ViewPager}
     * @param adapter {@link PagerAdapter}
     */
    @BindingAdapter(("pagerAdapter"))
    public static void setPagerAdapter(ViewPager viewPager, PagerAdapter adapter) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "setPagerAdapter: ");
        }
        viewPager.setAdapter(adapter);
    }

    /**
     * set ViewPager for TabLayout.
     * @param tabLayout
     * @param viewPager
     */
    @BindingAdapter(("viewPager"))
    public static void setViewPager(TabLayout tabLayout, ViewPager viewPager) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "setViewPager: ");
        }
        tabLayout.setupWithViewPager(viewPager, true);
    }
}
