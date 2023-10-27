package com.example.artinstituteapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ImageActivity extends AppCompatActivity {

    private TextView titleimage_layout;
    private TextView artist_display_image_layout;
    private TextView artist_display_secondpart;
    private ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title1");
        String artistName=intent.getStringExtra("artistName");
        String artistCountryAndYear=intent.getStringExtra("artist_2nd");
        String imageUrl=intent.getStringExtra("imageurl");

        titleimage_layout=findViewById(R.id.titleimage_layout);
        artist_display_image_layout=findViewById(R.id.artist_display_image_layout);
        artist_display_secondpart=findViewById(R.id.artist_display_secondpart);
        imageView3=findViewById(R.id.imageView3);
        PhotoView photoView=(PhotoView) findViewById(R.id.photo_view);
        titleimage_layout.setText(title);
        artist_display_image_layout.setText(artistName);
        artist_display_secondpart.setText(artistCountryAndYear);
        String picassoImageUrl="https://www.artic.edu/iiif/2/"+imageUrl+"/full/843,/0/default.jpg";
        Picasso.get().load(picassoImageUrl).into(photoView);

        imageView3.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });
    }
}
