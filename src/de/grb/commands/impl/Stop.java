package de.grb.commands.impl;

import de.grb.DroneProject;
import de.grb.commands.Command;


/**
 * Stops the drone in the air.
 */
public class Stop extends Command {
    
    public Stop() {
        super("stop");
    }
    
    @Override
    public boolean execute(String[] args) {
        return (DroneProject.droneCommunicator.sendAndReceive("stop").equals("ok"));
    }
}
