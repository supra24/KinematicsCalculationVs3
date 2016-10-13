package com.example.damian.kinematicscalculatorvs3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Damian on 2016-10-12.
 */

public abstract class FragmentParent extends Fragment {

    protected int layoutid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(layoutid, container, false);

        init(view);
        return view;
    }

    public abstract void init(View view);
}
