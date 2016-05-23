package com.dot.Pops.views.seller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 23/05/2016.
 */

public class MainBuyer extends AppCompatActivity {

    protected static final int ACTIONBAR_NO_BACK = 0;
    protected static final int ACTIONBAR_BACK = 1;

    private FragmentSeller fragment   = null;
    FragmentManager fm = getSupportFragmentManager();
    FragmentManager fmSingle = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    @Bind(R.id.actionbarProfile)
    View viewToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_seller);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        FragmentSeller fragment = new HomeSeller();
        changeFragment(fragment);
    }

    /**
     * addactionbar
     * @param type
     * @param title
     */
    protected void addActionBar(int type, String title){
        if (type == ACTIONBAR_NO_BACK){
            ActivityHelper.addActionbar(this, title);
        }else{
            ActivityHelper.addActionbarBack(this, title);
        }
    }


    /**
     * change fragment
     * @param fragment
     */
    public void changeFragment(FragmentSeller fragment) {
        if (fragment != null) {
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.holder, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }

    public void singleFragment(FragmentSeller fragment) {
        if (fragment != null) {
            fragmentTransaction = fmSingle.beginTransaction();
            fragmentTransaction.replace(R.id.holder, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }

    @Override
    public void onBackPressed() {
        if (fmSingle.getBackStackEntryCount() > 0) {
            fmSingle.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
