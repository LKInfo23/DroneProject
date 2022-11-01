package de.grb;

import de.grb.commands.CommandManger;
import de.grb.excercises.Exercise;
import de.grb.excercises.ExerciseFactory;
import de.grb.excercises.ExerciseTypes;
import de.grb.networking.DroneCommunicator;
import de.grb.vectormath.Vector3D;


import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Scanner;

public class ExerciseDemo {

    public static Vector3D readVector() {
        double x,y,z;
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        x = in.nextDouble();
        y = in.nextDouble();
        z = in.nextDouble();
        return new Vector3D(x,y,z);
    }


    public static DroneCommunicator droneCommunicator;
    public static CommandManger commandManger;

    public static void main(String[] args) {

        try {
            droneCommunicator = new DroneCommunicator("192.168.10.1", 8889);
            commandManger = new CommandManger();
            // needed so the drone accepts sdk commands
            commandManger.executeCommand("sdk", null);

            //generate Exercise
            ExerciseFactory exerciseFactory = new ExerciseFactory();
            Exercise exercise = null;
            exercise = exerciseFactory.getExercise(ExerciseTypes.Addition);
            exercise.Generate();


            exercise.flyExerciseSysout(commandManger);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}