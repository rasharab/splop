package com.dot.Pops.views.seller;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Win7 on 23/05/2016.
 */

public class FragmentSeller extends Fragment {

    public MainSeller activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainSeller) getActivity();

    }

}
