package com.masai.youtube.subscription;

public class ModelSubscription {
    int channelImage;
    String channelName, totalSubscribers, totalVideos, subscribeButton;

    public ModelSubscription(int channelImage, String channelName, String totalSubscribers, String totalVideos, String subscribeButton) {
        this.channelImage = channelImage;
        this.channelName = channelName;
        this.totalSubscribers = totalSubscribers;
        this.totalVideos = totalVideos;
        this.subscribeButton = subscribeButton;
    }

    public int getChannelImage() {
        return channelImage;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getTotalSubscribers() {
        return totalSubscribers;
    }

    public String getSubscribeButton() {
        return subscribeButton;
    }

    public String getTotalVideos() {
        return totalVideos;
    }
}
