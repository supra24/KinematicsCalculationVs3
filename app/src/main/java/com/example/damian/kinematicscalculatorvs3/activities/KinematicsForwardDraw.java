package com.example.damian.kinematicscalculatorvs3.activities;

import android.icu.math.BigDecimal;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.TextView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationCoordinatesEndEffector;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.openGL.AbstractRenderer;
import com.example.damian.kinematicscalculatorvs3.openGL.RenderManipulator;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForward;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-15.
 */

public class KinematicsForwardDraw extends AppCompatActivity {

    private GLSurfaceView mTestHarness;
    private VelocityTracker vTracker = null;  // VelocityTracer określa zachowanie sekwencji dotyku
    private float startingDistance;
    private ArrayList<JoinListViewModelKinematicsForwardValue> joinListViewModelKinematicsForwardValues;

    private DrawerLayout drawer;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_kinematics_forward);

        joinListViewModelKinematicsForwardValues = StaticVolumesJoinKinematicsForward.getJoinListViewModelKinematicsForwardValues();

        float[][] tableParameters = new float[StaticVolumesJoinKinematicsForward.getJoinListViewModelKinematicsForwardValues().size()][4];

//        KinematicsSImpleCustomView.reverseAllObject();
        for (int i = 0; i < tableParameters.length; i++) {

            tableParameters[i][0] = joinListViewModelKinematicsForwardValues.get(i).getEt_alpha();
            tableParameters[i][1] = joinListViewModelKinematicsForwardValues.get(i).getEt_a();
            tableParameters[i][2] = joinListViewModelKinematicsForwardValues.get(i).getEt_theta();
            tableParameters[i][3] = joinListViewModelKinematicsForwardValues.get(i).getEt_d();
        }

        CalculationCoordinatesEndEffector calculationCoordinatesEndEffector = new CalculationCoordinatesEndEffector(tableParameters);
        ArrayList<float[][]> coordinates = calculationCoordinatesEndEffector.getCoordinatesEndEffector();

        TextView textX = (TextView) findViewById(R.id.textX);
        TextView textY = (TextView) findViewById(R.id.textY);
        TextView textZ = (TextView) findViewById(R.id.textZ);

        textX.setText(String.valueOf(new BigDecimal(coordinates.get(coordinates.size() - 1)[0][3]).setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
        textY.setText(String.valueOf(new BigDecimal(coordinates.get(coordinates.size() - 1)[1][3]).setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
        textZ.setText(String.valueOf(new BigDecimal(coordinates.get(coordinates.size() - 1)[2][3]).setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue()));

        // openGlES
        mTestHarness = (GLSurfaceView) findViewById(R.id.GLView);
        mTestHarness.setEGLConfigChooser(false); // nie wymagamy wyboru specjalnej konfiguracji EDL i wystarczają domyśle ustawienia
        mTestHarness.setRenderer(new RenderManipulator(this, tableParameters, coordinates));
        mTestHarness.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        mTestHarness.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                onTouchEventGLSurfaceView(motionEvent);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTestHarness.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mTestHarness.onPause();
    }

//    @Override
//    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onTouchEventGLSurfaceView(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        int action = event.getAction() & MotionEvent.ACTION_MASK;

        if (event.getPointerCount() == 1) {
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    if (vTracker == null) {
                        vTracker = VelocityTracker.obtain();
                    } else {
                        vTracker.clear();
                    }
                    vTracker.addMovement(event);
                    break;
                case MotionEvent.ACTION_MOVE:

                    vTracker.addMovement(event);
                    vTracker.computeCurrentVelocity(1000);

                    AbstractRenderer.setRotate(vTracker.getXVelocity(), vTracker.getYVelocity());
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
            }
        } else if (event.getPointerCount() == 2) {
            switch (action) {
                case MotionEvent.ACTION_POINTER_DOWN: // przygotowanie do gestu ściskania/rozciągania
                    startingDistance = distanceBetweenTwoFingers(event); // zapamiętania początkowej odległości mięszy palcami
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                case MotionEvent.ACTION_MOVE:
                    float newDistance = distanceBetweenTwoFingers(event);
                    if (newDistance != startingDistance) { // palce się oddalają

                        AbstractRenderer.setRadiusDistance(newDistance - startingDistance);
                    }
                    break;
            }
        }
        return true;
    }

    private float distanceBetweenTwoFingers(MotionEvent e) {

        float x = e.getX(0) - e.getX(1);
        float y = e.getY(0) - e.getY(1);

        return (float) Math.sqrt(x * x + y * y);
    }

}