package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablesJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseVariablwsParent;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class StaticVolumesInverseVariables {

    private static final int FIRST_TYPE_OBJECT = 1;
    private static final int SECOND_TYPE_OBJECT = 2;
    private static ArrayList<ModelKinematicsInverseVariablwsParent> modelKinematicsInverseVariablwsParents = new ArrayList<>();

    public static ArrayList<ModelKinematicsInverseVariablwsParent> getModels() {

        return modelKinematicsInverseVariablwsParents;
    }

    public static void addObjects(int typeObject) {

        ModelKinematicsInverseVariablwsParent modelKinematicsInverseVariablwsParent = null;

        if (modelKinematicsInverseVariablwsParents.isEmpty()) {
            if (typeObject == FIRST_TYPE_OBJECT) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesJoin(0);
            } else if (typeObject == SECOND_TYPE_OBJECT) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesEffector(0);
            }
        } else {
            if (typeObject == FIRST_TYPE_OBJECT) {
                modelKinematicsInverseVariablwsParent = new ModelKinematicsInverseVariablesJoin(modelKinematicsInverseVariablwsParents.get(modelKinematicsInverseVariablwsParents.size() - 1).getObjectIndex() + 1);
            } else if (typeObject == SECOND_TYPE_OBJECT) {
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
