package com.example.damian.kinematicscalculatorvs3.calculations;

import android.util.Log;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Damian on 2017-01-16.
 */

public class CalculationInverseNumerical {

    private float[][] tableParameters;
    private boolean[][] tableParametersBool;
    private float[] coordinatesEnd;
    private float precision;
    private float[][] jacobianFloat;

    public CalculationInverseNumerical(float[][] tableParameters, boolean[][] tableParametersBool, float[] coordinatesEnd, float precision) {

        this.tableParameters = tableParameters;
        this.tableParametersBool = tableParametersBool;
        this.coordinatesEnd = coordinatesEnd;
        this.precision = precision;
        jacobianFloat = new float[tableParameters.length][tableParameters.length];

//        tableParameters[i][0] = modelKinematicsForwardValueJoin.getEt_alpha();
//        tableParameters[i][1] = modelKinematicsForwardValueJoin.getEt_a();
//        tableParameters[i][2] = modelKinematicsForwardValueJoin.getEt_theta();
//        tableParameters[i][3] = modelKinematicsForwardValueJoin.getEt_d();

        calculation();
    }

    public CalculationInverseNumerical(float[][] jacobianFloat) {
        this.jacobianFloat = jacobianFloat;
        calculation();
    }

    private void calculation() {

        float[] differentCoordinates = new float[3];
        differentCoordinates[0] = 30;
        differentCoordinates[1] = 30;
        differentCoordinates[2] = 30;

        do {

            float det;
            float[] coordinatesNow, differentJoin;

            float[][] inverseJacobian;
            jacobian();
            det = detJacobian();
            if (det != 0) {
                inverseJacobian = inverseJacobian(det);
                coordinatesNow = forwardKinematics(tableParameters);

                differentCoordinates[0] = coordinatesEnd[0] - coordinatesNow[0];
                differentCoordinates[1] = coordinatesEnd[1] - coordinatesNow[1];
                differentCoordinates[2] = coordinatesEnd[2] - coordinatesNow[2];

                differentJoin = SingeltonMatrixKinematicsForward.Multiplication(inverseJacobian, differentCoordinates);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (tableParametersBool[i][j] == true)
                            tableParameters[i][j] = tableParameters[i][j] + differentJoin[i];
                    }
                }
            } else {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (tableParametersBool[i][j] == true)
                            tableParameters[i][j] = (float) (tableParameters[i][j] + 0.001);
                    }
                }
            }
        }
        while ( !(!(differentCoordinates[0] > precision) && !(differentCoordinates[1] > precision) && !(differentCoordinates[2] > precision)));
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

    private void jacobian() {

        for (int i = 0; i < tableParameters.length; i++) {

            float[] firstCoordinates = forwardKinematics(tableParameters);

            for (int j = 0; j < 4; j++) {
                if (tableParametersBool[i][j] == true)
                    tableParameters[i][j] = tableParameters[i][j] + (0.000001f);
            }

            float[] secondCoordinates = forwardKinematics(tableParameters);
            float[] difference = {
                    firstCoordinates[0] - secondCoordinates[0],
                    firstCoordinates[1] - secondCoordinates[1],
                    firstCoordinates[2] - secondCoordinates[2]
            };

            for (int j = 0; j < 4; j++) {
                if (tableParametersBool[i][j] == true)
                    tableParameters[i][j] = (float) (tableParameters[i][j] - (0.000001));
            }

            if (i == 0)
                singleColumnJacobian(i, difference[0], difference[1], difference[2], 0.000001f, 0, 0);
            else if (i == 1)
                singleColumnJacobian(i, difference[0], difference[1], difference[2], 0, 0.000001f, 0);
            else if (i == 2)
                singleColumnJacobian(i, difference[0], difference[1], difference[2], 0, 0, 0.000001f);
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

    private float detJacobian() {

        float det = 0;
        det = jacobianFloat[0][0] * jacobianFloat[1][1] * jacobianFloat[2][2];
        det = det + jacobianFloat[0][1] * jacobianFloat[1][2] * jacobianFloat[2][0];
        det = det + jacobianFloat[0][2] * jacobianFloat[1][0] * jacobianFloat[2][1];

        det = det - jacobianFloat[0][2] * jacobianFloat[1][1] * jacobianFloat[2][0];
        det = det - jacobianFloat[0][0] * jacobianFloat[2][1] * jacobianFloat[1][2];
        det = det - jacobianFloat[1][0] * jacobianFloat[0][1] * jacobianFloat[2][2];

        return det;
    }

    private float[][] inverseJacobian(float det) {

        float dopelnienie[][] = new float[3][3];

        dopelnienie[0][0] = jacobianFloat[1][1] * jacobianFloat[2][2] - jacobianFloat[1][2] * jacobianFloat[2][1];
        dopelnienie[0][1] = (-1) * (jacobianFloat[1][0] * jacobianFloat[2][2] - jacobianFloat[2][0] * jacobianFloat[1][2]);
        dopelnienie[0][2] = jacobianFloat[1][0] * jacobianFloat[2][1] - jacobianFloat[2][0] * jacobianFloat[1][1];

        dopelnienie[1][0] = (-1) * (jacobianFloat[0][1] * jacobianFloat[2][2] - jacobianFloat[2][1] * jacobianFloat[0][2]);
        dopelnienie[1][1] = jacobianFloat[0][0] * jacobianFloat[2][2] - jacobianFloat[0][2] * jacobianFloat[2][0];
        dopelnienie[1][2] = (-1) * (jacobianFloat[0][0] * jacobianFloat[2][1] - jacobianFloat[0][1] * jacobianFloat[2][0]);

        dopelnienie[2][0] = jacobianFloat[0][1] * jacobianFloat[1][2] - jacobianFloat[0][2] * jacobianFloat[1][1];
        dopelnienie[2][1] = (-1) * (jacobianFloat[0][0] * jacobianFloat[1][2] - jacobianFloat[1][0] * jacobianFloat[0][2]);
        dopelnienie[2][2] = jacobianFloat[0][0] * jacobianFloat[1][1] - jacobianFloat[1][0] * jacobianFloat[0][1];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dopelnienie[i][j] = dopelnienie[i][j] / det;
            }
        }

        return dopelnienie;
    }

    public float[][] getTableParam() {
        return tableParameters;
    }

    public float[] getCoordinates() {

        return forwardKinematics(tableParameters);
    }
}
