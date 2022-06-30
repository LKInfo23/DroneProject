package de.grb.excercises;

import de.grb.vectormath.LinearFunction;
import de.grb.vectormath.Vector3D;

public class OrthogonalExerciseGenerator extends OrthogonalExercise {

    @Override
    public void Generate() {
        g1 = new LinearFunction(new Vector3D(0,0,2), new Vector3D(10,0));
        g2 = new LinearFunction(g1.pointAt(1), g1.getDirection().OrthogonalXY());
    }

    public String toString() {
        return g1.toString() + "\northogonal Line:\n" + g2.toString();
    }
}
