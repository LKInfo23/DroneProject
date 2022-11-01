package de.grb.excercises;

import de.grb.vectormath.Vector3D;
import de.grb.commands.CommandManger;

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

    @Override
    public boolean AskQuestion() {
        System.out.println(this.AsStringExerciseWSolution());
        Vector3D answer = new Vector3D();
        answer.readVectorFromStdIO();
        return isCorrect(answer);
    }

    @Override
    public boolean isCorrect(Vector3D answer) { return answer.equals(solution); }


    @Override
    public void flyExerciseSysout(CommandManger commandManger) {
        Vector3D answer = new Vector3D();
        System.out.print(this.AsStringExercise());
        commandManger.executeCommand("GoTo", v1.toStringArr());
        commandManger.executeCommand("GoTo", v2.toStringArr());
        answer.readVectorFromStdIO();
        if(isCorrect(answer)) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }

    public String toString() {
        return v1.toString() + " + " + v2.toString() + " = " + solution.toString() ;
    }
}
