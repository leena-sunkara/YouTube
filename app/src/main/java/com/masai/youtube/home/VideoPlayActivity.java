package com.masai.youtube.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.masai.youtube.R;

import java.util.Vector;

public class VideoPlayActivity extends AppCompatActivity implements com.masai.youtube.home.ItemClickListener {

    private WebView webView;
    private TextView textView1, textView2;
    private TextView textView3,textView4;
    private ImageView imageview;
    String pVideo;
    private RecyclerView recyclerView3;
    private Vector<Model>arraylist2=new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        initialization();
        dataSet();
        setRecycler();

    }

    private void setRecycler() {
        recyclerView3.setHasFixedSize(true);
        HomeAdapter homeAdapter = new HomeAdapter(arraylist2, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView3.setAdapter(homeAdapter);
        recyclerView3.setLayoutManager(linearLayoutManager);
    }

    private void dataSet() {
        for (int i = 0; i < 20; i++) {
            arraylist2.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/c9v8MzV6PVU\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.masai_icon, "Masai School - Education loans vs Coding Career", "11,201,181 views . Feb 2, 2021", R.drawable.masai,"Masai School","12.7K subscribers"));
            arraylist2.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Re9vbR80Lg4\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.india, "OMG!", "8,743 views . Sep 29, 2021", R.drawable.omgpic,"IndiaTV","27.7M subscribers"));
            arraylist2.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Y77JaKcYROw\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.nawaz, "Nawazuddin siddiqui motivational speech", "2,899,682 views . Mar 25, 2020", R.drawable.picnawaz,"daily Motivation","2M subscribers"));
            arraylist2.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Nv7EQ2dmBv8\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.sony, "Pawandeep की यह Performances हैं Classic", "719,048 views . Sep 7, 2021", R.drawable.singer,"Set india","116M subscribers"));
            arraylist2.add(new Model("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8yHSAtQ73_8\" frameborder=\"0\" allowfullscreen></iframe>", R.drawable.masai_icon, "Know your Resume and Portfolio #Shorts #Masai", "1,052 views . Sep 23, 2021", R.drawable.masai,"Masai School","12.7K subscribers"));

        }
    }

    private void initialization() {
       webView = findViewById(R.id.videoPlay);
        textView1 = findViewById(R.id.VIDEONAME);
        textView2 = findViewById(R.id.YOUTUBERVIEW);
        imageview = findViewById(R.id.ICONimage);
        textView3=findViewById(R.id.cName);
        textView4=findViewById(R.id.tSubscribe);
        recyclerView3=findViewById(R.id.recyclerData);


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

    @Override
    public void ItemClicked(Model model, int position) {
      Intent intent=new Intent(VideoPlayActivity.this,VideoPlayActivity.class);
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