package com.vuthanhvt.musicplayer.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.DimenRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.widgets.GridSpacingItemDecoration;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BindingUtils.
 */
public class BindingUtils {

    public static final String TAG = "BindingUtils";

    /***
     * Set adapter for recyclerview
     * @param recyclerView
     * @param adapter
     * @param columns
     * @param orientation
     * @param itemDecoration
     */
    @BindingAdapter(value = {
            "adapter", "columns", "orientation", "itemDecoration", "space", "includeEdge", "reverse"
    }, requireAll = false)
    public static void setRecyclerViewData(RecyclerView recyclerView, RecyclerView.Adapter adapter,
                                           int columns, int orientation, RecyclerView.ItemDecoration itemDecoration,
                                           @DimenRes int space, boolean includeEdge, boolean isReverse) {
        boolean isGrid = columns > 1;
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager;
        Context context = recyclerView.getContext();
        if (isGrid) {
            layoutManager = new GridLayoutManager(context, columns);
            itemDecoration =
                    new GridSpacingItemDecoration(context, columns, space, includeEdge);
        } else {

            layoutManager = new LinearLayoutManager(context,
                    orientation == context.getResources().getInteger(R.integer.vertical)
                            ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL, false);
            ((LinearLayoutManager) layoutManager).setReverseLayout(isReverse);
        }
        if (itemDecoration != null) {
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setLayoutManager(layoutManager);
    }

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
