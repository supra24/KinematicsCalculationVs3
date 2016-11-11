package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-21.
 */

public class AdapterInverseValueListView extends ArrayAdapter<ModelKinematicsInverseValue> {

    private Context context;
    private ArrayList<ModelKinematicsInverseValue> modelKinematicsInverseValues;
    private LayoutInflater inflater;

    public AdapterInverseValueListView(Context context, ArrayList<ModelKinematicsInverseValue> items) {
        super(context, R.layout.custom_join_list_view_value_kinematics, items);

        this.context = context;
        this.modelKinematicsInverseValues = items;

    }

    @Override
    public int getCount() {
        if (modelKinematicsInverseValues == null)
            return 0;
        else
            return modelKinematicsInverseValues.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ListViewHolder {

        TextView textViewlp;
        EditText editalpha;
        EditText edita;
        EditText edittheta;
        EditText editd;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final AdapterInverseValueListView.ListViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new AdapterInverseValueListView.ListViewHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_join_list_view_value_kinematics, null);

            listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_forward);
            listViewHolder.editalpha = (EditText) convertView.findViewById(R.id.list_view_join_alpha_forward);
            listViewHolder.edita = (EditText) convertView.findViewById(R.id.list_view_join_a_forward);
            listViewHolder.edittheta = (EditText) convertView.findViewById(R.id.list_view_join_theta_forward);
            listViewHolder.editd = (EditText) convertView.findViewById(R.id.list_view_join_d_forward);

            convertView.setTag(listViewHolder);

        } else {
            listViewHolder = (AdapterInverseValueListView.ListViewHolder) convertView.getTag();
        }

        listViewHolder.textViewlp.setText(String.valueOf(modelKinematicsInverseValues.get(position).getTv_lp()));
        listViewHolder.editalpha.setText(String.valueOf(modelKinematicsInverseValues.get(position).getEt_alpha()));
        listViewHolder.edita.setText(String.valueOf(modelKinematicsInverseValues.get(position).getEt_a()));
        listViewHolder.edittheta.setText(String.valueOf(modelKinematicsInverseValues.get(position).getEt_theta()));
        listViewHolder.editd.setText(String.valueOf(modelKinematicsInverseValues.get(position).getEt_d()));

        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                ModelKinematicsInverseValue joinListViewModelKinematicsForwardValue = new ModelKinematicsInverseValue();
                joinListViewModelKinematicsForwardValue.setTv_lp(position);
                joinListViewModelKinematicsForwardValue.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
                joinListViewModelKinematicsForwardValue.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
                joinListViewModelKinematicsForwardValue.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
                joinListViewModelKinematicsForwardValue.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));

                StaticVolumesJoinKinematicsInverseValue.setOneJoinModel(joinListViewModelKinematicsForwardValue);
                return false;
            }
        };

        listViewHolder.editalpha.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.edita.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.edittheta.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.editd.setOnEditorActionListener(onEditorActionListener);

//        listViewHolder.togglebuttonalpha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listViewHolder.togglebuttonalpha.setFocusableInTouchMode(true);
//                listViewHolder.togglebuttona.setFocusableInTouchMode(true);
//                listViewHolder.togglebuttontheta.setFocusableInTouchMode(true);
//                listViewHolder.togglebuttond.setFocusableInTouchMode(true);
//            }
//        });

//        listViewHolder.togglebuttonalpha.setOnLongClickListener();

        return convertView;
    }
}
