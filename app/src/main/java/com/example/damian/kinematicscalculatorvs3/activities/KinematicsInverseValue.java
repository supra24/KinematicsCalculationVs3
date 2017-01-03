package com.example.damian.kinematicscalculatorvs3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationKinematicsInverse;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsInverseValue;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-21.
 */

public class KinematicsInverseValue extends AppCompatActivity {

    private static final int RETURN_BACK_STACK = 0;
    private boolean doubleBackToExitPressedOnce = false;
    private static int CLOSE_APP_ON_BACK = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_value_kinematics_inverse);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > RETURN_BACK_STACK) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, CLOSE_APP_ON_BACK);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.floating_action_button_inverse_play_value_play)
    public void OnClickFloatingActionButtonPlayValuePlay(){


    }

    @OnClick(R.id.floating_action_button_inverse_play_value)
    public void OnClickFloatingActionButtonPlayInverse() {

        final int AMOUNT_VARIABLES = 4;
        final int AMOUNT_COORDINATES = 4;

        ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents = StaticVolumesKinematicsInverseValue.getModels();

        float[][] tableParameters = new float[modelKinematicsInverseValueParents.size()][AMOUNT_VARIABLES];

        // dodanie do tablcy wartosci z wybranych czlonow
        for (int i = 0; i < tableParameters.length - 1; i++) {

            ModelKinematicsInverseValueJoin modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(i);

            tableParameters[i][0] = modelKinematicsInverseValueJoin.getEt_alpha();
            tableParameters[i][1] = modelKinematicsInverseValueJoin.getEt_a();
            tableParameters[i][2] = modelKinematicsInverseValueJoin.getEt_theta();
            tableParameters[i][3] = modelKinematicsInverseValueJoin.getEt_d();
        }

        // stworzenei nowej tablicy do wartosci effectora
        float[] tableEffector = new float[AMOUNT_COORDINATES];
        ModelKinematicsInverseValueEffector kinematicsInverseValueEffector = (ModelKinematicsInverseValueEffector) modelKinematicsInverseValueParents.get(modelKinematicsInverseValueParents.size() - 1);
        tableEffector[0] = kinematicsInverseValueEffector.getEt_x();
        tableEffector[1] = kinematicsInverseValueEffector.getEt_y();
        tableEffector[2] = kinematicsInverseValueEffector.getEt_z();
        tableEffector[3] = 0;

        CalculationKinematicsInverse calculationKinematicsInverse = new CalculationKinematicsInverse(tableParameters, tableEffector);

        ModelKinematicsInverseValueJoin modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(1);
        modelKinematicsInverseValueJoin.setEt_theta(90-calculationKinematicsInverse.getAlpha_a());

        StaticVolumesKinematicsInverseValue.setOneModel(modelKinematicsInverseValueJoin);

        modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(tableParameters.length/2);
        modelKinematicsInverseValueJoin.setEt_theta(calculationKinematicsInverse.getAlpha_b());

        StaticVolumesKinematicsInverseValue.setOneModel(modelKinematicsInverseValueJoin);
    }
}
