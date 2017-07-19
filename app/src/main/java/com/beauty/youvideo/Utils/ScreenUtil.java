package com.beauty.youvideo.Utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by bangwen.lei on 2017/7/18.
 */

public class ScreenUtil {
    public static int getStateBarHeight(Context context){
        /**
         * 获取状态栏高度——方法1
         * */
        int statusBarHeight = -1;
//获取status_bar_height资源的ID
        Resources resources = context.getApplicationContext().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = resources.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
