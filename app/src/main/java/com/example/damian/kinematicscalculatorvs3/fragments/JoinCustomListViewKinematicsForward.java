package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsForwardListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForward;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForward;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinCustomListViewKinematicsForward extends FragmentParent {

    private JoinKinematicsForwardListViewAdapter joinKinematicsForwardListViewAdapter;
    private ArrayList<JoinListViewModelKinematicsForward> joinListViewModelKinematicsForwards = new ArrayList<>();


    public JoinCustomListViewKinematicsForward() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModelKinematicsForwards = StaticVolumesJoinKinematicsForward.getJoinListViewModelKinematicsForwards();

        joinKinematicsForwardListViewAdapter = new JoinKinematicsForwardListViewAdapter(getContext(), joinListViewModelKinematicsForwards);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsForwardListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsForward.addJoin();

        joinKinematicsForwardListViewAdapter.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        if (joinListViewModelKinematicsForwards.isEmpty()) {
            return false;
        } else {
            joinListViewModelKinematicsForwards.remove(joinListViewModelKinematicsForwards.size() - 1);
            joinKinematicsForwardListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }
}
