package com.dot.Pops.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.dot.Pops.R;
import com.dot.Pops.font.PopsTextView;
import com.dot.Pops.views.main.Register;

/**
 * Created by Win7 on 20/05/2016.
 */

public class ActivityHelper {

    /**
     * to go next page
     * @param fromClass
     * @param toClass
     */
    public static void toNextPage(Context fromClass, Class toClass){
        Intent intent = new Intent(fromClass, toClass);
        fromClass.startActivity(intent);
    }

    /**
     * check keyboard show or not
     * @param context
     * @return
     */
    public static boolean keyboadShow(Context context){
        boolean isShow = false;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        isShow = imm.isAcceptingText();

        return isShow;

    }

    /**
     * add toolbar
     * @param appCompatActivity
     * @param title
     */
    public static final void addToolbar(int type, AppCompatActivity appCompatActivity, String title) {
        // Attaching the layout to the toolbar object
        PopsTextView toolbarTitle = (PopsTextView) appCompatActivity.findViewById(R.id.toolbar_title);
        PopsTextView toolbarTitleBack = (PopsTextView) appCompatActivity.findViewById(R.id.toolbar_title_back);
        if (type == 0) {
            toolbarTitle.setVisibility(View.VISIBLE);
            toolbarTitleBack.setVisibility(View.GONE);
            toolbarTitle.setText(title);
        }else{
            toolbarTitle.setVisibility(View.GONE);
            toolbarTitleBack.setVisibility(View.VISIBLE);
            toolbarTitleBack.setText(title);
        }
        Toolbar toolbar = (Toolbar) appCompatActivity.findViewById(R.id.toolbar);
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setElevation(50);
    }

    /**
     * add toolbar with title
     * @param appCompatActivity
     * @param title
     */
    public static final void addActionbar(AppCompatActivity appCompatActivity, String title){
        addToolbar(0, appCompatActivity, title);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    public static final void addActionbarBack(AppCompatActivity appCompatActivity, String title){
        addToolbar(1, appCompatActivity, title);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

}
