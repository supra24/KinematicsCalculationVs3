package com.example.damian.kinematicscalculatorvs3.calculations;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Damian on 2017-01-16.
 */

public class CalculationInverseNumerical {

    private float[][] tableParameters;
    private boolean[][] tableParametersBool;
    private float precision;
    private float[][] jacobianFloat;

    public CalculationInverseNumerical(float[][] tableParameters, boolean[][] tableParametersBool, float precision) {

        this.tableParameters = tableParameters;
        this.tableParametersBool = tableParametersBool;
        this.precision = precision;
        jacobianFloat = new float[tableParameters.length][tableParameters.length];

//        tableParameters[i][0] = modelKinematicsForwardValueJoin.getEt_alpha();
//        tableParameters[i][1] = modelKinematicsForwardValueJoin.getEt_a();
//        tableParameters[i][2] = modelKinematicsForwardValueJoin.getEt_theta();
//        tableParameters[i][3] = modelKinematicsForwardValueJoin.getEt_d();

        calculation();
    }

    private void calculation() {


    }

    private float[] forwardKinematics() {

        float[][] matrixHomogeneous = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        for (int i = 0; i < tableParameters.length; i++) {

            float[][] RotZ = SingeltonMatrixKinematicsForward.DHRotZ(tableParameters[i][2]);
            float[][] TransZ = SingeltonMatrixKinematicsForward.DHTransZ(tableParameters[i][3]);
            float[][] TransX = SingeltonMatrixKinematicsForward.DHTransX(tableParameters[i][1]);
            float[][] RotX = SingeltonMatrixKinematicsForward.DHRotX(tableParameters[i][0]);

            float[][] RotZxTransZ = SingeltonMatrixKinematicsForward.Multiplication(RotZ, TransZ);
            float[][] xTransX = SingeltonMatrixKinematicsForward.Multiplication(RotZxTransZ, TransX);
            float[][] xRotX = SingeltonMatrixKinematicsForward.Multiplication(xTransX, RotX);

            matrixHomogeneous = SingeltonMatrixKinematicsForward.Multiplication(matrixHomogeneous, xRotX);
        }

        return new float[]{
                matrixHomogeneous[0][3], matrixHomogeneous[1][3], matrixHomogeneous[2][3]
        };
    }

    private void jacobian() {

        for (int i = 0; i < tableParameters.length; i++) {

            float[] firstCoordinates = forwardKinematics();

            for (int j = 0; j < 4; j++) {
                if (tableParametersBool[i][j] == true)
                    tableParameters[i][j] = (float) (tableParameters[i][j] + 0.00001);
            }

            float[] secondCoordinates = forwardKinematics();
            float[] difference = {
                    firstCoordinates[0] - secondCoordinates[0],
                    firstCoordinates[1] - secondCoordinates[1],
                    firstCoordinates[2] - secondCoordinates[2]
            };

            for (int j = 0; j < 4; j++) {
                if (tableParametersBool[i][j] == true)
                    tableParameters[i][j] = (float) (tableParameters[i][j] - 0.00001);
            }

            if (i == 0)
                singleColumnJacobian(i, difference[0], difference[1], difference[2], 0.00001f, 0, 0);
            else if (i == 1)
                singleColumnJacobian(i, difference[0], difference[1], difference[2], 0, 0.00001f, 0);
            else if (i == 2)
                singleColumnJacobian(i, difference[0], difference[1], difference[2], 0, 0, 0.00001f);
        }
    }

    private void singleColumnJacobian(int join, float dx, float dy, float dz, float dq1, float dq2, float dq3) {

        if (dq1 != 0) {
            jacobianFloat[0][join] = dx / dq1;
            jacobianFloat[1][join] = dy / dq1;
            jacobianFloat[2][join] = dz / dq1;
        } else if (dq2 != 0) {
            jacobianFloat[0][join] = dx / dq2;
            jacobianFloat[1][join] = dy / dq2;
            jacobianFloat[2][join] = dz / dq2;
        } else if (dq3 != 0) {
            jacobianFloat[0][join] = dx / dq3;
            jacobianFloat[1][join] = dy / dq3;
            jacobianFloat[2][join] = dz / dq3;
        }

    }

    private void inverseJacobian() {
    }
}
