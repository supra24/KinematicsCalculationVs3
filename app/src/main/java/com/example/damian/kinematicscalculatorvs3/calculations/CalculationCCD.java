package com.example.damian.kinematicscalculatorvs3.calculations;

/**
 * Created by Damian on 2017-01-20.
 */

public class CalculationCCD {

    private float[][] tableParameters;
    private boolean[][] tableParametersBool;
    private float[] coordinatesEnd;
    private float precision, precisionCalculation = 1;

    public CalculationCCD(float[][] tableParameters, boolean[][] tableParametersBool, float[] coordinatesEnd, float precision) {

        this.tableParameters = tableParameters;
        this.tableParametersBool = tableParametersBool;
        this.coordinatesEnd = coordinatesEnd;
        this.precision = precision;
        this.precisionCalculation = precision;

        calculation();
    }

    private void calculation() {

        float distanceStart, distanceEnd;
        int direction, numberPasses = 0;


        do {

//            for (int i = 0; i < tableParameters.length; i++) {
            for (int i = tableParameters.length - 1; i >= 0; i--) {

                for (int j = 0; j < 4; j++) {
                    if (tableParametersBool[i][j] == true) {

                        direction = 0;

                        do {

                            if (direction == 0) {

                                distanceStart = distanceBetweenPoints(forwardKinematics(tableParameters), coordinatesEnd);
                                tableParameters[i][j] = tableParameters[i][j] + (precisionCalculation);
                                distanceEnd = distanceBetweenPoints(forwardKinematics(tableParameters), coordinatesEnd);

                                if (distanceEnd >= distanceStart) {
                                    direction = 1;
                                    tableParameters[i][j] = tableParameters[i][j] - (precisionCalculation);
                                }

                                changePrecision(distanceEnd);

                            } else if (direction == 1) {

                                distanceStart = distanceBetweenPoints(forwardKinematics(tableParameters), coordinatesEnd);
                                tableParameters[i][j] = tableParameters[i][j] - (precisionCalculation);
                                distanceEnd = distanceBetweenPoints(forwardKinematics(tableParameters), coordinatesEnd);

                                if (distanceEnd >= distanceStart) {
                                    direction = 2;
                                    tableParameters[i][j] = tableParameters[i][j] + (precisionCalculation);
                                }

                                changePrecision(distanceEnd);
                            }
                        } while (direction < 2);
                    }
                }
            }
            numberPasses++;
        }
        while ((distanceBetweenPoints(forwardKinematics(tableParameters), coordinatesEnd) > precision) && numberPasses < 200);
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

    private float distanceBetweenPoints(float[] firstPoint, float[] secondPoint) {

        float ax = firstPoint[0] - secondPoint[0];
        float ay = firstPoint[1] - secondPoint[1];
        float az = firstPoint[2] - secondPoint[2];

        return (float) Math.sqrt(ax * ax + ay * ay + az * az);
    }

    private void changePrecision(float distance) {

        if (distance > 1)
            precisionCalculation = precision * 1000;
        else if (distance <= 1 && distance > 0.01)
            precisionCalculation = precision * 100;
        else
            precisionCalculation = precision;


    }

    public float[][] getTableParameters() {
        return tableParameters;
    }

    public float[] getCoordinatesEnd() {
        return forwardKinematics(tableParameters);
    }
}
