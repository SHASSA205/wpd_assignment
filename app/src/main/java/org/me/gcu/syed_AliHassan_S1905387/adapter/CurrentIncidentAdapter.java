package org.me.gcu.syed_AliHassan_S1905387.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.me.gcu.syed_AliHassan_S1905387.View.Current_incidents_detail;
import org.me.gcu.syed_AliHassan_S1905387.R;
import org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents.RssFeed;
import org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents.RssItem;
import org.me.gcu.syed_AliHassan_S1905387.Util.ItemClick;

import java.util.ArrayList;

public class CurrentIncidentAdapter extends RecyclerView.Adapter<CurrentIncidentAdapter.ViewHolder> {

    public RssFeed rssFeed;
    public LayoutInflater mInflater;
    public ItemClick itemClick;

    // data is passed into the constructor
    public CurrentIncidentAdapter(Context context, RssFeed rssFeed, Current_incidents_detail current_incidents_detail) {
        this.mInflater = LayoutInflater.from(context);
        this.rssFeed = rssFeed;
        this.itemClick = current_incidents_detail;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_current_incidents, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArrayList<RssItem> rssItems = rssFeed.channel.item;
        holder.tittle_data.setText(rssItems.get(position).title);
        holder.description_data.setText(rssItems.get(position).description);
        holder.date_time_data.setText(rssItems.get(position).pubDate);

        holder.location_map_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.mapClick(holder.getAdapterPosition());
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return rssFeed.channel.item.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date_time_data,description_data,tittle_data;
        ImageView location_map_id;

        ViewHolder(View itemView) {
            super(itemView);
            location_map_id = itemView.findViewById(R.id.location_map_id);
            date_time_data = itemView.findViewById(R.id.date_time_data);
            description_data = itemView.findViewById(R.id.description_data);
            tittle_data = itemView.findViewById(R.id.tittle_data);
        }
    }
}