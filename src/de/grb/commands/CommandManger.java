package de.grb.commands;

import de.grb.commands.impl.*;

import java.util.ArrayList;

public class CommandManger {
    ArrayList<Command> commands = new ArrayList<>();
    
    public CommandManger() {
        addCommand(new Emergency());
        addCommand(new Land());
        addCommand(new SDKMode());
        addCommand(new Stop());
        addCommand(new Takeoff());
    }
    
    public void addCommand(Command c) {
        commands.add(c);
    }
    
    public void removeCommand(Command c) {
        commands.remove(c);
    }
    
    public void executeCommand(String command, String[] args) {
        for (Command c : commands) {
            if (c.getName().equals(command)) {
                c.execute(args);
            }
        }
    }
}
