package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterInverseVariablesConstantListView;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesConstant;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseVariablesConstant;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-18.
 */

public class FragmentListViewKinematicsInverseVariablesConstant extends FragmentParent {

    private AdapterInverseVariablesConstantListView adapterInverseVariablesConstantListView;
    private ArrayList<ModelKinematicsInverseVariablesConstant> modelKinematicsInverseVariablesConstants = new ArrayList<>();

    public FragmentListViewKinematicsInverseVariablesConstant() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        modelKinematicsInverseVariablesConstants = StaticVolumesJoinKinematicsInverseVariablesConstant.getModelKinematicsInverseVariablesConstants();

        adapterInverseVariablesConstantListView = new AdapterInverseVariablesConstantListView(getContext(), modelKinematicsInverseVariablesConstants);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(adapterInverseVariablesConstantListView);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsInverseVariablesConstant.addJoin();
        StaticVolumesJoinKinematicsInverseValue.addJoin();

        adapterInverseVariablesConstantListView.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (modelKinematicsInverseVariablesConstants.isEmpty()) {
            return false;
        } else {
            modelKinematicsInverseVariablesConstants.remove(modelKinematicsInverseVariablesConstants.size() - 1);
            StaticVolumesJoinKinematicsInverseValue.undo();
            adapterInverseVariablesConstantListView.notifyDataSetInvalidated();
            return true;
        }
    }

}
