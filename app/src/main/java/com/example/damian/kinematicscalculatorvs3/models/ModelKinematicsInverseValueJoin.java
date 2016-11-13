package com.example.damian.kinematicscalculatorvs3.models;

/**
 * Created by Damian on 2016-11-11.
 */

public class ModelKinematicsInverseValueJoin extends ModelKinematicsInverseValueParent {

    private static final int TYPE_OBJECT = 1;
    private int index;
    private int tv_lp;
    private float et_alpha;
    private float et_a;
    private float et_theta;
    private float et_d;

    public ModelKinematicsInverseValueJoin(int index) {

        this.index = index;
        tv_lp = index + 1;
    }

    @Override
    public int getTypeObject() {
        return TYPE_OBJECT;
    }

    @Override
    public int getObjectIndex() {
        return index;
    }

    public void setTv_lp(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public void setEt_alpha(float et_alpha) {
        this.et_alpha = et_alpha;
    }

    public void setEt_a(float et_a) {
        this.et_a = et_a;
    }

    public void setEt_theta(float et_theta) {
        this.et_theta = et_theta;
    }

    public void setEt_d(float et_d) {
        this.et_d = et_d;
    }


    // get metods
    public int getTv_lp() {
        return tv_lp;
    }

    public float getEt_alpha() {
        return et_alpha;
    }

    public float getEt_a() {
        return et_a;
    }

    public float getEt_theta() {
        return et_theta;
    }

    public float getEt_d() {
        return et_d;
    }

}
