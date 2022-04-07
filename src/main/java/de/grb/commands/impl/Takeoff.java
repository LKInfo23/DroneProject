package de.grb.commands.impl;

import de.grb.DroneProject;
import de.grb.commands.Command;


/**
 * Auto takeoff command.
 */
public class Takeoff extends Command {
    public Takeoff() {
        super("takeoff");
    }
    
    @Override
    public boolean execute(String[] args) {
        return DroneProject.droneCommunicator.sendAndReceive("takeoff").equalsIgnoreCase("ok");
    }
}
