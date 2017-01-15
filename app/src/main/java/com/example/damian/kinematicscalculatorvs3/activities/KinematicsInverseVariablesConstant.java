package com.example.damian.kinematicscalculatorvs3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.fragments.FragmentListInverseVariables;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-12.
 */
public class KinematicsInverseVariablesConstant extends AppCompatActivity {

    private static final int RETURN_BACK_STACK = 0;
    private static final int FIRST_TYPE_OBJECT = 1;
    private static final int SECOND_TYPE_OBJECT = 2;

    @BindView(R.id.floating_action_button_inverse_play)
    FloatingActionButton floatingActionButtonPlay;

    @BindView(R.id.floating_action_button_inverse_add)
    FloatingActionButton floatingActionButton;

    private boolean doubleBackToExitPressedOnce = false;
    private static int CLOSE_APP_ON_BACK = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_variablesconstant_kinematics_inverse);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentListInverseVariables fragmentListInverseVariables = (FragmentListInverseVariables) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_inverse);
        fragmentListInverseVariables.undoObject();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_kinematics_simple, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        FragmentListInverseVariables fragmentListInverseVariables = (FragmentListInverseVariables) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_inverse);

        if (fragmentListInverseVariables != null) {

            switch (item.getItemId()) {

                case R.id.id_add_join:
                    fragmentListInverseVariables.addObjectJoin(FIRST_TYPE_OBJECT);
                    break;
                case R.id.id_add_effector: {
                    fragmentListInverseVariables.addObjectJoin(SECOND_TYPE_OBJECT);
                    floatingActionButton.setVisibility(View.INVISIBLE);
                }
                    break;
                case R.id.id_undo: {
                    fragmentListInverseVariables.undoObject();
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
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

        FragmentListInverseVariables fragmentListInverseVariables = (FragmentListInverseVariables) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_inverse);

        if (!fragmentListInverseVariables.undoObject()) {

            if (getSupportFragmentManager().getBackStackEntryCount() > RETURN_BACK_STACK) {
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
        } else {
            floatingActionButton.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.floating_action_button_inverse_add)
    public void OnClickFloatingActionButtonAdd() {

        registerForContextMenu(floatingActionButton);
        openContextMenu(floatingActionButton);
    }

    @OnClick(R.id.floating_action_button_inverse_play)
    public void OnClickFloatingActionButtonPlay() {

        FragmentListInverseVariables fragmentListInverseVariables = (FragmentListInverseVariables) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_inverse);
        fragmentListInverseVariables.addObjectJoin(SECOND_TYPE_OBJECT);

        startActivity(new Intent(KinematicsInverseVariablesConstant.this, KinematicsInverseValue.class));
    }

}
