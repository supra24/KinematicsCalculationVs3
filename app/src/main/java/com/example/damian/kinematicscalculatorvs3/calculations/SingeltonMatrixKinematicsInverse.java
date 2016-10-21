package com.example.damian.kinematicscalculatorvs3.calculations;

/**
 * Created by Damian on 2016-09-13.
 */
public class SingeltonMatrixKinematicsInverse {

    public static String[][] DHRotZ(String angle) {

        String theta = angle;

        String[][] result = {

                {"cos(" + theta + ")", "-sin(" + theta + ")", "0", "0"},
                {"sin(" + theta + ")", "cos(" + theta + ")", "0", "0"},
                {"0", "0", "1", "0"},
                {"0", "0", "0", "1"}
        };

        return result;
    }

    public static String[][] DHTransZ(String d) {

        String[][] result = {
                {"1", "0", "0", "0"},
                {"0", "1", "0", "0"},
                {"0", "0", "1", d},
                {"0", "0", "0", "1"}
        };

        return result;
    }

    public static String[][] DHTransX(String a) {

        String[][] result = {

                {"1", "0", "0", a},
                {"0", "1", "0", "0"},
                {"0", "0", "1", "0"},
                {"0", "0", "0", "1"}
        };

        return result;
    }

    public static String[][] DHRotX(String angle) {

        String alpha = angle;

        String[][] result = {
                {"1", "0", "0", "0"},
                {"0", "cos(" + alpha + ")", "-sin(" + alpha + ")", "0"},
                {"0", "sin(" + alpha + ")", "cos(" + alpha + ")", "0"},
                {"0", "0", "0", "1"}
        };

        return result;
    }

    public static String[][] Multiplication(String[][] firstMatrix, String[][] secondMatrix) {

        String[][] resultMatrix = new String[firstMatrix.length][firstMatrix.length];
        for (int i = 0; i < resultMatrix.length; i++) {//ilosc wierszy tab1
            for (int j = 0; j < resultMatrix.length; j++) { //ilosc kolumn tab2
                resultMatrix[i][j] = "0";
            }
        }

        for (int i = 0; i < resultMatrix.length; i++) {//ilosc wierszy tab1
            for (int j = 0; j < resultMatrix.length; j++) { //ilosc kolumn tab2
                for (int w = 0; w < resultMatrix.length; w++) { //ilosc wierszy tab2
                    resultMatrix[i][j] += "+" + firstMatrix[i][w] + "*" + secondMatrix[w][j];
                }
            }
        }

        for (int i = 0; i < resultMatrix.length; i++) {//ilosc wierszy tab1
            for (int j = 0; j < resultMatrix.length; j++) { //ilosc kolumn tab2
                resultMatrix[i][j] = "(" + resultMatrix[i][j] + ")";
            }
        }

        return resultMatrix;
    }
}
