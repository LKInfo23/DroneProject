package de.grb.excercises;

import de.grb.vectormath.Vector3D;
import de.grb.commands.CommandManger;

public abstract class Exercise {
    
    public abstract void Generate();

    public abstract String AsStringExercise();

    public abstract String AsStringExerciseWSolution();

    public abstract boolean AskQuestion();

    public abstract boolean isCorrect(Vector3D answer);

    public abstract void flyExerciseSysout(CommandManger commandManger);

}
