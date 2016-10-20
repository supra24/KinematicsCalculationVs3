package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForward;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverse;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForward;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverse;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinKinematicsInverseListViewAdapter extends ArrayAdapter<JoinListViewModelKinematicsInverse> {


    private Context context;
    private ArrayList<JoinListViewModelKinematicsInverse> joinListViewModelKinematicsInverses;
    private LayoutInflater inflater;

    public JoinKinematicsInverseListViewAdapter(Context context, ArrayList<JoinListViewModelKinematicsInverse> items) {
        super(context, R.layout.custom_join_list_view_kinematics_forward, items);

        this.context = context;
        this.joinListViewModelKinematicsInverses = items;

    }

    @Override
    public int getCount() {
        if (joinListViewModelKinematicsInverses == null)
            return 0;
        else
            return joinListViewModelKinematicsInverses.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ListViewHolder {

        TextView textViewlp;
        ToggleButton togglebuttonalpha;
        ToggleButton togglebuttona;
        ToggleButton togglebuttontheta;
        ToggleButton togglebuttond;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ListViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ListViewHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_join_list_view_kinematics_inverse, null);

            listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_inverse);
            listViewHolder.togglebuttonalpha = (ToggleButton) convertView.findViewById(R.id.b_list_view_alpha);
            listViewHolder.togglebuttona = (ToggleButton) convertView.findViewById(R.id.b_list_view_a);
            listViewHolder.togglebuttontheta = (ToggleButton) convertView.findViewById(R.id.b_list_view_theta);
            listViewHolder.togglebuttond = (ToggleButton) convertView.findViewById(R.id.b_list_view_d);

            convertView.setTag(listViewHolder);

        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.textViewlp.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getTv_lp()));
        listViewHolder.togglebuttonalpha.setChecked(joinListViewModelKinematicsInverses.get(position).getEt_alpha());
        listViewHolder.togglebuttona.setChecked(joinListViewModelKinematicsInverses.get(position).getEt_a());
        listViewHolder.togglebuttontheta.setChecked(joinListViewModelKinematicsInverses.get(position).getEt_theta());
        listViewHolder.togglebuttond.setChecked(joinListViewModelKinematicsInverses.get(position).getEt_d());

//        listViewHolder.togglebuttonalpha.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_alpha()));
//        listViewHolder.togglebuttona.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_a()));
//        listViewHolder.togglebuttontheta.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_theta()));
//        listViewHolder.togglebuttond.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_d()));

        listViewHolder.togglebuttonalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttonalpha.setChecked(!joinListViewModelKinematicsInverses.get(position).getEt_alpha());
                joinListViewModelKinematicsInverses.get(position).setEt_alpha(!joinListViewModelKinematicsInverses.get(position).getEt_alpha());
            }
        });

        listViewHolder.togglebuttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttona.setChecked(!joinListViewModelKinematicsInverses.get(position).getEt_a());
                joinListViewModelKinematicsInverses.get(position).setEt_a(!joinListViewModelKinematicsInverses.get(position).getEt_a());
            }
        });

        listViewHolder.togglebuttontheta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttontheta.setChecked(!joinListViewModelKinematicsInverses.get(position).getEt_theta());
                joinListViewModelKinematicsInverses.get(position).setEt_theta(!joinListViewModelKinematicsInverses.get(position).getEt_theta());
            }
        });

        listViewHolder.togglebuttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttond.setChecked(!joinListViewModelKinematicsInverses.get(position).getEt_d());
                joinListViewModelKinematicsInverses.get(position).setEt_d(!joinListViewModelKinematicsInverses.get(position).getEt_d());
            }
        });

        JoinListViewModelKinematicsInverse joinListViewModelKinematicsInverse = new JoinListViewModelKinematicsInverse();
        joinListViewModelKinematicsInverse.setTv_lp(position);
        joinListViewModelKinematicsInverse.setEt_alpha(joinListViewModelKinematicsInverses.get(position).getEt_alpha());
        joinListViewModelKinematicsInverse.setEt_a(joinListViewModelKinematicsInverses.get(position).getEt_a());
        joinListViewModelKinematicsInverse.setEt_theta(joinListViewModelKinematicsInverses.get(position).getEt_theta());
        joinListViewModelKinematicsInverse.setEt_d(joinListViewModelKinematicsInverses.get(position).getEt_d());

        StaticVolumesJoinKinematicsInverse.setOneJoinModel(joinListViewModelKinematicsInverse);
        return convertView;
    }
}

