package de.grb.commands.impl;

import de.grb.DroneProject;
import de.grb.commands.Command;

/**
 * This command is used to enter the SDK mode.
 */
public class SDKMode extends Command {
    public SDKMode() {
        super("sdk");
    }
    
    @Override
    public boolean execute(String[] args) {
        // this command has to lowercase which is explicitly against the SDK.
        return DroneProject.droneCommunicator.sendAndReceive("command").equalsIgnoreCase("ok");
    }
}
