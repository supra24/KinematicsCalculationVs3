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

    @BindView(R.id.b_kinematicsForward)
    Button b_kinematics_forward;
    @BindView(R.id.b_kinematicsInverse)
    Button b_kinematics_inverse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.b_kinematicsForward)
    void openActivityKinematicsForward(){
        Intent intent = new Intent(getApplicationContext(), KinematicsForward.class);
        startActivity(intent);
    }

    @OnClick(R.id.b_kinematicsInverse)
    void openActivityKinematicsInverse(){
        Intent intent = new Intent(getApplicationContext(), KinematicsInverseVariablesConstant.class);
        startActivity(intent);
    }
}
