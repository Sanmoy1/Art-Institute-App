package com.example.artinstituteapiapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DefaultBackgroundAdapter extends RecyclerView.Adapter<DefaultBackgroundAdapter.DefaultBackgroundViewHolder> {

    @NonNull
    @Override
    public DefaultBackgroundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_default_background, parent, false);
        return new DefaultBackgroundViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefaultBackgroundViewHolder holder, int position) {
        // No data binding required for the default background
    }

    @Override
    public int getItemCount() {
        return 1; // Only one item to display the default background
    }

    static class DefaultBackgroundViewHolder extends RecyclerView.ViewHolder {
        ImageView defaultImage;
        DefaultBackgroundViewHolder(View itemView) {
            super(itemView);
            defaultImage=itemView.findViewById(R.id.defaultImage);
        }
    }
}

