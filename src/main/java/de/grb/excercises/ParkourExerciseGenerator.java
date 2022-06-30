package de.grb.excercises;

import de.grb.vectormath.Vector3D;

import java.util.ArrayList;

public class ParkourExerciseGenerator extends ParkourExercise {

    @Override
    public void Generate() {
        PointList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            PointList.add(new Vector3D(10,0));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Vector3D vec : PointList) {
            sb.append(vec.toString()).append(" ");
        }
        return sb.toString();
    }
}
