package de.grb;

import de.grb.cli.CommandLineInterface;
import de.grb.commands.CommandManger;
import de.grb.networking.DroneCommunicator;

import java.net.SocketException;
import java.net.UnknownHostException;

public class DroneProject {
    
    public final static CommandLineInterface cli = new CommandLineInterface();
    public static DroneCommunicator droneCommunicator;
    public static CommandManger commandManger;
    
    public static void main(String[] args) {
        
        try {
            droneCommunicator = new DroneCommunicator("192.168.10.1", 8889);
            commandManger = new CommandManger();
            // needed so the drone accepts sdk commands
            commandManger.executeCommand("sdk", null);
            cli.start();
            
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
