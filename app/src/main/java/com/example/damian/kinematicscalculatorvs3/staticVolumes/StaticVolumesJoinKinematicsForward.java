package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForwardValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsForward {

    private static ArrayList<JoinListViewModelKinematicsForwardValue> joinListViewModelKinematicsForwardValues = new ArrayList<>();

    public static ArrayList<JoinListViewModelKinematicsForwardValue> getJoinListViewModelKinematicsForwardValues() {
        return joinListViewModelKinematicsForwardValues;
    }

    public static void setOneJoinModel(JoinListViewModelKinematicsForwardValue joinListViewModelKinematicsForwardValue) {

        joinListViewModelKinematicsForwardValues.get(joinListViewModelKinematicsForwardValue.getTv_lp()).setEt_alpha(joinListViewModelKinematicsForwardValue.getEt_alpha());
        joinListViewModelKinematicsForwardValues.get(joinListViewModelKinematicsForwardValue.getTv_lp()).setEt_a(joinListViewModelKinematicsForwardValue.getEt_a());
        joinListViewModelKinematicsForwardValues.get(joinListViewModelKinematicsForwardValue.getTv_lp()).setEt_theta(joinListViewModelKinematicsForwardValue.getEt_theta());
        joinListViewModelKinematicsForwardValues.get(joinListViewModelKinematicsForwardValue.getTv_lp()).setEt_d(joinListViewModelKinematicsForwardValue.getEt_d());
    }

    public static void addJoin() {

        JoinListViewModelKinematicsForwardValue joinListViewModelKinematicsForwardValue = new JoinListViewModelKinematicsForwardValue();
        if (joinListViewModelKinematicsForwardValues.isEmpty())
            joinListViewModelKinematicsForwardValue.setTv_lp(1);
        else
            joinListViewModelKinematicsForwardValue.setTv_lp(joinListViewModelKinematicsForwardValues.get(joinListViewModelKinematicsForwardValues.size() - 1).getTv_lp() + 1);

        joinListViewModelKinematicsForwardValues.add(joinListViewModelKinematicsForwardValue);
    }
}
