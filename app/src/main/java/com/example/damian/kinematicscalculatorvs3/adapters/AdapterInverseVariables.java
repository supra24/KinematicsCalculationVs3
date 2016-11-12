package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablwsParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesInverseVariables;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForwardValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */


public class AdapterInverseVariables extends ArrayAdapter<ModelKinematicsInverseVariablwsParent> {

    private Context context;
    private ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents;
    private LayoutInflater inflater;

    public AdapterInverseVariables(Context context, ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents) {
        super(context, 0, modelKinematicsInverseVariablwsParents);

        this.context = context;
        this.modelKinematicsInverseVariablwsParents = modelKinematicsInverseVariablwsParents;
    }

    @Override
    public int getCount() {

        if (modelKinematicsInverseVariablwsParents == null)
            return 0;
        else
            return modelKinematicsInverseVariablwsParents.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return modelKinematicsInverseVariablwsParents.get(position).getTypeObject();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    public class ListViewHolder {

        // model join
        TextView textViewlp;
        ToggleButton togglealpha;
        ToggleButton togglea;
        ToggleButton toggletheta;
        ToggleButton toggled;

        // model effector
        ToggleButton toggleX;
        ToggleButton toggleY;
        ToggleButton toggleZ;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ListViewHolder listViewHolder;

        listViewHolder = new ListViewHolder();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        switch (getItemViewType(position)) {
            case 1: {
                convertView = inflater.inflate(R.layout.model_kinematics_inverse_join, parent, false);
                convertView.setTag(listViewHolder);
            }
            break;
            case 2: {
                convertView = inflater.inflate(R.layout.model_kinematics_inverse_effector, parent, false);
                convertView.setTag(listViewHolder);
            }
            break;
        }

        switch (getItemViewType(position)) {
            case 1: {

                listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_inverse);
                listViewHolder.togglealpha = (ToggleButton) convertView.findViewById(R.id.list_view_join_alpha_inverse);
                listViewHolder.togglea = (ToggleButton) convertView.findViewById(R.id.list_view_join_a_inverse);
                listViewHolder.toggletheta = (ToggleButton) convertView.findViewById(R.id.list_view_join_theta_inverse);
                listViewHolder.toggled = (ToggleButton) convertView.findViewById(R.id.list_view_join_d_inverse);

                final ModelKinematicsInverseVariablesJoin modelKinematicsInverseVariablesJoin = (ModelKinematicsInverseVariablesJoin) modelKinematicsInverseVariablwsParents.get(position);

                listViewHolder.textViewlp.setText(String.valueOf(modelKinematicsInverseVariablesJoin.getTv_lp()));
                listViewHolder.togglealpha.setChecked(modelKinematicsInverseVariablesJoin.isEt_alpha());
                listViewHolder.togglea.setChecked(modelKinematicsInverseVariablesJoin.isEt_a());
                listViewHolder.toggletheta.setChecked(modelKinematicsInverseVariablesJoin.isEt_theta());
                listViewHolder.toggled.setChecked(modelKinematicsInverseVariablesJoin.isEt_d());

                ToggleButton.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ModelKinematicsInverseVariablesJoin model = new ModelKinematicsInverseVariablesJoin(position);
                        model.setEt_alpha(listViewHolder.togglealpha.isChecked());
                        model.setEt_a(listViewHolder.togglea.isChecked());
                        model.setEt_theta(listViewHolder.toggletheta.isChecked());
                        model.setEt_d(listViewHolder.toggled.isChecked());

                        StaticVolumesInverseVariables.setOneModel(model);
                    }
                };

                listViewHolder.togglealpha.setOnClickListener(onClickListener);
                listViewHolder.togglea.setOnClickListener(onClickListener);
                listViewHolder.toggletheta.setOnClickListener(onClickListener);
                listViewHolder.toggled.setOnClickListener(onClickListener);
            }
            break;
            case 2: {

                listViewHolder.toggleX = (ToggleButton) convertView.findViewById(R.id.model_inverse_effector_toggle_x);
                listViewHolder.toggleY = (ToggleButton) convertView.findViewById(R.id.model_inverse_effector_toggle_y);
                listViewHolder.toggleZ = (ToggleButton) convertView.findViewById(R.id.model_inverse_effector_toggle_z);

                ModelKinematicsInverseVariablesEffector modelKinematicsInverseVariablesEffector = (ModelKinematicsInverseVariablesEffector) modelKinematicsInverseVariablwsParents.get(position);
                listViewHolder.toggleX.setChecked(modelKinematicsInverseVariablesEffector.isEt_x());
                listViewHolder.toggleY.setChecked(modelKinematicsInverseVariablesEffector.isEt_y());
                listViewHolder.toggleZ.setChecked(modelKinematicsInverseVariablesEffector.isEt_z());

                ToggleButton.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ModelKinematicsInverseVariablesEffector model = new ModelKinematicsInverseVariablesEffector(position);
                        model.setEt_x(listViewHolder.toggleX.isChecked());
                        model.setEt_y(listViewHolder.toggleY.isChecked());
                        model.setEt_z(listViewHolder.toggleZ.isChecked());

                        StaticVolumesInverseVariables.setOneModel(model);
                    }
                };

                listViewHolder.toggleX.setOnClickListener(onClickListener);
                listViewHolder.toggleY.setOnClickListener(onClickListener);
                listViewHolder.toggleZ.setOnClickListener(onClickListener);
            }
            break;
        }

        return convertView;
    }
}
