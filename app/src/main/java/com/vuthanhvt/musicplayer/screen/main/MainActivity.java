package com.vuthanhvt.musicplayer.screen.main;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.vuthanhvt.musicplayer.R;
import com.vuthanhvt.musicplayer.base.BaseDataBindingActivity;
import com.vuthanhvt.musicplayer.databinding.ActivityMainBinding;
import com.vuthanhvt.musicplayer.screen.allalbums.AllAlbumsFragment;
import com.vuthanhvt.musicplayer.screen.allartists.AllArtistsFragment;
import com.vuthanhvt.musicplayer.screen.allsongs.AllSongsFragment;
import com.vuthanhvt.musicplayer.screen.main.adapter.MainViewPagerAdapter;

public class MainActivity extends BaseDataBindingActivity<ActivityMainBinding, MainPresenter>
    implements MainView, NavigationView.OnNavigationItemSelectedListener {


    public static final String TAG = "MainActivity";

    private NavigationView navigationView;

    private DrawerLayout drawer;

    private MainViewPagerAdapter mAdapter;

    private AllSongsFragment mSongsFragment;

    private AllAlbumsFragment mAlbumsFragment;

    private AllArtistsFragment mArtistsFragment;

    private Fragment mFragmentSelected;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

        mPresenter = new MainPresenter(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mSongsFragment = new AllSongsFragment();
        mAlbumsFragment = new AllAlbumsFragment();
        mArtistsFragment = new AllArtistsFragment();
        mAdapter.addFragment(mSongsFragment, getString(R.string.songs_title));
        mAdapter.addFragment(mAlbumsFragment, getString(R.string.albums_title));
        mAdapter.addFragment(mArtistsFragment, getString(R.string.artists_title));
        mFragmentSelected = mAdapter.getItem(0);
        mBinding.setAdapter(mAdapter);
        mBinding.pager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset,
                                               int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        mFragmentSelected = mAdapter.getItem(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                mPresenter.onClickItemSearch();
                break;

            case R.id.action_share:
                mPresenter.onClickItemShare();
                break;

            case R.id.action_shuffle_all:
                mPresenter.onClickItemShuffleAll();
                break;

            case R.id.action_sortby:
                mPresenter.onClickItemSortBy();
                break;

            case R.id.action_equalizer:
                mPresenter.onClickItemEqualizer();
                break;

            case R.id.action_settings:
                mPresenter.onClickItemSettings();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.navigation_item_library:
                mPresenter.onClickNaviLibrary();
                break;

            case R.id.navigation_item_playlists:
                mPresenter.onClickNaviPlayLists();
                break;

            case R.id.navigation_item_folders:
                mPresenter.onClickNaviFolder();
                break;

            case R.id.navigation_item_playing_queue:
                mPresenter.onClickNaviPlayingQueue();
                break;

            case R.id.navigation_item_now_playing:
                mPresenter.onClickNaviNowPlaying();
                break;

            case R.id.navigation_item_setting:
                mPresenter.onClickItemSettings();
                break;

            case R.id.navigation_item_about:
                mPresenter.onClickNaviAbout();
                break;

            case R.id.navigation_item_support:
                mPresenter.onClickNaviSupport();
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Context context() {
        return this;
    }
}
