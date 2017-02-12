package com.example.damian.kinematicscalculatorvs3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationCCD;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationKinematicsInverse;
import com.example.damian.kinematicscalculatorvs3.fragments.FragmentListInverseVariables;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablwsParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesInverseVariables;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsInverseValue;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-21.
 */

public class KinematicsInverseValue extends AppCompatActivity {

    private static final int RETURN_BACK_STACK = 0;
    private boolean doubleBackToExitPressedOnce = false;
    private static int CLOSE_APP_ON_BACK = 2000;
    Toolbar toolbar;

    @BindView(R.id.floating_action_button_inverse_play_value)
    FloatingActionButton floatingActionButtonPlayValue;

    @BindView(R.id.floating_action_button_inverse_calculation_value)
    FloatingActionButton floatingActionButtonCalcValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_value_kinematics_inverse);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar_value_inverse);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
        toolbar.setTitle(R.string.activity_name_dh);
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

    @OnClick(R.id.floating_action_button_inverse_play_value)
    public void OnClickFloatingActionButtonPlayInverse() {

//        final int AMOUNT_VARIABLES = 4;
//        final int AMOUNT_COORDINATES = 4;
//
//        ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents = StaticVolumesKinematicsInverseValue.getModels();
//
//        float[][] tableParameters = new float[modelKinematicsInverseValueParents.size()][AMOUNT_VARIABLES];
//
//        // dodanie do tablcy wartosci z wybranych czlonow
//        for (int i = 0; i < tableParameters.length - 1; i++) {
//
//            ModelKinematicsInverseValueJoin modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(i);
//
//            tableParameters[i][0] = modelKinematicsInverseValueJoin.getEt_alpha();
//            tableParameters[i][1] = modelKinematicsInverseValueJoin.getEt_a();
//            tableParameters[i][2] = modelKinematicsInverseValueJoin.getEt_theta();
//            tableParameters[i][3] = modelKinematicsInverseValueJoin.getEt_d();
//        }
//
//        // stworzenei nowej tablicy do wartosci effectora
//        float[] tableEffector = new float[AMOUNT_COORDINATES];
//        ModelKinematicsInverseValueEffector kinematicsInverseValueEffector = (ModelKinematicsInverseValueEffector) modelKinematicsInverseValueParents.get(modelKinematicsInverseValueParents.size() - 1);
//        tableEffector[0] = kinematicsInverseValueEffector.getEt_x();
//        tableEffector[1] = kinematicsInverseValueEffector.getEt_y();
//        tableEffector[2] = kinematicsInverseValueEffector.getEt_z();
//        tableEffector[3] = 0;
//
//        CalculationKinematicsInverse calculationKinematicsInverse = new CalculationKinematicsInverse(tableParameters, tableEffector);
//
//        ModelKinematicsInverseValueJoin modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(1);
//        modelKinematicsInverseValueJoin.setEt_theta(90-calculationKinematicsInverse.getAlpha_a());
//
//        StaticVolumesKinematicsInverseValue.setOneModel(modelKinematicsInverseValueJoin);
//
//        modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(tableParameters.length/2);
//        modelKinematicsInverseValueJoin.setEt_theta(calculationKinematicsInverse.getAlpha_b());
//
//        StaticVolumesKinematicsInverseValue.setOneModel(modelKinematicsInverseValueJoin);

//        String[][] tableParameter = {
//                {"0", "10", "a", "10"},
//                {"0", "10", "b", "10"},
//                {"0", "10", "c", "10"}
//        };
//
//        CalculationKinematicsInverse calculationKinematicsInverse = new CalculationKinematicsInverse(tableParameter);

        startActivity(new Intent(KinematicsInverseValue.this, KinematicsInverseSystemOfEquation.class));
    }

    @OnClick(R.id.floating_action_button_inverse_calculation_value)
    public void OnClickFloatingCalculationInverse() {

        ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents = StaticVolumesKinematicsInverseValue.getModels();
        ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents = StaticVolumesInverseVariables.getModels();

        float[][] tableParameters = new float[3][4];
        for (int i = 0; i < tableParameters.length; i++) {

            ModelKinematicsInverseValueJoin modelKinematicsForwardValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(i);

            tableParameters[i][0] = modelKinematicsForwardValueJoin.getEt_alpha();
            tableParameters[i][1] = modelKinematicsForwardValueJoin.getEt_a();
            tableParameters[i][2] = modelKinematicsForwardValueJoin.getEt_theta();
            tableParameters[i][3] = modelKinematicsForwardValueJoin.getEt_d();
        }

        ModelKinematicsInverseValueEffector kinematicsInverseValueEffector = (ModelKinematicsInverseValueEffector) modelKinematicsInverseValueParents.get(3);
        float[] endCoordinates = {
                kinematicsInverseValueEffector.getEt_x(),
                kinematicsInverseValueEffector.getEt_y(),
                kinematicsInverseValueEffector.getEt_z()
        };

        boolean[][] tableParametersBool = new boolean[3][4];
        for (int i = 0; i < tableParametersBool.length; i++) {

            ModelKinematicsInverseVariablesJoin modelKinematicsInverseVariablesJoin = (ModelKinematicsInverseVariablesJoin) modelKinematicsInverseVariablwsParents.get(i);

            tableParametersBool[i][0] = modelKinematicsInverseVariablesJoin.isEt_alpha();
            tableParametersBool[i][1] = modelKinematicsInverseVariablesJoin.isEt_a();
            tableParametersBool[i][2] = modelKinematicsInverseVariablesJoin.isEt_theta();
            tableParametersBool[i][3] = modelKinematicsInverseVariablesJoin.isEt_d();
        }

       // floatingActionButtonCalcValue.setVisibility(View.INVISIBLE);
       // floatingActionButtonPlayValue.setVisibility(View.INVISIBLE);

        //floatingActionButtonPlayValue.hide();
       // floatingActionButtonCalcValue.hide();
       // recreate();
       // onRestart();

      //  CalculationCCD calculationCCD = new CalculationCCD(tableParameters, tableParametersBool, endCoordinates, 0.001f);
       // calculationCCD.getTableParameters();

        floatingActionButtonCalcValue.setVisibility(View.VISIBLE);
        floatingActionButtonPlayValue.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.button_toolbar_value_inverse)
    void help() {

        Intent intent = new Intent(getApplicationContext(), Help.class);
        startActivity(intent);
    }

}
