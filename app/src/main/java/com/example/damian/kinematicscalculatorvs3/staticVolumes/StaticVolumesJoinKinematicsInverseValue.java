package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsInverseValue {

    private static ArrayList<ModelKinematicsInverseValue> modelKinematicsInverseValues = new ArrayList<>();

    public static ArrayList<ModelKinematicsInverseValue> getModelKinematicsInverseValues() {
        return modelKinematicsInverseValues;
    }

    public static void setOneJoinModel(ModelKinematicsInverseValue modelKinematicsInverseValue) {

        modelKinematicsInverseValues.get(modelKinematicsInverseValue.getTv_lp()).setEt_alpha(modelKinematicsInverseValue.getEt_alpha());
        modelKinematicsInverseValues.get(modelKinematicsInverseValue.getTv_lp()).setEt_a(modelKinematicsInverseValue.getEt_a());
        modelKinematicsInverseValues.get(modelKinematicsInverseValue.getTv_lp()).setEt_theta(modelKinematicsInverseValue.getEt_theta());
        modelKinematicsInverseValues.get(modelKinematicsInverseValue.getTv_lp()).setEt_d(modelKinematicsInverseValue.getEt_d());
    }

    public static void addJoin() {

        ModelKinematicsInverseValue modelKinematicsInverseValue = new ModelKinematicsInverseValue();
        if (modelKinematicsInverseValues.isEmpty())
            modelKinematicsInverseValue.setTv_lp(1);
        else
            modelKinematicsInverseValue.setTv_lp(modelKinematicsInverseValues.get(modelKinematicsInverseValues.size() - 1).getTv_lp() + 1);

        modelKinematicsInverseValues.add(modelKinematicsInverseValue);
    }

    public static void undo() {

        if (!modelKinematicsInverseValues.isEmpty()) {
            modelKinematicsInverseValues.remove(modelKinematicsInverseValues.size() - 1);
        }
    }
}
