package com.beauty.youvideo.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import com.beauty.youvideo.Bean.LocalVideoDataBean;
import com.beauty.youvideo.Bean.VideoDataBean;
import com.beauty.youvideo.Manager.HomeFragmentVideoAnalyzeUtil;
import com.beauty.youvideo.Manager.HomeFragmentVideoManager;
import com.beauty.youvideo.Manager.VideoDataManager;
import com.beauty.youvideo.R;
import com.beauty.youvideo.Utils.BLog;

import java.util.List;

/**
 * Created by bangwen.lei on 2017/7/18.
 */

public class HomeSubFragment extends BaseFragment implements View.OnClickListener {
    private String videoType = "";
    private String pageUrl = "";
    private WebView pageAnalyzeWebView = null;
    private WebView loadWebView = null;
    private boolean isLoadFinish = true;
    private View rootView = null;
    private Button testView = null;
    private int i = 0;
    private boolean isHaveFinishPage = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.home_fragment_sub_fragment_layout, null);
            initView();
        }
        return rootView;
    }

    private void initView() {
        testView = (Button) rootView.findViewById(R.id.testButton);
        i = i + 1;
        testView.setText("运行次数:" + i);
        testView.setOnClickListener(this);
        initWebView();
    }

    private void initWebView() {
        if (TextUtils.isEmpty(pageUrl)) {
            BLog.e("页面url为空");
            return;
        }
        BLog.i("加载页面：" + pageUrl);
        pageAnalyzeWebView = new WebView(getActivity());
        // 启用javascript
        pageAnalyzeWebView.getSettings().setJavaScriptEnabled(true);
        pageAnalyzeWebView.getSettings().setLoadsImagesAutomatically(false);
        // 从assets目录下面的加载html
        pageAnalyzeWebView.addJavascriptInterface(new GetWebHtmlInterface(), "getStr");
        pageAnalyzeWebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                BLog.e("newProgress: " + newProgress);
            }
        });
        pageAnalyzeWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                isLoadFinish = false;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                isLoadFinish = true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                BLog.e("shouldOverrideUrlLoading");
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
/*                  view.loadUrl("javascript:window.local_obj.showSource('<head>'+" +

                "document.getElementsByTagName('html')[0].innerHTML+'</head>');");*/
                BLog.i("onPageFinished");
                isLoadFinish = true;
                loadWebView = view;
                view.loadUrl("javascript:window.getStr.getHtmlStr(document.getElementsByTagName('html')[0].innerHTML);");
                isHaveFinishPage = true;
            }
        });
        ((LinearLayout)rootView).addView(pageAnalyzeWebView);
        if (isLoadFinish) {
            pageAnalyzeWebView.loadUrl(pageUrl);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.testButton:
                loadMoreVideo();
                break;
        }
    }


    public class GetWebHtmlInterface {
        @JavascriptInterface
        public void getHtmlStr(String htmlStr) {

            BLog.i(htmlStr.substring(htmlStr.length() - 100, htmlStr.length()));
            BLog.i("htmlStr.size = " + htmlStr.length());
            LocalVideoDataBean localVideoDataBean = HomeFragmentVideoManager.getVideoListByType(videoType);
            int videoStartIndex = 0;
            if(localVideoDataBean != null){
                videoStartIndex = localVideoDataBean.getGetedVideoDataList().size();
            }
            List<VideoDataBean> videoList = HomeFragmentVideoAnalyzeUtil.ListgetHomeVideoListByHtml(
                    getActivity(), htmlStr, videoStartIndex);
            BLog.e("videoList.size():" + videoList.size());
        }
        @JavascriptInterface
        public void getNextPageFinished(){
            BLog.i("运行结束");
            webViewHandler.sendEmptyMessage(0);
        }
    }

    public void loadMoreVideo() {
        BLog.i("loadnextpage");
        if(isHaveFinishPage){
            BLog.i("loadnextpage， isHaveFinishPage=" + isHaveFinishPage);
            //loadWebView.loadUrl("javascript:loadnextpage();");
            loadWebView.loadUrl("javascript:(function(){" +
                    "javascript:loadnextpage();" +
                    "getStr.getNextPageFinished();" +
                    "})();");
           /* new Thread(new Runnable() {
                @Override
                public void run() {
                    BLog.e("子线程中计时");
                    SystemClock.sleep(5000);

                    webViewHandler.sendEmptyMessage(0);
                }
            }).start();*/
        }else{
            BLog.i("not loadnextpage, isHaveFinishPage=" + isHaveFinishPage);
        }
    }

    private Handler webViewHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BLog.e("开始获取html");
            loadWebView.loadUrl("javascript:window.getStr.getHtmlStr(document.getElementsByTagName('html')[0].innerHTML);");

        }
    };

    public HomeSubFragment(String videoType, String pageUrl, String pageTitle, int fragmentId) {
        BLog.i("pageUlr:" + pageUrl + " + pageTitle:" + pageTitle + " + fragmentId:" + fragmentId);
        this.videoType = videoType;
        this.pageTigle = pageTitle;
        this.fragmentId = fragmentId;
        this.pageUrl = pageUrl;
    }
}
