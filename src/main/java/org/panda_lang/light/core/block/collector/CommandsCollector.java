package org.panda_lang.light.core.block.collector;

import org.panda_lang.light.core.block.CommandBlock;

import java.util.HashMap;
import java.util.Map;

public class CommandsCollector {

    private final Map<String, CommandBlock> commands;

    public CommandsCollector() {
        this.commands = new HashMap<>();
    }

    public void registerCommandBlock(CommandBlock commandBlock) {
        commands.put(commandBlock.getCommandName(), commandBlock);
    }

    public Map<String, CommandBlock> getCommands() {
        return commands;
    }

}
