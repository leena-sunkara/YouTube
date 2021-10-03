package com.masai.youtube.home;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.masai.youtube.R;
import com.masai.youtube.library.LibraryFragment;
import com.masai.youtube.shorts.ShortsActivity;
import com.masai.youtube.subscription.SubscribeAdapter;
import com.masai.youtube.subscription.SubscribeFragment;

public class Function extends AppCompatActivity implements View.OnClickListener {

    private ImageView home;
    private ImageView shorts;
    private ImageView upload;
    private ImageView sub;
    private ImageView library;
    private FragmentManager fragmentManager;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        fragmentManager = getSupportFragmentManager();
        initViews();
    }

    private void initViews() {
        home = findViewById(R.id.ivHome);
        shorts = findViewById(R.id.ivShorts);
        upload = findViewById(R.id.ivUpload);
        sub = findViewById(R.id.ivSub);
        library = findViewById(R.id.ivLibrary);
        user = findViewById(R.id.ivUser);
        addHome();
        home.setOnClickListener(this);
        shorts.setOnClickListener(this);
        upload.setOnClickListener(this);
        sub.setOnClickListener(this);
        library.setOnClickListener(this);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            user.setImageURI(personPhoto);
        }

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(Function.this, UserAccount.class);
                startActivity(user);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
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

    private void addHome() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        transaction.add(R.id.flContainer, homeFragment, "fragmentHome").commit();
    }

    private void addHomeAgain() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        transaction.add(R.id.flContainer, homeFragment, "fragmentHomeAgain").addToBackStack("fragHomeAgain").commit();
    }

    private void addSubscribe() {
        if (SubscribeAdapter.channelSubscribed) {
            ChannelFragment channelFragment = new ChannelFragment();
            fragmentManager.beginTransaction().add(R.id.flContainer, channelFragment).commit();
        } else {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            SubscribeFragment subscribeFragment = new SubscribeFragment();
            transaction.add(R.id.flContainer, subscribeFragment, "fragmentSub").addToBackStack("fragSub").commit();
        }
    }

    private void addLibrary() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        LibraryFragment libraryFragment = new LibraryFragment();
        transaction.add(R.id.flContainer, libraryFragment, "fragmentLib").addToBackStack("fragLib").commit();
    }
}