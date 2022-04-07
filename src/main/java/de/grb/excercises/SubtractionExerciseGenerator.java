package de.grb.excercises;

import de.grb.vectormath.Vector3D;

public class SubtractionExerciseGenerator extends Exercise {

    @Override
    public void Generate() {
        v1 = new Vector3D(0, 10);
        v2 = new Vector3D(-10, 10);
        solution.sub(v1.sub(v2));
    }
}
