package com.example.damian.kinematicscalculatorvs3.models;

/**
 * Created by Damian on 2016-11-11.
 */

public class ModelKinematicsForwardValueEffector extends ModelKinematicsForwardValueParent {

    private int index;
    private int et_x;
    private int et_y;
    private int et_z;

    public ModelKinematicsForwardValueEffector(int index) {
        this.index = index;
    }


    @Override
    public int getTypeObject() {
        return 2;
    }

    @Override
    public int getObjectIndex() {
        return index;
    }

    public int getEt_x() {
        return et_x;
    }

    public void setEt_x(int et_x) {
        this.et_x = et_x;
    }

    public int getEt_y() {
        return et_y;
    }

    public void setEt_y(int et_y) {
        this.et_y = et_y;
    }

    public int getEt_z() {
        return et_z;
    }

    public void setEt_z(int et_z) {
        this.et_z = et_z;
    }
}
