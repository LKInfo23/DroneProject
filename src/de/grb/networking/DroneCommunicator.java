package de.grb.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DroneCommunicator {
    
    String host;
    int port;
    DatagramSocket socket;
    
    /**
     * This class represents the connection to the drone. It may be used to send and receive data from and to the drone.
     * @param host the host of the drone/where to conncet to
     * @param port the port to connect to. Note this is UDP.
     * @throws SocketException should the creation of the DatagramSocket fail
     */
    public DroneCommunicator(String host, int port) throws SocketException {
        this.host = host;
        this.port = port;
        socket = new DatagramSocket();
    }
    
    /**
     * This function sends a message to the drone. Keep in mind this method just sends the message and won't return
     * any response. For that please use {@link #sendAndReceive(String)}
     * @param message The message that should be send to the drone.
     */
    public void send(String message) {
        try {
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName(host), port);
            socket.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This function sends a message to the drone and listens for a response.
     * @param message The message that should be send to the drone.
     * @return The response send by the drone
     */
    public String sendAndReceive(String message){
        send(message);
        return receive();
    }
    
    /**
     * This method returns the first new response from the drone. Should mostly be used for debugging etc.
     * Please use {@link #sendAndReceive} mostly
     * @return The next response from the drone
     */
    public String receive() {
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(dp);
            return new String(dp.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }
}
