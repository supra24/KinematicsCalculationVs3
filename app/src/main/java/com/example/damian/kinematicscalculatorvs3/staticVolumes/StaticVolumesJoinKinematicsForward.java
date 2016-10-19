package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForward;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsForward {

    private static ArrayList<JoinListViewModelKinematicsForward> joinListViewModelKinematicsForwards = new ArrayList<>();

    public static ArrayList<JoinListViewModelKinematicsForward> getJoinListViewModelKinematicsForwards() {
        return joinListViewModelKinematicsForwards;
    }

    public static void setOneJoinModel(JoinListViewModelKinematicsForward joinListViewModelKinematicsForward) {

        joinListViewModelKinematicsForwards.get(joinListViewModelKinematicsForward.getTv_lp()).setEt_alpha(joinListViewModelKinematicsForward.getEt_alpha());
        joinListViewModelKinematicsForwards.get(joinListViewModelKinematicsForward.getTv_lp()).setEt_a(joinListViewModelKinematicsForward.getEt_a());
        joinListViewModelKinematicsForwards.get(joinListViewModelKinematicsForward.getTv_lp()).setEt_theta(joinListViewModelKinematicsForward.getEt_theta());
        joinListViewModelKinematicsForwards.get(joinListViewModelKinematicsForward.getTv_lp()).setEt_d(joinListViewModelKinematicsForward.getEt_d());
    }

    public static void addJoin() {

        JoinListViewModelKinematicsForward joinListViewModelKinematicsForward = new JoinListViewModelKinematicsForward();
        if (joinListViewModelKinematicsForwards.isEmpty())
            joinListViewModelKinematicsForward.setTv_lp(1);
        else
            joinListViewModelKinematicsForward.setTv_lp(joinListViewModelKinematicsForwards.get(joinListViewModelKinematicsForwards.size() - 1).getTv_lp() + 1);

        joinListViewModelKinematicsForwards.add(joinListViewModelKinematicsForward);
    }
}
