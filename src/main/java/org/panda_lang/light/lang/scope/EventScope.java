package org.panda_lang.light.lang.scope;

import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.panda.core.parser.Atom;

public class EventScope extends Scope {

    private final String eventName;

    public EventScope(Atom atom) {
        this.eventName = atom.getBlockInfo().getSpecifiers().get(0);
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String getName() {
        return getEventName();
    }

}
