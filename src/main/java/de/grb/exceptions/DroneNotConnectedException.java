package de.grb.exceptions;

public class DroneNotConnectedException extends Exception {
    public DroneNotConnectedException() {
        super("Drone is not connected!");
    }
}