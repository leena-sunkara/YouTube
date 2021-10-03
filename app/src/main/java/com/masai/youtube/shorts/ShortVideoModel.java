package com.masai.youtube.shorts;

import android.net.Uri;

public class ShortVideoModel {
    String name,desc;Uri url;


    public ShortVideoModel(Uri url, String name, String desc) {
        this.url = url;
        this.name = name;
        this.desc = desc;
    }

    public Uri getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

}
