package net.dzikoysk.lightmc.core.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Memory;

import java.util.ArrayList;
import java.util.Collection;

public class BukkitListener implements Listener, EventExecutor {

    private final Collection<org.panda_lang.light.lang.scope.EventScope> eventScopeCollection;

    public BukkitListener() {
        this.eventScopeCollection = new ArrayList<>();
    }

    @EventHandler
    public void onEvent(Event event) {
        Alice alice = new Alice(null, new Memory(), null, null);

        org.panda_lang.light.core.Ray ray = new org.panda_lang.light.core.Ray(alice);
        ray.scopeObject(event);

        for (org.panda_lang.light.lang.scope.EventScope eventScope : eventScopeCollection) {
            eventScope.execute(alice);
        }
    }

    @Override
    public void execute(Listener listener, Event event) throws EventException {
        if (listener instanceof BukkitListener) {
            ((BukkitListener) listener).onEvent(event);
        }
    }

    public void registerEventScope(org.panda_lang.light.lang.scope.EventScope eventScope) {
        eventScopeCollection.add(eventScope);
    }

    public Collection<org.panda_lang.light.lang.scope.EventScope> getEventScopeCollection() {
        return eventScopeCollection;
    }

}
