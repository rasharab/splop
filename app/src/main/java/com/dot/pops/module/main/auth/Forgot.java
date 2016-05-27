package com.dot.Pops.module.main.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dot.Pops.R;
import com.facebook.FacebookSdk;

/**
 * Created by Win7 on 20/05/2016.
 */

public class Forgot extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.forgot);

    }

//    @OnClick(R.id.forgot)
//    protected void toForgot(){
//        ActivityHelper.toNextPage(this, );
//    }

}
