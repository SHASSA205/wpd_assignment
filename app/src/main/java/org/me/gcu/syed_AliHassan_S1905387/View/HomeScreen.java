package org.me.gcu.syed_AliHassan_S1905387.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.me.gcu.syed_AliHassan_S1905387.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener{

    private Unbinder unbinder;

    @BindView(R.id.Current_Incidents_layout)
    LinearLayout current_Incidents_layout;
    @BindView(R.id.Road_works_layout)
    LinearLayout road_works_layout;
    @BindView(R.id.Planned_Road_works_layout)
    LinearLayout planned_Road_works_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Buttter ButterKnife use
        unbinder = ButterKnife.bind(this);

        current_Incidents_layout.setOnClickListener(this);
        road_works_layout.setOnClickListener(this);
        planned_Road_works_layout.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        if(view == current_Incidents_layout){
            startActivity(new Intent(HomeScreen.this,Current_incidents_detail.class));
        }else if(view == road_works_layout){
            startActivity(new Intent(HomeScreen.this,Road_work_detail.class));
        }else if(view == planned_Road_works_layout){
            startActivity(new Intent(HomeScreen.this,Planned_road_works_detial.class));
        }
    }
}