package com.masai.youtube.shorts;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.youtube.R;

import java.util.ArrayList;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.shortsViewHolder> {

    ArrayList<ShortVideoModel> videoModels;

    public ShortsAdapter(ArrayList<ShortVideoModel> videoModels) {
        this.videoModels = videoModels;
    }

    @NonNull
    @Override
    public shortsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.short_layout,parent,false);
        return new shortsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull shortsViewHolder holder, int position) {
        holder.setData(videoModels.get(position));
    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }


    class shortsViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        TextView name,desc;
        ProgressBar pBar;

        public shortsViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.shortVideo);
            name = itemView.findViewById(R.id.shortChanelName);
            desc = itemView.findViewById(R.id.shortVideoTitle);
            pBar = itemView.findViewById(R.id.progressBar);

        }

        void setData(ShortVideoModel obj){
            videoView.setVideoURI(obj.getUrl());
            name.setText(obj.getName());
            desc.setText(obj.getDesc());
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    pBar.setVisibility(View.GONE);
                    mp.start();
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }


    }




}
