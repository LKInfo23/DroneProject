package de.grb.excercises;

import de.grb.vectormath.Vector3D;

public class AdditionExerciseGenerator extends AddSubExercise {

    @Override
    public void Generate() {
        v1 = new Vector3D(10, 0);
        v2 = new Vector3D(10, 0);
        solution = v1.add(v2);
    }

    public String toString() {
        return v1.toString() + " + " + v2.toString() + " = " + solution.toString() ;
    }
}
