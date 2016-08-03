package net.dzikoysk.lightmc.lang.scope;

import java.util.List;

public class CommandScope extends org.panda_lang.light.core.element.scope.Scope {

    private final String commandName;

    public CommandScope(String commandName) {
        this.commandName = commandName;
    }

    public List<String> getAliases() {
        return null;
    }

    public String getPermission() {
        return null;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getName() {
        return getCommandName();
    }

}
