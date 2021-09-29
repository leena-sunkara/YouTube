package com.masai.youtube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
  ArrayList<Model>arrayList;

    public HomeAdapter(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Model model=arrayList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView2;
        ImageView firstImage;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.youtuberImage);
            textView=itemView.findViewById(R.id.videoName);
            textView2=itemView.findViewById(R.id.youtubeview);
            firstImage=itemView.findViewById(R.id.video1);
        }

        public void setData(Model model) {
            imageView.setImageResource(model.getImage());
            firstImage.setImageResource(model.getFirstImage());
            textView.setText(model.getVideoName());
            textView2.setText(model.getViewer());
        }
    }
}
