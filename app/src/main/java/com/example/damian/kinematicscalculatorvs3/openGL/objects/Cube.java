package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-08-25.
 */
public class Cube extends ObjectParent {

    public Cube(float transX, float transY, float transZ) {

//        verticles = new float[]{
//                (float) (Math.cos(rotZ + Math.acos((transX + -1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + -1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f))), transZ + 1.0f,  // 0. left-bottom-front
//                (float) (Math.cos(rotZ + Math.acos((transX + 1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + -1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f))), transZ + 1.0f,  // 1. right-bottom-front
//                (float) (Math.cos(rotZ + Math.acos((transX + -1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + 1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f))), transZ + 1.0f,  // 2. left-top-front
//                (float) (Math.cos(rotZ + Math.acos((transX + 1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + 1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f))), transZ + 1.0f,  // 3. right-top-front
//                (float) (Math.cos(rotZ + Math.acos((transX + 1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + -1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + -1.0f) * (transY + -1.0f))), transZ + -1.0f,  // 6. right-bottom-back
//                (float) (Math.cos(rotZ + Math.acos((transX + -1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + -1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + -1.0f) * (transY + -1.0f))), transZ + -1.0f,  // 4. left-bottom-back
//                (float) (Math.cos(rotZ + Math.acos((transX + 1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + 1.0f) / Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + 1.0f) * (transX + 1.0f) + (transY + 1.0f) * (transY + 1.0f))), transZ + -1.0f,  // 7. right-top-back
//                (float) (Math.cos(rotZ + Math.acos((transX + -1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f))), (float) (Math.sin(rotZ + Math.asin((transY + 1.0f) / Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f)))) * Math.sqrt((transX + -1.0f) * (transX + -1.0f) + (transY + 1.0f) * (transY + 1.0f))), transZ + -1.0f,  // 5. left-top-back
//        };

        verticles = new float[]{
                transX + -1.0f, transY + -1.0f, transZ + 1.0f,
                transX + 1.0f, transY + -1.0f, transZ + 1.0f,
                transX + -1.0f, transY + 1.0f, transZ + 1.0f,
                transX + 1.0f, transY + 1.0f, transZ + 1.0f,
                transX + 1.0f, transY + -1.0f, transZ + -1.0f,
                transX + -1.0f, transY + -1.0f, transZ + -1.0f,
                transX + 1.0f, transY + 1.0f, transZ + -1.0f,
                transX + -1.0f, transY + 1.0f, transZ + -1.0f,
        };

        indices = new byte[]{
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
    protected void constructor() {

    }

    @Override
    protected void drawing(GL10 gl) {
        gl.glColor4f(colors[0][0], colors[0][1], colors[0][2], colors[0][3]);
    }
}
