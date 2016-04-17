package net.dzikoysk.moonlight.core.event;

import net.dzikoysk.moonlight.Moonlight;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class BukkitEvent {

    private final String eventName;
    private final ScopeUnit scopeUnit;
    private final Class<? extends Event> eventClass;
    private final BukkitListener bukkitListener;
    private boolean registered;

    public BukkitEvent(String eventName, ScopeUnit scopeUnit, Class<? extends Event> eventClass) {
        this.eventName = eventName;
        this.scopeUnit = scopeUnit;
        this.eventClass = eventClass;
        this.bukkitListener = new BukkitListener();
    }

    public void register() {
        if (registered) {
            return;
        }

        Bukkit.getPluginManager().registerEvent(eventClass, bukkitListener, EventPriority.NORMAL, bukkitListener, Moonlight.getInstance());
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

    public ScopeUnit getScopeUnit() {
        return scopeUnit;
    }

    public String getEventName() {
        return eventName;
    }

}
