package com.masai.youtube.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.masai.youtube.R;


public class VideoPlayFragment extends Fragment {
private WebView webView;
private TextView textView1,textView2;
private ImageView imageview;
String pVideo,pText1,pTExt2;
int pImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments()!=null){
            pVideo=getArguments().getString("video");
            pText1=getArguments().getString("videoName");
            pTExt2=getArguments().getString("totalViewer");
            pImage=getArguments().getInt("iconImage");
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_play, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialization(view);
    }

    private void initialization(View view) {
        webView=view.findViewById(R.id.videoPlay);
        textView1=view.findViewById(R.id.VIDEONAME);
        textView2=view.findViewById(R.id.YOUTUBERVIEW);
        imageview=view.findViewById(R.id.ICONimage);

        textView1.setText(pText1);
        textView2.setText(pTExt2);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadData(pVideo,"text/html","utf-8");

    }
}