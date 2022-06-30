package de.grb.excercises;

import de.grb.vectormath.Vector3D;

public class ParkourExerciseGenerator extends ParkourExercise {

    @Override
    void Generate() {
        for (int i = 0; i < 5; i++) {
            PointList.add(new Vector3D(10,0));
        }
    }
}
