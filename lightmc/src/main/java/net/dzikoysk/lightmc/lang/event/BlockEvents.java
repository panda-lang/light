package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.block.*;

public class BlockEvents implements BukkitElements {

    private final Light light;

    public BlockEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit blockPistonExtendScopeUnit = light.registerEvent(BlockPistonExtendEvent.class, "block piston extend");
        blockPistonExtendScopeUnit.registerArgument("blocks", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonExtendEvent event) {
                return event.getBlocks();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("direction", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonExtendEvent event) {
                return event.getDirection();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonExtendEvent event) {
                return event.getEventName();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("length", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonExtendEvent event) {
                return event.getLength();
            }
        });
        blockPistonExtendScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonExtendEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonExtendEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockDispenseScopeUnit = light.registerEvent(BlockDispenseEvent.class, "block dispense");
        blockDispenseScopeUnit.registerArgument("velocity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDispenseEvent event) {
                return event.getVelocity();
            }
        });
        blockDispenseScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDispenseEvent event) {
                return event.getItem();
            }
        });
        blockDispenseScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDispenseEvent event) {
                return event.getEventName();
            }
        });
        blockDispenseScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDispenseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDispenseEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockRedstoneScopeUnit = light.registerEvent(BlockRedstoneEvent.class, "block redstone");
        blockRedstoneScopeUnit.registerArgument("old current", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockRedstoneEvent event) {
                return event.getOldCurrent();
            }
        });
        blockRedstoneScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockRedstoneEvent event) {
                return event.getBlock();
            }
        });
        blockRedstoneScopeUnit.registerArgument("new current", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockRedstoneEvent event) {
                return event.getNewCurrent();
            }
        });
        blockRedstoneScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockRedstoneEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockRedstoneEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockFadeScopeUnit = light.registerEvent(BlockFadeEvent.class, "block fade");
        blockFadeScopeUnit.registerArgument("new state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFadeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFadeEvent event) {
                return event.getNewState();
            }
        });
        blockFadeScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFadeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFadeEvent event) {
                return event.getBlock();
            }
        });
        blockFadeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFadeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFadeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockBreakScopeUnit = light.registerEvent(BlockBreakEvent.class, "block break");
        blockBreakScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockBreakEvent event) {
                return event.getPlayer();
            }
        });
        blockBreakScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockBreakEvent event) {
                return event.getEventName();
            }
        });
        blockBreakScopeUnit.registerArgument("exp to drop", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockBreakEvent event) {
                return event.getExpToDrop();
            }
        });
        blockBreakScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockBreakEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockDamageScopeUnit = light.registerEvent(BlockDamageEvent.class, "block damage");
        blockDamageScopeUnit.registerArgument("item in hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDamageEvent event) {
                return event.getItemInHand();
            }
        });
        blockDamageScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDamageEvent event) {
                return event.getEventName();
            }
        });
        blockDamageScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDamageEvent event) {
                return event.getPlayer();
            }
        });
        blockDamageScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDamageEvent event) {
                return event.getBlock();
            }
        });
        blockDamageScopeUnit.registerArgument("insta break", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockDamageEvent event) {
                return event.getInstaBreak();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit notePlayScopeUnit = light.registerEvent(NotePlayEvent.class, "note play");
        notePlayScopeUnit.registerArgument("instrument", new org.panda_lang.light.core.element.argument.ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, NotePlayEvent event) {
                return event.getInstrument();
            }
        });
        notePlayScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, NotePlayEvent event) {
                return event.getEventName();
            }
        });
        notePlayScopeUnit.registerArgument("note", new org.panda_lang.light.core.element.argument.ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, NotePlayEvent event) {
                return event.getNote();
            }
        });
        notePlayScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<NotePlayEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, NotePlayEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockFormScopeUnit = light.registerEvent(BlockFormEvent.class, "block form");
        blockFormScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFormEvent event) {
                return event.getEventName();
            }
        });
        blockFormScopeUnit.registerArgument("new state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFormEvent event) {
                return event.getNewState();
            }
        });
        blockFormScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFormEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit leavesDecayScopeUnit = light.registerEvent(LeavesDecayEvent.class, "leaves decay");
        leavesDecayScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LeavesDecayEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LeavesDecayEvent event) {
                return event.getBlock();
            }
        });
        leavesDecayScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LeavesDecayEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LeavesDecayEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockExplodeScopeUnit = light.registerEvent(BlockExplodeEvent.class, "block explode");
        blockExplodeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockExplodeEvent event) {
                return event.getEventName();
            }
        });
        blockExplodeScopeUnit.registerArgument("yield", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockExplodeEvent event) {
                return event.getYield();
            }
        });
        blockExplodeScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockExplodeEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit signChangeScopeUnit = light.registerEvent(SignChangeEvent.class, "sign change");
        signChangeScopeUnit.registerArgument("line-*", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SignChangeEvent event) {
                String lineNumber = ray.getHollows().get(0);
                int index = Integer.parseInt(lineNumber);
                return event.getLine(index);
            }
        });
        signChangeScopeUnit.registerArgument("lines", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SignChangeEvent event) {
                return event.getLines();
            }
        });
        signChangeScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SignChangeEvent event) {
                return event.getPlayer();
            }
        });
        signChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SignChangeEvent event) {
                return event.getEventName();
            }
        });
        signChangeScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SignChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SignChangeEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockBurnScopeUnit = light.registerEvent(BlockBurnEvent.class, "block burn");
        blockBurnScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockBurnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockBurnEvent event) {
                return event.getBlock();
            }
        });
        blockBurnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockBurnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockBurnEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockIgniteScopeUnit = light.registerEvent(BlockIgniteEvent.class, "block ignite");
        blockIgniteScopeUnit.registerArgument("igniting block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockIgniteEvent event) {
                return event.getIgnitingBlock();
            }
        });
        blockIgniteScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockIgniteEvent event) {
                return event.getCause();
            }
        });
        blockIgniteScopeUnit.registerArgument("igniting entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockIgniteEvent event) {
                return event.getIgnitingEntity();
            }
        });
        blockIgniteScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockIgniteEvent event) {
                return event.getPlayer();
            }
        });
        blockIgniteScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockIgniteEvent event) {
                return event.getEventName();
            }
        });
        blockIgniteScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockIgniteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockIgniteEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockPlaceScopeUnit = light.registerEvent(BlockPlaceEvent.class, "block place");
        blockPlaceScopeUnit.registerArgument("item in hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getItemInHand();
            }
        });
        blockPlaceScopeUnit.registerArgument("block against", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getBlockAgainst();
            }
        });
        blockPlaceScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getEventName();
            }
        });
        blockPlaceScopeUnit.registerArgument("block replaced state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getBlockReplacedState();
            }
        });
        blockPlaceScopeUnit.registerArgument("block placed", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getBlockPlaced();
            }
        });
        blockPlaceScopeUnit.registerArgument("hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getHand();
            }
        });
        blockPlaceScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getBlock();
            }
        });
        blockPlaceScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPlaceEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockPhysicsScopeUnit = light.registerEvent(BlockPhysicsEvent.class, "block physics");
        blockPhysicsScopeUnit.registerArgument("changed type id", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPhysicsEvent event) {
                return event.getChangedTypeId();
            }
        });
        blockPhysicsScopeUnit.registerArgument("changed type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPhysicsEvent event) {
                return event.getChangedType();
            }
        });
        blockPhysicsScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPhysicsEvent event) {
                return event.getBlock();
            }
        });
        blockPhysicsScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPhysicsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPhysicsEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockGrowScopeUnit = light.registerEvent(BlockGrowEvent.class, "block grow");
        blockGrowScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockGrowEvent event) {
                return event.getBlock();
            }
        });
        blockGrowScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockGrowEvent event) {
                return event.getEventName();
            }
        });
        blockGrowScopeUnit.registerArgument("new state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockGrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockGrowEvent event) {
                return event.getNewState();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockSpreadScopeUnit = light.registerEvent(BlockSpreadEvent.class, "block spread");
        blockSpreadScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockSpreadEvent event) {
                return event.getEventName();
            }
        });
        blockSpreadScopeUnit.registerArgument("new state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockSpreadEvent event) {
                return event.getNewState();
            }
        });
        blockSpreadScopeUnit.registerArgument("source", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockSpreadEvent event) {
                return event.getSource();
            }
        });
        blockSpreadScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockSpreadEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockSpreadEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockPistonRetractScopeUnit = light.registerEvent(BlockPistonRetractEvent.class, "block piston retract");
        blockPistonRetractScopeUnit.registerArgument("direction", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonRetractEvent event) {
                return event.getDirection();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonRetractEvent event) {
                return event.getEventName();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("blocks", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonRetractEvent event) {
                return event.getBlocks();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonRetractEvent event) {
                return event.getBlock();
            }
        });
        blockPistonRetractScopeUnit.registerArgument("retract location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonRetractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonRetractEvent event) {
                return event.getRetractLocation();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockScopeUnit = light.registerEvent(BlockEvent.class, "block");
        blockScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockEvent event) {
                return event.getBlock();
            }
        });
        blockScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockExpScopeUnit = light.registerEvent(BlockExpEvent.class, "block exp");
        blockExpScopeUnit.registerArgument("exp to drop", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockExpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockExpEvent event) {
                return event.getExpToDrop();
            }
        });
        blockExpScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockExpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockExpEvent event) {
                return event.getBlock();
            }
        });
        blockExpScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockExpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockExpEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityBlockFormScopeUnit = light.registerEvent(EntityBlockFormEvent.class, "entity block form");
        entityBlockFormScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBlockFormEvent event) {
                return event.getEntity();
            }
        });
        entityBlockFormScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBlockFormEvent event) {
                return event.getEventName();
            }
        });
        entityBlockFormScopeUnit.registerArgument("new state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBlockFormEvent event) {
                return event.getNewState();
            }
        });
        entityBlockFormScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBlockFormEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBlockFormEvent event) {
                return event.getBlock();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockMultiPlaceScopeUnit = light.registerEvent(BlockMultiPlaceEvent.class, "block multi place");
        blockMultiPlaceScopeUnit.registerArgument("item in hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getItemInHand();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("replaced block states", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getReplacedBlockStates();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block against", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlockAgainst();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getEventName();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block replaced state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlockReplacedState();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block placed", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlockPlaced();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getHand();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getBlock();
            }
        });
        blockMultiPlaceScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockMultiPlaceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockMultiPlaceEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockPistonScopeUnit = light.registerEvent(BlockPistonEvent.class, "block piston");
        blockPistonScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonEvent event) {
                return event.getBlock();
            }
        });
        blockPistonScopeUnit.registerArgument("direction", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonEvent event) {
                return event.getDirection();
            }
        });
        blockPistonScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockPistonEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockPistonEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit cauldronLevelChangeScopeUnit = light.registerEvent(CauldronLevelChangeEvent.class, "cauldron level change");
        cauldronLevelChangeScopeUnit.registerArgument("new level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CauldronLevelChangeEvent event) {
                return event.getNewLevel();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("old level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CauldronLevelChangeEvent event) {
                return event.getOldLevel();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CauldronLevelChangeEvent event) {
                return event.getEventName();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CauldronLevelChangeEvent event) {
                return event.getEntity();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CauldronLevelChangeEvent event) {
                return event.getBlock();
            }
        });
        cauldronLevelChangeScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CauldronLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CauldronLevelChangeEvent event) {
                return event.getReason();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockFromToScopeUnit = light.registerEvent(BlockFromToEvent.class, "block from to");
        blockFromToScopeUnit.registerArgument("face", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFromToEvent event) {
                return event.getFace();
            }
        });
        blockFromToScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFromToEvent event) {
                return event.getBlock();
            }
        });
        blockFromToScopeUnit.registerArgument("to block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFromToEvent event) {
                return event.getToBlock();
            }
        });
        blockFromToScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockFromToEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockFromToEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit blockCanBuildScopeUnit = light.registerEvent(BlockCanBuildEvent.class, "block can build");
        blockCanBuildScopeUnit.registerArgument("material", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockCanBuildEvent event) {
                return event.getMaterial();
            }
        });
        blockCanBuildScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockCanBuildEvent event) {
                return event.getBlock();
            }
        });
        blockCanBuildScopeUnit.registerArgument("material id", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockCanBuildEvent event) {
                return event.getMaterialId();
            }
        });
        blockCanBuildScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BlockCanBuildEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BlockCanBuildEvent event) {
                return event.getEventName();
            }
        });


    }

}
