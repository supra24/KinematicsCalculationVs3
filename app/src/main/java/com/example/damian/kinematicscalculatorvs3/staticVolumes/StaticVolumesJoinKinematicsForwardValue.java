package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsForwardValue {

    private static ArrayList<ModelKinematicsForwardValue> modelKinematicsForwardValues = new ArrayList<>();

    public static ArrayList<ModelKinematicsForwardValue> getModelKinematicsForwardValues() {
        return modelKinematicsForwardValues;
    }

    public static void setOneJoinModel(ModelKinematicsForwardValue modelKinematicsForwardValue) {

        modelKinematicsForwardValues.get(modelKinematicsForwardValue.getTv_lp()).setEt_alpha(modelKinematicsForwardValue.getEt_alpha());
        modelKinematicsForwardValues.get(modelKinematicsForwardValue.getTv_lp()).setEt_a(modelKinematicsForwardValue.getEt_a());
        modelKinematicsForwardValues.get(modelKinematicsForwardValue.getTv_lp()).setEt_theta(modelKinematicsForwardValue.getEt_theta());
        modelKinematicsForwardValues.get(modelKinematicsForwardValue.getTv_lp()).setEt_d(modelKinematicsForwardValue.getEt_d());
    }

    public static void addJoin() {

        ModelKinematicsForwardValue modelKinematicsForwardValue = new ModelKinematicsForwardValue();
        if (modelKinematicsForwardValues.isEmpty())
            modelKinematicsForwardValue.setTv_lp(1);
        else
            modelKinematicsForwardValue.setTv_lp(modelKinematicsForwardValues.get(modelKinematicsForwardValues.size() - 1).getTv_lp() + 1);

        modelKinematicsForwardValues.add(modelKinematicsForwardValue);
    }
}
