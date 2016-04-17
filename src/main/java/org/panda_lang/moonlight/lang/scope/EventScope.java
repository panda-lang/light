package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class EventScope extends Scope {

    private final ScopeUnit scopeUnit;

    public EventScope(ScopeUnit scopeUnit) {
        this.scopeUnit = scopeUnit;
    }

    @Override
    public boolean argumentBelongsToScope(ArgumentRepresentation argumentRepresentation) {
        return scopeUnit.contains(argumentRepresentation);
    }

    public String getEventName() {
        return scopeUnit.getEventName();
    }

    public ScopeUnit getScopeUnit() {
        return scopeUnit;
    }

    @Override
    public String getName() {
        return getEventName();
    }

}
