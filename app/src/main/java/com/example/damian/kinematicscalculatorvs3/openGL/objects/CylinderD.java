package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2017-02-13.
 */

public class CylinderD extends ObjectParent {

    public CylinderD(float length) {

        verticles = new float[24];

        for (int i = 0; i < 12; i = i + 3) {
            verticles[i] = (float) Math.cos(i / 3);
            verticles[i + 1] = (float) Math.sin(i / 3);
            verticles[i + 2] = 0;
        }

        for (int i = 12; i < 24; i = i + 3) {
            verticles[i] = (float) Math.cos(i / 3);
            verticles[i + 1] = (float) Math.sin(i / 3);
            verticles[i + 2] = length;
        }

        indices = new short[12];

//        for (int i = 0; i < 12; i = i+3) {
//            indices[i] = (short) i;
//            indices[i+1] = (short) (i+6);
//            indices[i+2] = (short) (i+7);
//
////            indices[i+3] = (short) i;
////            indices[i+4] = (short) (i+1);
////            indices[i+5] = (short) (i+7);
//        }

//        indices = new short[]{
//                0,4,5,
//                0,1,5,
//
//                1,5,6,
//                1,2,6,
//
//                2,6,7,
//                2,3,7
//
//        };

        verticles = new float[2160];

        for (int i = 0; i < 1080; i = i + 3) {
            verticles[i] = (float) Math.cos(i / 3);
            verticles[i + 1] = (float) Math.sin(i / 3);
            verticles[i + 2] = 0;
        }

        for (int i = 1080; i < 2160; i = i + 3) {
            verticles[i] = (float) Math.cos(i / 3);
            verticles[i + 1] = (float) Math.sin(i / 3);
            verticles[i + 2] = length;
        }
//
        indices = new short[3240];

        short[] j = new short[]{
                0, 360, 361,
                0, 1, 361
        };


        for (int i = 0; i < 360; i = i + 6) {
            indices[i] = (short) (j[0] + i);
            indices[i + 1] = (short) (j[1] + i / 6);
            indices[i + 2] = (short) (j[2] + i / 6);
            indices[i + 3] = (short) (j[3] + i / 6);
            indices[i + 4] = (short) (j[4] + i / 6);
            indices[i + 5] = (short) (j[5] + i / 6);
        }

//        j = new short[]{
//                0, 180, 181,
//                0, 1, 181
//        };

//        for (int i = 2160; i < 3000; i = i + 6) {
//            indices[i] = (short) (j[0] + i);
//            indices[i + 1] = (short) (j[1] + i / 6);
//            indices[i + 2] = (short) (j[2] + i / 6);
//            indices[i + 3] = (short) (j[3] + i / 6);
//            indices[i + 4] = (short) (j[4] + i / 6);
//            indices[i + 5] = (short) (j[5] + i / 6);
//        }
    }

    @Override
    protected void drawing(GL10 gl) {
        gl.glColor4f(colors[5][0], colors[5][1], colors[5][2], colors[5][3]);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
    }
}
