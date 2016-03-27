package org.panda_lang.moonlight.lang.scope.event;

import java.util.HashMap;
import java.util.Map;

public class EventCenter {

    private final Map<String, EventUnit> eventUnitMap;

    public EventCenter() {
        this.eventUnitMap = new HashMap<>();
    }

    public EventUnit addEventUnit(EventUnit eventUnit) {
        return eventUnitMap.put(eventUnit.getEventName(), eventUnit);
    }

    public EventUnit getEventUnit(String eventName) {
        EventUnit eventUnit = eventUnitMap.get(eventName);
        if (eventUnit == null) {
            eventUnit = new EventUnit(eventName);
            addEventUnit(eventUnit);
        }
        return eventUnit;
    }

    public Map<String, EventUnit> getEventUnitMap() {
        return eventUnitMap;
    }

}
