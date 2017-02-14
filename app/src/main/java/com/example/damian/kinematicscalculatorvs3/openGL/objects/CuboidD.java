package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-09-09.
 */
public class CuboidD extends ObjectParent {

    public CuboidD(float length) {

        verticles = new float[]{
                -0.5f, -0.5f, 1f,  // 0. left-bottom-front
                0.5f, -0.5f, 1f,  // 1. right-bottom-front
                -0.5f, -0.5f, 0.5f + length,  // 2. left-top-front
                0.5f, -0.5f, 0.5f + length,  // 3. right-top-front
                0.5f, 0.5f, 1f,  // 6. right-bottom-back
                -0.5f, 0.5f, 1f,  // 4. left-bottom-back
                0.5f, 0.5f, 0.5f + length,  // 7. right-top-back
                -0.5f, 0.5f, 0.5f + length,  // 5. left-top-back
        };

        indices = new short[]{
                0, 1, 2,
                2, 1, 3,

                4, 5, 6,
                6, 5, 7,

                4, 0, 5,
                0, 4, 1,

                1, 6, 3,
                1, 4, 6,

                0, 2, 5,
                7, 5, 2,

                2, 3, 6,
                2, 6, 7
        };
    }

    @Override
    protected void drawing(GL10 gl) {
        gl.glColor4f(colors[5][0], colors[5][1], colors[5][2], colors[5][3]);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);

    }

}
