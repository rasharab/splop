package com.dot.Pops.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Win7 on 11/10/2015.
 */
public class PopsTextView extends TextView {
    public PopsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            FontManager.setFontFromAttributeSet(context, attrs, this);
        }
    }
}
