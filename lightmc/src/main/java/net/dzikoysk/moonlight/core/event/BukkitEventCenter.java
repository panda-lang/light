package net.dzikoysk.moonlight.core.event;

import net.dzikoysk.moonlight.Moonlight;
import org.bukkit.event.Event;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;
import org.panda_lang.moonlight.lang.scope.EventScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BukkitEventCenter {

    private final Moonlight moonlight;
    private final Map<String, BukkitEvent> bukkitEventMap;

    public BukkitEventCenter(Moonlight moonlight) {
        this.moonlight = moonlight;
        this.bukkitEventMap = new HashMap<>();
    }

    public ScopeUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        ScopeUnit scopeUnit = moonlight.getMoonlightCore().getEventCenter().getEventUnit(eventName);
        BukkitEvent bukkitEvent = new BukkitEvent(eventName, scopeUnit, eventClass);
        bukkitEventMap.put(eventName, bukkitEvent);
        return scopeUnit;
    }

    public void registerListeners() {
        Collection<MoonlightScript> moonlightScripts = moonlight.getMoonlightCore().getScripts();

        for (MoonlightScript moonlightScript : moonlightScripts) {
            Map<String, Collection<EventScope>> eventBlockMap = moonlightScript.getEventBlockMap();

            for (Map.Entry<String, Collection<EventScope>> entry : eventBlockMap.entrySet()) {
                BukkitEvent bukkitEvent = bukkitEventMap.get(entry.getKey());
                if (bukkitEvent == null) {
                    continue;
                }

                BukkitListener bukkitListener = bukkitEvent.getBukkitListener();
                for (EventScope eventScope : entry.getValue()) {
                    bukkitListener.registerEventScope(eventScope);
                }

                if (bukkitEvent.isUsed()) {
                    bukkitEvent.register();
                }
            }
        }

    }

}
