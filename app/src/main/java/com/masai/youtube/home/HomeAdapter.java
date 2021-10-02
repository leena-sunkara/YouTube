package com.masai.youtube.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.masai.youtube.R;
import com.masai.youtube.home.ItemClickListener;
import com.masai.youtube.home.Model;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    List<Model> arrayList;
    ItemClickListener itemClickListener;

    public HomeAdapter(List<Model> arrayList, ItemClickListener itemClickListener) {
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new HomeViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Model model = arrayList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, textView2;

        ImageView firstImage;
        ItemClickListener itemClickListener;
        RelativeLayout relativeLayout;

        public HomeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;

            firstImage = itemView.findViewById(R.id.video);
            imageView = itemView.findViewById(R.id.youtuberImage);
            textView = itemView.findViewById(R.id.videoName);
            textView2 = itemView.findViewById(R.id.youtubeviews);

            relativeLayout = itemView.findViewById(R.id.relative);


        }

        public void setData(Model model) {
            firstImage.setImageResource(model.getFirstImage());
            imageView.setImageResource(model.getImage());
            textView.setText(model.getVideoName());
            textView2.setText(model.getViewers());


            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.ItemClicked(model, getAdapterPosition());
                }
            });
        }
    }
}