package com.example.damian.kinematicscalculatorvs3.openGL;

import android.content.Context;

import com.example.damian.kinematicscalculatorvs3.calculations.SingeltonMatrixKinematicsForward;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateXAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateYAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateZAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.Cube;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CuboidA;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CuboidD;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CylinderD;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.ObjectParent;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.Vector;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class RenderManipulator extends AbstractRenderer {

    private float[][] tableParameter;
    private float[] effectorCoord;
    private ArrayList<float[][]> effectorEndCoord;

    private ArrayList<ObjectParent> object = new ArrayList<>();

    public RenderManipulator(Context context, float[][] tableParameter, ArrayList<float[][]> effectorEndCoord) {
        this.tableParameter = tableParameter;
        this.effectorEndCoord = effectorEndCoord;
        render();
    }

//    private void render() {
//
//        object.add(new CoordinateXAxes());
//        object.add(new CoordinateYAxes());
////        object.add(new CoordinateZAxes());
//        object.add(new CylinderD(4));
////        object.add(new CuboidD(3));
//
//        for (int i = 0; i < effectorEndCoord.size() - 1; i++) {
//            object.add(new Vector(
//                    new float[]{
//                            effectorEndCoord.get(i)[0][3],
//                            effectorEndCoord.get(i)[1][3],
//                            effectorEndCoord.get(i)[2][3]},
//                    new float[]{
//                            effectorEndCoord.get(i + 1)[0][3],
//                            effectorEndCoord.get(i + 1)[1][3],
//                            effectorEndCoord.get(i + 1)[2][3]}));
//        }
//    }

    private void render() {


        object.add(new CoordinateXAxes());
        object.add(new CoordinateYAxes());
        object.add(new CoordinateZAxes());

        for (int i = 0; i < tableParameter.length; i++) {

            float[][] MatrixUnit = {
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
            };
//-------------------------------------------------------------------
            // tworzenie członu
            for (int j = 0; j < i; j++) {

                float[][] RotZ = SingeltonMatrixKinematicsForward.DHRotZ(tableParameter[j][2]);
                float[][] TransZ = SingeltonMatrixKinematicsForward.DHTransZ(tableParameter[j][3]);
                float[][] TransX = SingeltonMatrixKinematicsForward.DHTransX(tableParameter[j][1]);
                float[][] RotX = SingeltonMatrixKinematicsForward.DHRotX(tableParameter[j][0]);

                float[][] RotZxTransZ = SingeltonMatrixKinematicsForward.Multiplication(RotZ, TransZ);
                float[][] xTransX = SingeltonMatrixKinematicsForward.Multiplication(RotZxTransZ, TransX);
                float[][] xRotX = SingeltonMatrixKinematicsForward.Multiplication(xTransX, RotX);

                MatrixUnit = SingeltonMatrixKinematicsForward.Multiplication(MatrixUnit, xRotX);
            }

//            object.add(new Cube(MatrixUnit[0][3], MatrixUnit[1][3], MatrixUnit[2][3]));
//-------------------------------------------------------------------
            // tworzenie długości D

            float[] verticlesD, verticlesD2;

//            if (tableParameter[i][3] == 0 /*&& i < (tableParameter.length - 1)*/) {

                object.add(new CylinderD(/*tableParameter[i][3]*/ + 0.5f));
                object.add(new CylinderD(/*tableParameter[i][3]*/ - 0.5f));
                verticlesD = object.get(object.size() - 1).getVerticles();
                verticlesD2 = object.get(object.size() - 2).getVerticles();

//            } else {
//                object.add(new CylinderD(tableParameter[i][3]));
//                verticlesD = object.get(object.size() - 1).getVerticles();
//                verticlesD2 = null;
//            }

//            float[][] Ad = {
//                    {1, 0, 0, 0},
//                    {0, 1, 0, 0},
//                    {0, 0, 1, 0},
//                    {0, 0, 0, 1}
//            };
            float[][] Ad = {
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            };

            if (i > 0) {

                for (int j = 0; j < i; j++) {

                    float[][] RotZD = SingeltonMatrixKinematicsForward.RotZ(tableParameter[j][2]);
                    float[][] RotXD = SingeltonMatrixKinematicsForward.RotX(tableParameter[j][0]);

                    float[][] RotZxRotXD = SingeltonMatrixKinematicsForward.Multiplication(RotZD, RotXD);

                    Ad = SingeltonMatrixKinematicsForward.Multiplication(Ad, RotZxRotXD);
                }

//                if (tableParameter[i][3] == 0  /*&& i < (tableParameter.length - 1)*/ ) {
                    for (int h = 0; h < verticlesD.length; h = h + 3) {
                        float[] v = {
                                verticlesD[h + 0],
                                verticlesD[h + 1],
                                verticlesD[h + 2]
                        };
                        v = SingeltonMatrixKinematicsForward.Multiplication(Ad, v);

                        verticlesD[h + 0] = v[0] + MatrixUnit[0][3];
                        verticlesD[h + 1] = v[1] + MatrixUnit[1][3];
                        verticlesD[h + 2] = v[2] + MatrixUnit[2][3];
                    }

                    object.get(object.size() - 1).setVerticles(verticlesD);

                    for (int h = 0; h < verticlesD.length; h = h + 3) {
                        float[] v = {
                                verticlesD2[h + 0],
                                verticlesD2[h + 1],
                                verticlesD2[h + 2]
                        };
                        v = SingeltonMatrixKinematicsForward.Multiplication(Ad, v);

                        verticlesD2[h + 0] = v[0] + MatrixUnit[0][3];
                        verticlesD2[h + 1] = v[1] + MatrixUnit[1][3];
                        verticlesD2[h + 2] = v[2] + MatrixUnit[2][3];
                    }

                    object.get(object.size() - 2).setVerticles(verticlesD2);

//                } else {
//                    for (int h = 0; h < verticlesD.length; h = h + 3) {
//                        float[] v = {
//                                verticlesD[h + 0],
//                                verticlesD[h + 1],
//                                verticlesD[h + 2]
//                        };
//                        v = SingeltonMatrixKinematicsForward.Multiplication(Ad, v);
//
//                        verticlesD[h + 0] = v[0] + MatrixUnit[0][3];
//                        verticlesD[h + 1] = v[1] + MatrixUnit[1][3];
//                        verticlesD[h + 2] = v[2] + MatrixUnit[2][3];
//                    }
//
//                    object.get(object.size() - 1).setVerticles(verticlesD);
//                }


            }
//=-------------------------------------
//
//            object.add(new Vector(
//                    new float[]{
//                            effectorEndCoord.get(i)[0][3],
//                            effectorEndCoord.get(i)[1][3],
//                            effectorEndCoord.get(i)[2][3]},
//                    new float[]{
//                            effectorEndCoord.get(i + 1)[0][3],
//                            effectorEndCoord.get(i + 1)[1][3],
//                            effectorEndCoord.get(i + 1)[2][3]}));

//-------------------------------------------------------------------
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
//                float[][] RotZA = SingeltonMatrixKinematicsForward.RotZ(tableParameter[j][2]);
//                float[][] RotXA = SingeltonMatrixKinematicsForward.RotX(tableParameter[j][0]);
//
//                float[][] RotZxRotXA = SingeltonMatrixKinematicsForward.Multiplication(RotZA, RotXA);
//
//                Aa = SingeltonMatrixKinematicsForward.Multiplication(Aa, RotZxRotXA);
//            }
//
//            float [][] MatrixUnitxRotz = SingeltonMatrixKinematicsForward.Multiplication(MatrixUnit,SingeltonMatrixKinematicsForward.DHRotZ(tableParameter[i][2]));
//            float [][] xTransZ = SingeltonMatrixKinematicsForward.Multiplication(MatrixUnitxRotz, SingeltonMatrixKinematicsForward.DHTransZ(tableParameter[i][3]));
//
//            for (int h = 0; h < verticlesA.length; h = h + 3) {
//                float[] v = {
//                        verticlesA[h + 0],
//                        verticlesA[h + 1],
//                        verticlesA[h + 2]
//                };
//                v = SingeltonMatrixKinematicsForward.Multiplication(Aa, v);
//
//                verticlesA[h + 0] = v[0] + xTransZ[0][3];
//                verticlesA[h + 1] = v[1] + xTransZ[1][3];
//                verticlesA[h + 2] = v[2] + xTransZ[2][3];
//            }
//
//            object.get(object.size() - 1).setVerticles(verticlesA);
//-------------------------------------------------------------------
        }

//        object.add(new Cube(effectorEndCoord[0], effectorEndCoord[1], effectorEndCoord[2]));


        for (int i = 0; i < effectorEndCoord.size() - 1; i++) {
            object.add(new Vector(
                    new float[]{
                            effectorEndCoord.get(i)[0][3],
                            effectorEndCoord.get(i)[1][3],
                            effectorEndCoord.get(i)[2][3]},
                    new float[]{
                            effectorEndCoord.get(i + 1)[0][3],
                            effectorEndCoord.get(i + 1)[1][3],
                            effectorEndCoord.get(i + 1)[2][3]}));
        }

    }

    @Override
    protected void draw(GL10 gl) {

        for (int i = 0; i < object.size(); i++) {
            object.get(i).draw(gl);
        }
    }
}