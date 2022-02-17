package de.grb.cli;

import de.grb.DroneProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineInterface {
    
    public CommandLineInterface() {
    }
    
    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Staring CLI\nCommands entered here are send directly to the drone (we have to check if the drone needs some sort of specific formating)\nType 'exit' to quit.");
        try {
            while ((line = reader.readLine()) != null) {
                if(line.equals("exit")) {
                    break;
                }
                System.out.println(DroneProject.droneCommunicator.sendAndReceive(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
