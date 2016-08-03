package net.dzikoysk.lightmc.core.event;

import net.dzikoysk.lightmc.Light;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;

public class BukkitEvent {

    private final String eventName;
    private final org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit;
    private final Class<? extends Event> eventClass;
    private final BukkitListener bukkitListener;
    private boolean registered;

    public BukkitEvent(String eventName, org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit, Class<? extends Event> eventClass) {
        this.eventName = eventName;
        this.scopeUnit = scopeUnit;
        this.eventClass = eventClass;
        this.bukkitListener = new BukkitListener();
    }

    public void register() {
        if (registered || eventClass == null) {
            return;
        }

        Bukkit.getPluginManager().registerEvent(eventClass, bukkitListener, EventPriority.NORMAL, bukkitListener, Light.getInstance());
        registered = true;
    }

    public boolean isUsed() {
        return bukkitListener.getEventScopeCollection().size() > 0;
    }

    public boolean isRegistered() {
        return registered;
    }

    public BukkitListener getBukkitListener() {
        return bukkitListener;
    }

    public Class<? extends Event> getEventClass() {
        return eventClass;
    }

    public org.panda_lang.light.core.element.scope.ScopeUnit getScopeUnit() {
        return scopeUnit;
    }

    public String getEventName() {
        return eventName;
    }

}
