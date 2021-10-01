package com.masai.youtube.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class JsonMemberDefaultModel implements Serializable {

	@SerializedName("url")
	private String url;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	public String getUrl(){
		return url;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}
}