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

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */


public class AdapterInverseValue extends ArrayAdapter<ModelKinematicsInverseValueParent> {

    private Context context;
    private ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents;
    private LayoutInflater inflater;

    public AdapterInverseValue(Context context, ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents) {
        super(context, 0, modelKinematicsInverseValueParents);

        this.context = context;
        this.modelKinematicsInverseValueParents = modelKinematicsInverseValueParents;
    }

    @Override
    public int getCount() {

        if (modelKinematicsInverseValueParents == null)
            return 0;
        else
            return modelKinematicsInverseValueParents.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return modelKinematicsInverseValueParents.get(position).getTypeObject();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    public class ListViewHolder {

        // model join
        TextView textViewlp;
        EditText editalpha;
        EditText edita;
        EditText edittheta;
        EditText editd;

        // model effector
        EditText editX;
        EditText editY;
        EditText editZ;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ListViewHolder listViewHolder;

        listViewHolder = new ListViewHolder();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        switch (getItemViewType(position)) {
            case 1: {
                convertView = inflater.inflate(R.layout.model_kinematics_inverse_value_join, parent, false);
                convertView.setTag(listViewHolder);
            }
            break;
            case 2: {
                convertView = inflater.inflate(R.layout.model_kinematics_inverse_value_effector, parent, false);
                convertView.setTag(listViewHolder);
            }
            break;
        }

        switch (getItemViewType(position)) {
            case 1: {

                listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_inverse_value);
                listViewHolder.editalpha = (EditText) convertView.findViewById(R.id.list_view_join_alpha_inverse_value);
                listViewHolder.edita = (EditText) convertView.findViewById(R.id.list_view_join_a_inverse_value);
                listViewHolder.edittheta = (EditText) convertView.findViewById(R.id.list_view_join_theta_inverse_value);
                listViewHolder.editd = (EditText) convertView.findViewById(R.id.list_view_join_d_inverse_value);

                final ModelKinematicsInverseValueJoin modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(position);

                listViewHolder.textViewlp.setText(String.valueOf(modelKinematicsInverseValueJoin.getTv_lp()));
                listViewHolder.editalpha.setText(String.valueOf(modelKinematicsInverseValueJoin.getEt_alpha()));
                listViewHolder.edita.setText(String.valueOf(modelKinematicsInverseValueJoin.getEt_a()));
                listViewHolder.edittheta.setText(String.valueOf(modelKinematicsInverseValueJoin.getEt_theta()));
                listViewHolder.editd.setText(String.valueOf(modelKinematicsInverseValueJoin.getEt_d()));

                TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {

                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                        ModelKinematicsInverseValueJoin model = new ModelKinematicsInverseValueJoin(position);
                        model.setTv_lp(modelKinematicsInverseValueJoin.getTv_lp());
                        model.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
                        model.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
                        model.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
                        model.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));

                        StaticVolumesKinematicsInverseValue.setOneModel(model);
                        return false;
                    }
                };

                listViewHolder.editalpha.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.edita.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.edittheta.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.editd.setOnEditorActionListener(onEditorActionListener);
            }
            break;
            case 2: {

                listViewHolder.editX = (EditText) convertView.findViewById(R.id.model_inverse_value_effector_edit_text_x);
                listViewHolder.editY = (EditText) convertView.findViewById(R.id.model_inverse_value_effector_edit_text_y);
                listViewHolder.editZ = (EditText) convertView.findViewById(R.id.model_inverse_value_effector_edit_text_z);

                ModelKinematicsInverseValueEffector kinematicsInverseValueEffector = (ModelKinematicsInverseValueEffector) modelKinematicsInverseValueParents.get(position);

                listViewHolder.editX.setText(String.valueOf(kinematicsInverseValueEffector.getEt_x()));
                listViewHolder.editY.setText(String.valueOf(kinematicsInverseValueEffector.getEt_y()));
                listViewHolder.editZ.setText(String.valueOf(kinematicsInverseValueEffector.getEt_z()));

                TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {

                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                        ModelKinematicsInverseValueEffector model = new ModelKinematicsInverseValueEffector(position);
                        model.setEt_x(Integer.parseInt(listViewHolder.editX.getText().toString()));
                        model.setEt_y(Integer.parseInt(listViewHolder.editY.getText().toString()));
                        model.setEt_z(Integer.parseInt(listViewHolder.editZ.getText().toString()));

                        StaticVolumesKinematicsInverseValue.setOneModel(model);
                        return false;
                    }
                };

                listViewHolder.editX.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.editY.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.editZ.setOnEditorActionListener(onEditorActionListener);

            }
            break;
        }

        return convertView;
    }
}
