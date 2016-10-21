package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsInverseValue {

    private static ArrayList<JoinListViewModelKinematicsInverseValue> joinListViewModelKinematicsInverseValues= new ArrayList<>();

    public static ArrayList<JoinListViewModelKinematicsInverseValue> getJoinListViewModelKinematicsInverseValues() {
        return joinListViewModelKinematicsInverseValues;
    }

    public static void setOneJoinModel(JoinListViewModelKinematicsInverseValue joinListViewModelKinematicsInverseValue) {

        joinListViewModelKinematicsInverseValues.get(joinListViewModelKinematicsInverseValue.getTv_lp()).setEt_alpha(joinListViewModelKinematicsInverseValue.getEt_alpha());
        joinListViewModelKinematicsInverseValues.get(joinListViewModelKinematicsInverseValue.getTv_lp()).setEt_a(joinListViewModelKinematicsInverseValue.getEt_a());
        joinListViewModelKinematicsInverseValues.get(joinListViewModelKinematicsInverseValue.getTv_lp()).setEt_theta(joinListViewModelKinematicsInverseValue.getEt_theta());
        joinListViewModelKinematicsInverseValues.get(joinListViewModelKinematicsInverseValue.getTv_lp()).setEt_d(joinListViewModelKinematicsInverseValue.getEt_d());
    }

    public static void addJoin() {

        JoinListViewModelKinematicsInverseValue joinListViewModelKinematicsInverseValue = new JoinListViewModelKinematicsInverseValue();
        if (joinListViewModelKinematicsInverseValues.isEmpty())
            joinListViewModelKinematicsInverseValue.setTv_lp(1);
        else
            joinListViewModelKinematicsInverseValue.setTv_lp(joinListViewModelKinematicsInverseValues.get(joinListViewModelKinematicsInverseValues.size() - 1).getTv_lp() + 1);

        joinListViewModelKinematicsInverseValues.add(joinListViewModelKinematicsInverseValue);
    }
}
