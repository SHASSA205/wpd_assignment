package org.me.gcu.syed_AliHassan_S1905387.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.me.gcu.syed_AliHassan_S1905387.Been.RoadWorkRssFeed;
import org.me.gcu.syed_AliHassan_S1905387.R;
import org.me.gcu.syed_AliHassan_S1905387.Util.ItemClick;
import org.me.gcu.syed_AliHassan_S1905387.adapter.RoadWorkAdapter;
import org.me.gcu.syed_AliHassan_S1905387.retrofit.ApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Road_work_detail extends AppCompatActivity implements ItemClick {

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.progressDialog)
    ProgressBar progressDialog;

    private RoadWorkAdapter adapter;

    private RoadWorkRssFeed roadWorkRssFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_incidents_detail);

        // Butter Knife use
        ButterKnife.bind(this);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Road Work");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        progressDialog.setVisibility(View.VISIBLE);
        // Thread Some time scrollView Hold
        Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                getRoadWork();
            }
        },1000);
    }

    public void getRoadWork()
    {
        new ApiClient(this).getInstance(this).getWebService().getRoadWork().enqueue(new Callback<RoadWorkRssFeed>() {
            @Override
            public void onResponse(Call<RoadWorkRssFeed> call, Response<RoadWorkRssFeed> response) {
                progressDialog.setVisibility(View.GONE);
                if(response.body() != null) {
                    // set up the RecyclerView

                    roadWorkRssFeed = response.body();
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    adapter = new RoadWorkAdapter(getApplicationContext(), response.body(),Road_work_detail.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<RoadWorkRssFeed> call, Throwable t) {
                progressDialog.setVisibility(View.GONE);
                Log.d("Error","----->"+t.getMessage());
            }
        });
    }

    @Override
    public void mapClick(int index) {
        if(!roadWorkRssFeed.channel.item.get(index).point.isEmpty())
        {
            String[] separated = roadWorkRssFeed.channel.item.get(index).point.split(" ");
            Uri gmmIntentUri = Uri.parse("google.navigation:q="+separated[0]+","+separated[1]);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }
    }
}