package com.example.damian.kinematicscalculatorvs3.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.damian.kinematicscalculatorvs3.R;

import butterknife.ButterKnife;

/**
 * Created by Damian on 2016-10-12.
 */
public class KinematicsInverse extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_kinematics_inverse);
        ButterKnife.bind(this);
    }
}
