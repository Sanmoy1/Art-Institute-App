package com.example.artinstituteapiapp;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtworkAdapter extends RecyclerView.Adapter<ArtworkAdapter.ArtworkViewHolder> {
    private final List<Artwork> artworkList;
    //Context context;

    public ArtworkAdapter(List<Artwork> artworkList) {
        this.artworkList = artworkList;

    }

    @Override
    public ArtworkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artwork_item, parent, false);
        return new ArtworkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtworkViewHolder holder, int position) {
        Artwork artwork = artworkList.get(position);
        holder.titleTextView.setText(artwork.getTitle());
        holder.artistTextView.setText(artwork.getArtist());
        String picassoImageUrl="https://www.artic.edu/iiif/2/"+artwork.getImageUrl()+"/full/843,/0/default.jpg";
        Picasso.get().load(picassoImageUrl).into(holder.imageView);
        Log.d("picasso",picassoImageUrl);

    }

    @Override
    public int getItemCount() {
        return artworkList.size();
    }

    public class ArtworkViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView artistTextView;
        public ImageView imageView;

        public ArtworkViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            artistTextView=itemView.findViewById(R.id.artistTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
