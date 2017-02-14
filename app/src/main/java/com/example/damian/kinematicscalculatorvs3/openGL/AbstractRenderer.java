package com.example.damian.kinematicscalculatorvs3.openGL;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class AbstractRenderer implements GLSurfaceView.Renderer {

    // zmienne do widoku kamery
    public static final int cameraBOTTOM = -1;
    public static final int cameraTOP = 1;
    public static final int cameraZ_NEAR = 3;
    public static final int cameraZ_FAR = 2000;

    // zmienne do ustawienia kamery:
    private static float alpha = -90;   // 0-PI
    private static float theta = 0;   // 0-2PI
    private static float transX = 0;
    private static float transY = 0;
    private static float radius = (float) 9;
    private static float EYE_X = 0;
    private static float EYE_Y = 0;
    private static float EYE_Z = radius;
    private static float CENTER_X = 0;
    private static float CENTER_Y = 0;
    private static float CENTER_Z = 0;
    private static float UP_X = 0;
    private static float UP_Y = 1;
    private static float UP_Z = 0;

    // zmienne do samego renderu
    private final static int APLICATION_THREAD_FPS_SLEEP = (1000 / 40);


    ShortBuffer mTriangleBorderIndicesBuffer = null;
    private int mNumOfTriangleBorderIndices = 0;
    private FloatBuffer mVertexBuffer = null;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) { // ogólne ustawienia, metoda która uruchamia się po uruchomieniu aplikacji
        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST); // ustawienia dotyczące perspektywy
        gl.glClearColor(.5f, .5f, .5f, 1); // kolor tła
        gl.glShadeModel(GL10.GL_SMOOTH); // włączenie cieniowania
        gl.glEnable(GL10.GL_DEPTH_TEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) { // zmiana parametrów widoku

        GLES20.glViewport(0, 0, width, height);
        float ratio = (float) width / height;
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glFrustumf(-ratio, ratio, cameraBOTTOM, cameraTOP, cameraZ_NEAR, cameraZ_FAR);
    }

    @Override
    public void onDrawFrame(GL10 gl) { // uruchamia się gdy odświerzany jest widok

        try {
            Thread.sleep(APLICATION_THREAD_FPS_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        gl.glDisable(GL10.GL_DITHER);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        GLU.gluLookAt(gl,
                EYE_X, EYE_Y, EYE_Z,
                CENTER_X, CENTER_Y, CENTER_Z,
                UP_X, UP_Y, UP_Z); // (gl, x,y,z, x1,y1,z1, 0,1,0)
        // x,y,z - punkt oczny, położneie kamery
        // x1,y1,z1 - punkt spoglądania kamery
        // 0,1,0 - wektor góry, orientacja pozioma, pionowa, lub nachylona

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glRotatef(alpha, 1.0f, 0, 0);
        gl.glRotatef(theta, 0, 0, 1.0f);
//        gl.glTranslatef(transX, 0, 0);
//        gl.glTranslatef(0, transY, 0);
        draw(gl);
    }

    protected abstract void draw(GL10 gl);

    public static void setRotate(float speedX, float speedY) {

        alpha = alpha + speedY / 100;
        theta = theta + speedX / 100;

        if (alpha > 0)
            alpha = 0;
        else if (alpha < -180)
            alpha = -180;
    }

    public static void setRadiusDistance(float difference) {

        EYE_Z = EYE_Z - difference / 500;
        if (EYE_Z > 1500)
            EYE_Z = 1500;
        if (EYE_Z < 7)
            EYE_Z = 7;
    }

    public static void setShiftOneSide(float speedX, float speedY) {

//        CENTER_X = CENTER_X + speedX / 700;
//        CENTER_Y = CENTER_Y + speedY / 700;


//        transX = transX + speedX / 500;
//        transY = transY + speedY / 500;

//        if (EYE_X > 120)
//            EYE_X = 120;
//        if (EYE_X < 7)
//            EYE_X = 7;
    }
}
