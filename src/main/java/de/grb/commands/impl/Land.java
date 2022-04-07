package de.grb.commands.impl;

import de.grb.DroneProject;
import de.grb.commands.Command;


/**
 * This command is used to land the drone.
 */
public class Land extends Command {
    
    public Land() {
        super("land");
    }
    
    @Override
    public boolean execute(String[] args) {
        return DroneProject.droneCommunicator.sendAndReceive("land").equalsIgnoreCase("ok");
    }
}
