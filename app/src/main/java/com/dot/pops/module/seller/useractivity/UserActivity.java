package com.dot.Pops.module.seller.useractivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.dot.Pops.R;
import com.dot.Pops.module.seller.FragmentSeller;
import com.dot.Pops.module.seller.useractivity.adapter.ViewPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Win7 on 26/05/2016.
 */

public class UserActivity extends FragmentSeller{

    View view;

    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view   = inflater.inflate(R.layout.user_activity, container, false);
        ButterKnife.bind(this, view);
        setupFragment();

        return view;
    }

    private void setupFragment() {
        activity.addActionBar(activity.ACTIONBAR_NO_BACK, getString(R.string.user_activity));
        setupPager();
    }

    private void setupPager(){
        Typeface _font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/proxima_regular.otf");
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        tabs.setTypeface(_font, Typeface.NORMAL);
        viewpager.setAdapter(adapter);
        tabs.setViewPager(viewpager);
    }

}
