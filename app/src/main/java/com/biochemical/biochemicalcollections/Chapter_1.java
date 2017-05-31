package com.biochemical.biochemicalcollections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class Chapter_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_1_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        ImageButton setting = (ImageButton) findViewById(R.id.setting);
        WebView page_1 = (WebView) findViewById(R.id.Page_1);
        WebSettings mwebsettings=page_1.getSettings();
        mwebsettings.setJavaScriptEnabled(true);
        final ProgressBar mProgressBar=(ProgressBar)findViewById(R.id.mProgressBar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set = new Intent(Chapter_1.this, Setting.class);
                startActivity(set);
            }
        });
        page_1.loadUrl("https://www.baidu.com/");
        page_1.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        page_1.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100)
                {
                    mProgressBar.setVisibility(view.GONE);
                }
                else
                {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);

                }
            }
        });
    }
}

