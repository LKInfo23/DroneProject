package de.grb.excercises;

import de.grb.commands.CommandManger;
import de.grb.vectormath.Vector3D;

public class SubtractionExerciseGenerator extends AddSubExercise {

    @Override
    public void Generate() {
        v1 = new Vector3D(10, 0);
        v2 = new Vector3D(10, 0);
        solution = v2.sub(v1);
    }

    @Override
    public String AsStringExercise() {
        return "Die Drone befindet sich am Punkt: " + v1 + "\nUnd soll zum Punkt: " + solution +
                "\nGeben sie den Vektor an den die Drone abfliegen muss.\n";
    }

    @Override
    public String AsStringExerciseWSolution() {
        return "Die Drone befindet sich am Punkt: " + v1 + "\nUnd soll zum Punkt: " + solution +
                "\nGeben sie den Vektor an den die Drone abfliegen muss.\n" + v2 + "\n";
    }

    @Override
    public boolean AskQuestion() {
        System.out.println(this.AsStringExerciseWSolution());
        Vector3D answer = new Vector3D();
        answer.readVectorFromStdIO();
        return isCorrect(answer);
    }

    @Override
    public boolean isCorrect(Vector3D answer) {
        return answer.equals(v2);
    }

    @Override
    public void flyExerciseSysout(CommandManger commandManger) {
        Vector3D answer = new Vector3D();
        System.out.print(this.AsStringExercise());
        commandManger.executeCommand("GoTo", v1.toStringArr());
        answer.readVectorFromStdIO();
        if(isCorrect(answer)) {
            System.out.println("correct");
            commandManger.executeCommand("GoTo", v2.toStringArr());
        } else {
            System.out.println("wrong");
            commandManger.executeCommand("GoTo", answer.toStringArr());
        }

    }

    public String toString() {
        return v1.toString() + " - " + v2.toString() + " = " + solution.toString() ;
    }
}
