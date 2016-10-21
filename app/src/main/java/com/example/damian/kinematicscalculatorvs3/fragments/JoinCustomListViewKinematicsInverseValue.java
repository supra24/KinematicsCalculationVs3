package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsForwardValueListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsInverseValueListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinCustomListViewKinematicsInverseValue extends FragmentParent {

    private JoinKinematicsInverseValueListViewAdapter joinKinematicsInverseValueListViewAdapter;
    private ArrayList<JoinListViewModelKinematicsInverseValue> joinListViewModelKinematicsInverseValues = new ArrayList<>();


    public JoinCustomListViewKinematicsInverseValue() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModelKinematicsInverseValues = StaticVolumesJoinKinematicsInverseValue.getJoinListViewModelKinematicsInverseValues();

        joinKinematicsInverseValueListViewAdapter = new JoinKinematicsInverseValueListViewAdapter(getContext(), joinListViewModelKinematicsInverseValues);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsInverseValueListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsForwardValue.addJoin();

        joinKinematicsInverseValueListViewAdapter.notifyDataSetInvalidated();
    }


    public boolean undoObject() {

        if (joinListViewModelKinematicsInverseValues.isEmpty()) {
            return false;
        } else {
            joinListViewModelKinematicsInverseValues.remove(joinListViewModelKinematicsInverseValues.size() - 1);
            joinKinematicsInverseValueListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }
}
