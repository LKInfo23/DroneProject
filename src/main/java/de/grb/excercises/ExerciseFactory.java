package de.grb.excercises;

public class ExerciseFactory {

    public Exercise getExercise(ExerciseTypes ExerciseType) {
        if (ExerciseType == null) {
            return null;
        }
        if(ExerciseType == ExerciseTypes.Addition) {
            return new AdditionExerciseGenerator();
        }
        if (ExerciseType == ExerciseTypes.Subtraction) {
            return new SubtractionExerciseGenerator();
        }
        if(ExerciseType == ExerciseTypes.Orthogonal) {
            return new OrthogonalExerciseGenerator();
        }
        if(ExerciseType == ExerciseTypes.Parkour) {
            return new ParkourExerciseGenerator();
        }
        else {
            return null;
        }
    }
}