package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;

public class WeatherEvents implements BukkitElements {

    private final Light light;

    public WeatherEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit weatherChangeScopeUnit = light.registerEvent(WeatherChangeEvent.class, "weather change");
        weatherChangeScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WeatherChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WeatherChangeEvent event) {
                return event.getWorld();
            }
        });
        weatherChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WeatherChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WeatherChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit lightningStrikeScopeUnit = light.registerEvent(LightningStrikeEvent.class, "lightning strike");
        lightningStrikeScopeUnit.registerArgument("lightning", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LightningStrikeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LightningStrikeEvent event) {
                return event.getLightning();
            }
        });
        lightningStrikeScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LightningStrikeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LightningStrikeEvent event) {
                return event.getWorld();
            }
        });
        lightningStrikeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LightningStrikeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LightningStrikeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit thunderChangeScopeUnit = light.registerEvent(ThunderChangeEvent.class, "thunder change");
        thunderChangeScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ThunderChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ThunderChangeEvent event) {
                return event.getWorld();
            }
        });
        thunderChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ThunderChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ThunderChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit weatherScopeUnit = light.registerEvent(WeatherEvent.class, "weather");
        weatherScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WeatherEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WeatherEvent event) {
                return event.getWorld();
            }
        });
        weatherScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WeatherEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WeatherEvent event) {
                return event.getEventName();
            }
        });

    }

}
