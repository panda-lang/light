package org.panda_lang.light.lang.scope;

public class EventScope extends org.panda_lang.light.core.element.scope.Scope {

    private final org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit;

    public EventScope(org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit) {
        this.scopeUnit = scopeUnit;
    }

    @Override
    public boolean argumentBelongsToScope(org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation) {
        return scopeUnit.contains(argumentRepresentation);
    }

    public String getEventName() {
        return scopeUnit.getEventName();
    }

    public org.panda_lang.light.core.element.scope.ScopeUnit getScopeUnit() {
        return scopeUnit;
    }

    @Override
    public boolean isReturned() {
        return true;
    }

    @Override
    public String getName() {
        return getEventName();
    }

}
