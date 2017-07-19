package com.beauty.youvideo.Fragment;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.beauty.youvideo.R;
import com.beauty.youvideo.Utils.BLog;
import com.beauty.youvideo.Utils.ScreenUtil;
import com.beauty.youvideo.Utils.ViewUtil;

/**
 * Created by bangwen.lei on 2017/7/17.
 */

public class BaseFragment extends Fragment {
    protected String pageTigle = "";
    protected int fragmentId = 0;
    private ImageView actionBarBg = null;
    private View adjustView = null;
    private LinearLayout actionBarContainer = null;
    private View actionBarRootLayout = null;
    private View myActionBar = null;

    public int getFragmentId() {
        return fragmentId;
    }

    public String getPageTigle() {
        return pageTigle;
    }

    public void setPageTigle(String pageTigle) {
        this.pageTigle = pageTigle;
    }

    public void setFragmentId(int fragmentId) {
        this.fragmentId = fragmentId;
    }

    /**
     * @param rootView    布局根目录
     * @param myActionBar 我的actionBar容器,
     */
    protected void setActionBar(View rootView, View myActionBar) {
        if (myActionBar == null || rootView == null) {
            return;
        }
        try {
            this.myActionBar = myActionBar;
            actionBarRootLayout = (View)rootView.findViewById(R.id.unified_action_bar_root_view);
            actionBarBg = (ImageView) actionBarRootLayout.findViewById(R.id.unified_action_bar_background);
            adjustView = actionBarRootLayout.findViewById(R.id.unified_action_bar_height_adjust);
            actionBarContainer = (LinearLayout) actionBarRootLayout.findViewById(R.id.unified_action_bar_container);
            actionBarContainer.addView(myActionBar);
            setAdjustViewHeight();
            adjustActionBarHeight();
        } catch (Exception e) {
            BLog.e(e.getMessage());
        }
    }

    private void adjustActionBarHeight() {
        ViewGroup.LayoutParams layoutParams = actionBarRootLayout.getLayoutParams();
        layoutParams.height = ScreenUtil.getStateBarHeight(getActivity()) + ViewUtil.getViewHeight(myActionBar);
        actionBarRootLayout.setLayoutParams(layoutParams);
    }

    private void setAdjustViewHeight() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adjustView.getLayoutParams();
        layoutParams.height = ScreenUtil.getStateBarHeight(getActivity());
        adjustView.setLayoutParams(layoutParams);
    }


    /**
     *
     * @param bitmap 图片Bitmap
     */
    public void setActionBarBg(Bitmap bitmap){
        if(actionBarBg == null || bitmap == null){
            return;
        }
        actionBarBg.setImageBitmap(bitmap);
    }

    /**
     *
     * @param imageResourse 图片资源ID
     */
    public void setActionBarBg(int imageResourse){
        if(actionBarBg == null){
            return;
        }
        try{
            actionBarBg.setImageResource(imageResourse);
        }catch (Exception e){
            BLog.e("imageResourse:" + imageResourse + "不是正确的图片资源ID");
        }

    }
}
