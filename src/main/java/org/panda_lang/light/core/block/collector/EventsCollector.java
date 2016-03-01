package org.panda_lang.light.core.block.collector;

import org.panda_lang.light.core.block.EventBlock;
import org.panda_lang.panda.core.Particle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventsCollector {

    private final Map<String, Collection<EventBlock>> events;

    public EventsCollector() {
        this.events = new HashMap<>();
    }

    public void callEvents(String eventName, Particle particle) {
        Collection<EventBlock> eventBlockCollection = events.get(eventName);
        if (eventBlockCollection == null) {
            return;
        }
        for (EventBlock eventBlock : eventBlockCollection) {
            eventBlock.run(particle);
        }
    }

    public void registerEventBlock(EventBlock eventBlock) {
        Collection<EventBlock> eventBlockCollection = events.get(eventBlock.getEventName());
        if (eventBlockCollection == null) {
            eventBlockCollection = new ArrayList<>();
        }
        eventBlockCollection.add(eventBlock);
        events.put(eventBlock.getEventName(), eventBlockCollection);
    }

    public Map<String, Collection<EventBlock>> getEvents() {
        return events;
    }

}
