package com.masai.youtube.Home;

public class Model {
    int image,firstImage;
    String VideoUrl;
    String VideoName,Viewer,ChannelName,TotalSubscribe;

    public Model(String VideoUrl,int image, String videoName, String viewer,int firstImage,String ChannelName,String TotalSubscribe) {
        this.image = image;
        this.VideoUrl=VideoUrl;
        VideoName = videoName;
        Viewer = viewer;
        this.firstImage=firstImage;
       this.ChannelName=ChannelName;
        this.TotalSubscribe=TotalSubscribe;
    }

    public int getImage() {
        return image;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public String getTotalSubscribe() {
        return TotalSubscribe;
    }

    public int getFirstImage() {
        return firstImage;
    }

    public String getVideoName() {
        return VideoName;
    }

    public String getViewer() {
        return Viewer;
    }
    public String getVideoUrl() {
        return VideoUrl;
    }

}
