package com.masai.youtube.subscription;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.youtube.R;

import java.util.ArrayList;

public class SubscribeAdapter extends RecyclerView.Adapter<SubscribeAdapter.SubscriptionViewHolder> {
    private ArrayList<ModelSubscription> arrayList2;

    public SubscribeAdapter(ArrayList<ModelSubscription> arrayList2) {
        this.arrayList2 = arrayList2;
    }

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_item_layout, parent, false);
        return new SubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        ModelSubscription model_subscription = arrayList2.get(position);
        holder.DataSet(model_subscription);
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public static class SubscriptionViewHolder extends RecyclerView.ViewHolder {
        ImageView channelImage;
        TextView channelName, subscribers, totalVideos, subButton;

        public SubscriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View itemView) {
            channelImage = itemView.findViewById(R.id.channelImage);
            channelName = itemView.findViewById(R.id.channelName);
            subscribers = itemView.findViewById(R.id.viewers);
            totalVideos = itemView.findViewById(R.id.uploadVideo);
            subButton = itemView.findViewById(R.id.subscribe);
        }

        public void DataSet(ModelSubscription model_subscription) {
            channelImage.setImageResource(model_subscription.getChannelImage());
            channelName.setText(model_subscription.getChannelName());
            subscribers.setText(model_subscription.getTotalSubscribers());
            totalVideos.setText(model_subscription.getTotalVideos());
            subButton.setText(model_subscription.getSubscribeButton());
        }
    }
}