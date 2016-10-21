package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsInverseVariablesConstantListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseVariablesConstant;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseVariablesConstant;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-18.
 */

public class JoinCustomListViewKinematicsInverseVariablesConstant extends FragmentParent {

    private JoinKinematicsInverseVariablesConstantListViewAdapter joinKinematicsInverseVariablesConstantListViewAdapter;
    private ArrayList<JoinListViewModelKinematicsInverseVariablesConstant> joinListViewModelKinematicsInverseVariablesConstants = new ArrayList<>();

    public JoinCustomListViewKinematicsInverseVariablesConstant() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModelKinematicsInverseVariablesConstants = StaticVolumesJoinKinematicsInverseVariablesConstant.getJoinListViewModelKinematicsInverseVariablesConstants();

        joinKinematicsInverseVariablesConstantListViewAdapter = new JoinKinematicsInverseVariablesConstantListViewAdapter(getContext(), joinListViewModelKinematicsInverseVariablesConstants);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsInverseVariablesConstantListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsInverseVariablesConstant.addJoin();
        StaticVolumesJoinKinematicsInverseValue.addJoin();

        joinKinematicsInverseVariablesConstantListViewAdapter.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (joinListViewModelKinematicsInverseVariablesConstants.isEmpty()) {
            return false;
        } else {
            joinListViewModelKinematicsInverseVariablesConstants.remove(joinListViewModelKinematicsInverseVariablesConstants.size() - 1);
            StaticVolumesJoinKinematicsInverseValue.undo();
            joinKinematicsInverseVariablesConstantListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }

}
