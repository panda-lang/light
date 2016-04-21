package net.dzikoysk.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;

import java.util.List;

public class CommandScope extends Scope {

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
