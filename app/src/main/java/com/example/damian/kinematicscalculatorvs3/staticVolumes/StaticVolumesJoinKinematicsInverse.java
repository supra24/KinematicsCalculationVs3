package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForward;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverse;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsInverse {

    private static ArrayList<JoinListViewModelKinematicsInverse> joinListViewModelKinematicsInverses = new ArrayList<>();

    public static ArrayList<JoinListViewModelKinematicsInverse> getJoinListViewModelKinematicsInverses() {
        return joinListViewModelKinematicsInverses;
    }

    public static void setOneJoinModel(JoinListViewModelKinematicsInverse joinListViewModelKinematicsInverse) {

        joinListViewModelKinematicsInverses.get(joinListViewModelKinematicsInverse.getTv_lp()).setEt_alpha(joinListViewModelKinematicsInverse.getEt_alpha());
        joinListViewModelKinematicsInverses.get(joinListViewModelKinematicsInverse.getTv_lp()).setEt_a(joinListViewModelKinematicsInverse.getEt_a());
        joinListViewModelKinematicsInverses.get(joinListViewModelKinematicsInverse.getTv_lp()).setEt_theta(joinListViewModelKinematicsInverse.getEt_theta());
        joinListViewModelKinematicsInverses.get(joinListViewModelKinematicsInverse.getTv_lp()).setEt_d(joinListViewModelKinematicsInverse.getEt_d());
    }


    public static void addJoin() {

        JoinListViewModelKinematicsInverse joinListViewModelKinematicsInverse = new JoinListViewModelKinematicsInverse();
        if (joinListViewModelKinematicsInverses.isEmpty())
            joinListViewModelKinematicsInverse.setTv_lp(1);
        else
            joinListViewModelKinematicsInverse.setTv_lp(joinListViewModelKinematicsInverses.get(joinListViewModelKinematicsInverses.size() - 1).getTv_lp() + 1);

        joinListViewModelKinematicsInverses.add(joinListViewModelKinematicsInverse);
    }
}
