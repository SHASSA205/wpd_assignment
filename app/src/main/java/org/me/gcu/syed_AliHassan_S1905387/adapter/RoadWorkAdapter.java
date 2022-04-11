package org.me.gcu.syed_AliHassan_S1905387.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.me.gcu.syed_AliHassan_S1905387.Been.RoadWork.RssItemRoadWork;
import org.me.gcu.syed_AliHassan_S1905387.Been.RoadWorkRssFeed;
import org.me.gcu.syed_AliHassan_S1905387.View.Planned_road_works_detial;
import org.me.gcu.syed_AliHassan_S1905387.R;
import org.me.gcu.syed_AliHassan_S1905387.View.Road_work_detail;
import org.me.gcu.syed_AliHassan_S1905387.Util.ItemClick;

import java.util.ArrayList;

public class RoadWorkAdapter extends RecyclerView.Adapter<RoadWorkAdapter.ViewHolder> {

    public RoadWorkRssFeed roadWorkRssFeed;
    public LayoutInflater mInflater;
    public ItemClick itemClick;

    // data is passed into the constructor
    public RoadWorkAdapter(Context context, RoadWorkRssFeed roadWorkRssFeed, Road_work_detail road_work_detail) {
        this.mInflater = LayoutInflater.from(context);
        this.roadWorkRssFeed = roadWorkRssFeed;
        this.itemClick = road_work_detail;
    }

    // data is passed into the constructor
    public RoadWorkAdapter(Context context, RoadWorkRssFeed roadWorkRssFeed, Planned_road_works_detial road_work_detail) {
        this.mInflater = LayoutInflater.from(context);
        this.roadWorkRssFeed = roadWorkRssFeed;
        this.itemClick = road_work_detail;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_road_work, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArrayList<RssItemRoadWork> rssItems = roadWorkRssFeed.channel.item;
        holder.tittle_data.setText(rssItems.get(position).title);
        holder.description_data.setText(roadWorkRssFeed.channel.title);
        holder.location_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.mapClick(holder.getAdapterPosition());
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return roadWorkRssFeed.channel.item.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tittle_data,description_data;
        ImageView location_map;

        ViewHolder(View itemView) {
            super(itemView);
            tittle_data = itemView.findViewById(R.id.tittle_data);
            description_data = itemView.findViewById(R.id.description_data);
            location_map = itemView.findViewById(R.id.location_map);
        }
    }
}