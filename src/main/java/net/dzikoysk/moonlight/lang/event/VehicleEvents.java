package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.vehicle.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class VehicleEvents implements BukkitElements {

    private final Moonlight moonlight;

    public VehicleEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit vehicleDamageScopeUnit = moonlight.registerEvent(VehicleDamageEvent.class, "vehicle damage");
        vehicleDamageScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(Ray ray, VehicleDamageEvent event) {
                return event.getVehicle();
            }
        });
        vehicleDamageScopeUnit.registerArgument("damage", new ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(Ray ray, VehicleDamageEvent event) {
                return event.getDamage();
            }
        });
        vehicleDamageScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(Ray ray, VehicleDamageEvent event) {
                return event.getEventName();
            }
        });
        vehicleDamageScopeUnit.registerArgument("attacker", new ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(Ray ray, VehicleDamageEvent event) {
                return event.getAttacker();
            }
        });

        ScopeUnit vehicleCollisionScopeUnit = moonlight.registerEvent(VehicleCollisionEvent.class, "vehicle collision");
        vehicleCollisionScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleCollisionEvent event) {
                return event.getVehicle();
            }
        });
        vehicleCollisionScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleCollisionEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleEnterScopeUnit = moonlight.registerEvent(VehicleEnterEvent.class, "vehicle enter");
        vehicleEnterScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleEnterEvent>() {
            @Override
            public Object get(Ray ray, VehicleEnterEvent event) {
                return event.getVehicle();
            }
        });
        vehicleEnterScopeUnit.registerArgument("entered", new ArgumentInitializer<VehicleEnterEvent>() {
            @Override
            public Object get(Ray ray, VehicleEnterEvent event) {
                return event.getEntered();
            }
        });
        vehicleEnterScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleEnterEvent>() {
            @Override
            public Object get(Ray ray, VehicleEnterEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleDestroyScopeUnit = moonlight.registerEvent(VehicleDestroyEvent.class, "vehicle destroy");
        vehicleDestroyScopeUnit.registerArgument("attacker", new ArgumentInitializer<VehicleDestroyEvent>() {
            @Override
            public Object get(Ray ray, VehicleDestroyEvent event) {
                return event.getAttacker();
            }
        });
        vehicleDestroyScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleDestroyEvent>() {
            @Override
            public Object get(Ray ray, VehicleDestroyEvent event) {
                return event.getVehicle();
            }
        });
        vehicleDestroyScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleDestroyEvent>() {
            @Override
            public Object get(Ray ray, VehicleDestroyEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleEntityCollisionScopeUnit = moonlight.registerEvent(VehicleEntityCollisionEvent.class, "vehicle entity collision");
        vehicleEntityCollisionScopeUnit.registerArgument("entity", new ArgumentInitializer<VehicleEntityCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleEntityCollisionEvent event) {
                return event.getEntity();
            }
        });
        vehicleEntityCollisionScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleEntityCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleEntityCollisionEvent event) {
                return event.getVehicle();
            }
        });
        vehicleEntityCollisionScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleEntityCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleEntityCollisionEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleMoveScopeUnit = moonlight.registerEvent(VehicleMoveEvent.class, "vehicle move");
        vehicleMoveScopeUnit.registerArgument("from", new ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(Ray ray, VehicleMoveEvent event) {
                return event.getFrom();
            }
        });
        vehicleMoveScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(Ray ray, VehicleMoveEvent event) {
                return event.getVehicle();
            }
        });
        vehicleMoveScopeUnit.registerArgument("to", new ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(Ray ray, VehicleMoveEvent event) {
                return event.getTo();
            }
        });
        vehicleMoveScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(Ray ray, VehicleMoveEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleUpdateScopeUnit = moonlight.registerEvent(VehicleUpdateEvent.class, "vehicle update");
        vehicleUpdateScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleUpdateEvent>() {
            @Override
            public Object get(Ray ray, VehicleUpdateEvent event) {
                return event.getVehicle();
            }
        });
        vehicleUpdateScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleUpdateEvent>() {
            @Override
            public Object get(Ray ray, VehicleUpdateEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleScopeUnit = moonlight.registerEvent(VehicleEvent.class, "vehicle");
        vehicleScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleEvent>() {
            @Override
            public Object get(Ray ray, VehicleEvent event) {
                return event.getVehicle();
            }
        });
        vehicleScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleEvent>() {
            @Override
            public Object get(Ray ray, VehicleEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleBlockCollisionScopeUnit = moonlight.registerEvent(VehicleBlockCollisionEvent.class, "vehicle block collision");
        vehicleBlockCollisionScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleBlockCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleBlockCollisionEvent event) {
                return event.getVehicle();
            }
        });
        vehicleBlockCollisionScopeUnit.registerArgument("block", new ArgumentInitializer<VehicleBlockCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleBlockCollisionEvent event) {
                return event.getBlock();
            }
        });
        vehicleBlockCollisionScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleBlockCollisionEvent>() {
            @Override
            public Object get(Ray ray, VehicleBlockCollisionEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleExitScopeUnit = moonlight.registerEvent(VehicleExitEvent.class, "vehicle exit");
        vehicleExitScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleExitEvent>() {
            @Override
            public Object get(Ray ray, VehicleExitEvent event) {
                return event.getVehicle();
            }
        });
        vehicleExitScopeUnit.registerArgument("exited", new ArgumentInitializer<VehicleExitEvent>() {
            @Override
            public Object get(Ray ray, VehicleExitEvent event) {
                return event.getExited();
            }
        });
        vehicleExitScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleExitEvent>() {
            @Override
            public Object get(Ray ray, VehicleExitEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit vehicleCreateScopeUnit = moonlight.registerEvent(VehicleCreateEvent.class, "vehicle create");
        vehicleCreateScopeUnit.registerArgument("vehicle", new ArgumentInitializer<VehicleCreateEvent>() {
            @Override
            public Object get(Ray ray, VehicleCreateEvent event) {
                return event.getVehicle();
            }
        });
        vehicleCreateScopeUnit.registerArgument("event name", new ArgumentInitializer<VehicleCreateEvent>() {
            @Override
            public Object get(Ray ray, VehicleCreateEvent event) {
                return event.getEventName();
            }
        });

    }

}
