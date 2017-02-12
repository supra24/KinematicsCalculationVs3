package com.example.damian.kinematicscalculatorvs3.activities;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationInverseNumerical;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.JacobianMatrices;
import org.apache.commons.math3.ode.MainStateJacobianProvider;
import org.apache.commons.math3.ode.ParameterJacobianProvider;
import org.apache.commons.math3.ode.UnknownParameterException;

import java.util.Collection;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-10-12.
 */
public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.b_kinematicsForward)
    Button b_kinematics_forward;
    @BindView(R.id.b_kinematicsInverse)
    Button b_kinematics_inverse;
    @BindView(R.id.b_change_language)
    Button b_change_language;
    @BindView(R.id.b_language_pl)
    Button b_pl;
    @BindView(R.id.b_language_en)
    Button b_en;
    @BindView(R.id.button_toolbar_menu)
    Button buttonToolbar;
    @BindView(R.id.relative_layout_menu)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        invalidateOptionsMenu();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.b_kinematicsForward)
    void openActivityKinematicsForward() {

        Intent intent = new Intent(getApplicationContext(), KinematicsForwardValue.class);
        startActivity(intent);
    }

    @OnClick(R.id.b_kinematicsInverse)
    void openActivityKinematicsInverse() {
        Intent intent = new Intent(getApplicationContext(), KinematicsInverseVariablesConstant.class);
        startActivity(intent);
    }

    @OnClick(R.id.b_change_language)
    void changeLanguage() {
        b_en.setVisibility(View.VISIBLE);
        b_pl.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.b_language_en)
    void changeLanguageEn() {
        setLocale("en");
    }

    @OnClick(R.id.b_language_pl)
    void changeLanguagePl() {
        setLocale("pl");
    }

    @OnClick(R.id.button_toolbar_menu)
    void help() {

        Intent intent = new Intent(getApplicationContext(), Help.class);
        startActivity(intent);

//        TextView textView =  (TextView) findViewById(R.id.text_fragment_help);
//        textView.setText(R.string.help_menu);

//        Toast.makeText(this, R.string.help_menu, Toast.LENGTH_LONG).show();
    }

    public void setLocale(String lang) {

        Locale myLocale;
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        invalidateOptionsMenu();
        Intent refresh = new Intent(this, MenuActivity.class);
        startActivity(refresh);
    }
}
