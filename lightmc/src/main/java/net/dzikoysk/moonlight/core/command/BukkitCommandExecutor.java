package net.dzikoysk.moonlight.core.command;

import org.bukkit.command.CommandSender;

public interface BukkitCommandExecutor {

    void execute(CommandSender sender, String[] args);

}
