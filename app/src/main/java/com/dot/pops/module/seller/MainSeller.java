package com.dot.Pops.module.seller;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;
import com.dot.Pops.module.main.profile.ProfileMenu;
import com.dot.Pops.module.seller.useractivity.UserActivity;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 23/05/2016.
 */

public class MainSeller extends AppCompatActivity {

    public static final int ACTIONBAR_NO_BACK = 0;
    public static final int ACTIONBAR_BACK = 1;

    private FragmentSeller fragment   = null;
    FragmentManager fm = getSupportFragmentManager();
    FragmentManager fmSingle = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    FragmentTransaction fragmentTransactionSingle;

    boolean isClick =false;

    PopupWindow popupWindow;
    @Bind(R.id.menu)
    View menu;
    @Bind(R.id.menuPlus)
    RelativeLayout menuPlus;
    @Bind(R.id.icMenuPlus)
    ImageView icMenuPlus;
    @Bind(R.id.menuHome)
    ImageButton menuHome;
    @Bind(R.id.menuActivity)
    ImageButton menuActivity;
    @Bind(R.id.menuNotif)
    ImageButton menuNotif;
    @Bind(R.id.menuProfile)
    ImageButton menuProfile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_seller);
        ButterKnife.bind(this);
        setup();


    }

    private void setup() {
//        set first fragment
        fragment = new HomeSeller();
        changeFragment(fragment);

        setupPopup();
//        handling event keyboard
        KeyboardVisibilityEvent.setEventListener(this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if (isOpen){
                    Log.d("keyboard", isOpen+"");
                    menu.setVisibility(View.INVISIBLE);
                }else {
                    Log.d("keyboard", isOpen+"");
                    menu.setVisibility(View.VISIBLE);
                }

            }
        });
    }

//  setup pop window
    private void setupPopup() {
        View popupView = this.getLayoutInflater().inflate(R.layout.layout_menu_plus,null);
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /**
     * addactionbar
     * @param type
     * @param title
     */
    public void addActionBar(int type, String title){
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
            fragmentTransactionSingle = fmSingle.beginTransaction();
            fragmentTransactionSingle.replace(R.id.holder, fragment);
            fragmentTransactionSingle.addToBackStack(null);
            fragmentTransactionSingle.commit();

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

    @OnClick(R.id.menuHome)
    protected void toHome(){
        menuHome();
        fragment = new HomeSeller();
        changeFragment(fragment);
    }

    @OnClick(R.id.menuActivity)
    protected void tomenuActivity(){
        menuActivity();
        fragment = new UserActivity();
        changeFragment(fragment);
    }

    @OnClick(R.id.menuPlus)
    protected void toMenuPlus(View v){
        menuPlus(v);
    }

    @OnClick(R.id.menuNotif)
    protected void toNotif(){
        menuNotif();
    }

    @OnClick(R.id.menuProfile)
    protected void tomenuProfile(){
        menuProfile();
        fragment = new ProfileMenu();
        changeFragment(fragment);
    }

//    menu home
    private void menuHome(){
        menuHome.setImageResource(R.drawable.ic_home_active);
        menuActivity.setImageResource(R.drawable.ic_activity);
        menuPlus.setBackgroundColor(ContextCompat.getColor(this, R.color.greenDark));
        menuNotif.setImageResource(R.drawable.ic_notification);
        menuProfile.setImageResource(R.drawable.ic_profile);
        dismisChildMenu();
    }

//    menu activity
    private void menuActivity(){
        menuHome.setImageResource(R.drawable.ic_home);
        menuActivity.setImageResource(R.drawable.ic_activity_active);
        menuPlus.setBackgroundColor(ContextCompat.getColor(this, R.color.greenDark));
        menuNotif.setImageResource(R.drawable.ic_notification);
        menuProfile.setImageResource(R.drawable.ic_profile);
        dismisChildMenu();
    }

//    menu plus
    private void menuPlus(View v){
        menuHome.setImageResource(R.drawable.ic_home);
        menuActivity.setImageResource(R.drawable.ic_activity);
        menuNotif.setImageResource(R.drawable.ic_notification);
        menuProfile.setImageResource(R.drawable.ic_profile);
        menuPlus.setBackgroundColor(ContextCompat.getColor(this, R.color.greenDark));
        Log.d("click", isClick+"");
        if (icMenuPlus.getRotation() == 45 || isClick){
            dismisChildMenu();
        }else {
            isClick = true;
            icMenuPlus.setRotation(45);
            menuPlus.setBackgroundColor(ContextCompat.getColor(this, R.color.grayDarkPress));
            childMenu(v);
        }
    }

//    menu notif
    private void menuNotif(){
        menuHome.setImageResource(R.drawable.ic_home);
        menuActivity.setImageResource(R.drawable.ic_activity);
        menuPlus.setBackgroundColor(ContextCompat.getColor(this, R.color.greenDark));
        menuNotif.setImageResource(R.drawable.ic_notification_actyive);
        menuProfile.setImageResource(R.drawable.ic_profile);
        dismisChildMenu();
    }

//    menu profile
    private void menuProfile(){
        menuHome.setImageResource(R.drawable.ic_home);
        menuActivity.setImageResource(R.drawable.ic_activity);
        menuPlus.setBackgroundColor(ContextCompat.getColor(this, R.color.greenDark));
        menuNotif.setImageResource(R.drawable.ic_notification);
        menuProfile.setImageResource(R.drawable.ic_profile_active);
        dismisChildMenu();
    }

//    dismiss childmenu
    private void dismisChildMenu() {
        if (icMenuPlus.getRotation() == 45 || isClick){
            popupWindow.dismiss();
            icMenuPlus.setRotation(0);
            isClick = false;
        }
    }

    // popup child menu
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void childMenu(View v){
        isClick = true;
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(30);
        }
        int location[] = new int[2];
        v.getLocationOnScreen(location);
        popupWindow.setAnimationStyle(R.style.SlideBottom);
        popupWindow.showAtLocation(v, Gravity.TOP, 0, location[1] -(v.getHeight()) - 30);
    }


}
