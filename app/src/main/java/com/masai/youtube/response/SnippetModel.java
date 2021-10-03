package com.masai.youtube.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SnippetModel implements Serializable {

	@SerializedName("publishedAt")
	private String publishedAt;

	@SerializedName("channelId")
	private String channelId;

	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private String description;

	@SerializedName("thumbnails")
	private ThumbnailsModel thumbnails;

	@SerializedName("channelTitle")
	private String channelTitle;

	@SerializedName("liveBroadcastContent")
	private String liveBroadcastContent;

	@SerializedName("publishTime")
	private String publishTime;

	public String getPublishedAt(){
		return publishedAt;
	}

	public String getChannelId(){
		return channelId;
	}

	public String getTitle(){
		return title;
	}

	public String getDescription(){
		return description;
	}

	public ThumbnailsModel getThumbnails(){
		return thumbnails;
	}

	public String getChannelTitle(){
		return channelTitle;
	}

	public String getLiveBroadcastContent(){
		return liveBroadcastContent;
	}

	public String getPublishTime(){
		return publishTime;
	}
}