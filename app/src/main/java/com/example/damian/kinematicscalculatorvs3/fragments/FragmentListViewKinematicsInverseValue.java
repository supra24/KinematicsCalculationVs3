package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterInverseValueListView;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class FragmentListViewKinematicsInverseValue extends FragmentParent {

    private AdapterInverseValueListView adapterInverseValueListView;
    private ArrayList<ModelKinematicsInverseValue> modelKinematicsInverseValues = new ArrayList<>();


    public FragmentListViewKinematicsInverseValue() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        modelKinematicsInverseValues = StaticVolumesJoinKinematicsInverseValue.getModelKinematicsInverseValues();

        adapterInverseValueListView = new AdapterInverseValueListView(getContext(), modelKinematicsInverseValues);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(adapterInverseValueListView);
    }

    public void addObjectJoin() {

//        StaticVolumesJoinKinematicsForwardValue.addJoin();
//
        adapterInverseValueListView.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        if (modelKinematicsInverseValues.isEmpty()) {
            return false;
        } else {
            modelKinematicsInverseValues.remove(modelKinematicsInverseValues.size() - 1);
            adapterInverseValueListView.notifyDataSetInvalidated();
            return true;
        }
    }
}
