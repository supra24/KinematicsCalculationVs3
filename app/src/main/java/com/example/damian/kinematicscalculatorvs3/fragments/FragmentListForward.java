package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.AdapterForward;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForward;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class FragmentListForward extends FragmentParent {

    private AdapterForward adapterForward;
    private ArrayList<ModelKinematicsForwardValueParent> modelKinematicsForwardValueParents = new ArrayList<>();

    public FragmentListForward(){
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        modelKinematicsForwardValueParents = StaticVolumesKinematicsForward.getModels();

        adapterForward = new AdapterForward(getContext(), modelKinematicsForwardValueParents);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(adapterForward);

    }

    public void addObjectJoin(int typeObject) {

        StaticVolumesKinematicsForward.addObjects(typeObject);

        adapterForward.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (modelKinematicsForwardValueParents.isEmpty()) {
            return false;
        } else {
            modelKinematicsForwardValueParents.remove(modelKinematicsForwardValueParents.size() - 1);
            adapterForward.notifyDataSetInvalidated();
            return true;
        }
    }
}
