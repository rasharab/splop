package com.dot.Pops.views.seller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;
import com.dot.Pops.views.seller.shipment.DetailShipment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 23/05/2016.
 */

public class CheckRate extends FragmentSeller {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view   = inflater.inflate(R.layout.check_rate, container, false);
        ButterKnife.bind(this, view);
        setupFragment();

        return view;
    }

    private void setupFragment() {
        activity.addActionBar(activity.ACTIONBAR_BACK, getString(R.string.check_rate));
    }

    @OnClick(R.id.buttonCreateShipment)
    protected void toCreateShipment(){
        FragmentSeller fDetailShipment = new DetailShipment();
        activity.singleFragment(fDetailShipment);
    }

}
