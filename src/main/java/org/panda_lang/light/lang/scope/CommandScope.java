package org.panda_lang.light.lang.scope;

import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.panda.core.parser.Atom;

public class CommandScope extends Scope {

    private final String commandName;

    public CommandScope(Atom atom) {
        this.commandName = atom.getBlockInfo().getSpecifiers().get(0);
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getName() {
        return getCommandName();
    }

}
