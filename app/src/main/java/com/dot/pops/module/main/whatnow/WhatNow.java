package com.dot.Pops.module.main.whatnow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;
import com.dot.Pops.module.main.profile.ProfileInformation;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 20/05/2016.
 */

public class WhatNow extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_buyer);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        ActivityHelper.addActionbar(this, getString(R.string.want_so_what_now));
    }

    @OnClick(R.id.buttonSeller)
    protected void toSeller(){
        Toast.makeText(this, "Seller", Toast.LENGTH_SHORT).show();
        ActivityHelper.toNextPage(this, ProfileInformation.class);
    }

    @OnClick(R.id.buttonBuyer)
    protected void toBuyer(){
        Toast.makeText(this, "Buyer", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.buttonSetting)
    protected void toSetting(){
        Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
    }
}
