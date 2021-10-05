package com.masai.youtube.shorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import com.masai.youtube.R;

public class ShortsActivity extends AppCompatActivity {
    private ArrayList<ShortVideoModel> videoModels = new ArrayList<>();
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //done
        setContentView(R.layout.activity_shorts);
        initViews();
        setVideos();

    }

    private void initViews() {
        viewPager2 = findViewById(R.id.viewpager);
    }

    private void setVideos() {
        Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid5);
        Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid2);
        Uri uri3 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid3);
        Uri uri4 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid4);
        Uri uri5 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid5);
        ShortVideoModel v1 = new ShortVideoModel(uri2,"Vijay","Video is Here For Dummy Cute puppy");
        videoModels.add(v1);
        ShortVideoModel v2 = new ShortVideoModel(uri5,"Vijay","Jackma Ali Baba motivation Video");
        videoModels.add(v2);
        ShortVideoModel v3 = new ShortVideoModel(uri3,"Vijay","Two major rules You should Folow");
        videoModels.add(v3);
        ShortVideoModel v4 = new ShortVideoModel(uri4,"Vijay","Cola Vs Potato Chips");
        videoModels.add(v4);
        ShortVideoModel v5 = new ShortVideoModel(uri1,"Vijay","Babbu Mann Super hit Song");
        videoModels.add(v5);
        viewPager2.setAdapter(new ShortsAdapter(videoModels));

    }
}