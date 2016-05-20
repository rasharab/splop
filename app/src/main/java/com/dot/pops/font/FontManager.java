package com.dot.Pops.font;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dot.Pops.R;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Win7 on 06/04/2016.
 */
public class FontManager {

    public enum Font {

        ProximaBold("fonts/proxima_bold.otf"),
        ProximaExtraBold("fonts/proxima_extrabold.otf"),
        ProximaLight("fonts/proxima_light.otf"),
        ProximaRegular("fonts/proxima_regular.otf"),
        ProximaThin("fonts/proxima_thin.otf"),
        ProximaBoldItalic("fonts/proxima_boldItalic.otf");

        public final String fileName;

        private Font(String name) {
            fileName = name;
        }
    }

    public static boolean isBold = false;

    public static void setFont(TextView tv, int fontId) {
        Font font = getFontFromId(fontId);
        Log.d("Cust Font", font.fileName);
        Typeface typeface = Typeface.createFromAsset(tv.getContext().getAssets(), font.fileName);
        tv.setTypeface(typeface);
    }

    public static Font getFontFromId(int fontId) {
        switch(fontId) {
            case 0:
                return Font.ProximaBold;
            case 1:
                return Font.ProximaExtraBold;
            case 2:
                return Font.ProximaLight;
            case 3:
                return Font.ProximaRegular;
            case 4:
                return Font.ProximaThin;
            case 5:
                return Font.ProximaBoldItalic;
        }

        return null;
    }

    public static void setFontFromAttributeSet(Context context, AttributeSet attrs, TextView tv) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustTextFont);
        if (a.length() > 0) {
            int fontId = -1;
            for (int i = 0; i < a.length(); i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.CustTextFont_cust_font) {
                    fontId = a.getInt(attr, -1);
                }
                else if (attr == R.styleable.CustTextFont_bold) {
                    isBold = a.getBoolean(attr, false);
                }

            }

            if(isBold){
                fontId = 1;
            }
            //Log.d(TAG, "FontId: " + fontId);
            if (fontId != -1) {
                FontManager.setFont(tv, fontId);
            }
        }
    }

    public static void setEditTextFontFromAttributeSet(Context context, AttributeSet attrs, EditText tv) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustTextFont);
        if (a.length() > 0) {
            int fontId = -1;
            for (int i = 0; i < a.length(); i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.CustTextFont_cust_font) {
                    fontId = a.getInt(attr, -1);
                }
                else if (attr == R.styleable.CustTextFont_bold) {
                    isBold = a.getBoolean(attr, false);
                }

            }

            if(isBold){
                fontId = 1;
            }
            //Log.d(TAG, "FontId: " + fontId);
            if (fontId != -1) {
                FontManager.setFont(tv, fontId);
            }
        }
    }

    public static void setButtonFontFromAttributeSet(Context context, AttributeSet attrs, Button tv) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustTextFont);
        if (a.length() > 0) {
            int fontId = -1;
            for (int i = 0; i < a.length(); i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.CustTextFont_cust_font) {
                    fontId = a.getInt(attr, -1);
                }
                else if (attr == R.styleable.CustTextFont_bold) {
                    isBold = a.getBoolean(attr, false);
                }

            }

            if(isBold){
                fontId = 1;
            }
            //Log.d(TAG, "FontId: " + fontId);
            if (fontId != -1) {
                FontManager.setFont(tv, fontId);
            }
        }
    }

    public static void setLoginFacebookFontFromAttributeSet(Context context, AttributeSet attrs, LoginButton tv) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustTextFont);
        if (a.length() > 0) {
            int fontId = -1;
            for (int i = 0; i < a.length(); i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.CustTextFont_cust_font) {
                    fontId = a.getInt(attr, -1);
                }
                else if (attr == R.styleable.CustTextFont_bold) {
                    isBold = a.getBoolean(attr, false);
                }

            }

            if(isBold){
                fontId = 1;
            }
            //Log.d(TAG, "FontId: " + fontId);
            if (fontId != -1) {
                FontManager.setFont(tv, fontId);
            }
        }
    }

}
