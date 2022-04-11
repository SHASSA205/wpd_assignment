package org.me.gcu.syed_AliHassan_S1905387.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents.RssFeed;
import org.me.gcu.syed_AliHassan_S1905387.R;
import org.me.gcu.syed_AliHassan_S1905387.Util.ItemClick;
import org.me.gcu.syed_AliHassan_S1905387.adapter.CurrentIncidentAdapter;
import org.me.gcu.syed_AliHassan_S1905387.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Current_incidents_detail extends AppCompatActivity implements ItemClick {

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.progressDialog) ProgressBar progressDialog;

    private CurrentIncidentAdapter adapter;

    private RssFeed rssFeed;

    private  int REQUEST_ID_MULTIPLE_PERMISSIONS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_incidents_detail);

        // Butter Knife use
        ButterKnife.bind(this);

        if(!checkAndRequestPermissions()){
            Toast.makeText(getApplicationContext(), "Please Acces Run time Permission ", Toast.LENGTH_SHORT).show();
        }

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Current Incidents");

        // toolBar ActionBar
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

                getCurrentinCidents();
            }
        },1000);
    }

    public void getCurrentinCidents()
    {
        new ApiClient(this).getInstance(this).getWebService().getCurrentIncidents().enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                progressDialog.setVisibility(View.GONE);
                if(response.body() != null) {
                    // set up the RecyclerView

                    rssFeed = response.body();
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    adapter = new CurrentIncidentAdapter(getApplicationContext(), response.body(),Current_incidents_detail.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                progressDialog.setVisibility(View.GONE);
                Log.d("Error","----->"+t.getMessage());
            }
        });
    }

    @Override
    public void mapClick(int index) {

        if(!rssFeed.channel.item.get(index).point.isEmpty())
        {
            String[] separated = rssFeed.channel.item.get(index).point.split(" ");
            Uri gmmIntentUri = Uri.parse("google.navigation:q="+separated[0]+","+separated[1]);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }
    }

    private  boolean checkAndRequestPermissions() {
        int loc = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        int loc2 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (loc2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (loc != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(this,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

}