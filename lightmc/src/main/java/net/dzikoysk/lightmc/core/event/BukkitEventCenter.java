package net.dzikoysk.lightmc.core.event;

import net.dzikoysk.lightmc.Light;
import org.bukkit.event.Event;
import org.panda_lang.light.LightScript;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BukkitEventCenter {

    private final Light light;
    private final Map<String, BukkitEvent> bukkitEventMap;

    public BukkitEventCenter(Light light) {
        this.light = light;
        this.bukkitEventMap = new HashMap<>();
    }

    public org.panda_lang.light.core.element.scope.ScopeUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit = light.getLightCore().getEventCenter().getEventUnit(eventName);
        BukkitEvent bukkitEvent = new BukkitEvent(eventName, scopeUnit, eventClass);
        bukkitEventMap.put(eventName, bukkitEvent);
        return scopeUnit;
    }

    public void registerListeners() {
        Collection<LightScript> lightScripts = light.getLightCore().getScripts();

        for (LightScript lightScript : lightScripts) {
            Map<String, Collection<org.panda_lang.light.lang.scope.EventScope>> eventBlockMap = lightScript.getEventBlockMap();

            for (Map.Entry<String, Collection<org.panda_lang.light.lang.scope.EventScope>> entry : eventBlockMap.entrySet()) {
                BukkitEvent bukkitEvent = bukkitEventMap.get(entry.getKey());
                if (bukkitEvent == null) {
                    continue;
                }

                BukkitListener bukkitListener = bukkitEvent.getBukkitListener();
                for (org.panda_lang.light.lang.scope.EventScope eventScope : entry.getValue()) {
                    bukkitListener.registerEventScope(eventScope);
                }

                if (bukkitEvent.isUsed()) {
                    bukkitEvent.register();
                }
            }
        }

    }

}
