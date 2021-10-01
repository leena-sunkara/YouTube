package com.masai.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.masai.youtube.Home.HomeFagment;
import com.masai.youtube.Subscription.SubscribeFragment;

public class Function extends AppCompatActivity implements View.OnClickListener {

    private ImageView home;
    private ImageView shorts;
    private ImageView upload;
    private ImageView sub;
    private ImageView library;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);


        fragmentManager = getSupportFragmentManager();
        initViews();

    }

    private void initViews() {
        home= findViewById(R.id.ivHome);
        shorts = findViewById(R.id.ivShorts);
        upload = findViewById(R.id.ivUpload);
        sub = findViewById(R.id.ivSub);
        library = findViewById(R.id.ivLibrary);
        addHome();
        home.setOnClickListener(this);
        shorts.setOnClickListener(this);
        upload.setOnClickListener(this);
        sub.setOnClickListener(this);
        library.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        int id= v.getId();
        switch (id){
            case R.id.ivHome:
                addHomeAgain();
                break;
            case R.id.ivShorts:
                Intent intent = new Intent(Function.this, ShortsActivity.class);
                startActivity(intent);
                break;
            case R.id.ivSub:
                addSubscribe();
                break;
            case R.id.ivLibrary:
                addLibrary();
                break;


        }

    }
    private void addHome(){
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        HomeFagment homeFagment=new HomeFagment();
        transaction.add(R.id.flContainer,homeFagment,"fragmentA").commit();
    }
    private void addHomeAgain(){
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        HomeFagment homeFagment=new HomeFagment();
        transaction.add(R.id.flContainer,homeFagment,"fragmentA").addToBackStack("aaa").commit();
    }


    private void addSubscribe(){
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        SubscribeFragment subscribeFragment=new SubscribeFragment();
        transaction.add(R.id.flContainer,subscribeFragment,"fragmentB").addToBackStack("aaa").commit();
    }
    private void addLibrary(){
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        LibraryFragment libraryFragment=new LibraryFragment();
        transaction.add(R.id.flContainer,libraryFragment,"fragmentB").addToBackStack("aaa").commit();
    }

}