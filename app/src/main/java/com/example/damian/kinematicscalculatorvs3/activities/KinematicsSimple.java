package com.example.damian.kinematicscalculatorvs3.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.fragments.JoinCustomListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-12.
 */
public class KinematicsSimple extends AppCompatActivity {

    @BindView(R.id.floating_action_button_simple)
    FloatingActionButton floatingActionButton;

    private boolean doubleBackToExitPressedOnce = false;
    private static int CLOSE_APP_ON_BACK = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_kinematics_simple);
        ButterKnife.bind(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_kinematics_simple, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        JoinCustomListView joinCustomListView = (JoinCustomListView) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view);

        if (joinCustomListView != null) {

            switch (item.getItemId()) {

                case R.id.id_add_join:
                    joinCustomListView.addObjectJoin();
                    break;
                case R.id.id_add_effetor:

                    break;
                case R.id.id_undo:
                    joinCustomListView.undoObject();
                    break;
                default:
                    return true;
            }
        } else {
            Toast.makeText(this, "Error Sending Message", Toast.LENGTH_SHORT).show();
        }
        return true;


    }

    @Override
    public void onBackPressed() {

        JoinCustomListView joinCustomListView = (JoinCustomListView) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view);

        if (!joinCustomListView.undoObject()) {

            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            } else if (!doubleBackToExitPressedOnce) {
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, CLOSE_APP_ON_BACK);
            } else {
                super.onBackPressed();
            }
        }
    }

    @OnClick(R.id.floating_action_button_simple)
    public void OnClickFloatingActionButton() {

        registerForContextMenu(floatingActionButton);
        openContextMenu(floatingActionButton);
    }
}
