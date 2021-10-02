package com.masai.youtube.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.masai.youtube.R;

public class VideoPlayActivity extends AppCompatActivity {

    private WebView webView;
    private TextView textView1, textView2;
    private TextView textView3, textView4;
    private ImageView imageview;
    String playVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        initialization();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initialization() {
        webView = findViewById(R.id.videoPlay);
        textView1 = findViewById(R.id.videoName);
        textView2 = findViewById(R.id.youtuberViews);
        imageview = findViewById(R.id.iconImage);
        textView3 = findViewById(R.id.channelName);
        textView4 = findViewById(R.id.totalSubscribers);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        playVideo = getIntent().getStringExtra("video");
        webView.loadData(playVideo, "text/html", "utf-8");
        textView1.setText(getIntent().getStringExtra("videoName"));
        textView2.setText(getIntent().getStringExtra("totalViewers"));
        imageview.setImageResource(getIntent().getIntExtra("iconImage", 0));
        textView3.setText(getIntent().getStringExtra("channelName"));
        textView4.setText(getIntent().getStringExtra("totalSubscribers"));
    }
}