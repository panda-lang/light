package net.dzikoysk.lightmc.core.command;

import org.bukkit.command.CommandSender;

public class BukkitCommandInfo {

    private final CommandSender commandSender;
    private final String[] arguments;

    public BukkitCommandInfo(CommandSender commandSender, String[] arguments) {
        this.commandSender = commandSender;
        this.arguments = arguments;
    }

    public String[] getArguments() {
        return arguments;
    }

    public CommandSender getCommandSender() {
        return commandSender;
    }

}
