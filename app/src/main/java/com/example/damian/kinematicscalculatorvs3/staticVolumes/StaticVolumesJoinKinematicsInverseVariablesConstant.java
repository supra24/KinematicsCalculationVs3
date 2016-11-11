package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesConstant;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsInverseVariablesConstant {

    private static ArrayList<ModelKinematicsInverseVariablesConstant> modelKinematicsInverseVariablesConstants = new ArrayList<>();

    public static ArrayList<ModelKinematicsInverseVariablesConstant> getModelKinematicsInverseVariablesConstants() {
        return modelKinematicsInverseVariablesConstants;
    }

    public static void setOneJoinModel(ModelKinematicsInverseVariablesConstant modelKinematicsInverseVariablesConstant) {

        modelKinematicsInverseVariablesConstants.get(modelKinematicsInverseVariablesConstant.getTv_lp()).setEt_alpha(modelKinematicsInverseVariablesConstant.getEt_alpha());
        modelKinematicsInverseVariablesConstants.get(modelKinematicsInverseVariablesConstant.getTv_lp()).setEt_a(modelKinematicsInverseVariablesConstant.getEt_a());
        modelKinematicsInverseVariablesConstants.get(modelKinematicsInverseVariablesConstant.getTv_lp()).setEt_theta(modelKinematicsInverseVariablesConstant.getEt_theta());
        modelKinematicsInverseVariablesConstants.get(modelKinematicsInverseVariablesConstant.getTv_lp()).setEt_d(modelKinematicsInverseVariablesConstant.getEt_d());
    }


    public static void addJoin() {

        ModelKinematicsInverseVariablesConstant modelKinematicsInverseVariablesConstant = new ModelKinematicsInverseVariablesConstant();
        if (modelKinematicsInverseVariablesConstants.isEmpty())
            modelKinematicsInverseVariablesConstant.setTv_lp(1);
        else
            modelKinematicsInverseVariablesConstant.setTv_lp(modelKinematicsInverseVariablesConstants.get(modelKinematicsInverseVariablesConstants.size() - 1).getTv_lp() + 1);

        modelKinematicsInverseVariablesConstants.add(modelKinematicsInverseVariablesConstant);
    }
}
