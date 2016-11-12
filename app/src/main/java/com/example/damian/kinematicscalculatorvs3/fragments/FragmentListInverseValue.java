package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterForwardValue;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterInverseValue;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class FragmentListInverseValue extends FragmentParent {

    private AdapterInverseValue adapterForwardValue;
    private ArrayList<ModelKinematicsInverseValueParent> kinematicsInverseValueParents = new ArrayList<>();

    public FragmentListInverseValue(){
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        kinematicsInverseValueParents = StaticVolumesKinematicsInverseValue.getModels();

        adapterForwardValue = new AdapterInverseValue(getContext(), kinematicsInverseValueParents);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(adapterForwardValue);

    }

//    public void addObjectJoin(int typeObject) {
//
//        StaticVolumesKinematicsForwardValue.addObjects(typeObject);
//
//        adapterForwardValue.notifyDataSetInvalidated();
//    }

//    public boolean undoObject() {
//
//        if (modelKinematicsForwardValueParents.isEmpty()) {
//            return false;
//        } else {
//            modelKinematicsForwardValueParents.remove(modelKinematicsForwardValueParents.size() - 1);
//            adapterForwardValue.notifyDataSetInvalidated();
//            return true;
//        }
//    }
}
