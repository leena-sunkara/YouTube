package com.masai.youtube;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFagment extends Fragment {
private RecyclerView recyclerView;
private ArrayList<Model>arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fagment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler);
        datSet();
        setRecycler();

    }

    private void datSet() {
        for (int i=0;i<20;i++){
            arrayList.add(new Model(R.drawable.masai,R.drawable.masiaicon,"Know your Resume and Portfolio #Shorts #Masai","1,052 viewsSep 23, 2021"));
        }

    }



    private void setRecycler() {
     HomeAdapter homeAdapter=new HomeAdapter(arrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}