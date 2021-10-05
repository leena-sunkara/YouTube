package com.masai.youtube.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masai.youtube.R;

import java.util.Vector;


public class HomeFragment extends Fragment implements ItemClickListener {
    private RecyclerView recyclerView;
    private Vector<Model> arrayList = new Vector<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        datSet();
        setRecycler();

    }

    private void datSet() {
        for (int i = 0; i < 20; i++) {
            arrayList.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/c9v8MzV6PVU\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.masai_icon, "Masai School - Education loans vs Coding Career", "11,201,181 views . Feb 2, 2021", R.drawable.masai,"Masai School","12.7K subscribers"));
            arrayList.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Re9vbR80Lg4\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.india, "OMG!", "8,743 views . Sep 29, 2021", R.drawable.omgpic,"IndiaTV","27.7M subscribers"));
            arrayList.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Y77JaKcYROw\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.nawaz, "Nawazuddin siddiqui motivational speech", "2,899,682 views . Mar 25, 2020", R.drawable.picnawaz,"daily Motivation","2M subscribers"));
            arrayList.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Nv7EQ2dmBv8\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.sony, "Pawandeep की यह Performances हैं Classic", "719,048 views . Sep 7, 2021", R.drawable.singer,"Set india","116M subscribers"));
            arrayList.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8yHSAtQ73_8\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.masai_icon, "Know your Resume and Portfolio #Shorts #Masai", "1,052 views . Sep 23, 2021", R.drawable.masai,"Masai School","12.7K subscribers"));
        }
    }


    private void setRecycler() {
        recyclerView.setHasFixedSize(true);
        HomeAdapter homeAdapter = new HomeAdapter(arrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void ItemClicked(Model model, int position) {

        Intent intent = new Intent(getContext(), VideoPlayActivity.class);

        String video, videoName, totalViewer,channelName,tSubscribe;
        int iconImage;

        video = model.getVideoUrl();
        iconImage = model.getImage();
        videoName = model.getVideoName();
        totalViewer = model.getViewers();
        channelName=model.getChannelName();
        tSubscribe=model.getTotalSubscribers();

        intent.putExtra("video", video);
        intent.putExtra("iconImage", iconImage);
        intent.putExtra("videoName", videoName);
        intent.putExtra("totalViewer", totalViewer);
        intent.putExtra("channelName",channelName);
        intent.putExtra("tSubscribe",tSubscribe);

        startActivity(intent);
    }
}