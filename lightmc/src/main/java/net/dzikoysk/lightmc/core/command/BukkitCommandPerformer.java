package net.dzikoysk.lightmc.core.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class BukkitCommandPerformer extends Command {

    private final BukkitCommand bukkitCommand;

    public BukkitCommandPerformer(String command, BukkitCommand bukkitCommand) {
        super(command);
        this.bukkitCommand = bukkitCommand;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        return bukkitCommand != null && bukkitCommand.onCommand(sender, this, commandLabel, args);
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (bukkitCommand == null) {
            return null;
        }
        return bukkitCommand.onTabComplete(sender, this, alias, args);
    }

    public BukkitCommand getBukkitCommand() {
        return bukkitCommand;
    }

}
