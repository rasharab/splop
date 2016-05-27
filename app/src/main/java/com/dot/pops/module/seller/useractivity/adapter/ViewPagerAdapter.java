package com.dot.Pops.module.seller.useractivity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dot.Pops.module.seller.useractivity.StatusFragment;

/**
 * Created by Win7 on 26/05/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private StatusFragment mFragments;
    String[] TITLES = { "Active", "Complete"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                mFragments = new StatusFragment().newInstance(StatusFragment.ACTIVE);
                return mFragments;
            case 1:
                mFragments = new StatusFragment().newInstance(StatusFragment.COMPLETE);
                break;
        }
        return mFragments;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}