package de.grb.excercises;

import de.grb.vectormath.Vector3D;

public class AdditionExerciseGenerator extends AddSubExercise {

    @Override
    public void Generate() {
        v1 = new Vector3D(10, 0);
        v2 = new Vector3D(10, 0);
        solution = v1.add(v2);
    }

    @Override
    public String AsStringExercise() {
        return "Die Drone befindet sich am Punkt: " + v1 + "\nUnd fliegt den Vektor: " + v2 +
                "\nGeben sie den Punkt an an dem die Drone sich jetzt befindet.\n";
    }

    @Override
    public String AsStringExerciseWSolution() {
        return "Die Drone befindet sich am Punkt: " + v1 + "\nUnd fliegt den Vektor: " + v2 +
                "\nGeben sie den Punkt an an dem die Drone sich jetzt befindet.\n" + solution + "\n";
    }

    public String toString() {
        return v1.toString() + " + " + v2.toString() + " = " + solution.toString() ;
    }
}
