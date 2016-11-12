package com.example.damian.kinematicscalculatorvs3.models;

/**
 * Created by Damian on 2016-11-11.
 */

public class ModelKinematicsInverseVariablesJoin extends ModelKinematicsInverseVariablwsParent {

    private int index;
    private int tv_lp;
    private boolean et_alpha;
    private boolean et_a;
    private boolean et_theta;
    private boolean et_d;

    public ModelKinematicsInverseVariablesJoin(int index) {

        this.index = index;
        tv_lp = index + 1;
    }

    @Override
    public int getTypeObject() {
        return 1;
    }

    @Override
    public int getObjectIndex() {
        return index;
    }

    public int getTv_lp() {
        return tv_lp;
    }

    public void setTv_lp(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public boolean isEt_alpha() {
        return et_alpha;
    }

    public void setEt_alpha(boolean et_alpha) {
        this.et_alpha = et_alpha;
    }

    public boolean isEt_a() {
        return et_a;
    }

    public void setEt_a(boolean et_a) {
        this.et_a = et_a;
    }

    public boolean isEt_theta() {
        return et_theta;
    }

    public void setEt_theta(boolean et_theta) {
        this.et_theta = et_theta;
    }

    public boolean isEt_d() {
        return et_d;
    }

    public void setEt_d(boolean et_d) {
        this.et_d = et_d;
    }
}
