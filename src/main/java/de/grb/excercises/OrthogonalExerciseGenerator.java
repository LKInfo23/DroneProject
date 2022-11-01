package de.grb.excercises;

import de.grb.commands.CommandManger;
import de.grb.vectormath.LinearFunction;
import de.grb.vectormath.Vector3D;

public class OrthogonalExerciseGenerator extends OrthogonalExercise {

    @Override
    public void Generate() {
        g1 = new LinearFunction(new Vector3D(0,0,2), new Vector3D(10,1));
        g2 = new LinearFunction(g1.pointAt(1), g1.getDirection().OrthogonalXY());
    }

    @Override
    public String AsStringExercise() {
        return "Die Drone fliegt entlang der Funktion: \n" + g1 + "\nJetzt ist die Drone bei dem Punkt: \n" +
                g1.pointAt(1) + "\nGeben sie ein Funktion an, sodass diese Orthogonal zu der Funktion auf der XY-Ebene ist.\n" +
                g2.withoutDirection();
    }

    @Override
    public String AsStringExerciseWSolution() {
        return "Die Drone fliegt entlang der Funktion: \n" + g1 + "\nJetzt ist die Drone bei dem Punkt: \n" +
                g1.pointAt(1) + "\nGeben sie ein Funktion an, sodass diese Orthogonal zu der Funktion auf der XY-Ebene ist.\n" +
                g2;
    }

    @Override
    public boolean AskQuestion() {
        System.out.println(AsStringExerciseWSolution());
        Vector3D answer = new Vector3D();
        answer.readVectorFromStdIO();
        System.out.println("read vector: " + answer);
        return isCorrect(answer);
    }

    @Override
    public boolean isCorrect(Vector3D answer) { return Math.abs(answer.dot(g2.getDirection())) <= 5 ; }

    @Override
    public void flyExerciseSysout(CommandManger commandManger) {

    }

    public String toString() {
        return g1.toString() + "\northogonal Line:\n" + g2.toString();
    }
}
