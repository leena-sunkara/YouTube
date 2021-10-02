package com.masai.youtube.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class IdModel implements Serializable {

    @SerializedName("kind")
    private String kind;

    @SerializedName("videoId")
    private String videoId;

    public String getKind() {
        return kind;
    }

    public String getVideoId() {
        return videoId;
    }
}