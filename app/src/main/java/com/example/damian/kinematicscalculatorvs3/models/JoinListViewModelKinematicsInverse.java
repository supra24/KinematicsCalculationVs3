package com.example.damian.kinematicscalculatorvs3.models;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinListViewModelKinematicsInverse {

    private int tv_lp;
    private boolean et_alpha = false;
    private boolean et_a = false;
    private boolean et_theta = false;
    private boolean et_d = false;

    public JoinListViewModelKinematicsInverse() {

    }

    // set metods

    public void setTv_lp(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public void setEt_alpha(boolean et_alpha) {
        this.et_alpha = et_alpha;
    }

    public void setEt_a(boolean et_a) {
        this.et_a = et_a;
    }

    public void setEt_theta(boolean et_theta) {
        this.et_theta = et_theta;
    }

    public void setEt_d(boolean et_d) {
        this.et_d = et_d;
    }


    // get metods


    public int getTv_lp() {
        return tv_lp;
    }

    public boolean getEt_alpha() {
        return et_alpha;
    }

    public boolean getEt_a() {
        return et_a;
    }

    public boolean getEt_theta() {
        return et_theta;
    }

    public boolean getEt_d() {
        return et_d;
    }
}
