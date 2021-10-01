package com.masai.youtube.Subscription;

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

import java.util.ArrayList;


public class SubscribeFragment extends Fragment {
private RecyclerView recyclerView2;
private ArrayList<Model_Subscription>arrayList2=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscribe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView2=view.findViewById(R.id.recycler2);
        setData();
        setREcyclerview();
    }

    private void setREcyclerview() {
        SubscriptionAdapter subscriptionAdapter=new SubscriptionAdapter(arrayList2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(subscriptionAdapter);
    }

    private void setData() {
       for (int i=0;i<30;i++){
           arrayList2.add(new Model_Subscription(R.drawable.masiaicon,"Masai School","12.7K subscribers","131 videos","SUBSCRIBE"));
           arrayList2.add(new Model_Subscription(R.drawable.aajtak,"Aaj Tak","47.7M subscribers","145,482 videos","SUBSCRIBE"));
           arrayList2.add(new Model_Subscription(R.drawable.sony,"Set india","116M subscribers","66,306 videos","SUBSCRIBE"));
       }
    }

}