package com.masai.youtube.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ThumbnailsModel implements Serializable {

	@SerializedName("default")
	private JsonMemberDefaultModel jsonMemberDefault;

	@SerializedName("medium")
	private MediumModel medium;

	@SerializedName("high")
	private HighModel high;

	public JsonMemberDefaultModel getJsonMemberDefault(){
		return jsonMemberDefault;
	}

	public MediumModel getMedium(){
		return medium;
	}

	public HighModel getHigh(){
		return high;
	}
}