package de.grb.excercises;

import de.grb.vectormath.Vector3D;

public class AdditionExerciseGenerator extends Exercise {

    @Override
    public void Generate() {
        v1 = new Vector3D(0, 10);
        v2 = new Vector3D(0, 10);
        solution.add(v1.add(v2));
    }
}
