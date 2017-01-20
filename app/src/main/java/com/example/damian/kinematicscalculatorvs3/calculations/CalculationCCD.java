package com.example.damian.kinematicscalculatorvs3.calculations;

/**
 * Created by Damian on 2017-01-20.
 */

public class CalculationCCD {

    private float[][] tableParameters;
    private boolean[][] tableParametersBool;
    private float[] coordinatesEnd;
    private float precision;
    private float[][] jacobianFloat;

    public CalculationCCD(float[][] tableParameters, boolean[][] tableParametersBool, float[] coordinatesEnd, float precision){

        this.tableParameters = tableParameters;
        this.tableParametersBool = tableParametersBool;
        this.coordinatesEnd = coordinatesEnd;
        this.precision = precision;
    }



    private float[] forwardKinematics(float[][] tab) {

        float[][] matrixHomogeneous = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        for (int i = 0; i < tab.length; i++) {

            float[][] RotZ = SingeltonMatrixKinematicsForward.DHRotZ(tab[i][2]);
            float[][] TransZ = SingeltonMatrixKinematicsForward.DHTransZ(tab[i][3]);
            float[][] TransX = SingeltonMatrixKinematicsForward.DHTransX(tab[i][1]);
            float[][] RotX = SingeltonMatrixKinematicsForward.DHRotX(tab[i][0]);

            float[][] RotZxTransZ = SingeltonMatrixKinematicsForward.Multiplication(RotZ, TransZ);
            float[][] xTransX = SingeltonMatrixKinematicsForward.Multiplication(RotZxTransZ, TransX);
            float[][] xRotX = SingeltonMatrixKinematicsForward.Multiplication(xTransX, RotX);

            matrixHomogeneous = SingeltonMatrixKinematicsForward.Multiplication(matrixHomogeneous, xRotX);
        }

        return new float[]{
                matrixHomogeneous[0][3], matrixHomogeneous[1][3], matrixHomogeneous[2][3]
        };
    }

}
