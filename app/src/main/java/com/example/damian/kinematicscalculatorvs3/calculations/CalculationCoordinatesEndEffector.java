package com.example.damian.kinematicscalculatorvs3.calculations;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-09-13.
 */
public class CalculationCoordinatesEndEffector {

    private float[][] tableParameters;
    //    private float[] coordinatesEndEffector;
    private ArrayList<float[][]> Aa = new ArrayList<>();

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

        float[][] B;

        Aa.add(A);

        for (int i = 0; i < tableParameters.length; i++) {

            float[][] RotZ = SingeltonMatrix.DHRotZ(tableParameters[i][2]);
            float[][] TransZ = SingeltonMatrix.DHTransZ(tableParameters[i][3]);
            float[][] TransX = SingeltonMatrix.DHTransX(0);
            float[][] RotX = SingeltonMatrix.DHRotX(tableParameters[i][0]);

            float[][] RotZxTransZ = SingeltonMatrix.Multiplication(RotZ, TransZ);
            float[][] xTransX = SingeltonMatrix.Multiplication(RotZxTransZ, TransX);
            float[][] xRotX = SingeltonMatrix.Multiplication(xTransX, RotX);

            B = SingeltonMatrix.Multiplication(A, xRotX);
            Aa.add(B);

            Log.v("coo X= ", String.valueOf(Aa.get(Aa.size() - 1)[0][3]));
            Log.v("coo Y= ", String.valueOf(Aa.get(Aa.size() - 1)[1][3]));
            Log.v("coo Z= ", String.valueOf(Aa.get(Aa.size() - 1)[2][3]));
//---------------------------------------------------------------------------------------

            RotZ = SingeltonMatrix.DHRotZ(tableParameters[i][2]);
            TransZ = SingeltonMatrix.DHTransZ(tableParameters[i][3]);
            TransX = SingeltonMatrix.DHTransX(tableParameters[i][1]);
            RotX = SingeltonMatrix.DHRotX(tableParameters[i][0]);

            RotZxTransZ = SingeltonMatrix.Multiplication(RotZ, TransZ);
            xTransX = SingeltonMatrix.Multiplication(RotZxTransZ, TransX);
            xRotX = SingeltonMatrix.Multiplication(xTransX, RotX);

            A = SingeltonMatrix.Multiplication(A, xRotX);
            Aa.add(A);
            Log.v("coo X= ", String.valueOf(Aa.get(Aa.size() - 1)[0][3]));
            Log.v("coo Y= ", String.valueOf(Aa.get(Aa.size() - 1)[1][3]));
            Log.v("coo Z= ", String.valueOf(Aa.get(Aa.size() - 1)[2][3]));
        }

//        coordinatesEndEffector = new float[]{
//                A[0][3], A[1][3], A[2][3]
//        };
    }

    public ArrayList<float[][]> getCoordinatesEndEffector() {
        return Aa;
    }
}
