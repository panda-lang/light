package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;

public class HangingEvents implements BukkitElements {

    private final Light light;

    public HangingEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit hangingPlaceScopeUnit = light.registerEvent(HangingPlaceEvent.class, "hanging place");
        hangingPlaceScopeUnit.registerArgument("block face", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingPlaceEvent event) {
                return event.getBlockFace();
            }
        });
        hangingPlaceScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingPlaceEvent event) {
                return event.getEventName();
            }
        });
        hangingPlaceScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingPlaceEvent event) {
                return event.getEntity();
            }
        });
        hangingPlaceScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingPlaceEvent event) {
                return event.getPlayer();
            }
        });
        hangingPlaceScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingPlaceEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit hangingBreakByEntityScopeUnit = light.registerEvent(HangingBreakByEntityEvent.class, "hanging break by entity");
        hangingBreakByEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakByEntityEvent event) {
                return event.getEntity();
            }
        });
        hangingBreakByEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakByEntityEvent event) {
                return event.getEventName();
            }
        });
        hangingBreakByEntityScopeUnit.registerArgument("remover", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakByEntityEvent event) {
                return event.getRemover();
            }
        });
        hangingBreakByEntityScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakByEntityEvent event) {
                return event.getCause();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit hangingScopeUnit = light.registerEvent(HangingEvent.class, "hanging");
        hangingScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingEvent event) {
                return event.getEntity();
            }
        });
        hangingScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit hangingBreakScopeUnit = light.registerEvent(HangingBreakEvent.class, "hanging break");
        hangingBreakScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakEvent event) {
                return event.getEntity();
            }
        });
        hangingBreakScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakEvent event) {
                return event.getEventName();
            }
        });
        hangingBreakScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HangingBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HangingBreakEvent event) {
                return event.getCause();
            }
        });


    }

}
