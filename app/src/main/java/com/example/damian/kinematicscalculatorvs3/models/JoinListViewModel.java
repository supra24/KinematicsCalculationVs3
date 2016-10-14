package com.example.damian.kinematicscalculatorvs3.models;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinListViewModel {

    private int tv_lp;
    private String et_alpha;
    private String et_a;
    private String et_theta;
    private String et_d;

    public JoinListViewModel(){

    }

    // set metods

    public void setTv_lp(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public void setEt_alpha(String et_alpha) {
        this.et_alpha = et_alpha;
    }

    public void setEt_a(String et_a) {
        this.et_a = et_a;
    }

    public void setEt_theta(String et_theta) {
        this.et_theta = et_theta;
    }

    public void setEt_d(String et_d) {
        this.et_d = et_d;
    }


    // get metods


    public int getTv_lp() {
        return tv_lp;
    }

    public String getEt_alpha() {
        return et_alpha;
    }

    public String getEt_a() {
        return et_a;
    }

    public String getEt_theta() {
        return et_theta;
    }

    public String getEt_d() {
        return et_d;
    }
}
