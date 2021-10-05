package com.masai.youtube.subscription;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.masai.youtube.R;
import com.masai.youtube.home.ChannelFragment;

import java.util.ArrayList;

public class SignedInSubscribeFragment extends Fragment {

    private RecyclerView recyclerView2;
    private ArrayList<ModelSubscription> arrayList2 = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signed_in_subscribe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView2 = view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipe);
        setData();
        setRecyclerView();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (SubscribeAdapter.channelSubscribed) updateLayout();
            }
        });
    }

    private void updateLayout() {
        ChannelFragment channelFragment = new ChannelFragment();
        getParentFragmentManager().beginTransaction().remove(this).commit();
        getParentFragmentManager().beginTransaction().replace(R.id.flContainer, channelFragment).commit();
    }

    private void setRecyclerView() {
        SubscribeAdapter subscribeAdapter = new SubscribeAdapter(arrayList2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(subscribeAdapter);
    }

    private void setData() {
        for (int i = 0; i < 30; i++) {
            arrayList2.add(new ModelSubscription(R.drawable.masai_icon, "Masai School", "12.7K subscribers", "131 videos", "SUBSCRIBE"));
            arrayList2.add(new ModelSubscription(R.drawable.aajtak, "Aaj Tak", "47.7M subscribers", "145,482 videos", "SUBSCRIBE"));
            arrayList2.add(new ModelSubscription(R.drawable.sony, "Set india", "116M subscribers", "66,306 videos", "SUBSCRIBE"));
        }
    }
}