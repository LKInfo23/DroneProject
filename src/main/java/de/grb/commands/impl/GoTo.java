package de.grb.commands.impl;

import de.grb.DroneProject;
import de.grb.commands.Command;
import de.grb.exceptions.DroneNotConnectedException;

public class GoTo extends Command {
    public GoTo() {
        super("goto");
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length != 4) {
            return false;
        }

        try {
            float x = Float.parseFloat(args[0]);
            float y = Float.parseFloat(args[1]);
            float z = Float.parseFloat(args[2]);
            DroneProject.droneCommunicator.send("goto " + x + " " + y + " " + z + " 10");
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (DroneNotConnectedException e) {
            throw new RuntimeException(e);
        }
    }
}
