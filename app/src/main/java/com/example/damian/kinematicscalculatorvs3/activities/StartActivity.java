package com.example.damian.kinematicscalculatorvs3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.damian.kinematicscalculatorvs3.R;

/**
 * Created by Damian on 2016-10-12.
 */

public class StartActivity extends AppCompatActivity{

    private static final int DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Thread(){
            @Override
            public void run(){
                Intent activityMenu = new Intent(StartActivity.this,MenuActivity.class);
                StartActivity.this.startActivity(activityMenu);
                StartActivity.this.finish();
            }
        }, DELAY_MILLIS);
    }
}
