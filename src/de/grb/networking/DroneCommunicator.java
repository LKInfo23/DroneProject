package de.grb.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

public class DroneCommunicator {
    
    private final String host;
    private final int port;
    private final DatagramSocket droneSocket;
    private final DatagramSocket listenerSocket;
    private long lastSent = System.currentTimeMillis();
    
    /**
     * This class represents the connection to the drone. It may be used to send and receive data from and to the drone.
     *
     * @param host The host of the drone/where to connect to.
     * @param port The port to connect to. Note: this is UDP.
     * @throws SocketException should the creation of the DatagramSocket fail
     */
    public DroneCommunicator(String host, int port) throws SocketException {
        this.host = host;
        this.port = port;
        droneSocket = new DatagramSocket();
        listenerSocket = new DatagramSocket(8890);
        Timer timer = new Timer();
        // this is technically not the way according to java convention, but it is more readable
        //noinspection CodeBlock2Expr
        new Thread(() -> {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (System.currentTimeMillis() - lastSent > 10000) {
                        send("battery?");
                    }
                }
            }, 0L, 5000L);
        }).start();
    }
    
    /**
     * This function sends a message to the drone. Keep in mind this method just sends the message and won't return
     * any response. For that please use {@link #sendAndReceive(String)}
     *
     * @param message The message that should be sent to the drone.
     */
    public void send(String message) {
        try {
            DatagramPacket dp = new DatagramPacket(message.getBytes(StandardCharsets.UTF_8), message.length(), InetAddress.getByName(host), port);
            droneSocket.send(dp);
            lastSent = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This function sends a message to the drone and returns the response if given.
     *
     * @param message The message that should be sent to the drone.
     * @return The response sent by the drone.
     */
    public String sendAndReceive(String message) {
        send(message);
        return receive();
    }
    
    /**
     * This method returns the first new response from the drone. Should mostly be used for debugging etc.
     * Please use {@link #sendAndReceive(String)} mostly
     *
     * @return The next response from the drone.
     */
    public String receive() {
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        try {
            listenerSocket.receive(dp);
            return new String(dp.getData(), 0, dp.getLength(), StandardCharsets.UTF_8);
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
