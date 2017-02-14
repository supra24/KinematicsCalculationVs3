package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-10-16.
 */

public class CoordinateZAxes extends ObjectParent {


    public CoordinateZAxes() {

        verticles = new float[]{
                0, 0, 0,
                0, 0, 10
        };

        indices = new short[]{
                0, 1
        };
    }

    @Override
    protected void drawing(GL10 gl) {

        gl.glColor4f(colors[3][0], colors[3][1], colors[3][2], colors[3][3]);
        gl.glLineWidth(10);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);

    }

}
