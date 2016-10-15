package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModel;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesJoinKinematicsSimple {

    private static ArrayList<JoinListViewModel> joinListViewModels = new ArrayList<>();

    public static ArrayList<JoinListViewModel> getJoinListViewModels() {
        return joinListViewModels;
    }

    public static void setOneJoinModel(JoinListViewModel joinListViewModel) {

        joinListViewModels.get(joinListViewModel.getTv_lp()).setEt_alpha(joinListViewModel.getEt_alpha());
        joinListViewModels.get(joinListViewModel.getTv_lp()).setEt_a(joinListViewModel.getEt_a());
        joinListViewModels.get(joinListViewModel.getTv_lp()).setEt_theta(joinListViewModel.getEt_theta());
        joinListViewModels.get(joinListViewModel.getTv_lp()).setEt_d(joinListViewModel.getEt_d());
    }

    public static void addJoin() {

        JoinListViewModel joinListViewModel = new JoinListViewModel();
        if (joinListViewModels.isEmpty())
            joinListViewModel.setTv_lp(0);
        else
            joinListViewModel.setTv_lp(joinListViewModels.get(joinListViewModels.size() - 1).getTv_lp() + 1);

        joinListViewModels.add(joinListViewModel);
    }
}
