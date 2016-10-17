package com.example.damian.kinematicscalculatorvs3.openGL;

import android.content.Context;
import android.util.Log;

import com.example.damian.kinematicscalculatorvs3.calculations.SingeltonMatrix;
//import com.example.damian.kinematicscalculatorvs3.openGL.objects.Cube;
//import com.example.damian.kinematicscalculatorvs3.openGL.objects.CuboidA;
//import com.example.damian.kinematicscalculatorvs3.openGL.objects.CuboidD;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateXAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateYAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateZAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.ObjectParent;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.Vector;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class RenderManipulator extends AbstractRenderer {

//        Cube cube = new Cube(0, 0, 0);
//    CuboidD cuboidD = new CuboidD((float) 2);
//    CuboidA cuboidA = new CuboidA(2);
//    Cube cube1 = new Cube(8, 8, 8);

    private float[][] tableParameter;
    private float[] effectorCoord;
    private ArrayList<float[][]> effectorEndCoord;

    private ArrayList<ObjectParent> object = new ArrayList<>();

    public RenderManipulator(Context context, float[][] tableParameter, ArrayList<float[][]> effectorEndCoord) {
        this.tableParameter = tableParameter;
        this.effectorEndCoord = effectorEndCoord;
        render();
    }

    private void render() {

        object.add(new CoordinateXAxes());
        object.add(new CoordinateYAxes());
        object.add(new CoordinateZAxes());

//        Log.v("coo X= ", String.valueOf(Aa.get(Aa.size()-1)[0][3]));
//        Log.v("coo Y= ", String.valueOf(Aa.get(Aa.size()-1)[1][3]));
//        Log.v("coo Z= ", String.valueOf(Aa.get(Aa.size()-1)[2][3]));
//
        for (int i = 0; i < effectorEndCoord.size()-1; i++) {
            object.add(new Vector(
                    new float[]{
                            effectorEndCoord.get(i)[0][3],
                            effectorEndCoord.get(i)[1][3],
                            effectorEndCoord.get(i)[2][3]},
                    new float[]{
                            effectorEndCoord.get(i+1)[0][3],
                            effectorEndCoord.get(i+1)[1][3],
                            effectorEndCoord.get(i+1)[2][3]}));
        }
//        for (int i = 0; i < tableParameter.length; i++) {
//
//            float[][] MatrixUnit = {
//                    {1, 0, 0, 0},
//                    {0, 1, 0, 0},
//                    {0, 0, 1, 0},
//                    {0, 0, 0, 1}
//            };
////-------------------------------------------------------------------
//            // tworzenie członu
//            for (int j = 0; j < i; j++) {
//
//                float[][] RotZ = SingeltonMatrix.DHRotZ(tableParameter[j][2]);
//                float[][] TransZ = SingeltonMatrix.DHTransZ(tableParameter[j][3]);
//                float[][] TransX = SingeltonMatrix.DHTransX(tableParameter[j][1]);
//                float[][] RotX = SingeltonMatrix.DHRotX(tableParameter[j][0]);
//
//                float[][] RotZxTransZ = SingeltonMatrix.Multiplication(RotZ, TransZ);
//                float[][] xTransX = SingeltonMatrix.Multiplication(RotZxTransZ, TransX);
//                float[][] xRotX = SingeltonMatrix.Multiplication(xTransX, RotX);
//
//                MatrixUnit = SingeltonMatrix.Multiplication(MatrixUnit, xRotX);
//            }
//
//            object.add(new Cube(MatrixUnit[0][3], MatrixUnit[1][3], MatrixUnit[2][3]));
////-------------------------------------------------------------------
//            // tworzenie długości D
//            object.add(new CuboidD(tableParameter[i][3]));
//            float[] verticlesD = object.get(object.size() - 1).getVerticles();
//
////            float[][] Ad = {
////                    {1, 0, 0, 0},
////                    {0, 1, 0, 0},
////                    {0, 0, 1, 0},
////                    {0, 0, 0, 1}
////            };
//            float[][] Ad = {
//                    {1, 0, 0},
//                    {0, 1, 0},
//                    {0, 0, 1}
//            };
//
//            if (i > 0) {
//
//                for (int j = 0; j < i - 1; j++) {
//
//                    float[][] RotZD = SingeltonMatrix.RotZ(tableParameter[j][2]);
//                    float[][] RotXD = SingeltonMatrix.RotX(tableParameter[j][0]);
//
//                    float[][] RotZxRotXD = SingeltonMatrix.Multiplication(RotZD, RotXD);
//
//                    Ad = SingeltonMatrix.Multiplication(Ad, RotZxRotXD);
//                }
//
//                for (int h = 0; h < verticlesD.length; h = h + 3) {
//                    float[] v = {
//                            verticlesD[h + 0],
//                            verticlesD[h + 1],
//                            verticlesD[h + 2]
//                    };
//                    v = SingeltonMatrix.Multiplication(Ad, v);
//
//                    verticlesD[h + 0] = v[0] + MatrixUnit[0][3];
//                    verticlesD[h + 1] = v[1] + MatrixUnit[1][3];
//                    verticlesD[h + 2] = v[2] + MatrixUnit[2][3];
//                }
//
//                object.get(object.size() - 1).setVerticles(verticlesD);
//            }
//
////-------------------------------------------------------------------
//            // tworzenie długości A
//            object.add(new CuboidA(tableParameter[i][1]));
//            float[] verticlesA = object.get(object.size() - 1).getVerticles();
//
//            float[][] Aa = {
//                    {1, 0, 0},
//                    {0, 1, 0},
//                    {0, 0, 1}
//            };
//            for (int j = 0; j < i; j++) {
//
//                float[][] RotZA = SingeltonMatrix.RotZ(tableParameter[j][2]);
//                float[][] RotXA = SingeltonMatrix.RotX(tableParameter[j][0]);
//
//                float[][] RotZxRotXA = SingeltonMatrix.Multiplication(RotZA, RotXA);
//
//                Aa = SingeltonMatrix.Multiplication(Aa, RotZxRotXA);
//            }
//
//            float[][] MatrixUnitxRotz = SingeltonMatrix.Multiplication(MatrixUnit, SingeltonMatrix.DHRotZ(tableParameter[i][2]));
//            float[][] xTransZ = SingeltonMatrix.Multiplication(MatrixUnitxRotz, SingeltonMatrix.DHTransZ(tableParameter[i][3]));
//
//            for (int h = 0; h < verticlesA.length; h = h + 3) {
//                float[] v = {
//                        verticlesA[h + 0],
//                        verticlesA[h + 1],
//                        verticlesA[h + 2]
//                };
//                v = SingeltonMatrix.Multiplication(Aa, v);
//
//                verticlesA[h + 0] = v[0] + xTransZ[0][3];
//                verticlesA[h + 1] = v[1] + xTransZ[1][3];
//                verticlesA[h + 2] = v[2] + xTransZ[2][3];
//            }
//
//            object.get(object.size() - 1).setVerticles(verticlesA);
////-------------------------------------------------------------------
//        }
//
//        object.add(new Cube(effectorEndCoord[0], effectorEndCoord[1], effectorEndCoord[2]));
    }

    @Override
    protected void draw(GL10 gl) {

        for (int i = 0; i < object.size(); i++) {
            object.get(i).draw(gl);
        }

//        cube.draw(gl);
//        cuboidA.draw(gl);
//        cube1.draw(gl);
    }
}