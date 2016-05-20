package com.dot.Pops.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Win7 on 12/10/2015.
 */
public class PopsEditText extends EditText {

    public PopsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            FontManager.setEditTextFontFromAttributeSet(context, attrs, this);
        }
    }

}
