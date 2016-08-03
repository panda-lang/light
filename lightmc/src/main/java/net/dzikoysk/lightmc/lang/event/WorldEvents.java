package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.world.*;

public class WorldEvents implements BukkitElements {

    private final Light light;

    public WorldEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit worldSaveScopeUnit = light.registerEvent(WorldSaveEvent.class, "world save");
        worldSaveScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldSaveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldSaveEvent event) {
                return event.getWorld();
            }
        });
        worldSaveScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldSaveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldSaveEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit structureGrowScopeUnit = light.registerEvent(StructureGrowEvent.class, "structure grow");
        structureGrowScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, StructureGrowEvent event) {
                return event.getLocation();
            }
        });
        structureGrowScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, StructureGrowEvent event) {
                return event.getPlayer();
            }
        });
        structureGrowScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, StructureGrowEvent event) {
                return event.getWorld();
            }
        });
        structureGrowScopeUnit.registerArgument("blocks", new org.panda_lang.light.core.element.argument.ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, StructureGrowEvent event) {
                return event.getBlocks();
            }
        });
        structureGrowScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, StructureGrowEvent event) {
                return event.getEventName();
            }
        });
        structureGrowScopeUnit.registerArgument("species", new org.panda_lang.light.core.element.argument.ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, StructureGrowEvent event) {
                return event.getSpecies();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit portalCreateScopeUnit = light.registerEvent(PortalCreateEvent.class, "portal create");
        portalCreateScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PortalCreateEvent event) {
                return event.getReason();
            }
        });
        portalCreateScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PortalCreateEvent event) {
                return event.getWorld();
            }
        });
        portalCreateScopeUnit.registerArgument("blocks", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PortalCreateEvent event) {
                return event.getBlocks();
            }
        });
        portalCreateScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PortalCreateEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit chunkPopulateScopeUnit = light.registerEvent(ChunkPopulateEvent.class, "chunk populate");
        chunkPopulateScopeUnit.registerArgument("chunk", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkPopulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkPopulateEvent event) {
                return event.getChunk();
            }
        });
        chunkPopulateScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkPopulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkPopulateEvent event) {
                return event.getWorld();
            }
        });
        chunkPopulateScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkPopulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkPopulateEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit worldLoadScopeUnit = light.registerEvent(WorldLoadEvent.class, "world load");
        worldLoadScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldLoadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldLoadEvent event) {
                return event.getWorld();
            }
        });
        worldLoadScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldLoadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldLoadEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit chunkScopeUnit = light.registerEvent(ChunkEvent.class, "chunk");
        chunkScopeUnit.registerArgument("chunk", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkEvent event) {
                return event.getChunk();
            }
        });
        chunkScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkEvent event) {
                return event.getWorld();
            }
        });
        chunkScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit worldScopeUnit = light.registerEvent(WorldEvent.class, "world");
        worldScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldEvent event) {
                return event.getWorld();
            }
        });
        worldScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit chunkUnloadScopeUnit = light.registerEvent(ChunkUnloadEvent.class, "chunk unload");
        chunkUnloadScopeUnit.registerArgument("chunk", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkUnloadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkUnloadEvent event) {
                return event.getChunk();
            }
        });
        chunkUnloadScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkUnloadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkUnloadEvent event) {
                return event.getWorld();
            }
        });
        chunkUnloadScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkUnloadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkUnloadEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit spawnChangeScopeUnit = light.registerEvent(SpawnChangeEvent.class, "spawn change");
        spawnChangeScopeUnit.registerArgument("previous location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnChangeEvent event) {
                return event.getPreviousLocation();
            }
        });
        spawnChangeScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnChangeEvent event) {
                return event.getWorld();
            }
        });
        spawnChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit worldInitScopeUnit = light.registerEvent(WorldInitEvent.class, "world init");
        worldInitScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldInitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldInitEvent event) {
                return event.getWorld();
            }
        });
        worldInitScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldInitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldInitEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit chunkLoadScopeUnit = light.registerEvent(ChunkLoadEvent.class, "chunk load");
        chunkLoadScopeUnit.registerArgument("chunk", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkLoadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkLoadEvent event) {
                return event.getChunk();
            }
        });
        chunkLoadScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkLoadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkLoadEvent event) {
                return event.getWorld();
            }
        });
        chunkLoadScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ChunkLoadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ChunkLoadEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit worldUnloadScopeUnit = light.registerEvent(WorldUnloadEvent.class, "world unload");
        worldUnloadScopeUnit.registerArgument("world", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldUnloadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldUnloadEvent event) {
                return event.getWorld();
            }
        });
        worldUnloadScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<WorldUnloadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, WorldUnloadEvent event) {
                return event.getEventName();
            }
        });

    }

}
