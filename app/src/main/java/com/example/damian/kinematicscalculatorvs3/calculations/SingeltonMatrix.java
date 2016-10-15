package com.example.damian.kinematicscalculatorvs3.calculations;

/**
 * Created by Damian on 2016-09-13.
 */
public class SingeltonMatrix {

    public static float[][] DHRotZ(float angle) {

        float theta = (float) (Math.PI * angle / 180);

        float[][] result = {
                {(float) Math.cos(theta), (float) -Math.sin(theta), 0, 0},
                {(float) Math.sin(theta), (float) Math.cos(theta), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        return result;
    }

    public static float[][] DHTransZ(float d) {

        float[][] result = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, d},
                {0, 0, 0, 1}
        };

        return result;
    }

    public static float[][] DHTransX(float a) {

        float[][] result = {
                {1, 0, 0, a},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        return result;
    }

    public static float[][] DHRotX(float angle) {

        float alpha = (float) (Math.PI * angle / 180);

        float[][] result = {
                {1, 0, 0, 0},
                {0, (float) Math.cos(alpha), (float) -Math.sin(alpha), 0},
                {0, (float) Math.sin(alpha), (float) Math.cos(alpha), 0},
                {0, 0, 0, 1}
        };

        return result;
    }

    public static float[][] RotZ(float angle) {

        float theta = (float) (Math.PI * angle / 180);

        float[][] result = {
                {(float) Math.cos(theta), (float) -Math.sin(theta), 0},
                {(float) Math.sin(theta), (float) Math.cos(theta), 0},
                {0, 0, 1},
        };

        return result;
    }

    public static float[][] RotX(float angle) {
        float alpha = (float) (Math.PI * angle / 180);

        float[][] result = {
                {1, 0, 0},
                {0, (float) Math.cos(alpha), (float) -Math.sin(alpha)},
                {0, (float) Math.sin(alpha), (float) Math.cos(alpha)},
        };

        return result;
    }

    public static float[][] Multiplication(float[][] firstMatrix, float[][] secondMatrix) {

        float[][] resultMatrix = new float[firstMatrix.length][firstMatrix.length];

        for (int i = 0; i < resultMatrix.length; i++) {//ilosc wierszy tab1
            for (int j = 0; j < resultMatrix.length; j++) { //ilosc kolumn tab2
                for (int w = 0; w < resultMatrix.length; w++) { //ilosc wierszy tab2
                    resultMatrix[i][j] += firstMatrix[i][w] * secondMatrix[w][j];
                }
            }
        }
        return resultMatrix;
    }

    public static float[][] Multiplication3x3(float[][] firstMatrix, float[][] secondMatrix) {

        float[][] resultMatrix = new float[3][3];

        for (int i = 0; i <3; i++) {//ilosc wierszy tab1
            for (int j = 0; j < 3; j++) { //ilosc kolumn tab2
                for (int w = 0; w < 3; w++) { //ilosc wierszy tab2
                    resultMatrix[i][j] += firstMatrix[i][w] * secondMatrix[w][j];
                }
            }
        }
        return resultMatrix;
    }

    public static float[] Multiplication(float[][] firstMatrix, float[] secondMatrix) {

        float[] resultMatrix = new float[secondMatrix.length];

        for (int i = 0; i < resultMatrix.length; i++) {//ilosc wierszy tab1
            for (int j = 0; j < secondMatrix.length; j++) { //ilosc kolumn tab2
                    resultMatrix[i] += firstMatrix[i][j] * secondMatrix[j];
            }
        }
        return resultMatrix;
    }
}
