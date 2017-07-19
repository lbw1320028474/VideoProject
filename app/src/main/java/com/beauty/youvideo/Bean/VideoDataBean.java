package com.beauty.youvideo.Bean;

/**
 * Created by bangwen.lei on 2017/7/18.
 */

public class VideoDataBean {

    /**
     * id : 806774853
     * user_id : 19343921
     * url : http://www.meipai.com/media/806774853
     * cover_pic : http://mvimg1.meitudata.com/596c1ea1931a66277.jpg!thumb320
     * screen_name : 派派派派派大星ོ
     * caption : 8月5号 SuperMi x TheOne 等你口水满天飞
     * avatar : http://mvavatar2.meitudata.com/58bbcd3d2f7019030.jpg
     * plays_count : 52194
     * comments_count : 54
     * likes_count : 1818
     * created_at : 1500257949
     */

    private String id = "";
    private String user_id = "";
    private String user_name = "";
    private String video_url = "";
    private String cover_pic = "";
    private String caption = "";
    private String avatar = "";
    private String plays_count = "";
    private String comments_count = "";
    private String likes_count = "";
    private String created_at = "";
    private String videoType = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPlays_count() {
        return plays_count;
    }

    public void setPlays_count(String plays_count) {
        this.plays_count = plays_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Override
    public String toString() {
        return "VideoDataBean{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", video_url='" + video_url + '\'' +
                ", cover_pic='" + cover_pic + '\'' +
                ", caption='" + caption + '\'' +
                ", avatar='" + avatar + '\'' +
                ", plays_count='" + plays_count + '\'' +
                ", comments_count='" + comments_count + '\'' +
                ", likes_count='" + likes_count + '\'' +
                ", created_at='" + created_at + '\'' +
                ", videoType='" + videoType + '\'' +
                '}';
    }
}
