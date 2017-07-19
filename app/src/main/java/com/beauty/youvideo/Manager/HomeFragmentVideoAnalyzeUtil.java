package com.beauty.youvideo.Manager;

import android.content.Context;
import android.text.TextUtils;

import com.beauty.youvideo.Bean.VideoDataBean;
import com.beauty.youvideo.Utils.BLog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

public class HomeFragmentVideoAnalyzeUtil {
    public static List<VideoDataBean> ListgetHomeVideoListByHtml(Context context, String htmlStr, int fromIndex) {

        if (TextUtils.isEmpty(htmlStr) || htmlStr.length() < 100) {
            BLog.e("网页html不符合规范,解析错误");
            return null;
        }
        String htmlContent = "<html>" + htmlStr + "</html>";
        List<VideoDataBean> videoList = new ArrayList<VideoDataBean>();
        Document doc = Jsoup.parse(htmlContent);
        videoList = getVideoListByDoc(doc, fromIndex);
        return videoList;
    }

    private static List<VideoDataBean> getVideoListByDoc(Document doc, int fromIndex) {
        List<VideoDataBean> videoList = new ArrayList<VideoDataBean>();
        Elements mainContentElements = doc.body().getElementsByClass("category-main");
       // BLog.e(doc.body().toString());
        if (mainContentElements == null || mainContentElements.size() <= 0) {
            BLog.e("mainContentElements == null, not find class category-main cmmain");
            return null;
        }
        Elements listElements = mainContentElements.get(0).getElementsByClass("category-list");
        if (listElements == null || listElements.size() <= 0) {
            BLog.e("listElements == null, not find class category-list clearfix");
            return null;
        }
        Elements videoListElements = listElements.get(0).getElementsByClass("categoryem");
        if (videoListElements == null || videoListElements.size() <= 0) {
            BLog.e("videoListElements == null, not find class categoryem");
            return null;
        }
        int startIndex = 0;
        if(fromIndex > 0 && fromIndex < videoListElements.size()){
            startIndex = fromIndex - 1;
        }
        for (int i = startIndex; i < videoListElements.size(); ++i) {
            Element e = videoListElements.get(i);
           // BLog.e(e.toString());
            VideoDataBean subVideo = getSubVideo(e);
            if(subVideo != null){
                videoList.add(subVideo);
            }
        }

        return videoList;
    }

    private static VideoDataBean getSubVideo(Element e) {
        if (e == null) {
            return null;
        }
        try {
            VideoDataBean videoDataBean = new VideoDataBean();
            Elements videoElement = e.getElementsByClass("vervideo-bd");
            if (videoElement == null || videoElement.size() <= 0) {
                return null;
            }
            Element subElement = videoElement.get(0);
            if (subElement == null) {
                return null;
            }
            Elements videoLinkElement = subElement.getElementsByClass("vervideo-lilink");
            Element videoTitleElement = subElement.getElementsByClass("vervideo-title").get(0);
            String videoUrl = videoLinkElement.attr("href");
            String videoTitle = videoTitleElement.html();
            Element videoCoverElement = videoLinkElement.get(0).getElementsByClass("vervideo-img").get(0);
            Elements imageElement = videoCoverElement.getElementsByClass("verimg-view");
            String videoImageUrl = imageElement.get(0).getElementsByClass("img").attr("style");
            String videoDuraction = videoCoverElement.getElementsByClass("duration").html();
            String userName = videoElement.get(0).getElementsByClass("actcont-auto").get(0).getElementsByClass("column").html();
            String like_count = videoElement.get(0).getElementsByClass("fav").get(0).html();
            String videoId = videoElement.get(0).getElementsByClass("fav").get(0).attr("data-id");
            BLog.i("videoUrl:" + videoUrl + " + videoTitle:" + videoTitle + " + videoImageUrl:" + videoImageUrl +
                    " + videoDuraction:" + videoDuraction + " + userName:" + userName + " + like_count:" + like_count + " + videoId:" + videoId);
            videoDataBean.setCover_pic(videoImageUrl);
            videoDataBean.setLikes_count(like_count);
            videoDataBean.setUser_name(userName);
            videoDataBean.setId(videoId);
            videoDataBean.setVideo_url(videoUrl);
            videoDataBean.setCaption(videoTitle);
            return videoDataBean;
        } catch (Exception except) {
            BLog.e(except.getMessage());
            return null;
        }
    }
}
