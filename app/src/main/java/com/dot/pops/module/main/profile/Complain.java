package com.dot.Pops.module.main.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;

import butterknife.ButterKnife;

/**
 * Created by Win7 on 27/05/2016.
 */

public class Complain extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complain_form);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        ActivityHelper.addActionbarBack(this, getString(R.string.complain_form));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
