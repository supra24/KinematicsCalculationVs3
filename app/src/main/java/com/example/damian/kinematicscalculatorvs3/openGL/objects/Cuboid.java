package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-09-09.
 */
public class Cuboid {

    private FloatBuffer vertexBuffer;
    private FloatBuffer textureBuffer;
    private ByteBuffer indexBuffer;

    private float[] verticles;
    private float[] texture;
    private byte[] indices;

    private float[][] colors = {  // Colors of the 6 faces
            {1.0f, 0.5f, 0.0f, 1.0f},  // 0. orange
            {1.0f, 0.0f, 1.0f, 1.0f},  // 1. violet
            {0.0f, 1.0f, 0.0f, 1.0f},  // 2. green
            {0.0f, 0.0f, 1.0f, 1.0f},  // 3. blue
            {1.0f, 0.0f, 0.0f, 1.0f},  // 4. red
            {1.0f, 1.0f, 0.0f, 1.0f},  // 5. yellow
            {1.0f, 1.0f, 0.0f, 1.0f},   // 5. yellow
            {1.0f, 0.0f, 0.0f, 1.0f},  // 4. red
            {0.0f, 0.0f, 1.0f, 1.0f},  // 3. blue
            {0.0f, 1.0f, 0.0f, 1.0f},  // 2. green
            {1.0f, 0.0f, 1.0f, 1.0f},  // 1. violet
            {1.0f, 0.5f, 0.0f, 1.0f},  // 0. orange
    };

    public Cuboid(float length) {

//        verticles = new float[]{
//                -0.5f, -0.5f, -0.5f,  // 0. left-bottom-front
//                0.5f, -0.5f, -0.5f,  // 1. right-bottom-front
//                -0.5f, -0.5f, 0.5f+length,  // 2. left-top-front
//                0.5f, -0.5f, 0.5f+length,  // 3. right-top-front
//                0.5f, 0.5f, -0.5f,  // 6. right-bottom-back
//                -0.5f, 0.5f, -0.5f,  // 4. left-bottom-back
//                0.5f, 0.5f, 0.5f+length,  // 7. right-top-back
//                -0.5f, 0.5f, 0.5f+length,  // 5. left-top-back
//        };

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

    public float[] getVerticles() {

        return verticles;
    }

    public void setVerticles(float[] verticles) {
        this.verticles = verticles;
    }

    public void draw(GL10 gl) {

        ByteBuffer vbb = ByteBuffer.allocateDirect(verticles.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert from byte to float
        vertexBuffer.put(verticles);         // Copy data into buffer
        vertexBuffer.position(0);

//        vbb = ByteBuffer.allocateDirect(texture.length * 4);
//        vbb.order(ByteOrder.nativeOrder());
//        textureBuffer = vbb.asFloatBuffer();
//        textureBuffer.put(texture);
//        textureBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length * 4);
        indexBuffer.put(indices);
        indexBuffer.position(0);


        gl.glFrontFace(GL10.GL_CCW);    // Front face in counter-clockwise orientation
        gl.glEnable(GL10.GL_CULL_FACE); // Enable cull face
        gl.glCullFace(GL10.GL_BACK);    // Cull the back face (don't display)
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
//        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
        gl.glColor4f(colors[2][0], colors[2][1], colors[2][2], colors[2][3]);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);

    }
}
