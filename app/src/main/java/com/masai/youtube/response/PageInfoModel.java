package com.masai.youtube.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PageInfoModel implements Serializable {

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("resultsPerPage")
	private int resultsPerPage;

	public int getTotalResults(){
		return totalResults;
	}

	public int getResultsPerPage(){
		return resultsPerPage;
	}
}