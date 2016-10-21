package com.example.damian.kinematicscalculatorvs3.calculations;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-09-13.
 */
public class CalculationKinematicsInverse {

    private float[][] tableParameters;
    private String[] coordinatesEndEffector;
//    private ArrayList<float[][]> Aa = new ArrayList<>();

    public CalculationKinematicsInverse(float[][] tableParameters) {
        this.tableParameters = tableParameters;
        Calculation();
    }

    public void Calculation() {

        String[][] A = {
                {"1", "0", "0", "0"},
                {"0", "1", "0", "0"},
                {"0", "0", "1", "0"},
                {"0", "0", "0", "1"}
        };

        for (int i = 0; i < tableParameters.length; i++) {

            String[][] RotZ = SingeltonMatrixKinematicsInverse.DHRotZ(tableParameters[i][2]);
            String[][] TransZ = SingeltonMatrixKinematicsInverse.DHTransZ(tableParameters[i][3]);
            String[][] TransX = SingeltonMatrixKinematicsInverse.DHTransX(tableParameters[i][1]);
            String[][] RotX = SingeltonMatrixKinematicsInverse.DHRotX(tableParameters[i][0]);

            String[][] RotZxTransZ = SingeltonMatrixKinematicsInverse.Multiplication(RotZ, TransZ);
            String[][] xTransX = SingeltonMatrixKinematicsInverse.Multiplication(RotZxTransZ, TransX);
            String[][] xRotX = SingeltonMatrixKinematicsInverse.Multiplication(xTransX, RotX);

            A = SingeltonMatrixKinematicsInverse.Multiplication(A, xRotX);
        }


        coordinatesEndEffector = new String[]{
                A[0][3], A[1][3], A[2][3]
        };
    }

    public String[] getCoordinatesEndEffector() {
        return coordinatesEndEffector;
    }
}