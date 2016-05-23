package com.dot.Pops.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 20/05/2016.
 */

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login)
    protected void toLogin(){
        ActivityHelper.toNextPage(this, WhatNow.class);
    }

    @OnClick(R.id.forgot)
    protected void toForgot(){
        ActivityHelper.toNextPage(this, Forgot.class);
    }

}
