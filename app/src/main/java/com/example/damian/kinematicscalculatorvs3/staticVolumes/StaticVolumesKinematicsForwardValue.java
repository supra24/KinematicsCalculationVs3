package com.example.damian.kinematicscalculatorvs3.staticVolumes;

import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueEffector;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueJoin;
import com.example.damian.kinematicscalculatorvs3.models.ModelKinematicsForwardValueParent;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-11-11.
 */

public class StaticVolumesKinematicsForwardValue {

    private static ArrayList<ModelKinematicsForwardValueParent> modelKinematicsForwardValueParents = new ArrayList<>();

    public static ArrayList<ModelKinematicsForwardValueParent> getModels() {

        return modelKinematicsForwardValueParents;
    }

    public static void addObjects(int typeObject) {

        ModelKinematicsForwardValueParent modelKinematicsForwardValueParent = null;

        if (modelKinematicsForwardValueParents.isEmpty()) {
            if (typeObject == 1) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueJoin(0);
            } else if (typeObject == 2) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueEffector(0);
            }
        } else {
            if (typeObject == 1) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueJoin(modelKinematicsForwardValueParents.get(modelKinematicsForwardValueParents.size() - 1).getObjectIndex() + 1);
            } else if (typeObject == 2) {
                modelKinematicsForwardValueParent = new ModelKinematicsForwardValueEffector(modelKinematicsForwardValueParents.get(modelKinematicsForwardValueParents.size() - 1).getObjectIndex() + 1);
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
