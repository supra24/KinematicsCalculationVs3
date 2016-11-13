package com.example.damian.kinematicscalculatorvs3.models;

/**
 * Created by Damian on 2016-11-11.
 */

public class ModelKinematicsInverseVariablesEffector extends ModelKinematicsInverseVariablwsParent {

    private static final int TYPE_OBJECT = 2;
    private int index;
    private boolean et_x;
    private boolean et_y;
    private boolean et_z;

    public ModelKinematicsInverseVariablesEffector(int index) {
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

    public boolean isEt_x() {
        return et_x;
    }

    public void setEt_x(boolean et_x) {
        this.et_x = et_x;
    }

    public boolean isEt_y() {
        return et_y;
    }

    public void setEt_y(boolean et_y) {
        this.et_y = et_y;
    }

    public boolean isEt_z() {
        return et_z;
    }

    public void setEt_z(boolean et_z) {
        this.et_z = et_z;
    }
}
