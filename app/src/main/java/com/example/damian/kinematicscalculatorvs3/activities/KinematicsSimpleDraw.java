package com.example.damian.kinematicscalculatorvs3.activities;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationCoordinatesEndEffector;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModel;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsSimple;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-15.
 */

public class KinematicsSimpleDraw extends AppCompatActivity  {

    private GLSurfaceView mTestHarness;
    private VelocityTracker vTracker = null;  // VelocityTracer określa zachowanie sekwencji dotyku
    private float startingDistance;
    private ArrayList<JoinListViewModel> joinListViewModels;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_kinematics_simple);

        joinListViewModels = StaticVolumesJoinKinematicsSimple.getJoinListViewModels();

        float[][] tableParameters = new float[StaticVolumesJoinKinematicsSimple.getJoinListViewModels().size()][4];

//        KinematicsSImpleCustomView.reverseAllObject();
        for (int i = 0; i < tableParameters.length - 1; i++) {
//            Log.v("getEditFirst", KinematicsSImpleCustomView.getEditFirst(i));
//            Log.v("getEditSecond", KinematicsSImpleCustomView.getEditSecond(i));
//            Log.v("getEditThird", KinematicsSImpleCustomView.getEditThird(i));
//            Log.v("getEditFourth", KinematicsSImpleCustomView.getEditFourth(i));

            tableParameters[i][0] = joinListViewModels.get(i).getEt_alpha();
            tableParameters[i][1] = joinListViewModels.get(i).getEt_a();
            tableParameters[i][2] = joinListViewModels.get(i).getEt_theta();
            tableParameters[i][3] = joinListViewModels.get(i).getEt_d();

        }

        CalculationCoordinatesEndEffector calculationCoordinatesEndEffector = new CalculationCoordinatesEndEffector(tableParameters, effector);
        calculationCoordinatesEndEffector.Calculation();
        float[] coordinates = calculationCoordinatesEndEffector.getCoordinatesEndEffector();

        TextView textX = (TextView) findViewById(R.id.textX);
        TextView textY = (TextView) findViewById(R.id.textY);
        TextView textZ = (TextView) findViewById(R.id.textZ);
        textX.setText(String.valueOf(coordinates[0]));
        textY.setText(String.valueOf(coordinates[1]));
        textZ.setText(String.valueOf(coordinates[2]));


        // openGlES
        mTestHarness = (GLSurfaceView) findViewById(R.id.GLView);
        mTestHarness.setEGLConfigChooser(false); // nie wymagamy wyboru specjalnej konfiguracji EDL i wystarczają domyśle ustawienia
        mTestHarness.setRenderer(new RenderManipulator(this, tableParameters, effector, coordinates));
//        mTestHarness.setRenderer(new RenderManipulator(getBaseContext()));
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

//        Log.v("VelocityTracker", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

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

//                    Log.v("VelocityTracker", "Predkosc w osi x wynosi: " + vTracker.getXVelocity() + " pikseli na sekunde");
//                    Log.v("VelocityTracker", "Predkosc w osi y wynosi: " + vTracker.getYVelocity() + " pikseli na sekunde");

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
                        /*
                        if newDistance < startingDistance to palce się przyblizają
                         if newDistance > startingDistance to palce się oddlają
                         */
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