package net.dzikoysk.moonlight.core.event;

import org.bukkit.event.Event;
import org.panda_lang.moonlight.lang.scope.event.EventUnit;

import java.util.HashMap;
import java.util.Map;

public class BukkitEventsCenter {

    private final Map<Class<? extends Event>, EventUnit> eventMap;

    public BukkitEventsCenter() {
        this.eventMap = new HashMap<>();
    }

    public EventUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        EventUnit eventUnit = new EventUnit(eventName);
        eventMap.put(eventClass, eventUnit);
        return eventUnit;
    }

    public Map<Class<? extends Event>, EventUnit> getEventMap() {
        return eventMap;
    }

}
