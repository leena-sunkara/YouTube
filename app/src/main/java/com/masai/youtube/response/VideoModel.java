package com.masai.youtube.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VideoModel implements Serializable {

	@SerializedName("kind")
	private String kind;

	@SerializedName("etag")
	private String etag;

	@SerializedName("nextPageToken")
	private String nextPageToken;

	@SerializedName("regionCode")
	private String regionCode;

	@SerializedName("pageInfo")
	private PageInfoModel pageInfo;

	@SerializedName("items")
	private List<ItemsModel> items;

	public String getKind(){
		return kind;
	}

	public String getEtag(){
		return etag;
	}

	public String getNextPageToken(){
		return nextPageToken;
	}

	public String getRegionCode(){
		return regionCode;
	}

	public PageInfoModel getPageInfo(){
		return pageInfo;
	}

	public List<ItemsModel> getItems(){
		return items;
	}
}