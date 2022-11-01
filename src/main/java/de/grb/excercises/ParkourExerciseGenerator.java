package de.grb.excercises;

import de.grb.commands.CommandManger;
import de.grb.vectormath.Vector3D;

import java.util.ArrayList;

public class ParkourExerciseGenerator extends ParkourExercise {

    @Override
    public void Generate() {
        PointList = new ArrayList<>(5);
        PointList.add(new Vector3D(0,0,2));
        for (int i = 1; i < 5; i++) {
            PointList.add(new Vector3D(10,0));
        }
    }

    //very crude and useless implementation
    @Override
    public String AsStringExercise() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++ ) {
            sb.append("Die Drone ist am Punkt: ").append(PointList.get(i)).append("\n");
            sb.append("Und muss zum Punkt: ").append(PointList.get(i+1)).append("\n");
        }
        return sb.toString();
    }
    //very crude and useless implementation
    @Override
    public String AsStringExerciseWSolution() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++ ) {
            sb.append("Die Drone ist am Punkt: ").append(PointList.get(i)).append("\n");
            sb.append("Und muss zum Punkt: ").append(PointList.get(i+1)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean AskQuestion() {
        return true;
    }

    @Override
    public boolean isCorrect(Vector3D answer) {
        return false;
    }

    @Override
    public void flyExerciseSysout(CommandManger commandManger) {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Vector3D vec : PointList) {
            sb.append(vec.toString()).append(" ");
        }
        return sb.toString();
    }
}
