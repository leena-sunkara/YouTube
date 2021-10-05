package com.masai.youtube.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.youtube.R;
import com.masai.youtube.response.ItemsModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder> {

    Context context;
    List<ItemsModel> items;

    public ChannelAdapter(Context context, List<ItemsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel_item_layout, parent, false);
        return new ChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load(items.get(position).getSnippet().getThumbnails().getHigh().getUrl()).into(holder.videoThumbnail);
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onApiChange(@NonNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer) {
                super.onApiChange(youTubePlayer);
                    String videoID = items.get(position).getId().getVideoId();
                    youTubePlayer.loadVideo(videoID, 0);
                    holder.videoThumbnail.setVisibility(View.INVISIBLE);
            }
        });
        holder.channelImage.setImageResource(R.drawable.masai_icon);
        holder.videoTitle.setText(items.get(position).getSnippet().getTitle());
        holder.channelTitle.setText(items.get(position).getSnippet().getChannelTitle());
        holder.publishTime.setText(items.get(position).getSnippet().getPublishTime());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ChannelViewHolder extends RecyclerView.ViewHolder {
        YouTubePlayerView youTubePlayerView;
        ImageView videoThumbnail, channelImage;
        TextView videoTitle, channelTitle, publishTime;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
            youTubePlayerView = itemView.findViewById(R.id.video);
            channelImage = itemView.findViewById(R.id.channelImage);
            videoTitle = itemView.findViewById(R.id.videoTitle);
            channelTitle = itemView.findViewById(R.id.channelTitle);
            publishTime = itemView.findViewById(R.id.publishTime);
        }
    }
}
