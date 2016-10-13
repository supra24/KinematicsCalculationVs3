package com.example.damian.kinematicscalculatorvs3.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinListViewAdapter;
import com.example.damian.kinematicscalculatorvs3.adapters.JoinListViewModel;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinCustomListView extends FragmentParent {

    private JoinListViewAdapter joinListViewAdapter;

    public JoinCustomListView(){
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        ArrayList<JoinListViewModel> joinListViewModels = new ArrayList<>();
        JoinListViewModel joinListViewModel = new JoinListViewModel();
        joinListViewModel.setTv_lp(0);
        joinListViewModels.add(joinListViewModel);
//
        JoinListViewModel joinListViewModel1 = new JoinListViewModel();
        joinListViewModel1.setTv_lp(1);
        joinListViewModels.add(joinListViewModel1);

        joinListViewAdapter = new JoinListViewAdapter(getContext(), joinListViewModels);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(joinListViewAdapter);
    }
}
