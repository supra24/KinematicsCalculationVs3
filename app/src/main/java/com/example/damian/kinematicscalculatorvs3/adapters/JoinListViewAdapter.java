package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModel;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesJoinKinematicsSimple;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class JoinListViewAdapter extends ArrayAdapter<JoinListViewModel> {


    private Context context;
    private ArrayList<JoinListViewModel> joinListViewModels;
    private LayoutInflater inflater;

    public JoinListViewAdapter(Context context, ArrayList<JoinListViewModel> items) {
        super(context, R.layout.custom_join_list_view, items);

        this.context = context;
        this.joinListViewModels = items;

    }

    @Override
    public int getCount() {
        if (joinListViewModels == null)
            return 0;
        else
            return joinListViewModels.size();
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
            convertView = inflater.inflate(R.layout.custom_join_list_view, null);

            listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i);
            listViewHolder.editalpha = (EditText) convertView.findViewById(R.id.list_view_join_alpha);
            listViewHolder.edita = (EditText) convertView.findViewById(R.id.list_view_join_a);
            listViewHolder.edittheta = (EditText) convertView.findViewById(R.id.list_view_join_theta);
            listViewHolder.editd = (EditText) convertView.findViewById(R.id.list_view_join_d);

            convertView.setTag(listViewHolder);

        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.textViewlp.setText(String.valueOf(joinListViewModels.get(position).getTv_lp()));
        listViewHolder.editalpha.setText(String.valueOf(joinListViewModels.get(position).getEt_alpha()));
        listViewHolder.edita.setText(String.valueOf(joinListViewModels.get(position).getEt_a()));
        listViewHolder.edittheta.setText(String.valueOf(joinListViewModels.get(position).getEt_theta()));
        listViewHolder.editd.setText(String.valueOf(joinListViewModels.get(position).getEt_d()));

//        setEditTextActionListener(listViewHolder.edita, position);
//        setEditTextActionListener(listViewHolder.editalpha, position);
//        setEditTextActionListener(listViewHolder.edittheta, position);
//        setEditTextActionListener(listViewHolder.editd, position);

        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener(){

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                JoinListViewModel joinListViewModel = new JoinListViewModel();
                joinListViewModel.setTv_lp(position);
                joinListViewModel.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
                joinListViewModel.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
                joinListViewModel.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
                joinListViewModel.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));

                StaticVolumesJoinKinematicsSimple.setOneJoinModel(joinListViewModel);
                return false;
            }
        };

        listViewHolder.editalpha.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.edita.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.edittheta.setOnEditorActionListener(onEditorActionListener);
        listViewHolder.editd.setOnEditorActionListener(onEditorActionListener);

//        listViewHolder.editalpha.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                JoinListViewModel joinListViewModel = new JoinListViewModel();
//                joinListViewModel.setTv_lp(position);
//                joinListViewModel.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
//                joinListViewModel.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
//                joinListViewModel.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
//                joinListViewModel.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));
//
//                StaticVolumesJoinKinematicsSimple.setOneJoinModel(joinListViewModel);
//
////                joinListViewModels.get(position).setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
////                joinListViewModels.get(position).setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
////                joinListViewModels.get(position).setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
////                joinListViewModels.get(position).setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));
//
//                return false;
//            }
//        });
//
//        listViewHolder.edita.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                JoinListViewModel joinListViewModel = new JoinListViewModel();
//                joinListViewModel.setTv_lp(position);
//                joinListViewModel.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
//                joinListViewModel.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
//                joinListViewModel.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
//                joinListViewModel.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));
//
//                StaticVolumesJoinKinematicsSimple.setOneJoinModel(joinListViewModel);
//                return false;
//            }
//        });
//
//        listViewHolder.edittheta.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                JoinListViewModel joinListViewModel = new JoinListViewModel();
//                joinListViewModel.setTv_lp(position);
//                joinListViewModel.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
//                joinListViewModel.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
//                joinListViewModel.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
//                joinListViewModel.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));
//
//                StaticVolumesJoinKinematicsSimple.setOneJoinModel(joinListViewModel);
//                return false;
//            }
//        });
//
//        listViewHolder.editd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                JoinListViewModel joinListViewModel = new JoinListViewModel();
//                joinListViewModel.setTv_lp(position);
//                joinListViewModel.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
//                joinListViewModel.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
//                joinListViewModel.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
//                joinListViewModel.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));
//
//                StaticVolumesJoinKinematicsSimple.setOneJoinModel(joinListViewModel);
//                return false;
//            }
//        });

        return convertView;
    }


//    private void setEditTextActionListener(final ListViewHolder listViewHolder, final int position) {
//        listViewHolder..setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
////                joinListViewModels.get(position).setEt_alpha(editText.getText().toString());
////                joinListViewModels.get(position).setEt_a(editText.toString());
////                joinListViewModels.get(position).setEt_theta(editText.toString());
////                joinListViewModels.get(position).setEt_d(editText.toString());
//
////                StaticVolumesJoinKinematicsSimple.getJoinListViewModels().get(position).setEt_alpha(Integer.parseInt(editText.getText().toString()));
////                StaticVolumesJoinKinematicsSimple.getJoinListViewModels().get(position).setEt_a(Integer.parseInt(editText.getText().toString()));
////                StaticVolumesJoinKinematicsSimple.getJoinListViewModels().get(position).setEt_theta(Integer.parseInt(editText.getText().toString()));
////                StaticVolumesJoinKinematicsSimple.getJoinListViewModels().get(position).setEt_d(Integer.parseInt(editText.getText().toString()));
//
//
//
//                return false;
//            }
//        });
}

