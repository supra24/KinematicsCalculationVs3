package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class StaticVolumesKinematicsForwardValue {

    private static final int FIRST_TYPE_OBJECT = 1;
    private static final int SECOND_TYPE_OBJECT = 2;
    private static ArrayList<ModelKinematicsForwardValueParent> modelKinematicsForwardValueParents = new ArrayList<>();

    public static ArrayList<ModelKinematicsForwardValueParent> getModels() {

        return modelKinematicsForwardValueParents;
    }

    public static void addObjects(int typeObject) {

        ModelKinematicsForwardValueParent modelKinematicsForwardValueParent = null;

        if (modelKinematicsForwardValueParents.isEmpty()) {
            if (typeObject == FIRST_TYPE_OBJECT) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueJoin(0);
            } else if (typeObject == SECOND_TYPE_OBJECT) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueEffector(0);
            }
        } else {
            if (typeObject == FIRST_TYPE_OBJECT) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueJoin(modelKinematicsForwardValueParents.get(modelKinematicsForwardValueParents.size() - FIRST_TYPE_OBJECT).getObjectIndex() + FIRST_TYPE_OBJECT);
            } else if (typeObject == SECOND_TYPE_OBJECT) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueEffector(modelKinematicsForwardValueParents.get(modelKinematicsForwardValueParents.size() - FIRST_TYPE_OBJECT).getObjectIndex() + FIRST_TYPE_OBJECT);
            }
        }

        modelKinematicsForwardValueParents.add(modelKinematicsForwardValueParent);
    }

    public static void setOneModel(ModelKinematicsForwardValueJoin oneModel) {

        modelKinematicsForwardValueParents.remove(oneModel.getObjectIndex());
        modelKinematicsForwardValueParents.add(oneModel.getObjectIndex(), oneModel);
    }

    public static void setOneModel(ModelKinematicsForwardValueEffector oneModel) {

        modelKinematicsForwardValueParents.remove(oneModel.getObjectIndex());
        modelKinematicsForwardValueParents.add(oneModel.getObjectIndex(), oneModel);
    }
}
