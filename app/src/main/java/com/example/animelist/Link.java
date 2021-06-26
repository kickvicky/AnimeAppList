package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Link extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.instagram.com/kickvickyy/");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
//    @Override
//    public void onBackPressed(){
//        if(webView.canGoBack()){
//            webView.goBack();
//        }
//        else {
//            super.onBackPressed();
//        }
//
//    }
}