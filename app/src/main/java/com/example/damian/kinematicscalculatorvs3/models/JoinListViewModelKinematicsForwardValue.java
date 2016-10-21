package com.example.damian.kinematicscalculatorvs3.models;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinListViewModelKinematicsForwardValue {

    private int tv_lp ;
    private int et_alpha;
    private int et_a;
    private int et_theta;
    private int et_d;

    public JoinListViewModelKinematicsForwardValue(){

    }

    // set metods

    public void setTv_lp(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public void setEt_alpha(int et_alpha) {
        this.et_alpha = et_alpha;
    }

    public void setEt_a(int et_a) {
        this.et_a = et_a;
    }

    public void setEt_theta(int et_theta) {
        this.et_theta = et_theta;
    }

    public void setEt_d(int et_d) {
        this.et_d = et_d;
    }


    // get metods


    public int getTv_lp() {
        return tv_lp;
    }

    public int getEt_alpha() {
        return et_alpha;
    }

    public int getEt_a() {
        return et_a;
    }

    public int getEt_theta() {
        return et_theta;
    }

    public int getEt_d() {
        return et_d;
    }
}
