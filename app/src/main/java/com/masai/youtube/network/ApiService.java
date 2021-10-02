package com.masai.youtube.network;

import com.masai.youtube.response.VideoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search")
    Call<VideoModel> getVideoDetails(@Query("key") String key,
                                     @Query("channelId") String channelId,
                                     @Query("part") String part,
                                     @Query("order") String order,
                                     @Query("maxResults") String maxResults,
                                     @Query("type") String type);
}