package com.masai.youtube;

public class Model {
    int image,FirstImage;
    String VideoName,Viewer;

    public Model(int FirstImage,int image, String videoName, String viewer) {
        this.image = image;
        this.FirstImage=FirstImage;
        VideoName = videoName;
        Viewer = viewer;
    }

    public int getImage() {
        return image;
    }

    public String getVideoName() {
        return VideoName;
    }

    public String getViewer() {
        return Viewer;
    }
    public int getFirstImage() {
        return FirstImage;
    }

}
