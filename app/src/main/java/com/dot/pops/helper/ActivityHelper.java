package com.dot.Pops.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

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

}
