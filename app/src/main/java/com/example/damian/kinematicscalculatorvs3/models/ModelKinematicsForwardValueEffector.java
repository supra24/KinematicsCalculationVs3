package com.example.damian.kinematicscalculatorvs3.models;

/**
 * Created by Damian on 2016-11-11.
 */

public class ModelKinematicsForwardValueEffector extends ModelKinematicsForwardValueParent {

    private static final int TYPE_OBJECT = 2;
    private int index;
    private float et_x;
    private float et_y;
    private float et_z;

    public ModelKinematicsForwardValueEffector(int index) {
        this.index = index;
    }

    @Override
    public int getTypeObject() {
        return TYPE_OBJECT;
    }

    @Override
    public int getObjectIndex() {
        return index;
    }

    public float getEt_x() {
        return et_x;
    }

    public void setEt_x(float et_x) {
        this.et_x = et_x;
    }

    public float getEt_y() {
        return et_y;
    }

    public void setEt_y(float et_y) {
        this.et_y = et_y;
    }

    public float getEt_z() {
        return et_z;
    }

    public void setEt_z(float et_z) {
        this.et_z = et_z;
    }
}
