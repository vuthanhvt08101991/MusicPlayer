package com.vuthanhvt.musicplayer.widgets;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BindingUtils.
 */
public class BindingUtils {

    /**
     * Set adapter for ViewPager.
     * @param viewPager {@link ViewPager}
     * @param adapter {@link PagerAdapter}
     */
    @BindingAdapter(("pagerAdapter"))
    public static void setPagerAdapter(ViewPager viewPager, PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    /**
     * set ViewPager for TabLayout.
     * @param tabLayout
     * @param viewPager
     */
    @BindingAdapter(("viewPager"))
    public static void setViewPager(TabLayout tabLayout, ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager, true);
    }
}
