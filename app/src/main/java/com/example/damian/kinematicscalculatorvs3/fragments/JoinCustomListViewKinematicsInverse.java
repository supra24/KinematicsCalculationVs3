package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsInverseVariablesConstantListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseVariablesConstant;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverse;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-18.
 */

public class JoinCustomListViewKinematicsInverse extends FragmentParent {

    private JoinKinematicsInverseVariablesConstantListViewAdapter joinKinematicsInverseVariablesConstantListViewAdapter;
    private ArrayList<JoinListViewModelKinematicsInverseVariablesConstant> joinListViewModelKinematicsInverseVariablesConstants = new ArrayList<>();

    public JoinCustomListViewKinematicsInverse() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModelKinematicsInverseVariablesConstants = StaticVolumesJoinKinematicsInverse.getJoinListViewModelKinematicsInverseVariablesConstants();

        joinKinematicsInverseVariablesConstantListViewAdapter = new JoinKinematicsInverseVariablesConstantListViewAdapter(getContext(), joinListViewModelKinematicsInverseVariablesConstants);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsInverseVariablesConstantListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsInverse.addJoin();

        joinKinematicsInverseVariablesConstantListViewAdapter.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (joinListViewModelKinematicsInverseVariablesConstants.isEmpty()) {
            return false;
        } else {
            joinListViewModelKinematicsInverseVariablesConstants.remove(joinListViewModelKinematicsInverseVariablesConstants.size() - 1);
            joinKinematicsInverseVariablesConstantListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }

}
