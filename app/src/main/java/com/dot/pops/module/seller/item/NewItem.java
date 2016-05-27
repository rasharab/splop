package com.dot.Pops.module.seller.item;

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

public class NewItem extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        ActivityHelper.addActionbarBack(this, getString(R.string.add_new_item));
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
