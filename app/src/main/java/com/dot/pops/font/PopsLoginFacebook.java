package com.dot.Pops.font;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.login.widget.LoginButton;

/**
 * Created by Win7 on 11/10/2015.
 */
public class PopsLoginFacebook extends LoginButton {
    public PopsLoginFacebook(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            FontManager.setLoginFacebookFontFromAttributeSet(context, attrs, this);
        }
    }
}
