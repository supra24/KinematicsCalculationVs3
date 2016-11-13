package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsInverseValueParent;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class StaticVolumesKinematicsInverseValue {

    private static final int FIRST_TYPE_OBJECT = 1;
    private static final int SECOND_TYPE_OBJECT = 2;
    private static ArrayList<ModelKinematicsInverseValueParent> modelKinematicsInverseValueParents = new ArrayList<>();

    public static ArrayList<ModelKinematicsInverseValueParent> getModels() {

        return modelKinematicsInverseValueParents;
    }

    public static void addObjects(int typeObject) {

        ModelKinematicsInverseValueParent modelKinematicsInverseValueParent = null;

        if (modelKinematicsInverseValueParents.isEmpty()) {
            if (typeObject == FIRST_TYPE_OBJECT) {
                modelKinematicsInverseValueParent = new ModelKinematicsInverseValueJoin(0);
            } else if (typeObject == SECOND_TYPE_OBJECT) {
                modelKinematicsInverseValueParent = new ModelKinematicsInverseValueEffector(0);
            }
        } else {
            if (typeObject == FIRST_TYPE_OBJECT) {
                modelKinematicsInverseValueParent = new ModelKinematicsInverseValueJoin(modelKinematicsInverseValueParents.get(modelKinematicsInverseValueParents.size() - FIRST_TYPE_OBJECT).getObjectIndex() + FIRST_TYPE_OBJECT);
            } else if (typeObject == SECOND_TYPE_OBJECT) {
                modelKinematicsInverseValueParent = new ModelKinematicsInverseValueEffector(modelKinematicsInverseValueParents.get(modelKinematicsInverseValueParents.size() - FIRST_TYPE_OBJECT).getObjectIndex() + FIRST_TYPE_OBJECT);
            }
        }

        modelKinematicsInverseValueParents.add(modelKinematicsInverseValueParent);
    }

    public static void setOneModel(ModelKinematicsInverseValueJoin oneModel) {

        modelKinematicsInverseValueParents.remove(oneModel.getObjectIndex());
        modelKinematicsInverseValueParents.add(oneModel.getObjectIndex(), oneModel);
    }

    public static void setOneModel(ModelKinematicsInverseValueEffector oneModel) {

        modelKinematicsInverseValueParents.remove(oneModel.getObjectIndex());
        modelKinematicsInverseValueParents.add(oneModel.getObjectIndex(), oneModel);
    }

    public static void removeEnd() {
        modelKinematicsInverseValueParents.remove(modelKinematicsInverseValueParents.size() - 1);
    }
}
