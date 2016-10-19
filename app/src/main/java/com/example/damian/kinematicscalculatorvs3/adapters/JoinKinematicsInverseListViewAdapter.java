package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsForward;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModelKinematicsInverse;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsForward;

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
        Button buttonalpha;
        Button buttona;
        Button buttontheta;
        Button buttond;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ListViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ListViewHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_join_list_view_kinematics_forward, null);

            listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_inverse);
            listViewHolder.buttonalpha = (Button) convertView.findViewById(R.id.b_list_view_alpha);
            listViewHolder.buttona = (Button) convertView.findViewById(R.id.b_list_view_a);
            listViewHolder.buttontheta = (Button) convertView.findViewById(R.id.b_list_view_theta);
            listViewHolder.buttond = (Button) convertView.findViewById(R.id.b_list_view_d);

            convertView.setTag(listViewHolder);

        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.textViewlp.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getTv_lp()));
        listViewHolder.buttonalpha.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_alpha()));
        listViewHolder.buttona.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_a()));
        listViewHolder.buttontheta.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_theta()));
        listViewHolder.buttond.setText(String.valueOf(joinListViewModelKinematicsInverses.get(position).getEt_d()));



        listViewHolder.buttonalpha.setFocusable(true);
//        listViewHolder.buttonalpha.setClickable();
        listViewHolder.buttona.setFocusable(true);
        listViewHolder.buttontheta.setFocusable(true);
        listViewHolder.buttond.setFocusable(true);

//        listViewHolder.buttonalpha.setFocusableInTouchMode(true);
//        listViewHolder.buttona.setFocusableInTouchMode(true);
//        listViewHolder.buttontheta.setFocusableInTouchMode(true);
//        listViewHolder.buttond.setFocusableInTouchMode(true);


        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                JoinListViewModelKinematicsForward joinListViewModelKinematicsForward = new JoinListViewModelKinematicsForward();
                joinListViewModelKinematicsForward.setTv_lp(position);
                joinListViewModelKinematicsForward.setEt_alpha(Integer.parseInt(listViewHolder.buttonalpha.getText().toString()));
                joinListViewModelKinematicsForward.setEt_a(Integer.parseInt(listViewHolder.buttona.getText().toString()));
                joinListViewModelKinematicsForward.setEt_theta(Integer.parseInt(listViewHolder.buttontheta.getText().toString()));
                joinListViewModelKinematicsForward.setEt_d(Integer.parseInt(listViewHolder.buttond.getText().toString()));

                StaticVolumesJoinKinematicsForward.setOneJoinModel(joinListViewModelKinematicsForward);
                return false;
            }
        };

        listViewHolder.buttonalpha.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.buttona.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.buttontheta.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.buttond.setOnEditorActionListener(onEditorActionListener);

        return convertView;
    }
}

