package com.a2driano.city.my.weather.presenter.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.a2driano.city.my.weather.presenter.view.FragmentFavorite;
import com.a2driano.city.my.weather.presenter.view.FragmentSearch;

/**
 * Created by Andrii Papai on 16.09.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentSearch fragmentSearch = new FragmentSearch();
                return fragmentSearch;
            case 1:
                FragmentFavorite fragmentFavorite = new FragmentFavorite();
                return fragmentFavorite;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
