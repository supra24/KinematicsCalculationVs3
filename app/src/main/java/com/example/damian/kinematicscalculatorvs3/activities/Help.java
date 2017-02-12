package com.example.damian.kinematicscalculatorvs3.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.damian.kinematicscalculatorvs3.R;

import butterknife.OnClick;

/**
 * Created by Damian on 2017-02-11.
 */

public class Help extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        toolbar = (Toolbar) findViewById(R.id.toolbar_help);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
        toolbar.setTitle(R.string.toolbar_help);
    }
}
