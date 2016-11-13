package com.example.damian.kinematicscalculatorvs3.openGL;

import android.content.Context;

//import com.example.damian.kinematicscalculatorvs3.openGL.objects.Cube;
//import com.example.damian.kinematicscalculatorvs3.openGL.objects.CuboidA;
//import com.example.damian.kinematicscalculatorvs3.openGL.objects.CuboidD;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateXAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateYAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.CoordinateZAxes;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.ObjectParent;
import com.example.damian.kinematicscalculatorvs3.openGL.objects.Vector;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class RenderManipulator extends AbstractRenderer {

    private float[][] tableParameter;
    private float[] effectorCoord;
    private ArrayList<float[][]> effectorEndCoord;

    private ArrayList<ObjectParent> object = new ArrayList<>();

    public RenderManipulator(Context context, float[][] tableParameter, ArrayList<float[][]> effectorEndCoord) {
        this.tableParameter = tableParameter;
        this.effectorEndCoord = effectorEndCoord;
        render();
    }

    private void render() {

        object.add(new CoordinateXAxes());
        object.add(new CoordinateYAxes());
        object.add(new CoordinateZAxes());

        for (int i = 0; i < effectorEndCoord.size()-1; i++) {
            object.add(new Vector(
                    new float[]{
                            effectorEndCoord.get(i)[0][3],
                            effectorEndCoord.get(i)[1][3],
                            effectorEndCoord.get(i)[2][3]},
                    new float[]{
                            effectorEndCoord.get(i+1)[0][3],
                            effectorEndCoord.get(i+1)[1][3],
                            effectorEndCoord.get(i+1)[2][3]}));
        }
    }

    @Override
    protected void draw(GL10 gl) {

        for (int i = 0; i < object.size(); i++) {
            object.get(i).draw(gl);
        }
    }
}