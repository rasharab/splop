package com.dot.Pops.views.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;
import com.dot.Pops.views.seller.MainSeller;
import com.dot.Pops.views.seller.MapPointing;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 22/05/2016.
 */

public class ProfileInformation extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_information);
        setup();
    }

    private void setup() {
        ButterKnife.bind(this);
        ActivityHelper.addActionbar(this, getString(R.string.profile_information));
    }

    @OnClick(R.id.mapPointing)
    protected void toMapPointing(){
        ActivityHelper.toNextPage(this, MapPointing.class);
    }

    @OnClick(R.id.buttonSave)
    protected void toSave(){
        ActivityHelper.toNextPage(this, MainSeller.class);
    }

}
