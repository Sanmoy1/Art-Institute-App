package com.example.artinstituteapiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ArtworkActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView dateTextView;
    private TextView artistNameTextView;
    private TextView artistCountryAndYearTextView;
    private ImageView artworkImageView;
    private TextView departmentTextView;
    private TextView galleryTitleTextView;
    private ImageView galleryIconImageView;
    private TextView locationTextView;
    private TextView typeAndMediumTextView;
    private TextView dimensionsTextView;
    private TextView creditLineTextView;
    private ImageView applogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork);

        // Initialize your UI elements
        titleTextView = findViewById(R.id.titleTextView);
        dateTextView = findViewById(R.id.dateTextView);
        artistNameTextView = findViewById(R.id.artistNameTextView);
        artistCountryAndYearTextView = findViewById(R.id.artistCountryAndYearTextView);
        artworkImageView = findViewById(R.id.artworkImageView);
        departmentTextView = findViewById(R.id.departmentTextView);
        galleryTitleTextView = findViewById(R.id.galleryTitleTextView);
        galleryIconImageView = findViewById(R.id.galleryIconImageView);
        locationTextView = findViewById(R.id.locationTextView);
        typeAndMediumTextView = findViewById(R.id.typeAndMediumTextView);
        dimensionsTextView = findViewById(R.id.dimensionsTextView);
        creditLineTextView = findViewById(R.id.creditLineTextView);

        // Retrieve data from the intent (passed from MainActivity)
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");
        String artistName = intent.getStringExtra("artistName");
        String artistCountryAndYear = intent.getStringExtra("artistCountryAndYear");
        String imageUrl = intent.getStringExtra("imageUrl");
        String department = intent.getStringExtra("department");
        String galleryTitle = intent.getStringExtra("galleryTitle");
        String galleryId = intent.getStringExtra("galleryId");
        String location = intent.getStringExtra("location");
        String type = intent.getStringExtra("type");
        String medium = intent.getStringExtra("medium");
        String dimensions = intent.getStringExtra("dimensions");
        String creditLine = intent.getStringExtra("creditLine");

        //Log.d("date",date);e
        if (date != null) {
            Log.d("TAG", date);
        } else {
            Log.d("TAG", "someVariable is null");
        }


        // Set the retrieved data to the respective TextViews and ImageView
        titleTextView.setText(title);
        dateTextView.setText(date);
        artistNameTextView.setText(artistName);
        artistCountryAndYearTextView.setText(artistCountryAndYear);

        // Load the image using Picasso
        String picassoImageUrl="https://www.artic.edu/iiif/2/"+imageUrl+"/full/843,/0/default.jpg";
        Picasso.get().load(picassoImageUrl).into(artworkImageView);

        departmentTextView.setText(department);
        galleryTitleTextView.setText(galleryTitle);

        // Create a gallery link and set it as a clickable link
        SpannableString galleryLink = new SpannableString("Gallery Info");
        galleryLink.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle gallery link click
                openGalleryInfo(galleryId);
            }
        }, 0, galleryLink.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        galleryTitleTextView.setText(galleryLink);
        galleryTitleTextView.setMovementMethod(LinkMovementMethod.getInstance());

        locationTextView.setText(location);
        typeAndMediumTextView.setText(type + " - " + medium);
        dimensionsTextView.setText(dimensions);
        creditLineTextView.setText(creditLine);
    }

    private void openGalleryInfo(String galleryId) {
        // Create a URL and open the gallery info in a web browser
        String galleryUrl = "https://www.artic.edu/galleries/" + galleryId;
        Uri galleryUri = Uri.parse(galleryUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, galleryUri);
        startActivity(intent);
    }
}
