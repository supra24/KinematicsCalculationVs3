package com.example.damian.kinematicscalculatorvs3.calculations;

import android.util.Log;

/**
 * Created by Damian on 2016-09-13.
 */
public class CalculationCoordinatesEndEffector {

    private float[][] tableParameters;
    private float[] coordinatesEndEffector;

    public CalculationCoordinatesEndEffector(float[][] tableParameters) {
        this.tableParameters = tableParameters;
        Calculation();
    }

    public void Calculation() {

        float[][] A = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        for (int i = 0; i < tableParameters.length; i++) {

            float[][] RotZ = SingeltonMatrix.DHRotZ(tableParameters[i][2]);
            float[][] TransZ = SingeltonMatrix.DHTransZ(tableParameters[i][3]);
            float[][] TransX = SingeltonMatrix.DHTransX(tableParameters[i][1]);
            float[][] RotX = SingeltonMatrix.DHRotX(tableParameters[i][0]);

            float[][] RotZxTransZ = SingeltonMatrix.Multiplication(RotZ, TransZ);
            float[][] xTransX = SingeltonMatrix.Multiplication(RotZxTransZ, TransX);
            float[][] xRotX = SingeltonMatrix.Multiplication(xTransX, RotX);

            A = SingeltonMatrix.Multiplication(A, xRotX);
        }

        coordinatesEndEffector = new float[]{
                A[0][3], A[1][3], A[2][3]
        };
    }

    public float[] getCoordinatesEndEffector() {
        return coordinatesEndEffector;
    }
}
