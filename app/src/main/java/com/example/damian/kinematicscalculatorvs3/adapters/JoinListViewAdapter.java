package com.example.damian.kinematicscalculatorvs3.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.damian.kinematicscalculatorvs3.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public View getView(int position, View convertView, ViewGroup parent) {

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
        listViewHolder.editalpha.setText(joinListViewModels.get(position).getEt_alpha());
        listViewHolder.edita.setText(joinListViewModels.get(position).getEt_a());
        listViewHolder.edittheta.setText(joinListViewModels.get(position).getEt_theta());
        listViewHolder.editd.setText(joinListViewModels.get(position).getEt_d());

//        listViewHolder.editalpha.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        return convertView;
    }
}
