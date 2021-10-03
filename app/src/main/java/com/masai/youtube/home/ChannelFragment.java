package com.masai.youtube.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.youtube.R;
import com.masai.youtube.network.ApiService;
import com.masai.youtube.network.Network;
import com.masai.youtube.response.ItemsModel;
import com.masai.youtube.response.VideoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChannelFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_channel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        progressBar = view.findViewById(R.id.progress_circular);
        getData();
    }

    private void getData() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getVideoDetails("AIzaSyDaI4Ku72uiRPFk4pOBbBIC9P3qt7qzmsg",
                "UCENOACKQiqejXP-bb9sCnMg",
                "snippet", "date", "20", "video").enqueue(new Callback<VideoModel>() {
            @Override
            public void onResponse(Call<VideoModel> call, Response<VideoModel> response) {
                setRecyclerView(response.body().getItems());
            }

            @Override
            public void onFailure(Call<VideoModel> call, Throwable t) {
                Toast.makeText(context, "Failed to get the data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView(List<ItemsModel> items) {
        ChannelAdapter channelAdapter = new ChannelAdapter(context, items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setAdapter(channelAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}