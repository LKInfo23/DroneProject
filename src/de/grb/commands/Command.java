package de.grb.commands;

public abstract class Command {
    
    String name;
    
    public Command(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * Executes the command. Returns true if the command was executed successfully.
     * @param args The arguments for the command.
     * @return true if the command was executed successfully.
     */
    public abstract boolean execute(String[] args);
    
}
