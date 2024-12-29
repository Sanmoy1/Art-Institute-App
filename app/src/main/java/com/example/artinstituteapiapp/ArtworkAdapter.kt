package com.example.artinstituteapiapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteapiapp.ArtworkAdapter.ArtworkViewHolder
import com.squareup.picasso.Picasso

class ArtworkAdapter(private val artworkList: List<Artwork>) :
    RecyclerView.Adapter<ArtworkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artwork_item, parent, false)
        return ArtworkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) {
        val artwork = artworkList[position]
        holder.titleTextView.text = artwork.title
        holder.artistTextView.text = artwork.artist
        val picassoImageUrl =
            "https://www.artic.edu/iiif/2/" + artwork.imageUrl + "/full/843,/0/default.jpg"
        Picasso.get().load(picassoImageUrl).into(holder.imageView)
        Log.d("picasso", picassoImageUrl)
    }

    override fun getItemCount(): Int {
        return artworkList.size
    }

    inner class ArtworkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView
        var artistTextView: TextView
        var imageView: ImageView

        init {
            titleTextView = itemView.findViewById(R.id.titleTextView)
            artistTextView = itemView.findViewById(R.id.artistTextView)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }
}