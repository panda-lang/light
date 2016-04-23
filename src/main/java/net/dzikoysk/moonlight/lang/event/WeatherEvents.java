package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class WeatherEvents implements BukkitElements {

    private final Moonlight moonlight;

    public WeatherEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit weatherChangeScopeUnit = moonlight.registerEvent(WeatherChangeEvent.class, "weather change");
        weatherChangeScopeUnit.registerArgument("world", new ArgumentInitializer<WeatherChangeEvent>() {
            @Override
            public Object get(Ray ray, WeatherChangeEvent event) {
                return event.getWorld();
            }
        });
        weatherChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<WeatherChangeEvent>() {
            @Override
            public Object get(Ray ray, WeatherChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit lightningStrikeScopeUnit = moonlight.registerEvent(LightningStrikeEvent.class, "lightning strike");
        lightningStrikeScopeUnit.registerArgument("lightning", new ArgumentInitializer<LightningStrikeEvent>() {
            @Override
            public Object get(Ray ray, LightningStrikeEvent event) {
                return event.getLightning();
            }
        });
        lightningStrikeScopeUnit.registerArgument("world", new ArgumentInitializer<LightningStrikeEvent>() {
            @Override
            public Object get(Ray ray, LightningStrikeEvent event) {
                return event.getWorld();
            }
        });
        lightningStrikeScopeUnit.registerArgument("event name", new ArgumentInitializer<LightningStrikeEvent>() {
            @Override
            public Object get(Ray ray, LightningStrikeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit thunderChangeScopeUnit = moonlight.registerEvent(ThunderChangeEvent.class, "thunder change");
        thunderChangeScopeUnit.registerArgument("world", new ArgumentInitializer<ThunderChangeEvent>() {
            @Override
            public Object get(Ray ray, ThunderChangeEvent event) {
                return event.getWorld();
            }
        });
        thunderChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<ThunderChangeEvent>() {
            @Override
            public Object get(Ray ray, ThunderChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit weatherScopeUnit = moonlight.registerEvent(WeatherEvent.class, "weather");
        weatherScopeUnit.registerArgument("world", new ArgumentInitializer<WeatherEvent>() {
            @Override
            public Object get(Ray ray, WeatherEvent event) {
                return event.getWorld();
            }
        });
        weatherScopeUnit.registerArgument("event name", new ArgumentInitializer<WeatherEvent>() {
            @Override
            public Object get(Ray ray, WeatherEvent event) {
                return event.getEventName();
            }
        });

    }

}
