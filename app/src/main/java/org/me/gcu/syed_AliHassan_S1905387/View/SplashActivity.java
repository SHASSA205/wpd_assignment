package org.me.gcu.syed_AliHassan_S1905387.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.me.gcu.syed_AliHassan_S1905387.R;
import org.me.gcu.syed_AliHassan_S1905387.Util.Util;

import java.io.IOException;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try {
                Util.getLazyUtil(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, HomeScreen.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}