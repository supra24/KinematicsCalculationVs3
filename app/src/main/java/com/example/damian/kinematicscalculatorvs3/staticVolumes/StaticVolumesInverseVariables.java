package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablwsParent;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class StaticVolumesInverseVariables {

    private static ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents = new ArrayList<>();

    public static ArrayList<ModelKinematicsInverseVariablwsParent> getModels() {

        return modelKinematicsInverseVariablwsParents;
    }

    public static void addObjects(int typeObject) {

        ModelKinematicsInverseVariablwsParent modelKinematicsInverseVariablwsParent = null;

        if (modelKinematicsInverseVariablwsParents.isEmpty()) {
            if (typeObject == 1) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesJoin(0);
            } else if (typeObject == 2) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesEffector(0);
            }
        } else {
            if (typeObject == 1) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesJoin(modelKinematicsInverseVariablwsParents.get(modelKinematicsInverseVariablwsParents.size() - 1).getObjectIndex() + 1);
            } else if (typeObject == 2) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesEffector(modelKinematicsInverseVariablwsParents.get(modelKinematicsInverseVariablwsParents.size() - 1).getObjectIndex() + 1);
            }
        }

        modelKinematicsInverseVariablwsParents.add(modelKinematicsInverseVariablwsParent);
    }

    public static void setOneModel(ModelKinematicsInverseVariablesJoin oneModel) {

        modelKinematicsInverseVariablwsParents.remove(oneModel.getObjectIndex());
        modelKinematicsInverseVariablwsParents.add(oneModel.getObjectIndex(), oneModel);
    }

    public static void setOneModel(ModelKinematicsInverseVariablesEffector oneModel) {

        modelKinematicsInverseVariablwsParents.remove(oneModel.getObjectIndex());
        modelKinematicsInverseVariablwsParents.add(oneModel.getObjectIndex(), oneModel);
    }
}
