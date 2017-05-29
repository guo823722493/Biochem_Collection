package com.biochemical.biochemicalcollections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Catalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_layout);



        ImageButton chapter_1=(ImageButton)findViewById(R.id.chapter1);
        ImageButton chapter_2=(ImageButton)findViewById(R.id.chapter2);
        ImageButton chapter_3=(ImageButton)findViewById(R.id.chapter3);
        ImageButton chapter_4=(ImageButton)findViewById(R.id.chapter4);
        ImageButton chapter_5=(ImageButton)findViewById(R.id.chapter5);
        ImageButton chapter_6=(ImageButton)findViewById(R.id.chapter6);
        ImageButton setting=(ImageButton)findViewById(R.id.setting);
        chapter_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent ch1=new Intent(Catalog.this,Chapter_1.class);
                startActivity(ch1);
            }
        });
        chapter_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ch2=new Intent(Catalog.this,Chapter_2.class);
                startActivity(ch2);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set=new Intent(Catalog.this,Setting.class);
                        startActivity(set);
            }
        });


    }
}
