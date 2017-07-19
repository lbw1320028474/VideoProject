package com.beauty.youvideo.Utils;

import android.view.View;

/**
 * Created by bangwen.lei on 2017/7/18.
 */

public class ViewUtil {
    public static int getViewHeight(View view){
        if(view == null){
            return -1;
        }
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height =view.getMeasuredHeight();
        return height;
    }

    public static int getViewWidght(View view){
        if(view == null){
            return -1;
        }
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int width =view.getMeasuredWidth();
        return width;
    }
}
