package net.dzikoysk.luminosity.core.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.lang.scope.EventScope;

import java.util.ArrayList;
import java.util.Collection;

public class LuminosityListener implements Listener {

    private final MoonlightScript moonlightScript;
    private final Collection<EventScope> eventScopeCollection;

    public LuminosityListener(MoonlightScript moonlightScript) {
        this.moonlightScript = moonlightScript;
        this.eventScopeCollection = new ArrayList<>();
    }

    @EventHandler
    public void onEvent(Event event) {
        for (EventScope eventScope : eventScopeCollection) {
            eventScope.run(null);
        }
    }

    public void registerEventScope(EventScope eventScope) {
        eventScopeCollection.add(eventScope);
    }

    public Collection<EventScope> getEventScopeCollection() {
        return eventScopeCollection;
    }

}
