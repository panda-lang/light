package net.dzikoysk.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;

public class CommandScope extends Scope {

    private final String commandName;

    public CommandScope(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getName() {
        return getCommandName();
    }

}
