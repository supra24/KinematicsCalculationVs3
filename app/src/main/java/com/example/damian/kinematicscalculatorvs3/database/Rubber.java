package com.example.damian.kinematicscalculatorvs3.database;

public class Rubber {

    int _id;
    float x_axis;
    float y_axis;

    public Rubber() {
    }

    public Rubber(int _id, float x_axis, float y_axis) {
        this._id = _id;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    public Rubber(float x_axis, float y_axis) {
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }


    public int get_id() {
        return _id;
    }

    public float getX_axis() {
        return x_axis;
    }

    public float getY_axis() {
        return y_axis;
    }

    public void setX_axis(float x_axis) {
        this.x_axis = x_axis;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setY_axis(float y_axis) {
        this.y_axis = y_axis;
    }
}
