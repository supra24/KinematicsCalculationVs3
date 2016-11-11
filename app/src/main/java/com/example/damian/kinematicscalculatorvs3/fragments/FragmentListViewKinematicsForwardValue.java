package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterForwardValueListView;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForwardValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class FragmentListViewKinematicsForwardValue extends FragmentParent {

    private AdapterForwardValueListView adapterForwardValueListView;
    private ArrayList<ModelKinematicsForwardValue> modelKinematicsForwardValues = new ArrayList<>();


    public FragmentListViewKinematicsForwardValue() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        modelKinematicsForwardValues = StaticVolumesJoinKinematicsForwardValue.getModelKinematicsForwardValues();

        adapterForwardValueListView = new AdapterForwardValueListView(getContext(), modelKinematicsForwardValues);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(adapterForwardValueListView);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsForwardValue.addJoin();

        adapterForwardValueListView.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        if (modelKinematicsForwardValues.isEmpty()) {
            return false;
        } else {
            modelKinematicsForwardValues.remove(modelKinematicsForwardValues.size() - 1);
            adapterForwardValueListView.notifyDataSetInvalidated();
            return true;
        }
    }
}
