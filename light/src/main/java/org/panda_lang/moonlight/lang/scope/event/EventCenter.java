package org.panda_lang.moonlight.lang.scope.event;

import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

import java.util.HashMap;
import java.util.Map;

public class EventCenter {

    private final Map<String, ScopeUnit> eventUnitMap;

    public EventCenter() {
        this.eventUnitMap = new HashMap<>();
    }

    public ScopeUnit addEventUnit(ScopeUnit scopeUnit) {
        return eventUnitMap.put(scopeUnit.getEventName(), scopeUnit);
    }

    public ScopeUnit getEventUnit(String eventName) {
        ScopeUnit scopeUnit = eventUnitMap.get(eventName);
        if (scopeUnit == null) {
            scopeUnit = new ScopeUnit(eventName);
            addEventUnit(scopeUnit);
        }
        return scopeUnit;
    }

    public Map<String, ScopeUnit> getEventUnitMap() {
        return eventUnitMap;
    }

}
