package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinKinematicsInverseListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverse;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverse;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-18.
 */

public class JoinCustomListViewKinematicsInverse extends FragmentParent {

    private JoinKinematicsInverseListViewAdapter joinKinematicsInverseListViewAdapter;
    private ArrayList<JoinListViewModelKinematicsInverse> joinListViewModelKinematicsInverses = new ArrayList<>();

    public JoinCustomListViewKinematicsInverse() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        joinListViewModelKinematicsInverses = StaticVolumesJoinKinematicsInverse.getJoinListViewModelKinematicsInverses();

        joinKinematicsInverseListViewAdapter = new JoinKinematicsInverseListViewAdapter(getContext(), joinListViewModelKinematicsInverses);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinKinematicsInverseListViewAdapter);
    }

    public void addObjectJoin() {

        StaticVolumesJoinKinematicsInverse.addJoin();

        joinKinematicsInverseListViewAdapter.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (joinListViewModelKinematicsInverses.isEmpty()) {
            return false;
        } else {
            joinListViewModelKinematicsInverses.remove(joinListViewModelKinematicsInverses.size() - 1);
            joinKinematicsInverseListViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }

}
