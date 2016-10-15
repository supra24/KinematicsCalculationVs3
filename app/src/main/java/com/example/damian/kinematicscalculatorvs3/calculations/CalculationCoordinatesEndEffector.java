package com.example.damian.kinematicscalculatorvs3.calculations;

import android.util.Log;

/**
 * Created by Damian on 2016-09-13.
 */
public class CalculationCoordinatesEndEffector {

    private float[][] tableParameters;
    private float[] coordinatesEffector;
    private float[] coordinatesEndEffector;

    public CalculationCoordinatesEndEffector(float[][] tableParameters) {
        this.tableParameters = tableParameters;
    }

    public void Calculation() {

        float[][] A = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        for (int i = 0; i < tableParameters.length; i++) {

            float[][] RotZ = SingeltonMatrix.DHRotZ(tableParameters[i][3]);
            float[][] TransZ = SingeltonMatrix.DHTransZ(tableParameters[i][2]);
            float[][] TransX = SingeltonMatrix.DHTransX(tableParameters[i][0]);
            float[][] RotX = SingeltonMatrix.DHRotX(tableParameters[i][1]);

            float[][] RotZxTransZ = SingeltonMatrix.Multiplication(RotZ, TransZ);
            float[][] xTransX = SingeltonMatrix.Multiplication(RotZxTransZ, TransX);
            float[][] xRotX = SingeltonMatrix.Multiplication(xTransX, RotX);

            A = SingeltonMatrix.Multiplication(A, xRotX);
        }

        coordinatesEndEffector = new float[]{
                A[0][3] + coordinatesEffector[0],
                A[1][3] + coordinatesEffector[1],
                A[2][3] + coordinatesEffector[2]
        };

        Log.v("X = ", String.valueOf(coordinatesEndEffector[0]));
        Log.v("Y = ", String.valueOf(coordinatesEndEffector[1]));
        Log.v("Z = ", String.valueOf(coordinatesEndEffector[2]));
    }

    public float [] getCoordinatesEndEffector(){
        return coordinatesEndEffector;
    }
}
