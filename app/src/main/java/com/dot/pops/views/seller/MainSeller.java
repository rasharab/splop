package com.dot.Pops.views.seller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 23/05/2016.
 */

public class MainSeller extends AppCompatActivity {

    protected static final int ACTIONBAR_NO_BACK = 0;
    protected static final int ACTIONBAR_BACK = 1;

    private FragmentSeller fragment   = null;
    FragmentManager fm = getSupportFragmentManager();
    FragmentManager fmSingle = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    PopupWindow popupWindow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_seller);
        ButterKnife.bind(this);
        setup();


    }

    private void setup() {
//        set first fragment
        FragmentSeller fragment = new HomeSeller();
        changeFragment(fragment);

//        display popup menu
        findViewById(R.id.scrollscreen).post(new Runnable() {
            public void run() {
                popupWindow();
            }
        });

//        handling event keyboard
        KeyboardVisibilityEvent.setEventListener(this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if (isOpen){
                    Log.d("keyboard", isOpen+"");
                    popupWindow.dismiss();
                }else {
                    Log.d("keyboard", isOpen+"");
                    popupWindow();
                }

            }
        });
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

//    menu
    public void popupWindow(){
        View popupView = this.getLayoutInflater().inflate(R.layout.layout_menu,null);
        popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0);
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
        if (fmSingle.getBackStackEntryCount() > 1) {
            fmSingle.popBackStack();
            Log.d("fragment", "back");
        } else {
            Log.d("fragment", "finist");
            super.onBackPressed();
            finish();
        }
    }
}
