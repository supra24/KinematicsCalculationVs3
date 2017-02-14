package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-10-16.
 */

public class CoordinateXAxes extends ObjectParent {


    public CoordinateXAxes() {

        verticles = new float[]{
                0, 0, 0,
                10, 0, 0
        };

        indices = new short[]{
                0, 1
        };
    }

    @Override
    protected void drawing(GL10 gl) {

        gl.glColor4f(colors[4][0], colors[4][1], colors[4][2], colors[4][3]);
        gl.glLineWidth(10);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
    }
}
