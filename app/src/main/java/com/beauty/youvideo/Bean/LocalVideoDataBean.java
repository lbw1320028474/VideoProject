package com.beauty.youvideo.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangwen.lei on 2017/7/19.
 */

public class LocalVideoDataBean {
    private int videoType = 0;
    private List<VideoDataBean> getedVideoDataList = null;

    public LocalVideoDataBean(){
        getedVideoDataList = new ArrayList<VideoDataBean>();
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    public List<VideoDataBean> getGetedVideoDataList() {
        return getedVideoDataList;
    }

    public void setGetedVideoDataList(List<VideoDataBean> getedVideoDataList) {
        this.getedVideoDataList = getedVideoDataList;
    }
}
