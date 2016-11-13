package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-10-16.
 */

public class Vector extends ObjectParent {

    public Vector(float[] firstPoint, float[] secondPoint) {

        verticles = new float[]{
                firstPoint[0], firstPoint[1], firstPoint[2],
                secondPoint[0], secondPoint[1], secondPoint[2]
        };

        indices = new short[]{
                0, 1
        };
    }

    @Override
    protected void drawing(GL10 gl) {

        gl.glColor4f(colors[0][0], colors[0][1], colors[0][2], colors[0][3]);
        gl.glLineWidth(10);
    }
}
