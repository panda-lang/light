package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class HangingEvents implements BukkitElements {

    private final Moonlight moonlight;

    public HangingEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit hangingPlaceScopeUnit = moonlight.registerEvent(HangingPlaceEvent.class, "hanging place");
        hangingPlaceScopeUnit.registerArgument("block face", new ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(Ray ray, HangingPlaceEvent event) {
                return event.getBlockFace();
            }
        });
        hangingPlaceScopeUnit.registerArgument("event name", new ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(Ray ray, HangingPlaceEvent event) {
                return event.getEventName();
            }
        });
        hangingPlaceScopeUnit.registerArgument("entity", new ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(Ray ray, HangingPlaceEvent event) {
                return event.getEntity();
            }
        });
        hangingPlaceScopeUnit.registerArgument("player", new ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(Ray ray, HangingPlaceEvent event) {
                return event.getPlayer();
            }
        });
        hangingPlaceScopeUnit.registerArgument("block", new ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(Ray ray, HangingPlaceEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit hangingBreakByEntityScopeUnit = moonlight.registerEvent(HangingBreakByEntityEvent.class, "hanging break by entity");
        hangingBreakByEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakByEntityEvent event) {
                return event.getEntity();
            }
        });
        hangingBreakByEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakByEntityEvent event) {
                return event.getEventName();
            }
        });
        hangingBreakByEntityScopeUnit.registerArgument("remover", new ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakByEntityEvent event) {
                return event.getRemover();
            }
        });
        hangingBreakByEntityScopeUnit.registerArgument("cause", new ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakByEntityEvent event) {
                return event.getCause();
            }
        });

        ScopeUnit hangingScopeUnit = moonlight.registerEvent(HangingEvent.class, "hanging");
        hangingScopeUnit.registerArgument("entity", new ArgumentInitializer<HangingEvent>() {
            @Override
            public Object get(Ray ray, HangingEvent event) {
                return event.getEntity();
            }
        });
        hangingScopeUnit.registerArgument("event name", new ArgumentInitializer<HangingEvent>() {
            @Override
            public Object get(Ray ray, HangingEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit hangingBreakScopeUnit = moonlight.registerEvent(HangingBreakEvent.class, "hanging break");
        hangingBreakScopeUnit.registerArgument("entity", new ArgumentInitializer<HangingBreakEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakEvent event) {
                return event.getEntity();
            }
        });
        hangingBreakScopeUnit.registerArgument("event name", new ArgumentInitializer<HangingBreakEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakEvent event) {
                return event.getEventName();
            }
        });
        hangingBreakScopeUnit.registerArgument("cause", new ArgumentInitializer<HangingBreakEvent>() {
            @Override
            public Object get(Ray ray, HangingBreakEvent event) {
                return event.getCause();
            }
        });


    }

}
