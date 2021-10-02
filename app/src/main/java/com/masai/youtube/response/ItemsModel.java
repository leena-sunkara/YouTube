package com.masai.youtube.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ItemsModel implements Serializable {

    @SerializedName("kind")
    private String kind;

    @SerializedName("etag")
    private String etag;

    @SerializedName("id")
    private IdModel id;

    @SerializedName("snippet")
    private SnippetModel snippet;

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public IdModel getId() {
        return id;
    }

    public SnippetModel getSnippet() {
        return snippet;
    }
}