package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-10-16.
 */

public class CoordinateYAxes extends ObjectParent {


    public CoordinateYAxes() {

        verticles = new float[]{
                0, 0, 0,
                0, 10, 0
        };

        indices = new short[]{
                0, 1
        };
    }

    @Override
    protected void drawing(GL10 gl) {

        gl.glColor4f(colors[2][0], colors[2][1], colors[2][2], colors[2][3]);
        gl.glLineWidth(10);
    }
}
