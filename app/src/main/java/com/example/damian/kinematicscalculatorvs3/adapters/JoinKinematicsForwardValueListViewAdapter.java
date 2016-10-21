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
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForwardValue;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForwardValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinKinematicsForwardValueListViewAdapter extends ArrayAdapter<JoinListViewModelKinematicsForwardValue> {


    private Context context;
    private ArrayList<JoinListViewModelKinematicsForwardValue> joinListViewModelKinematicsForwardValues;
    private LayoutInflater inflater;

    public JoinKinematicsForwardValueListViewAdapter(Context context, ArrayList<JoinListViewModelKinematicsForwardValue> items) {
        super(context, R.layout.custom_join_list_view_value_kinematics, items);

        this.context = context;
        this.joinListViewModelKinematicsForwardValues = items;

    }

    @Override
    public int getCount() {
        if (joinListViewModelKinematicsForwardValues == null)
            return 0;
        else
            return joinListViewModelKinematicsForwardValues.size();
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

        final ListViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ListViewHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_join_list_view_value_kinematics, null);

            listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_forward);
            listViewHolder.editalpha = (EditText) convertView.findViewById(R.id.list_view_join_alpha_forward);
            listViewHolder.edita = (EditText) convertView.findViewById(R.id.list_view_join_a_forward);
            listViewHolder.edittheta = (EditText) convertView.findViewById(R.id.list_view_join_theta_forward);
            listViewHolder.editd = (EditText) convertView.findViewById(R.id.list_view_join_d_forward);

            convertView.setTag(listViewHolder);

        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.textViewlp.setText(String.valueOf(joinListViewModelKinematicsForwardValues.get(position).getTv_lp()));
        listViewHolder.editalpha.setText(String.valueOf(joinListViewModelKinematicsForwardValues.get(position).getEt_alpha()));
        listViewHolder.edita.setText(String.valueOf(joinListViewModelKinematicsForwardValues.get(position).getEt_a()));
        listViewHolder.edittheta.setText(String.valueOf(joinListViewModelKinematicsForwardValues.get(position).getEt_theta()));
        listViewHolder.editd.setText(String.valueOf(joinListViewModelKinematicsForwardValues.get(position).getEt_d()));

//        listViewHolder.editalpha.setFocusable(true);
////        listViewHolder.togglebuttonalpha.setClickable();
//        listViewHolder.edita.setFocusable(true);
//        listViewHolder.edittheta.setFocusable(true);
//        listViewHolder.editd.setFocusable(true);

//        listViewHolder.togglebuttonalpha.setFocusableInTouchMode(true);
//        listViewHolder.togglebuttona.setFocusableInTouchMode(true);
//        listViewHolder.togglebuttontheta.setFocusableInTouchMode(true);
//        listViewHolder.togglebuttond.setFocusableInTouchMode(true);


        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                JoinListViewModelKinematicsForwardValue joinListViewModelKinematicsForwardValue = new JoinListViewModelKinematicsForwardValue();
                joinListViewModelKinematicsForwardValue.setTv_lp(position);
                joinListViewModelKinematicsForwardValue.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
                joinListViewModelKinematicsForwardValue.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
                joinListViewModelKinematicsForwardValue.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
                joinListViewModelKinematicsForwardValue.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));

                StaticVolumesJoinKinematicsForwardValue.setOneJoinModel(joinListViewModelKinematicsForwardValue);
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

