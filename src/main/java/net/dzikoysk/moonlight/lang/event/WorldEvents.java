package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.world.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class WorldEvents implements BukkitElements {

    private final Moonlight moonlight;

    public WorldEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit worldSaveScopeUnit = moonlight.registerEvent(WorldSaveEvent.class, "world save");
        worldSaveScopeUnit.registerArgument("world", new ArgumentInitializer<WorldSaveEvent>() {
            @Override
            public Object get(Ray ray, WorldSaveEvent event) {
                return event.getWorld();
            }
        });
        worldSaveScopeUnit.registerArgument("event name", new ArgumentInitializer<WorldSaveEvent>() {
            @Override
            public Object get(Ray ray, WorldSaveEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit structureGrowScopeUnit = moonlight.registerEvent(StructureGrowEvent.class, "structure grow");
        structureGrowScopeUnit.registerArgument("location", new ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(Ray ray, StructureGrowEvent event) {
                return event.getLocation();
            }
        });
        structureGrowScopeUnit.registerArgument("player", new ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(Ray ray, StructureGrowEvent event) {
                return event.getPlayer();
            }
        });
        structureGrowScopeUnit.registerArgument("world", new ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(Ray ray, StructureGrowEvent event) {
                return event.getWorld();
            }
        });
        structureGrowScopeUnit.registerArgument("blocks", new ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(Ray ray, StructureGrowEvent event) {
                return event.getBlocks();
            }
        });
        structureGrowScopeUnit.registerArgument("event name", new ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(Ray ray, StructureGrowEvent event) {
                return event.getEventName();
            }
        });
        structureGrowScopeUnit.registerArgument("species", new ArgumentInitializer<StructureGrowEvent>() {
            @Override
            public Object get(Ray ray, StructureGrowEvent event) {
                return event.getSpecies();
            }
        });

        ScopeUnit portalCreateScopeUnit = moonlight.registerEvent(PortalCreateEvent.class, "portal create");
        portalCreateScopeUnit.registerArgument("reason", new ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(Ray ray, PortalCreateEvent event) {
                return event.getReason();
            }
        });
        portalCreateScopeUnit.registerArgument("world", new ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(Ray ray, PortalCreateEvent event) {
                return event.getWorld();
            }
        });
        portalCreateScopeUnit.registerArgument("blocks", new ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(Ray ray, PortalCreateEvent event) {
                return event.getBlocks();
            }
        });
        portalCreateScopeUnit.registerArgument("event name", new ArgumentInitializer<PortalCreateEvent>() {
            @Override
            public Object get(Ray ray, PortalCreateEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit chunkPopulateScopeUnit = moonlight.registerEvent(ChunkPopulateEvent.class, "chunk populate");
        chunkPopulateScopeUnit.registerArgument("chunk", new ArgumentInitializer<ChunkPopulateEvent>() {
            @Override
            public Object get(Ray ray, ChunkPopulateEvent event) {
                return event.getChunk();
            }
        });
        chunkPopulateScopeUnit.registerArgument("world", new ArgumentInitializer<ChunkPopulateEvent>() {
            @Override
            public Object get(Ray ray, ChunkPopulateEvent event) {
                return event.getWorld();
            }
        });
        chunkPopulateScopeUnit.registerArgument("event name", new ArgumentInitializer<ChunkPopulateEvent>() {
            @Override
            public Object get(Ray ray, ChunkPopulateEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit worldLoadScopeUnit = moonlight.registerEvent(WorldLoadEvent.class, "world load");
        worldLoadScopeUnit.registerArgument("world", new ArgumentInitializer<WorldLoadEvent>() {
            @Override
            public Object get(Ray ray, WorldLoadEvent event) {
                return event.getWorld();
            }
        });
        worldLoadScopeUnit.registerArgument("event name", new ArgumentInitializer<WorldLoadEvent>() {
            @Override
            public Object get(Ray ray, WorldLoadEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit chunkScopeUnit = moonlight.registerEvent(ChunkEvent.class, "chunk");
        chunkScopeUnit.registerArgument("chunk", new ArgumentInitializer<ChunkEvent>() {
            @Override
            public Object get(Ray ray, ChunkEvent event) {
                return event.getChunk();
            }
        });
        chunkScopeUnit.registerArgument("world", new ArgumentInitializer<ChunkEvent>() {
            @Override
            public Object get(Ray ray, ChunkEvent event) {
                return event.getWorld();
            }
        });
        chunkScopeUnit.registerArgument("event name", new ArgumentInitializer<ChunkEvent>() {
            @Override
            public Object get(Ray ray, ChunkEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit worldScopeUnit = moonlight.registerEvent(WorldEvent.class, "world");
        worldScopeUnit.registerArgument("world", new ArgumentInitializer<WorldEvent>() {
            @Override
            public Object get(Ray ray, WorldEvent event) {
                return event.getWorld();
            }
        });
        worldScopeUnit.registerArgument("event name", new ArgumentInitializer<WorldEvent>() {
            @Override
            public Object get(Ray ray, WorldEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit chunkUnloadScopeUnit = moonlight.registerEvent(ChunkUnloadEvent.class, "chunk unload");
        chunkUnloadScopeUnit.registerArgument("chunk", new ArgumentInitializer<ChunkUnloadEvent>() {
            @Override
            public Object get(Ray ray, ChunkUnloadEvent event) {
                return event.getChunk();
            }
        });
        chunkUnloadScopeUnit.registerArgument("world", new ArgumentInitializer<ChunkUnloadEvent>() {
            @Override
            public Object get(Ray ray, ChunkUnloadEvent event) {
                return event.getWorld();
            }
        });
        chunkUnloadScopeUnit.registerArgument("event name", new ArgumentInitializer<ChunkUnloadEvent>() {
            @Override
            public Object get(Ray ray, ChunkUnloadEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit spawnChangeScopeUnit = moonlight.registerEvent(SpawnChangeEvent.class, "spawn change");
        spawnChangeScopeUnit.registerArgument("previous location", new ArgumentInitializer<SpawnChangeEvent>() {
            @Override
            public Object get(Ray ray, SpawnChangeEvent event) {
                return event.getPreviousLocation();
            }
        });
        spawnChangeScopeUnit.registerArgument("world", new ArgumentInitializer<SpawnChangeEvent>() {
            @Override
            public Object get(Ray ray, SpawnChangeEvent event) {
                return event.getWorld();
            }
        });
        spawnChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<SpawnChangeEvent>() {
            @Override
            public Object get(Ray ray, SpawnChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit worldInitScopeUnit = moonlight.registerEvent(WorldInitEvent.class, "world init");
        worldInitScopeUnit.registerArgument("world", new ArgumentInitializer<WorldInitEvent>() {
            @Override
            public Object get(Ray ray, WorldInitEvent event) {
                return event.getWorld();
            }
        });
        worldInitScopeUnit.registerArgument("event name", new ArgumentInitializer<WorldInitEvent>() {
            @Override
            public Object get(Ray ray, WorldInitEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit chunkLoadScopeUnit = moonlight.registerEvent(ChunkLoadEvent.class, "chunk load");
        chunkLoadScopeUnit.registerArgument("chunk", new ArgumentInitializer<ChunkLoadEvent>() {
            @Override
            public Object get(Ray ray, ChunkLoadEvent event) {
                return event.getChunk();
            }
        });
        chunkLoadScopeUnit.registerArgument("world", new ArgumentInitializer<ChunkLoadEvent>() {
            @Override
            public Object get(Ray ray, ChunkLoadEvent event) {
                return event.getWorld();
            }
        });
        chunkLoadScopeUnit.registerArgument("event name", new ArgumentInitializer<ChunkLoadEvent>() {
            @Override
            public Object get(Ray ray, ChunkLoadEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit worldUnloadScopeUnit = moonlight.registerEvent(WorldUnloadEvent.class, "world unload");
        worldUnloadScopeUnit.registerArgument("world", new ArgumentInitializer<WorldUnloadEvent>() {
            @Override
            public Object get(Ray ray, WorldUnloadEvent event) {
                return event.getWorld();
            }
        });
        worldUnloadScopeUnit.registerArgument("event name", new ArgumentInitializer<WorldUnloadEvent>() {
            @Override
            public Object get(Ray ray, WorldUnloadEvent event) {
                return event.getEventName();
            }
        });

    }

}
