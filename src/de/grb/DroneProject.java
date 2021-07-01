package de.grb;

import de.grb.networking.DroneCommunicator;
import de.grb.vectormath.Vector3D;

import java.net.SocketException;

public class DroneProject {
    
    public static void main(String[] args) {
        try {
            DroneCommunicator commandCommunicator = new DroneCommunicator("192.168.10.1", 8889);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
