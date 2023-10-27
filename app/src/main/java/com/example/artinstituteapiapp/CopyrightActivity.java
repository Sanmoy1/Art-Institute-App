package com.example.artinstituteapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CopyrightActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.copyright_layout);

        ImageView imageView2=findViewById(R.id.imageView2);
        imageView2.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, MainActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent2);
        });
    }
}
