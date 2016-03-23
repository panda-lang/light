package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;

public class EventScope extends Scope {

    private final String eventName;

    public EventScope(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String getName() {
        return getEventName();
    }

}
