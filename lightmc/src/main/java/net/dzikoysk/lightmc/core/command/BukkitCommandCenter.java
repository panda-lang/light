package net.dzikoysk.lightmc.core.command;

import net.dzikoysk.lightmc.Light;

import java.util.HashMap;
import java.util.Map;

public class BukkitCommandCenter {

    private final Light light;
    private final Map<String, BukkitCommand> commands;

    public BukkitCommandCenter(Light light) {
        this.light = light;
        this.commands = new HashMap<>();
    }

    public void registerCommand(BukkitCommand bukkitCommand) {
        commands.put(bukkitCommand.getCommand(), bukkitCommand);
    }

    public Map<String, BukkitCommand> getCommands() {
        return commands;
    }

    public Light getLight() {
        return light;
    }

}
