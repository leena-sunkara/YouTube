package com.masai.youtube.Subscription;

public class Model_Subscription {
    int channelImage;
    String channelName,totalSubscriber,totalVideo,subscribeButton;

    public Model_Subscription(int channelImage, String channelName, String totalSubscriber, String totalVideo,String subscribeButton) {
        this.channelImage = channelImage;
        this.channelName = channelName;
        this.totalSubscriber = totalSubscriber;
        this.totalVideo = totalVideo;
        this.totalVideo = totalVideo;
        this.subscribeButton = subscribeButton;
    }

    public int getChannelImage() {
        return channelImage;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getTotalSubscriber() {
        return totalSubscriber;
    }

    public String getsubscribeButton() {
        return subscribeButton;
    }
    public String getTotalVideo() {
        return totalVideo;
    }
}
