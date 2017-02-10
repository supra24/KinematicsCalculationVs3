package com.example.damian.kinematicscalculatorvs3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationInverseNumerical;
import com.example.damian.kinematicscalculatorvs3.fragments.FragmentListForwardValue;
import com.example.damian.kinematicscalculatorvs3.fragments.FragmentListInverseVariables;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesJoin;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesInverseVariables;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsInverseValue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-12.
 */
public class KinematicsForwardValue extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int RETURN_BACK_STACK = 0;
    private static int CLOSE_APP_ON_BACK = 2000;
    private static final int FIRST_TYPE_OBJECT = 1;

    private static final int SECOND_TYPE_OBJECT = 2;

    @BindView(R.id.floating_action_button_forward_add)
    FloatingActionButton floatingActionButtonAdd;

    @BindView(R.id.floating_action_button_forward_play)
    FloatingActionButton floatingActionButtonPlay;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_value_kinematics_forward);
        ButterKnife.bind(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_kinematics_simple, menu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_forward);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        FragmentListForwardValue fragmentById = (FragmentListForwardValue) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_forward);

        if (fragmentById != null) {

            switch (item.getItemId()) {

                case R.id.id_add_join:
                    fragmentById.addObjectJoin(FIRST_TYPE_OBJECT);
                    break;
                case R.id.id_add_effector: {
                    fragmentById.addObjectJoin(SECOND_TYPE_OBJECT);
                    floatingActionButtonAdd.setVisibility(View.INVISIBLE);
                    floatingActionButtonPlay.setVisibility(View.VISIBLE);
                }
                break;
                case R.id.id_undo: {
                    fragmentById.undoObject();
                    floatingActionButtonAdd.setVisibility(View.VISIBLE);
                    floatingActionButtonPlay.setVisibility(View.INVISIBLE);
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

        FragmentListForwardValue fragmentById = (FragmentListForwardValue) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_forward);

        if (!fragmentById.undoObject()) {

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
            floatingActionButtonAdd.setVisibility(View.VISIBLE);
            floatingActionButtonPlay.setVisibility(View.INVISIBLE);
        }
    }

    @OnClick(R.id.floating_action_button_forward_add)
    public void OnClickFloatingActionButtonAdd() {

        registerForContextMenu(floatingActionButtonAdd);
        openContextMenu(floatingActionButtonAdd);
    }

    @OnClick(R.id.floating_action_button_forward_play)
    public void OnClickFloatingActionButtonPlay() {

        startActivity(new Intent(KinematicsForwardValue.this, KinematicsForwardDraw.class));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_kartezjanski: {
                FragmentListForwardValue fragmentListForwardValue = (FragmentListForwardValue) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_forward);

                while (fragmentListForwardValue.undoObject()) {

                }

                fragmentListForwardValue.addObjectJoin(FIRST_TYPE_OBJECT);
                fragmentListForwardValue.addObjectJoin(FIRST_TYPE_OBJECT);
                fragmentListForwardValue.addObjectJoin(FIRST_TYPE_OBJECT);

                ModelKinematicsInverseVariablesJoin modelVariables = new ModelKinematicsInverseVariablesJoin(0);
                modelVariables.setEt_alpha(false);
                modelVariables.setEt_a(false);
                modelVariables.setEt_theta(false);
                modelVariables.setEt_d(true);
                StaticVolumesInverseVariables.setOneModel(modelVariables);

                modelVariables = new ModelKinematicsInverseVariablesJoin(1);
                modelVariables.setEt_alpha(false);
                modelVariables.setEt_a(false);
                modelVariables.setEt_theta(false);
                modelVariables.setEt_d(true);
                StaticVolumesInverseVariables.setOneModel(modelVariables);

                modelVariables = new ModelKinematicsInverseVariablesJoin(2);
                modelVariables.setEt_alpha(false);
                modelVariables.setEt_a(false);
                modelVariables.setEt_theta(false);
                modelVariables.setEt_d(true);
                StaticVolumesInverseVariables.setOneModel(modelVariables);

                ModelKinematicsInverseValueJoin model = new ModelKinematicsInverseValueJoin(0);
                model.setTv_lp(1);
                model.setEt_alpha(90);
                model.setEt_a(0);
                model.setEt_theta(90);
                model.setEt_d(20);
                StaticVolumesKinematicsInverseValue.setOneModel(model);

                model = new ModelKinematicsInverseValueJoin(1);
                model.setTv_lp(2);
                model.setEt_alpha(-90);
                model.setEt_a(0);
                model.setEt_theta(90);
                model.setEt_d(20);
                StaticVolumesKinematicsInverseValue.setOneModel(model);

                model = new ModelKinematicsInverseValueJoin(2);
                model.setTv_lp(3);
                model.setEt_alpha(0);
                model.setEt_a(0);
                model.setEt_theta(0);
                model.setEt_d(20);
                StaticVolumesKinematicsInverseValue.setOneModel(model);

            }
            break;
            case R.id.nav_cylindryczny: {

            }
            break;
            case R.id.nav_sferyczny: {

            }
            break;
            case R.id.nav_scara: {

            }
            break;
            default:
                return true;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
