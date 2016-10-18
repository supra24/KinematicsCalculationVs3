package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsForwardListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModel;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsSimple;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinCustomListViewKinematicsForward extends FragmentParent {

    private JoinKinematicsForwardListViewAdapter joinKinematicsForwardListViewAdapter;
    private ArrayList<JoinListViewModel> joinListViewModels = new ArrayList<>();


    public JoinCustomListViewKinematicsForward() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModels = StaticVolumesJoinKinematicsSimple.getJoinListViewModels();

        joinKinematicsForwardListViewAdapter = new JoinKinematicsForwardListViewAdapter(getContext(), joinListViewModels);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsForwardListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsSimple.addJoin();

        joinKinematicsForwardListViewAdapter.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        if (joinListViewModels.isEmpty()) {
            return false;
        } else {
            joinListViewModels.remove(joinListViewModels.size() - 1);
            joinKinematicsForwardListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }
}
