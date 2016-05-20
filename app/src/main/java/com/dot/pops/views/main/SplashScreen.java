package com.dot.Pops.views.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.dot.Pops.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    protected void toLogin(){
        Intent i = new Intent(SplashScreen.this, Login.class);
        startActivity(i);
    }
}
