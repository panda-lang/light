package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.lang.scope.event.EventUnit;

public class EventScope extends Scope {

    private final EventUnit eventUnit;

    public EventScope(EventUnit eventUnit) {
        this.eventUnit = eventUnit;
    }

    @Override
    public boolean argumentBelongsToScope(ArgumentRepresentation argumentRepresentation) {
        return eventUnit.contains(argumentRepresentation);
    }

    public String getEventName() {
        return eventUnit.getEventName();
    }

    public EventUnit getEventUnit() {
        return eventUnit;
    }

    @Override
    public String getName() {
        return getEventName();
    }

}
