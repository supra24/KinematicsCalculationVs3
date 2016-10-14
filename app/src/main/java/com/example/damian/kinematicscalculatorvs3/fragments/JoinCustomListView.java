package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.database.DatabaseHelper;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModel;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsSimple;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinCustomListView extends FragmentParent {

    private JoinListViewAdapter joinListViewAdapter;
    private ArrayList<JoinListViewModel> joinListViewModels = new ArrayList<>();
    private DatabaseHelper databaseHelper;


    public JoinCustomListView() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

//        JoinListViewModel joinListViewModel = new JoinListViewModel();
//        joinListViewModel.setTv_lp(0);
//        joinListViewModels.add(joinListViewModel);
//
//        JoinListViewModel joinListViewModel1 = new JoinListViewModel();
//        joinListViewModel1.setTv_lp(1);
//        joinListViewModels.add(joinListViewModel1);

//        databaseHelper = new DatabaseHelper(getContext());
//        joinListViewModels = databaseHelper.gerAllJoin();

        joinListViewModels = StaticVolumesJoinKinematicsSimple.getJoinListViewModels();

        joinListViewAdapter = new JoinListViewAdapter(getContext(), joinListViewModels);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsSimple.addJoin();

//        joinListViewModels.add(joinListViewModel);
//        databaseHelper.addJoin(joinListViewModel);
        joinListViewAdapter.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        StaticVolumesJoinKinematicsSimple.undoJoin();

        if (joinListViewModels.isEmpty()) {
            return false;
        } else {

            joinListViewModels.remove(joinListViewModels.size() - 1);
            joinListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }
}
