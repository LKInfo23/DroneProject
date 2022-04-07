package de.grb.commands.impl;

import de.grb.DroneProject;
import de.grb.commands.Command;

/**
 * Kills the motors of the drone.
 */
public class Emergency extends Command {
    public Emergency() {
        super("emergency");
    }
    
    @Override
    public boolean execute(String[] args) {
        return DroneProject.droneCommunicator.sendAndReceive("emergency").equalsIgnoreCase("ok");
    }
}
