package com.dot.Pops.module.main;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;
import com.dot.Pops.module.main.auth.Login;
import com.dot.Pops.module.main.auth.Register;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashScreen extends AppCompatActivity {

    private MediaPlayer mp = null;

    @Bind(R.id.bgVideo)
    VideoView videoPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        previewVideo();
    }

    @OnClick(R.id.login)
    protected void toLogin(){
        ActivityHelper.toNextPage(this, Login.class);
    }

    @OnClick(R.id.register)
    protected void toRegister(){
        ActivityHelper.toNextPage(this, Register.class);
    }

    /*
     * Previewing recorded video
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void previewVideo() {
        try {
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.splash_video);
            videoPreview.setVideoURI(video);
            videoPreview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    // start playing
                    mp.setLooping(true);
                    videoPreview.start();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
