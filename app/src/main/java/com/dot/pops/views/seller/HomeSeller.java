package com.dot.Pops.views.seller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 23/05/2016.
 */

public class HomeSeller extends FragmentSeller {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view   = inflater.inflate(R.layout.home, container, false);
        ButterKnife.bind(this, view);
        setupFragment();

        return view;
    }

    private void setupFragment() {
        activity.addActionBar(activity.ACTIONBAR_NO_BACK, getString(R.string.home));
    }

    @OnClick(R.id.buttonRate)
    protected void toRate(){
        FragmentSeller fCheckRate  = new CheckRate();
        activity.singleFragment(fCheckRate);
    }

}
