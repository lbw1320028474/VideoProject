package com.beauty.youvideo.Manager;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebView;

import com.beauty.youvideo.Bean.LocalVideoDataBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bangwen.lei on 2017/7/19.
 */

public class HomeFragmentVideoManager {
    private static Map<String, LocalVideoDataBean> allVideoList = new HashMap<String, LocalVideoDataBean>();

    public static LocalVideoDataBean getVideoListByType(String type) {
        LocalVideoDataBean videoDataBean = allVideoList.get(type);
        return videoDataBean;
    }

    public static void getMoreVideoListByType(String type, WebView webView, GetVideoListCallBack callBack) {
        webView.loadUrl("javascript:loadnextpage();");
        newThreadAsTime(type, webView,callBack);
    }

    private static void newThreadAsTime(String type, WebView webView, GetVideoListCallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                getVideoHandler.sendEmptyMessage(0);
            }
        }).start();
    }

    private static Handler getVideoHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public interface GetVideoListCallBack {
        void listCallBack(LocalVideoDataBean videoListBean);
    }
}
