package com.example.damian.kinematicscalculatorvs3.openGL.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Damian on 2016-09-14.
 */
public abstract class ObjectParent {

    protected FloatBuffer vertexBuffer;
    protected FloatBuffer textureBuffer;
    protected ByteBuffer indexBuffer;

    protected float[] verticles;
    protected float[] texture;
    protected byte[] indices;

    protected float[][] colors = {  // Colors of the 6 faces
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

    public ObjectParent (){
        constructor();
    }

    public void draw(GL10 gl){

        ByteBuffer vbb = ByteBuffer.allocateDirect(verticles.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert from byte to float
        vertexBuffer.put(verticles);         // Copy data into buffer
        vertexBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length * 4);
        indexBuffer.put(indices);
        indexBuffer.position(0);

        gl.glFrontFace(GL10.GL_CCW);    // Front face in counter-clockwise orientation
        gl.glEnable(GL10.GL_CULL_FACE); // Enable cull face
        gl.glCullFace(GL10.GL_BACK);    // Cull the back face (don't display)
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        drawing(gl);

        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }

    public float[] getVerticles() {

        return verticles;
    }

    public void setVerticles(float[] verticles) {
        this.verticles = verticles;
    }

    protected abstract void constructor();
    protected abstract void drawing(GL10 gl);
}
