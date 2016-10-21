package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseVariablesConstant;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsInverse {

    private static ArrayList<JoinListViewModelKinematicsInverseVariablesConstant> joinListViewModelKinematicsInverseVariablesConstants = new ArrayList<>();

    public static ArrayList<JoinListViewModelKinematicsInverseVariablesConstant> getJoinListViewModelKinematicsInverseVariablesConstants() {
        return joinListViewModelKinematicsInverseVariablesConstants;
    }

    public static void setOneJoinModel(JoinListViewModelKinematicsInverseVariablesConstant joinListViewModelKinematicsInverseVariablesConstant) {

        joinListViewModelKinematicsInverseVariablesConstants.get(joinListViewModelKinematicsInverseVariablesConstant.getTv_lp()).setEt_alpha(joinListViewModelKinematicsInverseVariablesConstant.getEt_alpha());
        joinListViewModelKinematicsInverseVariablesConstants.get(joinListViewModelKinematicsInverseVariablesConstant.getTv_lp()).setEt_a(joinListViewModelKinematicsInverseVariablesConstant.getEt_a());
        joinListViewModelKinematicsInverseVariablesConstants.get(joinListViewModelKinematicsInverseVariablesConstant.getTv_lp()).setEt_theta(joinListViewModelKinematicsInverseVariablesConstant.getEt_theta());
        joinListViewModelKinematicsInverseVariablesConstants.get(joinListViewModelKinematicsInverseVariablesConstant.getTv_lp()).setEt_d(joinListViewModelKinematicsInverseVariablesConstant.getEt_d());
    }


    public static void addJoin() {

        JoinListViewModelKinematicsInverseVariablesConstant joinListViewModelKinematicsInverseVariablesConstant = new JoinListViewModelKinematicsInverseVariablesConstant();
        if (joinListViewModelKinematicsInverseVariablesConstants.isEmpty())
            joinListViewModelKinematicsInverseVariablesConstant.setTv_lp(1);
        else
            joinListViewModelKinematicsInverseVariablesConstant.setTv_lp(joinListViewModelKinematicsInverseVariablesConstants.get(joinListViewModelKinematicsInverseVariablesConstants.size() - 1).getTv_lp() + 1);

        joinListViewModelKinematicsInverseVariablesConstants.add(joinListViewModelKinematicsInverseVariablesConstant);
    }
}
