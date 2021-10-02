package com.masai.youtube.home;

public class Model {
    int image, firstImage;
    String VideoUrl;
    String VideoName, Viewers, ChannelName, TotalSubscribers;

    public Model(String VideoUrl, int image, String videoName, String viewers, int firstImage, String ChannelName, String TotalSubscribers) {
        this.image = image;
        this.VideoUrl = VideoUrl;
        VideoName = videoName;
        Viewers = viewers;
        this.firstImage = firstImage;
        this.ChannelName = ChannelName;
        this.TotalSubscribers = TotalSubscribers;
    }

    public int getImage() {
        return image;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public String getTotalSubscribers() {
        return TotalSubscribers;
    }

    public int getFirstImage() {
        return firstImage;
    }

    public String getVideoName() {
        return VideoName;
    }

    public String getViewers() {
        return Viewers;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

}