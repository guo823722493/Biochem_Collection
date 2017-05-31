package com.biochemical.biochemicalcollections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Chapter_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_2_layout);

        ImageButton back = (ImageButton) findViewById(R.id.back);
        ImageButton setting = (ImageButton) findViewById(R.id.setting);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set = new Intent(Chapter_2.this, Setting.class);
                startActivity(set);
            }
        });
    }
}
