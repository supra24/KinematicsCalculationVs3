package com.example.damian.kinematicscalculatorvs3.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.damian.kinematicscalculatorvs3.R;
import com.example.damian.kinematicscalculatorvs3.calculations.CalculationKinematicsInverse;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablwsParent;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesInverseVariables;
import com.example.damian.kinematicscalculatorvs3.staticVolumes.StaticVolumesKinematicsInverseValue;

import java.util.ArrayList;

/**
 * Created by Damian on 2017-01-14.
 */

public class KinematicsInverseSystemOfEquation extends AppCompatActivity {

    private static final int AMOUNT_VARIABLES = 4;
    private static final int AMOUNT_COORDINATES = 4;
    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_of_equation_inverse);

        list = (ListView) findViewById(R.id.list_view_inverse_system_of_equation);

        adapter = new ArrayAdapter<String>(this, R.layout.model_system_of_equation_inverse, Calculation());
        list.setAdapter(adapter);
    }

    private ArrayList<String> Calculation() {

        ArrayList<String> arrayList = new ArrayList<>();

        ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents = StaticVolumesKinematicsInverseValue.getModels();
        ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents = StaticVolumesInverseVariables.getModels();

        String[][] tableParameters = new String[modelKinematicsInverseValueParents.size()-2][AMOUNT_VARIABLES];

        for (int i = 0; i < tableParameters.length; i++) {

            ModelKinematicsInverseValueJoin modelKinematicsInverseValueJoin = (ModelKinematicsInverseValueJoin) modelKinematicsInverseValueParents.get(i);
            ModelKinematicsInverseVariablesJoin modelKinematicsInverseVariablesJoin = (ModelKinematicsInverseVariablesJoin) modelKinematicsInverseVariablwsParents.get(i);

            if (modelKinematicsInverseVariablesJoin.isEt_alpha() == true)
                tableParameters[i][0] = "α" + (i + 1);
            else
                tableParameters[i][0] = String.valueOf(modelKinematicsInverseValueJoin.getEt_alpha());

            if (modelKinematicsInverseVariablesJoin.isEt_a() == true)
                tableParameters[i][1] = "a" + (i + 1);
            else
                tableParameters[i][1] = String.valueOf(modelKinematicsInverseValueJoin.getEt_a());

            if (modelKinematicsInverseVariablesJoin.isEt_theta() == true)
                tableParameters[i][2] = "θ" + (i + 1);
            else
                tableParameters[i][2] = String.valueOf(modelKinematicsInverseValueJoin.getEt_theta());

            if (modelKinematicsInverseVariablesJoin.isEt_d() == true)
                tableParameters[i][3] = "d" + (i + 1);
            else
                tableParameters[i][3] = String.valueOf(modelKinematicsInverseValueJoin.getEt_d());
        }

        // stworzenei nowej tablicy do wartosci effectora
        String[] tableEffector = new String[AMOUNT_COORDINATES];
        ModelKinematicsInverseValueEffector modelKinematicsInverseValueEffector = (ModelKinematicsInverseValueEffector) modelKinematicsInverseValueParents.get(modelKinematicsInverseValueParents.size() - 2);
        ModelKinematicsInverseVariablesEffector modelKinematicsInverseVariablesEffector = (ModelKinematicsInverseVariablesEffector) modelKinematicsInverseVariablwsParents.get(modelKinematicsInverseVariablwsParents.size() - 2);

        if (modelKinematicsInverseVariablesEffector.isEt_x() == true)
            tableEffector[0] = "x";
        else
            tableEffector[0] = String.valueOf(modelKinematicsInverseValueEffector.getEt_x());

        if (modelKinematicsInverseVariablesEffector.isEt_y() == true)
            tableEffector[1] = "y";
        else
            tableEffector[1] = String.valueOf(modelKinematicsInverseValueEffector.getEt_y());

        if (modelKinematicsInverseVariablesEffector.isEt_z() == true)
            tableEffector[2] = "z";
        else
            tableEffector[2] = String.valueOf(modelKinematicsInverseValueEffector.getEt_z());

        tableEffector[3] = String.valueOf(0);

        String[] tableEffector2 = new String[AMOUNT_COORDINATES];
        ModelKinematicsInverseValueEffector modelKinematicsInverseValueEffector2 = (ModelKinematicsInverseValueEffector) modelKinematicsInverseValueParents.get(modelKinematicsInverseValueParents.size() - 1);
        tableEffector2[0] = String.valueOf(modelKinematicsInverseValueEffector2.getEt_x());
        tableEffector2[1] = String.valueOf(modelKinematicsInverseValueEffector2.getEt_y());
        tableEffector2[2] = String.valueOf(modelKinematicsInverseValueEffector2.getEt_z());
        tableEffector2[3] = String.valueOf(0);

        CalculationKinematicsInverse calculationKinematicsInverse = new CalculationKinematicsInverse(tableParameters, tableEffector);
        String[] end = calculationKinematicsInverse.getCoordinatesEndEffector();
        arrayList.add(tableEffector2[0] + "=" + end[0]);
        arrayList.add(tableEffector2[1] + "=" + end[1]);
        arrayList.add(tableEffector2[2] + "=" + end[2]);

        Log.d("x ", arrayList.get(0) );
        Log.d("y ", arrayList.get(1) );
        Log.d("z ", arrayList.get(2) );


        return arrayList;
    }
}