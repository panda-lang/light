package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.vehicle.*;

public class VehicleEvents implements BukkitElements {

    private final Light light;

    public VehicleEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit vehicleDamageScopeUnit = light.registerEvent(VehicleDamageEvent.class, "vehicle damage");
        vehicleDamageScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDamageEvent event) {
                return event.getVehicle();
            }
        });
        vehicleDamageScopeUnit.registerArgument("damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDamageEvent event) {
                return event.getDamage();
            }
        });
        vehicleDamageScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDamageEvent event) {
                return event.getEventName();
            }
        });
        vehicleDamageScopeUnit.registerArgument("attacker", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDamageEvent event) {
                return event.getAttacker();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleCollisionScopeUnit = light.registerEvent(VehicleCollisionEvent.class, "vehicle collision");
        vehicleCollisionScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleCollisionEvent event) {
                return event.getVehicle();
            }
        });
        vehicleCollisionScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleCollisionEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleEnterScopeUnit = light.registerEvent(VehicleEnterEvent.class, "vehicle enter");
        vehicleEnterScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEnterEvent event) {
                return event.getVehicle();
            }
        });
        vehicleEnterScopeUnit.registerArgument("entered", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEnterEvent event) {
                return event.getEntered();
            }
        });
        vehicleEnterScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEnterEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleDestroyScopeUnit = light.registerEvent(VehicleDestroyEvent.class, "vehicle destroy");
        vehicleDestroyScopeUnit.registerArgument("attacker", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDestroyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDestroyEvent event) {
                return event.getAttacker();
            }
        });
        vehicleDestroyScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDestroyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDestroyEvent event) {
                return event.getVehicle();
            }
        });
        vehicleDestroyScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleDestroyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleDestroyEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleEntityCollisionScopeUnit = light.registerEvent(VehicleEntityCollisionEvent.class, "vehicle entity collision");
        vehicleEntityCollisionScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEntityCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEntityCollisionEvent event) {
                return event.getEntity();
            }
        });
        vehicleEntityCollisionScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEntityCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEntityCollisionEvent event) {
                return event.getVehicle();
            }
        });
        vehicleEntityCollisionScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEntityCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEntityCollisionEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleMoveScopeUnit = light.registerEvent(VehicleMoveEvent.class, "vehicle move");
        vehicleMoveScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleMoveEvent event) {
                return event.getFrom();
            }
        });
        vehicleMoveScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleMoveEvent event) {
                return event.getVehicle();
            }
        });
        vehicleMoveScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleMoveEvent event) {
                return event.getTo();
            }
        });
        vehicleMoveScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleMoveEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleUpdateScopeUnit = light.registerEvent(VehicleUpdateEvent.class, "vehicle update");
        vehicleUpdateScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleUpdateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleUpdateEvent event) {
                return event.getVehicle();
            }
        });
        vehicleUpdateScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleUpdateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleUpdateEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleScopeUnit = light.registerEvent(VehicleEvent.class, "vehicle");
        vehicleScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEvent event) {
                return event.getVehicle();
            }
        });
        vehicleScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleBlockCollisionScopeUnit = light.registerEvent(VehicleBlockCollisionEvent.class, "vehicle block collision");
        vehicleBlockCollisionScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleBlockCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleBlockCollisionEvent event) {
                return event.getVehicle();
            }
        });
        vehicleBlockCollisionScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleBlockCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleBlockCollisionEvent event) {
                return event.getBlock();
            }
        });
        vehicleBlockCollisionScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleBlockCollisionEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleBlockCollisionEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleExitScopeUnit = light.registerEvent(VehicleExitEvent.class, "vehicle exit");
        vehicleExitScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleExitEvent event) {
                return event.getVehicle();
            }
        });
        vehicleExitScopeUnit.registerArgument("exited", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleExitEvent event) {
                return event.getExited();
            }
        });
        vehicleExitScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleExitEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit vehicleCreateScopeUnit = light.registerEvent(VehicleCreateEvent.class, "vehicle create");
        vehicleCreateScopeUnit.registerArgument("vehicle", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleCreateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleCreateEvent event) {
                return event.getVehicle();
            }
        });
        vehicleCreateScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VehicleCreateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VehicleCreateEvent event) {
                return event.getEventName();
            }
        });

    }

}
