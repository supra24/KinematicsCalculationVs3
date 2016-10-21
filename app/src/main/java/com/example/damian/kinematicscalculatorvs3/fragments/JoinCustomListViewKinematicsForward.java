package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsForwardValueListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForward;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinCustomListViewKinematicsForward extends FragmentParent {

    private JoinKinematicsForwardValueListViewAdapter joinKinematicsForwardValueListViewAdapter;
    private ArrayList<JoinListViewModelKinematicsForwardValue> joinListViewModelKinematicsForwardValues = new ArrayList<>();


    public JoinCustomListViewKinematicsForward() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModelKinematicsForwardValues = StaticVolumesJoinKinematicsForward.getJoinListViewModelKinematicsForwardValues();

        joinKinematicsForwardValueListViewAdapter = new JoinKinematicsForwardValueListViewAdapter(getContext(), joinListViewModelKinematicsForwardValues);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsForwardValueListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsForward.addJoin();

        joinKinematicsForwardValueListViewAdapter.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        if (joinListViewModelKinematicsForwardValues.isEmpty()) {
            return false;
        } else {
            joinListViewModelKinematicsForwardValues.remove(joinListViewModelKinematicsForwardValues.size() - 1);
            joinKinematicsForwardValueListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }
}
