package com.masai.youtube.Subscription;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.youtube.R;

import java.util.ArrayList;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder> {
private ArrayList<Model_Subscription>arrayList2;

    public SubscriptionAdapter(ArrayList<Model_Subscription> arrayList2) {
        this.arrayList2 = arrayList2;
    }

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_item_layout,parent,false);

        return new SubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        Model_Subscription model_subscription=arrayList2.get(position);
        holder.DataSet(model_subscription);
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class SubscriptionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageChannel;
        TextView channel,subscriber,tVideoUpload,subButton;
        public SubscriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            inittt(itemView);
        }

        private void inittt(View itemView) {
            imageChannel=itemView.findViewById(R.id.subscriptImage);
            channel=itemView.findViewById(R.id.channelName);
            subscriber=itemView.findViewById(R.id.viewer);
            tVideoUpload=itemView.findViewById(R.id.uploadVideo);
            subButton=itemView.findViewById(R.id.subcribe);
        }

        public void DataSet(Model_Subscription model_subscription) {
            imageChannel.setImageResource(model_subscription.getChannelImage());
            channel.setText(model_subscription.getChannelName());
            subscriber.setText(model_subscription.getTotalSubscriber());
            tVideoUpload.setText(model_subscription.getTotalVideo());
            subButton.setText(model_subscription.getsubscribeButton());
        }
    }
}
