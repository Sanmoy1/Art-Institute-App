package com.example.artinstituteapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText searchEditText;
    private ImageView clearImageView;
    private Button searchButton;
    private RecyclerView artworkRecyclerView;
    private TextView copyrightNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        clearImageView = findViewById(R.id.clearImageView);
        searchButton = findViewById(R.id.searchButton);
        artworkRecyclerView = findViewById(R.id.artworkRecyclerView);
        copyrightNotice = findViewById(R.id.copyrightNotice);

        clearImageView.setOnClickListener(v -> searchEditText.setText(""));

        searchButton.setOnClickListener(v -> {
            String searchQuery = searchEditText.getText().toString().trim();
            //artworkRecyclerView.setAdapter(new DefaultBackgroundAdapter());

            if (!searchQuery.isEmpty()) {

                fetchArtworkData(searchQuery);
            }
            else {
                artworkRecyclerView.setAdapter(new DefaultBackgroundAdapter());
            }
        });

        copyrightNotice.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,CopyrightActivity.class);
            startActivity(intent);
        });


    }
    private void fetchArtworkData(String searchQuery) {
        // Build the API endpoint URL
        String baseUrl = "https://api.artic.edu/api/v1/artworks/search";
        Uri.Builder builder = Uri.parse(baseUrl).buildUpon();
        builder.appendQueryParameter("q", searchQuery);
        builder.appendQueryParameter("limit", "15");
        builder.appendQueryParameter("page", "1");
        builder.appendQueryParameter("fields", "title, date_display, artist_display, medium_display,artwork_type_title, image_id, dimensions, department_title,credit_line, place_of_origin, gallery_title, gallery_id, id, api_link");
        String apiUrl = builder.build().toString();


        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
                response -> {

                    String apiResponse = response.toString();



                    ArrayList<Artwork> artworkList = parseAndCreateArtworkObjects(apiResponse);
                    if (artworkList.isEmpty()) {

                        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                        artworkRecyclerView.setLayoutManager(layoutManager);
                        artworkRecyclerView.setAdapter(new DefaultBackgroundAdapter());
                    } else {

                        //Toast.makeText(this,"comeon",Toast.LENGTH_SHORT).show();
                        ArtworkAdapter adapter = new ArtworkAdapter(artworkList);
                        artworkRecyclerView.setAdapter(adapter);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                        artworkRecyclerView.setLayoutManager(layoutManager);

                        artworkRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, artworkRecyclerView, (view, position) -> {
                            // Handle the item click
                            //ArrayList<Artwork> artworkList = parseAndCreateArtworkObjects(String.valueOf(apiResponse));
                            Artwork selectedArtwork = artworkList.get(position);

                            // Create an Intent to start ArtworkActivity
                            Intent intent = new Intent(MainActivity.this, ArtworkActivity.class);

                            // Pass the selected artwork's details to ArtworkActivity
                            intent.putExtra("title", selectedArtwork.getTitle());
                            intent.putExtra("date", selectedArtwork.getDate());
                            intent.putExtra("artist", selectedArtwork.getArtist());
                            intent.putExtra("imageUrl", selectedArtwork.getImageUrl());
                            intent.putExtra("department", selectedArtwork.getDepartment());
                            intent.putExtra("galleryTitle", selectedArtwork.getGalleryTitle());
                            intent.putExtra("galleryId", selectedArtwork.getGalleryId());
                            intent.putExtra("location", selectedArtwork.getLocation());
                            intent.putExtra("type", selectedArtwork.getartworkType());
                            intent.putExtra("medium",selectedArtwork.getMedium_display());
                            intent.putExtra("dimensions", selectedArtwork.getDimensions());
                            intent.putExtra("creditLine", selectedArtwork.getCreditLine());

                            // Start the ArtworkActivity with the selected artwork's details
                            startActivity(intent);
                        }));

                    }
                },
                error -> {
                    // Handle errors
                });


        requestQueue.add(jsonObjectRequest);





    }

    private ArrayList<Artwork> parseAndCreateArtworkObjects(String apiResponse) {
        ArrayList<Artwork> artworkList = new ArrayList<>();


        try {
            // Parse the JSON response from the API
            JSONObject jsonResponse = new JSONObject(apiResponse);
            JSONArray data = jsonResponse.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject artworkData = data.getJSONObject(i);

                // Extract the artwork details
                String title = artworkData.getString("title");
                Log.d("Title",title);

                String artist = artworkData.getString("artist_display");
                String imageUrl = artworkData.getString("image_id");
                String date=artworkData.getString("date_display");
                String medium_display=artworkData.getString("medium_display");
                String department_title=artworkData.getString("department_title");
                String gallery_title=artworkData.getString("gallery_title");
                String gallery_id=artworkData.getString("gallery_id");
                String place_of_origin=artworkData.getString("place_of_origin");
                String artwork_type_title=artworkData.getString("artwork_type_title");
                String dimensions=artworkData.getString("dimensions");
                String credit_line=artworkData.getString("credit_line");



                // Create an Artwork object and add it to the list
                Artwork artwork = new Artwork(title,artist,imageUrl,date,department_title,gallery_title,gallery_id,place_of_origin,artwork_type_title,medium_display,dimensions,credit_line);
                artworkList.add(artwork);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("artwork",artworkList.toString());


        return artworkList;
    }


}