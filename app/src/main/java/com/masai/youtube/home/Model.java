package com.masai.youtube.home;

public class Model {
    int video, FirstImage;
    String VideoName, Viewer;

    public Model(int video, int firstImage, String videoName, String viewer) {
        this.video = video;
        FirstImage = firstImage;
        VideoName = videoName;
        Viewer = viewer;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public int getFirstImage() {
        return FirstImage;
    }

    public void setFirstImage(int firstImage) {
        FirstImage = firstImage;
    }

    public String getVideoName() {
        return VideoName;
    }

    public void setVideoName(String videoName) {
        VideoName = videoName;
    }

    public String getViewer() {
        return Viewer;
    }

    public void setViewer(String viewer) {
        Viewer = viewer;
    }
}
