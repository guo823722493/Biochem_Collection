package com.biochemical.biochemicalcollections;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class Chapter_1 extends AppCompatActivity {
    WebView page_1;
    ImageButton back;
    ImageButton setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_1_layout);
        back = (ImageButton) findViewById(R.id.back);
        setting = (ImageButton) findViewById(R.id.setting);
        page_1 = (WebView) findViewById(R.id.Page_1);

        WebSettings mwebsettings=page_1.getSettings();
        mwebsettings.setJavaScriptEnabled(true);
        mwebsettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mwebsettings.setPluginState(WebSettings.PluginState.ON);
        mwebsettings.setAllowFileAccess(true);
        mwebsettings.setLoadWithOverviewMode(true);
        mwebsettings.setUseWideViewPort(true);
        page_1.setVisibility(View.VISIBLE);
        mwebsettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
       mwebsettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        mwebsettings.setSupportMultipleWindows(true);
        mwebsettings.setBuiltInZoomControls(true);
        mwebsettings.setDomStorageEnabled(true);
        page_1.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        if(Build.VERSION.SDK_INT>=21)
        {
            mwebsettings.setMixedContentMode(mwebsettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
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
        page_1.loadUrl("file:///android_asset/index.html");
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

    @Override
    protected void onPause() {
        super.onPause();
        page_1.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        page_1.onResume();
    }
}

