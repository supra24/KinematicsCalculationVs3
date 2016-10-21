package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverseVariablesConstant;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseVariablesConstant;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinKinematicsInverseVariablesConstantListViewAdapter extends ArrayAdapter<JoinListViewModelKinematicsInverseVariablesConstant> {


    private Context context;
    private ArrayList<JoinListViewModelKinematicsInverseVariablesConstant> joinListViewModelKinematicsInverseVariablesConstants;
    private LayoutInflater inflater;

    public JoinKinematicsInverseVariablesConstantListViewAdapter(Context context, ArrayList<JoinListViewModelKinematicsInverseVariablesConstant> items) {
        super(context, R.layout.custom_join_list_view_value_kinematics, items);

        this.context = context;
        this.joinListViewModelKinematicsInverseVariablesConstants = items;

    }

    @Override
    public int getCount() {
        if (joinListViewModelKinematicsInverseVariablesConstants == null)
            return 0;
        else
            return joinListViewModelKinematicsInverseVariablesConstants.size();
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

        listViewHolder.textViewlp.setText(String.valueOf(joinListViewModelKinematicsInverseVariablesConstants.get(position).getTv_lp()));
        listViewHolder.togglebuttonalpha.setChecked(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
        listViewHolder.togglebuttona.setChecked(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_a());
        listViewHolder.togglebuttontheta.setChecked(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_theta());
        listViewHolder.togglebuttond.setChecked(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_d());

        listViewHolder.togglebuttonalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttonalpha.setChecked(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
                joinListViewModelKinematicsInverseVariablesConstants.get(position).setEt_alpha(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
            }
        });

        listViewHolder.togglebuttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttona.setChecked(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_a());
                joinListViewModelKinematicsInverseVariablesConstants.get(position).setEt_a(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_a());
            }
        });

        listViewHolder.togglebuttontheta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttontheta.setChecked(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_theta());
                joinListViewModelKinematicsInverseVariablesConstants.get(position).setEt_theta(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_theta());
            }
        });

        listViewHolder.togglebuttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttond.setChecked(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_d());
                joinListViewModelKinematicsInverseVariablesConstants.get(position).setEt_d(!joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_d());
            }
        });

        JoinListViewModelKinematicsInverseVariablesConstant joinListViewModelKinematicsInverseVariablesConstant = new JoinListViewModelKinematicsInverseVariablesConstant();
        joinListViewModelKinematicsInverseVariablesConstant.setTv_lp(position);
        joinListViewModelKinematicsInverseVariablesConstant.setEt_alpha(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
        joinListViewModelKinematicsInverseVariablesConstant.setEt_a(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_a());
        joinListViewModelKinematicsInverseVariablesConstant.setEt_theta(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_theta());
        joinListViewModelKinematicsInverseVariablesConstant.setEt_d(joinListViewModelKinematicsInverseVariablesConstants.get(position).getEt_d());

        StaticVolumesJoinKinematicsInverseVariablesConstant.setOneJoinModel(joinListViewModelKinematicsInverseVariablesConstant);

        JoinListViewModelKinematicsInverseValue joinListViewModelKinematicsInverseValue = new JoinListViewModelKinematicsInverseValue();
        joinListViewModelKinematicsInverseValue.setTv_lp(position);


        return convertView;
    }
}

