package com.masai.youtube.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.masai.youtube.R;

public class VideoPlayActivity extends AppCompatActivity {

    private WebView webView;
    private TextView textView1, textView2;
    private TextView textView3,textView4;
    private ImageView imageview;
    String pVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        initialization();

    }

    private void initialization() {
       webView = findViewById(R.id.videoPlay);
        textView1 = findViewById(R.id.VIDEONAME);
        textView2 = findViewById(R.id.YOUTUBERVIEW);
        imageview = findViewById(R.id.ICONimage);
        textView3=findViewById(R.id.cName);
        textView4=findViewById(R.id.tSubscribe);



        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        pVideo=getIntent().getStringExtra("video");
        webView.loadData(pVideo, "text/html", "utf-8");
        textView1.setText(getIntent().getStringExtra("videoName"));
        textView2.setText(getIntent().getStringExtra("totalViewer"));
        imageview.setImageResource(getIntent().getIntExtra("iconImage", 0));
        textView3.setText(getIntent().getStringExtra("channelName"));
        textView4.setText(getIntent().getStringExtra("tSubscribe"));
    }
}