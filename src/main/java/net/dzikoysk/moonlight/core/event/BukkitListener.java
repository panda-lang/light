package net.dzikoysk.moonlight.core.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.lang.scope.EventScope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Memory;

import java.util.ArrayList;
import java.util.Collection;

public class BukkitListener implements Listener, EventExecutor {

    private final Collection<EventScope> eventScopeCollection;

    public BukkitListener() {
        this.eventScopeCollection = new ArrayList<>();
    }

    @EventHandler
    public void onEvent(Event event) {
        Alice alice = new Alice(null, new Memory(), null, null);

        Ray ray = new Ray(alice);
        ray.scopeObject(event);

        System.out.println(alice + " : " + ray + " : " + event);

        for (EventScope eventScope : eventScopeCollection) {
            eventScope.execute(alice);
        }
    }

    @Override
    public void execute(Listener listener, Event event) throws EventException {
        if (listener instanceof BukkitListener) {
            ((BukkitListener) listener).onEvent(event);
        }
    }

    public void registerEventScope(EventScope eventScope) {
        eventScopeCollection.add(eventScope);
    }

    public Collection<EventScope> getEventScopeCollection() {
        return eventScopeCollection;
    }

}
