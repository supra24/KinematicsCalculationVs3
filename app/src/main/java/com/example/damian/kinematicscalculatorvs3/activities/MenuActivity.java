package com.example.damian.kinematicscalculatorvs3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.damian.kinematicscalculatorvs3.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-12.
 */
public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.b_kinematicsSimple)
    Button b_kinematics_simple;
    @BindView(R.id.b_kinematicsReverse)
    Button b_kinematics_reverse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.b_kinematicsSimple)
    void openActivityKinematicsSimple(){
        Intent intent = new Intent(getApplicationContext(), KinematicsSimple.class);
        startActivity(intent);
    }

    @OnClick(R.id.b_kinematicsReverse)
    void openActivityKinematicsReverse(){
        Intent intent = new Intent(getApplicationContext(), KinematicsReverse.class);
        startActivity(intent);
    }
}
