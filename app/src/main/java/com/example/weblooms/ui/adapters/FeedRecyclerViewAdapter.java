package com.example.weblooms.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weblooms.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> imageList;
    private int deviceheight;
    private int devicewidth;

    public FeedRecyclerViewAdapter(ArrayList<String> imageList){
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)parent.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //if you need three fix imageview in width
        devicewidth = displaymetrics.widthPixels / 3;
        Log.e("TAG", "onCreateViewHolder: image width = " + devicewidth);
        //if you need 4-5-6 anything fix imageview in height
        deviceheight = (int)(devicewidth * 1.2);
        Log.e("TAG", "onCreateViewHolder: image height = " + deviceheight);

        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(imageList.get(position)).into(holder.imageView);
        holder.textView.setText((position*10) + "");
        Log.e("TAG", "onBindViewHolder: " + imageList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount: "+ imageList.size());
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.e("TAG", "ViewHolder: inside its constructor");
            imageView = itemView.findViewById(R.id.image_view_item);
            textView = itemView.findViewById(R.id.text_likes_item);
            textView.getLayoutParams().width = devicewidth;
            imageView.getLayoutParams().width = devicewidth;
            imageView.getLayoutParams().height= deviceheight;
        }
    }
}
