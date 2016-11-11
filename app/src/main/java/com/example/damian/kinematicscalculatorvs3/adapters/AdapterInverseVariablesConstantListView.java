package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesConstant;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseVariablesConstant;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class AdapterInverseVariablesConstantListView extends ArrayAdapter<ModelKinematicsInverseVariablesConstant> {


    private Context context;
    private ArrayList<ModelKinematicsInverseVariablesConstant> modelKinematicsInverseVariablesConstants;
    private LayoutInflater inflater;

    public AdapterInverseVariablesConstantListView(Context context, ArrayList<ModelKinematicsInverseVariablesConstant> items) {
        super(context, R.layout.custom_join_list_view_value_kinematics, items);

        this.context = context;
        this.modelKinematicsInverseVariablesConstants = items;

    }

    @Override
    public int getCount() {
        if (modelKinematicsInverseVariablesConstants == null)
            return 0;
        else
            return modelKinematicsInverseVariablesConstants.size();
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

        listViewHolder.textViewlp.setText(String.valueOf(modelKinematicsInverseVariablesConstants.get(position).getTv_lp()));
        listViewHolder.togglebuttonalpha.setChecked(modelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
        listViewHolder.togglebuttona.setChecked(modelKinematicsInverseVariablesConstants.get(position).getEt_a());
        listViewHolder.togglebuttontheta.setChecked(modelKinematicsInverseVariablesConstants.get(position).getEt_theta());
        listViewHolder.togglebuttond.setChecked(modelKinematicsInverseVariablesConstants.get(position).getEt_d());

        listViewHolder.togglebuttonalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttonalpha.setChecked(!modelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
                modelKinematicsInverseVariablesConstants.get(position).setEt_alpha(!modelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
            }
        });

        listViewHolder.togglebuttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttona.setChecked(!modelKinematicsInverseVariablesConstants.get(position).getEt_a());
                modelKinematicsInverseVariablesConstants.get(position).setEt_a(!modelKinematicsInverseVariablesConstants.get(position).getEt_a());
            }
        });

        listViewHolder.togglebuttontheta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttontheta.setChecked(!modelKinematicsInverseVariablesConstants.get(position).getEt_theta());
                modelKinematicsInverseVariablesConstants.get(position).setEt_theta(!modelKinematicsInverseVariablesConstants.get(position).getEt_theta());
            }
        });

        listViewHolder.togglebuttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewHolder.togglebuttond.setChecked(!modelKinematicsInverseVariablesConstants.get(position).getEt_d());
                modelKinematicsInverseVariablesConstants.get(position).setEt_d(!modelKinematicsInverseVariablesConstants.get(position).getEt_d());
            }
        });

        ModelKinematicsInverseVariablesConstant modelKinematicsInverseVariablesConstant = new ModelKinematicsInverseVariablesConstant();
        modelKinematicsInverseVariablesConstant.setTv_lp(position);
        modelKinematicsInverseVariablesConstant.setEt_alpha(modelKinematicsInverseVariablesConstants.get(position).getEt_alpha());
        modelKinematicsInverseVariablesConstant.setEt_a(modelKinematicsInverseVariablesConstants.get(position).getEt_a());
        modelKinematicsInverseVariablesConstant.setEt_theta(modelKinematicsInverseVariablesConstants.get(position).getEt_theta());
        modelKinematicsInverseVariablesConstant.setEt_d(modelKinematicsInverseVariablesConstants.get(position).getEt_d());

        StaticVolumesJoinKinematicsInverseVariablesConstant.setOneJoinModel(modelKinematicsInverseVariablesConstant);

        ModelKinematicsInverseValue modelKinematicsInverseValue = new ModelKinematicsInverseValue();
        modelKinematicsInverseValue.setTv_lp(position);


        return convertView;
    }
}

