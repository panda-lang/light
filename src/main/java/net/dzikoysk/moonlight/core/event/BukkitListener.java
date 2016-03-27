package net.dzikoysk.moonlight.core.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.lang.scope.EventScope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Memory;

import java.util.ArrayList;
import java.util.Collection;

public class BukkitListener implements Listener {

    private final MoonlightScript moonlightScript;
    private final Collection<EventScope> eventScopeCollection;

    public BukkitListener(MoonlightScript moonlightScript) {
        this.moonlightScript = moonlightScript;
        this.eventScopeCollection = new ArrayList<>();
    }

    @EventHandler
    public void onEvent(Event event) {
        Alice alice = new Alice(moonlightScript, new Memory(), null, null);
        new Ray(alice).scopeObject(event);

        for (EventScope eventScope : eventScopeCollection) {
            eventScope.run(alice);
        }
    }

    public void registerEventScope(EventScope eventScope) {
        eventScopeCollection.add(eventScope);
    }

    public Collection<EventScope> getEventScopeCollection() {
        return eventScopeCollection;
    }

}
