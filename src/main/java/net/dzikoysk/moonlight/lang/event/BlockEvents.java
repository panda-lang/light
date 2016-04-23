package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.block.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class BlockEvents implements BukkitElements {

    private final Moonlight moonlight;

    public BlockEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit blockPistonExtendScopeUnit = moonlight.registerEvent(BlockPistonExtendEvent.class, "block piston extend");
        blockPistonExtendScopeUnit.registerArgument("blocks", new ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonExtendEvent event) {
                return event.getBlocks();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("direction", new ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonExtendEvent event) {
                return event.getDirection();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonExtendEvent event) {
                return event.getEventName();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("length", new ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonExtendEvent event) {
                return event.getLength();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("block", new ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonExtendEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockDispenseScopeUnit = moonlight.registerEvent(BlockDispenseEvent.class, "block dispense");
        blockDispenseScopeUnit.registerArgument("velocity", new ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(Ray ray, BlockDispenseEvent event) {
                return event.getVelocity();
            }
        });
        blockDispenseScopeUnit.registerArgument("item", new ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(Ray ray, BlockDispenseEvent event) {
                return event.getItem();
            }
        });
        blockDispenseScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(Ray ray, BlockDispenseEvent event) {
                return event.getEventName();
            }
        });
        blockDispenseScopeUnit.registerArgument("block", new ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(Ray ray, BlockDispenseEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockRedstoneScopeUnit = moonlight.registerEvent(BlockRedstoneEvent.class, "block redstone");
        blockRedstoneScopeUnit.registerArgument("old current", new ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(Ray ray, BlockRedstoneEvent event) {
                return event.getOldCurrent();
            }
        });
        blockRedstoneScopeUnit.registerArgument("block", new ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(Ray ray, BlockRedstoneEvent event) {
                return event.getBlock();
            }
        });
        blockRedstoneScopeUnit.registerArgument("new current", new ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(Ray ray, BlockRedstoneEvent event) {
                return event.getNewCurrent();
            }
        });
        blockRedstoneScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(Ray ray, BlockRedstoneEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockFadeScopeUnit = moonlight.registerEvent(BlockFadeEvent.class, "block fade");
        blockFadeScopeUnit.registerArgument("new state", new ArgumentInitializer<BlockFadeEvent>() {
            @Override
            public Object get(Ray ray, BlockFadeEvent event) {
                return event.getNewState();
            }
        });
        blockFadeScopeUnit.registerArgument("block", new ArgumentInitializer<BlockFadeEvent>() {
            @Override
            public Object get(Ray ray, BlockFadeEvent event) {
                return event.getBlock();
            }
        });
        blockFadeScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockFadeEvent>() {
            @Override
            public Object get(Ray ray, BlockFadeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockBreakScopeUnit = moonlight.registerEvent(BlockBreakEvent.class, "block break");
        blockBreakScopeUnit.registerArgument("player", new ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(Ray ray, BlockBreakEvent event) {
                return event.getPlayer();
            }
        });
        blockBreakScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(Ray ray, BlockBreakEvent event) {
                return event.getEventName();
            }
        });
        blockBreakScopeUnit.registerArgument("exp to drop", new ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(Ray ray, BlockBreakEvent event) {
                return event.getExpToDrop();
            }
        });
        blockBreakScopeUnit.registerArgument("block", new ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(Ray ray, BlockBreakEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockDamageScopeUnit = moonlight.registerEvent(BlockDamageEvent.class, "block damage");
        blockDamageScopeUnit.registerArgument("item in hand", new ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(Ray ray, BlockDamageEvent event) {
                return event.getItemInHand();
            }
        });
        blockDamageScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(Ray ray, BlockDamageEvent event) {
                return event.getEventName();
            }
        });
        blockDamageScopeUnit.registerArgument("player", new ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(Ray ray, BlockDamageEvent event) {
                return event.getPlayer();
            }
        });
        blockDamageScopeUnit.registerArgument("block", new ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(Ray ray, BlockDamageEvent event) {
                return event.getBlock();
            }
        });
        blockDamageScopeUnit.registerArgument("insta break", new ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(Ray ray, BlockDamageEvent event) {
                return event.getInstaBreak();
            }
        });

        ScopeUnit notePlayScopeUnit = moonlight.registerEvent(NotePlayEvent.class, "note play");
        notePlayScopeUnit.registerArgument("instrument", new ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(Ray ray, NotePlayEvent event) {
                return event.getInstrument();
            }
        });
        notePlayScopeUnit.registerArgument("event name", new ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(Ray ray, NotePlayEvent event) {
                return event.getEventName();
            }
        });
        notePlayScopeUnit.registerArgument("note", new ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(Ray ray, NotePlayEvent event) {
                return event.getNote();
            }
        });
        notePlayScopeUnit.registerArgument("block", new ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(Ray ray, NotePlayEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockFormScopeUnit = moonlight.registerEvent(BlockFormEvent.class, "block form");
        blockFormScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockFormEvent>() {
            @Override
            public Object get(Ray ray, BlockFormEvent event) {
                return event.getEventName();
            }
        });
        blockFormScopeUnit.registerArgument("new state", new ArgumentInitializer<BlockFormEvent>() {
            @Override
            public Object get(Ray ray, BlockFormEvent event) {
                return event.getNewState();
            }
        });
        blockFormScopeUnit.registerArgument("block", new ArgumentInitializer<BlockFormEvent>() {
            @Override
            public Object get(Ray ray, BlockFormEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit leavesDecayScopeUnit = moonlight.registerEvent(LeavesDecayEvent.class, "leaves decay");
        leavesDecayScopeUnit.registerArgument("block", new ArgumentInitializer<LeavesDecayEvent>() {
            @Override
            public Object get(Ray ray, LeavesDecayEvent event) {
                return event.getBlock();
            }
        });
        leavesDecayScopeUnit.registerArgument("event name", new ArgumentInitializer<LeavesDecayEvent>() {
            @Override
            public Object get(Ray ray, LeavesDecayEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockExplodeScopeUnit = moonlight.registerEvent(BlockExplodeEvent.class, "block explode");
        blockExplodeScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockExplodeEvent>() {
            @Override
            public Object get(Ray ray, BlockExplodeEvent event) {
                return event.getEventName();
            }
        });
        blockExplodeScopeUnit.registerArgument("yield", new ArgumentInitializer<BlockExplodeEvent>() {
            @Override
            public Object get(Ray ray, BlockExplodeEvent event) {
                return event.getYield();
            }
        });
        blockExplodeScopeUnit.registerArgument("block", new ArgumentInitializer<BlockExplodeEvent>() {
            @Override
            public Object get(Ray ray, BlockExplodeEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit signChangeScopeUnit = moonlight.registerEvent(SignChangeEvent.class, "sign change");
        signChangeScopeUnit.registerArgument("line-*", new ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(Ray ray, SignChangeEvent event) {
                String lineNumber = ray.getHollows().get(0);
                int index = Integer.parseInt(lineNumber);
                return event.getLine(index);
            }
        });
        signChangeScopeUnit.registerArgument("lines", new ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(Ray ray, SignChangeEvent event) {
                return event.getLines();
            }
        });
        signChangeScopeUnit.registerArgument("player", new ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(Ray ray, SignChangeEvent event) {
                return event.getPlayer();
            }
        });
        signChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(Ray ray, SignChangeEvent event) {
                return event.getEventName();
            }
        });
        signChangeScopeUnit.registerArgument("block", new ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(Ray ray, SignChangeEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockBurnScopeUnit = moonlight.registerEvent(BlockBurnEvent.class, "block burn");
        blockBurnScopeUnit.registerArgument("block", new ArgumentInitializer<BlockBurnEvent>() {
            @Override
            public Object get(Ray ray, BlockBurnEvent event) {
                return event.getBlock();
            }
        });
        blockBurnScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockBurnEvent>() {
            @Override
            public Object get(Ray ray, BlockBurnEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockIgniteScopeUnit = moonlight.registerEvent(BlockIgniteEvent.class, "block ignite");
        blockIgniteScopeUnit.registerArgument("igniting block", new ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(Ray ray, BlockIgniteEvent event) {
                return event.getIgnitingBlock();
            }
        });
        blockIgniteScopeUnit.registerArgument("cause", new ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(Ray ray, BlockIgniteEvent event) {
                return event.getCause();
            }
        });
        blockIgniteScopeUnit.registerArgument("igniting entity", new ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(Ray ray, BlockIgniteEvent event) {
                return event.getIgnitingEntity();
            }
        });
        blockIgniteScopeUnit.registerArgument("player", new ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(Ray ray, BlockIgniteEvent event) {
                return event.getPlayer();
            }
        });
        blockIgniteScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(Ray ray, BlockIgniteEvent event) {
                return event.getEventName();
            }
        });
        blockIgniteScopeUnit.registerArgument("block", new ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(Ray ray, BlockIgniteEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockPlaceScopeUnit = moonlight.registerEvent(BlockPlaceEvent.class, "block place");
        blockPlaceScopeUnit.registerArgument("item in hand", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getItemInHand();
            }
        });
        blockPlaceScopeUnit.registerArgument("block against", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getBlockAgainst();
            }
        });
        blockPlaceScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getEventName();
            }
        });
        blockPlaceScopeUnit.registerArgument("block replaced state", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getBlockReplacedState();
            }
        });
        blockPlaceScopeUnit.registerArgument("block placed", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getBlockPlaced();
            }
        });
        blockPlaceScopeUnit.registerArgument("hand", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getHand();
            }
        });
        blockPlaceScopeUnit.registerArgument("block", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getBlock();
            }
        });
        blockPlaceScopeUnit.registerArgument("player", new ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockPlaceEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit blockPhysicsScopeUnit = moonlight.registerEvent(BlockPhysicsEvent.class, "block physics");
        blockPhysicsScopeUnit.registerArgument("changed type id", new ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(Ray ray, BlockPhysicsEvent event) {
                return event.getChangedTypeId();
            }
        });
        blockPhysicsScopeUnit.registerArgument("changed type", new ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(Ray ray, BlockPhysicsEvent event) {
                return event.getChangedType();
            }
        });
        blockPhysicsScopeUnit.registerArgument("block", new ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(Ray ray, BlockPhysicsEvent event) {
                return event.getBlock();
            }
        });
        blockPhysicsScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(Ray ray, BlockPhysicsEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockGrowScopeUnit = moonlight.registerEvent(BlockGrowEvent.class, "block grow");
        blockGrowScopeUnit.registerArgument("block", new ArgumentInitializer<BlockGrowEvent>() {
            @Override
            public Object get(Ray ray, BlockGrowEvent event) {
                return event.getBlock();
            }
        });
        blockGrowScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockGrowEvent>() {
            @Override
            public Object get(Ray ray, BlockGrowEvent event) {
                return event.getEventName();
            }
        });
        blockGrowScopeUnit.registerArgument("new state", new ArgumentInitializer<BlockGrowEvent>() {
            @Override
            public Object get(Ray ray, BlockGrowEvent event) {
                return event.getNewState();
            }
        });

        ScopeUnit blockSpreadScopeUnit = moonlight.registerEvent(BlockSpreadEvent.class, "block spread");
        blockSpreadScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(Ray ray, BlockSpreadEvent event) {
                return event.getEventName();
            }
        });
        blockSpreadScopeUnit.registerArgument("new state", new ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(Ray ray, BlockSpreadEvent event) {
                return event.getNewState();
            }
        });
        blockSpreadScopeUnit.registerArgument("source", new ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(Ray ray, BlockSpreadEvent event) {
                return event.getSource();
            }
        });
        blockSpreadScopeUnit.registerArgument("block", new ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(Ray ray, BlockSpreadEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockPistonRetractScopeUnit = moonlight.registerEvent(BlockPistonRetractEvent.class, "block piston retract");
        blockPistonRetractScopeUnit.registerArgument("direction", new ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonRetractEvent event) {
                return event.getDirection();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonRetractEvent event) {
                return event.getEventName();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("blocks", new ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonRetractEvent event) {
                return event.getBlocks();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("block", new ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonRetractEvent event) {
                return event.getBlock();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("retract location", new ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonRetractEvent event) {
                return event.getRetractLocation();
            }
        });

        ScopeUnit blockScopeUnit = moonlight.registerEvent(BlockEvent.class, "block");
        blockScopeUnit.registerArgument("block", new ArgumentInitializer<BlockEvent>() {
            @Override
            public Object get(Ray ray, BlockEvent event) {
                return event.getBlock();
            }
        });
        blockScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockEvent>() {
            @Override
            public Object get(Ray ray, BlockEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockExpScopeUnit = moonlight.registerEvent(BlockExpEvent.class, "block exp");
        blockExpScopeUnit.registerArgument("exp to drop", new ArgumentInitializer<BlockExpEvent>() {
            @Override
            public Object get(Ray ray, BlockExpEvent event) {
                return event.getExpToDrop();
            }
        });
        blockExpScopeUnit.registerArgument("block", new ArgumentInitializer<BlockExpEvent>() {
            @Override
            public Object get(Ray ray, BlockExpEvent event) {
                return event.getBlock();
            }
        });
        blockExpScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockExpEvent>() {
            @Override
            public Object get(Ray ray, BlockExpEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityBlockFormScopeUnit = moonlight.registerEvent(EntityBlockFormEvent.class, "entity block form");
        entityBlockFormScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(Ray ray, EntityBlockFormEvent event) {
                return event.getEntity();
            }
        });
        entityBlockFormScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(Ray ray, EntityBlockFormEvent event) {
                return event.getEventName();
            }
        });
        entityBlockFormScopeUnit.registerArgument("new state", new ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(Ray ray, EntityBlockFormEvent event) {
                return event.getNewState();
            }
        });
        entityBlockFormScopeUnit.registerArgument("block", new ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(Ray ray, EntityBlockFormEvent event) {
                return event.getBlock();
            }
        });

        ScopeUnit blockMultiPlaceScopeUnit = moonlight.registerEvent(BlockMultiPlaceEvent.class, "block multi place");
        blockMultiPlaceScopeUnit.registerArgument("item in hand", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getItemInHand();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("replaced block states", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getReplacedBlockStates();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block against", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlockAgainst();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getEventName();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block replaced state", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlockReplacedState();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block placed", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlockPlaced();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("hand", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getHand();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlock();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("player", new ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(Ray ray, BlockMultiPlaceEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit blockPistonScopeUnit = moonlight.registerEvent(BlockPistonEvent.class, "block piston");
        blockPistonScopeUnit.registerArgument("block", new ArgumentInitializer<BlockPistonEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonEvent event) {
                return event.getBlock();
            }
        });
        blockPistonScopeUnit.registerArgument("direction", new ArgumentInitializer<BlockPistonEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonEvent event) {
                return event.getDirection();
            }
        });
        blockPistonScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockPistonEvent>() {
            @Override
            public Object get(Ray ray, BlockPistonEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit cauldronLevelChangeScopeUnit = moonlight.registerEvent(CauldronLevelChangeEvent.class, "cauldron level change");
        cauldronLevelChangeScopeUnit.registerArgument("new level", new ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, CauldronLevelChangeEvent event) {
                return event.getNewLevel();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("old level", new ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, CauldronLevelChangeEvent event) {
                return event.getOldLevel();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, CauldronLevelChangeEvent event) {
                return event.getEventName();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("entity", new ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, CauldronLevelChangeEvent event) {
                return event.getEntity();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("block", new ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, CauldronLevelChangeEvent event) {
                return event.getBlock();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("reason", new ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, CauldronLevelChangeEvent event) {
                return event.getReason();
            }
        });

        ScopeUnit blockFromToScopeUnit = moonlight.registerEvent(BlockFromToEvent.class, "block from to");
        blockFromToScopeUnit.registerArgument("face", new ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(Ray ray, BlockFromToEvent event) {
                return event.getFace();
            }
        });
        blockFromToScopeUnit.registerArgument("block", new ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(Ray ray, BlockFromToEvent event) {
                return event.getBlock();
            }
        });
        blockFromToScopeUnit.registerArgument("to block", new ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(Ray ray, BlockFromToEvent event) {
                return event.getToBlock();
            }
        });
        blockFromToScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(Ray ray, BlockFromToEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit blockCanBuildScopeUnit = moonlight.registerEvent(BlockCanBuildEvent.class, "block can build");
        blockCanBuildScopeUnit.registerArgument("material", new ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(Ray ray, BlockCanBuildEvent event) {
                return event.getMaterial();
            }
        });
        blockCanBuildScopeUnit.registerArgument("block", new ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(Ray ray, BlockCanBuildEvent event) {
                return event.getBlock();
            }
        });
        blockCanBuildScopeUnit.registerArgument("material id", new ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(Ray ray, BlockCanBuildEvent event) {
                return event.getMaterialId();
            }
        });
        blockCanBuildScopeUnit.registerArgument("event name", new ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(Ray ray, BlockCanBuildEvent event) {
                return event.getEventName();
            }
        });


    }

}
