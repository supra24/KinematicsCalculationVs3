package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterForward;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterInverseVariables;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablwsParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesInverseVariables;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForwardValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class FragmentListInverseVariables extends FragmentParent {

    private AdapterInverseVariables adapterInverseVariables;
    private ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents = new ArrayList<>();

    public FragmentListInverseVariables(){
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        modelKinematicsInverseVariablwsParents = StaticVolumesInverseVariables.getModels();

        adapterInverseVariables = new AdapterInverseVariables(getContext(), modelKinematicsInverseVariablwsParents);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(adapterInverseVariables);

    }

    public void addObjectJoin(int typeObject) {

        StaticVolumesInverseVariables.addObjects(typeObject);

        adapterInverseVariables.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (modelKinematicsInverseVariablwsParents.isEmpty()) {
            return false;
        } else {
            modelKinematicsInverseVariablwsParents.remove(modelKinematicsInverseVariablwsParents.size() - 1);
            adapterInverseVariables.notifyDataSetInvalidated();
            return true;
        }
    }
}
