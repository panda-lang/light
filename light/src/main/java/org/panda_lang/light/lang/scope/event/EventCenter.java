package org.panda_lang.light.lang.scope.event;

import java.util.HashMap;
import java.util.Map;

public class EventCenter {

    private final Map<String, org.panda_lang.light.core.element.scope.ScopeUnit> eventUnitMap;

    public EventCenter() {
        this.eventUnitMap = new HashMap<>();
    }

    public org.panda_lang.light.core.element.scope.ScopeUnit addEventUnit(org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit) {
        return eventUnitMap.put(scopeUnit.getEventName(), scopeUnit);
    }

    public org.panda_lang.light.core.element.scope.ScopeUnit getEventUnit(String eventName) {
        org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit = eventUnitMap.get(eventName);
        if (scopeUnit == null) {
            scopeUnit = new org.panda_lang.light.core.element.scope.ScopeUnit(eventName);
            addEventUnit(scopeUnit);
        }
        return scopeUnit;
    }

    public Map<String, org.panda_lang.light.core.element.scope.ScopeUnit> getEventUnitMap() {
        return eventUnitMap;
    }

}
