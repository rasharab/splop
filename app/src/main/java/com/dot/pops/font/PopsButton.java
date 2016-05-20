package com.dot.Pops.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Win7 on 12/10/2015.
 */
public class PopsButton extends Button {

    public PopsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            FontManager.setButtonFontFromAttributeSet(context, attrs, this);
        }
    }

}
