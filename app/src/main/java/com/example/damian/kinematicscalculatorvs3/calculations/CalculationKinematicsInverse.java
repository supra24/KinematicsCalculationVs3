package com.example.damian.kinematicscalculatorvs3.calculations;

import android.util.Log;

import org.apache.commons.math3.ode.JacobianMatrices;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-09-13.
 */
public class CalculationKinematicsInverse {

    private String[][] tableParametersString;
    private String[] coordinatesEndEffectorString;
    private float[][] tableParameters;
    private float[] coordinatesEndEffector;
    private float amountA = 0, amountB = 0, amountC = 0;
    private float angleBetweenBaseEnd, theta = 0, alpha_a = 0, alpha_b = 0;

    public CalculationKinematicsInverse(String[][] tableParameters) {
        this.tableParametersString = tableParameters;
        CalculationString();
    }

    private void CalculationString() {

        String[][] A = {
                {"1", "0", "0", "0"},
                {"0", "1", "0", "0"},
                {"0", "0", "1", "0"},
                {"0", "0", "0", "1"}
        };

        for (int i = 0; i < tableParametersString.length; i++) {

            String[][] RotZ = SingeltonMatrixKinematicsInverse.DHRotZ(tableParametersString[i][2]);
            String[][] TransZ = SingeltonMatrixKinematicsInverse.DHTransZ(tableParametersString[i][3]);
            String[][] TransX = SingeltonMatrixKinematicsInverse.DHTransX(tableParametersString[i][1]);
            String[][] RotX = SingeltonMatrixKinematicsInverse.DHRotX(tableParametersString[i][0]);

            String[][] RotZxTransZ = SingeltonMatrixKinematicsInverse.Multiplication(RotZ, TransZ);
            String[][] xTransX = SingeltonMatrixKinematicsInverse.Multiplication(RotZxTransZ, TransX);
            String[][] xRotX = SingeltonMatrixKinematicsInverse.Multiplication(xTransX, RotX);

            A = SingeltonMatrixKinematicsInverse.Multiplication(A, xRotX);

            Log.v("X = ", A[0][3]);
            Log.v("Y = ", A[1][3]);
            Log.v("Z = ", A[2][3]);
        }

        coordinatesEndEffectorString = new String[]{
                A[0][3], A[1][3], A[2][3]
        };

        Log.v("X = ", coordinatesEndEffectorString[0]);
        Log.v("Y = ", coordinatesEndEffectorString[1]);
        Log.v("Z = ", coordinatesEndEffectorString[2]);
    }

    public String[] getCoordinatesEndEffector() {
        return coordinatesEndEffectorString;
    }

    public CalculationKinematicsInverse(float[][] tableParameters, float[] coordinatesEndEffector) {
        this.tableParameters = tableParameters;
        this.coordinatesEndEffector = coordinatesEndEffector;
        Calculation();
    }

    public void Calculation() {
        int size = tableParameters.length;

        if (size > 1) {

            for (int i = 1; i < size / 2; i++) {
                amountA += tableParameters[i][1];
            }

            for (int i = size / 2; i < size - 1; i++) {
                amountB += tableParameters[i][1];
            }
            amountC = (float) Math.sqrt((coordinatesEndEffector[0] * coordinatesEndEffector[0]) + (coordinatesEndEffector[1] * coordinatesEndEffector[1]) + ((coordinatesEndEffector[2] - tableParameters[0][3]) * (coordinatesEndEffector[2] - tableParameters[0][3])));

            if (amountC <= Math.abs(amountA + amountB)) {

                float vectorAO[] = {
                        100,
                        0,
                        0
                };
                float vectorAB[] = {
                        coordinatesEndEffector[0],
                        coordinatesEndEffector[1],
                        coordinatesEndEffector[2] - tableParameters[0][3]
                };

                float multiplicationScalar = vectorAO[0] * vectorAB[0];
                float lengthAO = (float) Math.sqrt(vectorAO[0] * vectorAO[0]);
                float lengthAB = (float) Math.sqrt(vectorAB[0] * vectorAB[0] + vectorAB[1] * vectorAB[1] + vectorAB[2] * vectorAB[2]);

                angleBetweenBaseEnd = (float) (Math.acos(multiplicationScalar / (lengthAO * lengthAB)) * 180 / Math.PI);
                theta = (float) (Math.acos((amountA * amountA - amountB * amountB + amountC * amountC) / (2 * amountA * amountC)) * 180 / Math.PI);
                alpha_a = angleBetweenBaseEnd - theta;
                alpha_b = (float) (180 - Math.acos((amountA * amountA + amountB * amountB - amountC * amountC) / (2 * amountA * amountB)) * 180 / Math.PI);
            }
        }
    }

    public float getAlpha_a() {
        return alpha_a;
    }

    public float getAlpha_b() {
        return alpha_b;
    }
}