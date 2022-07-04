package de.grb;

import de.grb.excercises.Exercise;
import de.grb.excercises.ExerciseFactory;
import de.grb.excercises.ExerciseTypes;

public class ExerciseDemo {
    public static void main(String[] Args) {
        ExerciseFactory exerciseFactory = new ExerciseFactory();

        Exercise a = null;

        for(ExerciseTypes Exercise : ExerciseTypes.values()) {
            System.out.println(Exercise + ":");
            a = exerciseFactory.getExercise(Exercise);
            a.Generate();
            System.out.println(a.AsStringExerciseWSolution());
        }

    }
}