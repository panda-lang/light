package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.entity.*;

public class EntityEvents implements BukkitElements {

    private final Light light;

    public EntityEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit entityBreakDoorScopeUnit = light.registerEvent(EntityBreakDoorEvent.class, "entity break door");
        entityBreakDoorScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBreakDoorEvent event) {
                return event.getEntityType();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBreakDoorEvent event) {
                return event.getEntity();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("data", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBreakDoorEvent event) {
                return event.getData();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBreakDoorEvent event) {
                return event.getEventName();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBreakDoorEvent event) {
                return event.getBlock();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityBreakDoorEvent event) {
                return event.getTo();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit potionSplashScopeUnit = light.registerEvent(PotionSplashEvent.class, "potion splash");
        potionSplashScopeUnit.registerArgument("potion", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PotionSplashEvent event) {
                return event.getPotion();
            }
        });
        potionSplashScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PotionSplashEvent event) {
                return event.getEntityType();
            }
        });
        potionSplashScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PotionSplashEvent event) {
                return event.getEntity();
            }
        });
        potionSplashScopeUnit.registerArgument("intensity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PotionSplashEvent event) {
                return 1.0;
            }
        });
        potionSplashScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PotionSplashEvent event) {
                return event.getEventName();
            }
        });
        potionSplashScopeUnit.registerArgument("affected entities", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PotionSplashEvent event) {
                return event.getAffectedEntities();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityScopeUnit = light.registerEvent(EntityEvent.class, "entity");
        entityScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityEvent event) {
                return event.getEntityType();
            }
        });
        entityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityEvent event) {
                return event.getEntity();
            }
        });
        entityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit villagerAcquireTradeScopeUnit = light.registerEvent(VillagerAcquireTradeEvent.class, "villager acquire trade");
        villagerAcquireTradeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerAcquireTradeEvent event) {
                return event.getEntityType();
            }
        });
        villagerAcquireTradeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerAcquireTradeEvent event) {
                return event.getEntity();
            }
        });
        villagerAcquireTradeScopeUnit.registerArgument("recipe", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerAcquireTradeEvent event) {
                return event.getRecipe();
            }
        });
        villagerAcquireTradeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerAcquireTradeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit foodLevelChangeScopeUnit = light.registerEvent(FoodLevelChangeEvent.class, "food level change");
        foodLevelChangeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FoodLevelChangeEvent event) {
                return event.getEntityType();
            }
        });
        foodLevelChangeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FoodLevelChangeEvent event) {
                return event.getEntity();
            }
        });
        foodLevelChangeScopeUnit.registerArgument("food level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FoodLevelChangeEvent event) {
                return event.getFoodLevel();
            }
        });
        foodLevelChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FoodLevelChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit sheepDyeWoolScopeUnit = light.registerEvent(SheepDyeWoolEvent.class, "sheep dye wool");
        sheepDyeWoolScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepDyeWoolEvent event) {
                return event.getEntity();
            }
        });
        sheepDyeWoolScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepDyeWoolEvent event) {
                return event.getEntityType();
            }
        });
        sheepDyeWoolScopeUnit.registerArgument("color", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepDyeWoolEvent event) {
                return event.getColor();
            }
        });
        sheepDyeWoolScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepDyeWoolEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit itemMergeScopeUnit = light.registerEvent(ItemMergeEvent.class, "item merge");
        itemMergeScopeUnit.registerArgument("target", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemMergeEvent event) {
                return event.getTarget();
            }
        });
        itemMergeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemMergeEvent event) {
                return event.getEntityType();
            }
        });
        itemMergeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemMergeEvent event) {
                return event.getEntity();
            }
        });
        itemMergeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemMergeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit villagerReplenishTradeScopeUnit = light.registerEvent(VillagerReplenishTradeEvent.class, "villager replenish trade");
        villagerReplenishTradeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerReplenishTradeEvent event) {
                return event.getEntityType();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("recipe", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerReplenishTradeEvent event) {
                return event.getRecipe();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("bonus", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerReplenishTradeEvent event) {
                return event.getBonus();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerReplenishTradeEvent event) {
                return event.getEntity();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, VillagerReplenishTradeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityTargetScopeUnit = light.registerEvent(EntityTargetEvent.class, "entity target");
        entityTargetScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetEvent event) {
                return event.getEntityType();
            }
        });
        entityTargetScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetEvent event) {
                return event.getEntity();
            }
        });
        entityTargetScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetEvent event) {
                return event.getReason();
            }
        });
        entityTargetScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetEvent event) {
                return event.getEventName();
            }
        });
        entityTargetScopeUnit.registerArgument("target", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetEvent event) {
                return event.getTarget();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityCreatePortalScopeUnit = light.registerEvent(EntityCreatePortalEvent.class, "entity create portal");
        entityCreatePortalScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCreatePortalEvent event) {
                return event.getEntityType();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("portal type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCreatePortalEvent event) {
                return event.getPortalType();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCreatePortalEvent event) {
                return event.getEntity();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCreatePortalEvent event) {
                return event.getEventName();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("blocks", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCreatePortalEvent event) {
                return event.getBlocks();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit creeperPowerScopeUnit = light.registerEvent(CreeperPowerEvent.class, "creeper power");
        creeperPowerScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreeperPowerEvent event) {
                return event.getEntityType();
            }
        });
        creeperPowerScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreeperPowerEvent event) {
                return event.getEntity();
            }
        });
        creeperPowerScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreeperPowerEvent event) {
                return event.getCause();
            }
        });
        creeperPowerScopeUnit.registerArgument("lightning", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreeperPowerEvent event) {
                return event.getLightning();
            }
        });
        creeperPowerScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreeperPowerEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityTargetLivingEntityScopeUnit = light.registerEvent(EntityTargetLivingEntityEvent.class, "entity target living entity");
        entityTargetLivingEntityScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getEntityType();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getEntity();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getReason();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getEventName();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("target", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getTarget();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityPortalEnterScopeUnit = light.registerEvent(EntityPortalEnterEvent.class, "entity portal enter");
        entityPortalEnterScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEnterEvent event) {
                return event.getEntityType();
            }
        });
        entityPortalEnterScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEnterEvent event) {
                return event.getEntity();
            }
        });
        entityPortalEnterScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEnterEvent event) {
                return event.getLocation();
            }
        });
        entityPortalEnterScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEnterEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityPortalScopeUnit = light.registerEvent(EntityPortalEvent.class, "entity portal");
        entityPortalScopeUnit.registerArgument("portal travel agent", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEvent event) {
                return event.getPortalTravelAgent();
            }
        });
        entityPortalScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEvent event) {
                return event.getEntityType();
            }
        });
        entityPortalScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEvent event) {
                return event.getEntity();
            }
        });
        entityPortalScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEvent event) {
                return event.getTo();
            }
        });
        entityPortalScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEvent event) {
                return event.getEventName();
            }
        });
        entityPortalScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalEvent event) {
                return event.getFrom();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityUnleashScopeUnit = light.registerEvent(EntityUnleashEvent.class, "entity unleash");
        entityUnleashScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityUnleashEvent event) {
                return event.getEntityType();
            }
        });
        entityUnleashScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityUnleashEvent event) {
                return event.getReason();
            }
        });
        entityUnleashScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityUnleashEvent event) {
                return event.getEntity();
            }
        });
        entityUnleashScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityUnleashEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit slimeSplitScopeUnit = light.registerEvent(SlimeSplitEvent.class, "slime split");
        slimeSplitScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SlimeSplitEvent event) {
                return event.getEntityType();
            }
        });
        slimeSplitScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SlimeSplitEvent event) {
                return event.getEntity();
            }
        });
        slimeSplitScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SlimeSplitEvent event) {
                return event.getEventName();
            }
        });
        slimeSplitScopeUnit.registerArgument("count", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SlimeSplitEvent event) {
                return event.getCount();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit itemDespawnScopeUnit = light.registerEvent(ItemDespawnEvent.class, "item despawn");
        itemDespawnScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemDespawnEvent event) {
                return event.getEntityType();
            }
        });
        itemDespawnScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemDespawnEvent event) {
                return event.getEntity();
            }
        });
        itemDespawnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemDespawnEvent event) {
                return event.getEventName();
            }
        });
        itemDespawnScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemDespawnEvent event) {
                return event.getLocation();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit projectileHitScopeUnit = light.registerEvent(ProjectileHitEvent.class, "projectile hit");
        projectileHitScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ProjectileHitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ProjectileHitEvent event) {
                return event.getEntityType();
            }
        });
        projectileHitScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ProjectileHitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ProjectileHitEvent event) {
                return event.getEntity();
            }
        });
        projectileHitScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ProjectileHitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ProjectileHitEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit fireworkExplodeScopeUnit = light.registerEvent(FireworkExplodeEvent.class, "firework explode");
        fireworkExplodeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FireworkExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FireworkExplodeEvent event) {
                return event.getEntityType();
            }
        });
        fireworkExplodeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FireworkExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FireworkExplodeEvent event) {
                return event.getEntity();
            }
        });
        fireworkExplodeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FireworkExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FireworkExplodeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit projectileLaunchScopeUnit = light.registerEvent(ProjectileLaunchEvent.class, "projectile launch");
        projectileLaunchScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ProjectileLaunchEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ProjectileLaunchEvent event) {
                return event.getEntityType();
            }
        });
        projectileLaunchScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ProjectileLaunchEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ProjectileLaunchEvent event) {
                return event.getEntity();
            }
        });
        projectileLaunchScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ProjectileLaunchEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ProjectileLaunchEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit areaEffectCloudApplyScopeUnit = light.registerEvent(AreaEffectCloudApplyEvent.class, "area effect cloud apply");
        areaEffectCloudApplyScopeUnit.registerArgument("affected entities", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getAffectedEntities();
            }
        });
        areaEffectCloudApplyScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getEntityType();
            }
        });
        areaEffectCloudApplyScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getEntity();
            }
        });
        areaEffectCloudApplyScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entitySpawnScopeUnit = light.registerEvent(EntitySpawnEvent.class, "entity spawn");
        entitySpawnScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntitySpawnEvent event) {
                return event.getEntityType();
            }
        });
        entitySpawnScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntitySpawnEvent event) {
                return event.getEntity();
            }
        });
        entitySpawnScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntitySpawnEvent event) {
                return event.getLocation();
            }
        });
        entitySpawnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntitySpawnEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityTameScopeUnit = light.registerEvent(EntityTameEvent.class, "entity tame");
        entityTameScopeUnit.registerArgument("owner", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTameEvent event) {
                return event.getOwner();
            }
        });
        entityTameScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTameEvent event) {
                return event.getEntity();
            }
        });
        entityTameScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTameEvent event) {
                return event.getEntityType();
            }
        });
        entityTameScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTameEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityRegainHealthScopeUnit = light.registerEvent(EntityRegainHealthEvent.class, "entity regain health");
        entityRegainHealthScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityRegainHealthEvent event) {
                return event.getEntityType();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityRegainHealthEvent event) {
                return event.getEntity();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityRegainHealthEvent event) {
                return event.getEventName();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("regain reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityRegainHealthEvent event) {
                return event.getRegainReason();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("amount", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityRegainHealthEvent event) {
                return event.getAmount();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityDamageByBlockScopeUnit = light.registerEvent(EntityDamageByBlockEvent.class, "entity damage by block");
        entityDamageByBlockScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getEntityType();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("original damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE);
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getEntity();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("damager", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getDamager();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getEventName();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("final damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getFinalDamage();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getCause();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByBlockEvent event) {
                return event.getDamage();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityDamageByEntityScopeUnit = light.registerEvent(EntityDamageByEntityEvent.class, "entity damage by entity");
        entityDamageByEntityScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getEntityType();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("original damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE);
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("damager", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getDamager();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getEntity();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getEventName();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("final damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getFinalDamage();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getCause();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageByEntityEvent event) {
                return event.getDamage();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit horseJumpScopeUnit = light.registerEvent(HorseJumpEvent.class, "horse jump");
        horseJumpScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HorseJumpEvent event) {
                return event.getEntityType();
            }
        });
        horseJumpScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HorseJumpEvent event) {
                return event.getEntity();
            }
        });
        horseJumpScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HorseJumpEvent event) {
                return event.getEventName();
            }
        });
        horseJumpScopeUnit.registerArgument("power", new org.panda_lang.light.core.element.argument.ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, HorseJumpEvent event) {
                return event.getPower();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit enderDragonChangePhaseScopeUnit = light.registerEvent(EnderDragonChangePhaseEvent.class, "ender dragon change phase");
        enderDragonChangePhaseScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getEntityType();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getEntity();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("new phase", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getNewPhase();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getEventName();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("current phase", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getCurrentPhase();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityShootBowScopeUnit = light.registerEvent(EntityShootBowEvent.class, "entity shoot bow");
        entityShootBowScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityShootBowEvent event) {
                return event.getEntityType();
            }
        });
        entityShootBowScopeUnit.registerArgument("force", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityShootBowEvent event) {
                return event.getForce();
            }
        });
        entityShootBowScopeUnit.registerArgument("bow", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityShootBowEvent event) {
                return event.getBow();
            }
        });
        entityShootBowScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityShootBowEvent event) {
                return event.getEntity();
            }
        });
        entityShootBowScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityShootBowEvent event) {
                return event.getEventName();
            }
        });
        entityShootBowScopeUnit.registerArgument("projectile", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityShootBowEvent event) {
                return event.getProjectile();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerDeathScopeUnit = light.registerEvent(PlayerDeathEvent.class, "player death");
        playerDeathScopeUnit.registerArgument("dropped exp", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getDroppedExp();
            }
        });
        playerDeathScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getEntityType();
            }
        });
        playerDeathScopeUnit.registerArgument("keep inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getKeepInventory();
            }
        });
        playerDeathScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getEntity();
            }
        });
        playerDeathScopeUnit.registerArgument("keep level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getKeepLevel();
            }
        });
        playerDeathScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getEventName();
            }
        });
        playerDeathScopeUnit.registerArgument("death message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getDeathMessage();
            }
        });
        playerDeathScopeUnit.registerArgument("new total exp", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getNewTotalExp();
            }
        });
        playerDeathScopeUnit.registerArgument("new level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getNewLevel();
            }
        });
        playerDeathScopeUnit.registerArgument("drops", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getDrops();
            }
        });
        playerDeathScopeUnit.registerArgument("new exp", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDeathEvent event) {
                return event.getNewExp();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityCombustScopeUnit = light.registerEvent(EntityCombustEvent.class, "entity combust");
        entityCombustScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustEvent event) {
                return event.getEntityType();
            }
        });
        entityCombustScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustEvent event) {
                return event.getEntity();
            }
        });
        entityCombustScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustEvent event) {
                return event.getEventName();
            }
        });
        entityCombustScopeUnit.registerArgument("duration", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustEvent event) {
                return event.getDuration();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityCombustByEntityScopeUnit = light.registerEvent(EntityCombustByEntityEvent.class, "entity combust by entity");
        entityCombustByEntityScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByEntityEvent event) {
                return event.getEntityType();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByEntityEvent event) {
                return event.getEntity();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByEntityEvent event) {
                return event.getEventName();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("duration", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByEntityEvent event) {
                return event.getDuration();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("combuster", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByEntityEvent event) {
                return event.getCombuster();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityInteractScopeUnit = light.registerEvent(EntityInteractEvent.class, "entity interact");
        entityInteractScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityInteractEvent event) {
                return event.getEntityType();
            }
        });
        entityInteractScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityInteractEvent event) {
                return event.getEntity();
            }
        });
        entityInteractScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityInteractEvent event) {
                return event.getBlock();
            }
        });
        entityInteractScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityInteractEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit creatureSpawnScopeUnit = light.registerEvent(CreatureSpawnEvent.class, "creature spawn");
        creatureSpawnScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreatureSpawnEvent event) {
                return event.getEntityType();
            }
        });
        creatureSpawnScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreatureSpawnEvent event) {
                return event.getEntity();
            }
        });
        creatureSpawnScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreatureSpawnEvent event) {
                return event.getLocation();
            }
        });
        creatureSpawnScopeUnit.registerArgument("spawn reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreatureSpawnEvent event) {
                return event.getSpawnReason();
            }
        });
        creatureSpawnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CreatureSpawnEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit spawnerSpawnScopeUnit = light.registerEvent(SpawnerSpawnEvent.class, "spawner spawn");
        spawnerSpawnScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnerSpawnEvent event) {
                return event.getEntityType();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnerSpawnEvent event) {
                return event.getEntity();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnerSpawnEvent event) {
                return event.getLocation();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnerSpawnEvent event) {
                return event.getEventName();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("spawner", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SpawnerSpawnEvent event) {
                return event.getSpawner();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityDeathScopeUnit = light.registerEvent(EntityDeathEvent.class, "entity death");
        entityDeathScopeUnit.registerArgument("dropped exp", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDeathEvent event) {
                return event.getDroppedExp();
            }
        });
        entityDeathScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDeathEvent event) {
                return event.getEntityType();
            }
        });
        entityDeathScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDeathEvent event) {
                return event.getEntity();
            }
        });
        entityDeathScopeUnit.registerArgument("drops", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDeathEvent event) {
                return event.getDrops();
            }
        });
        entityDeathScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDeathEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit lingeringPotionSplashScopeUnit = light.registerEvent(LingeringPotionSplashEvent.class, "lingering potion splash");
        lingeringPotionSplashScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LingeringPotionSplashEvent event) {
                return event.getEntityType();
            }
        });
        lingeringPotionSplashScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LingeringPotionSplashEvent event) {
                return event.getEntity();
            }
        });
        lingeringPotionSplashScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LingeringPotionSplashEvent event) {
                return event.getEventName();
            }
        });
        lingeringPotionSplashScopeUnit.registerArgument("area effect cloud", new org.panda_lang.light.core.element.argument.ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, LingeringPotionSplashEvent event) {
                return event.getAreaEffectCloud();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityCombustByBlockScopeUnit = light.registerEvent(EntityCombustByBlockEvent.class, "entity combust by block");
        entityCombustByBlockScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByBlockEvent event) {
                return event.getEntityType();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByBlockEvent event) {
                return event.getEntity();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByBlockEvent event) {
                return event.getEventName();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("duration", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByBlockEvent event) {
                return event.getDuration();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("combuster", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityCombustByBlockEvent event) {
                return event.getCombuster();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit pigZapScopeUnit = light.registerEvent(PigZapEvent.class, "pig zap");
        pigZapScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PigZapEvent event) {
                return event.getEntityType();
            }
        });
        pigZapScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PigZapEvent event) {
                return event.getEntity();
            }
        });
        pigZapScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PigZapEvent event) {
                return event.getEventName();
            }
        });
        pigZapScopeUnit.registerArgument("pig zombie", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PigZapEvent event) {
                return event.getPigZombie();
            }
        });
        pigZapScopeUnit.registerArgument("lightning", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PigZapEvent event) {
                return event.getLightning();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityChangeBlockScopeUnit = light.registerEvent(EntityChangeBlockEvent.class, "entity change block");
        entityChangeBlockScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityChangeBlockEvent event) {
                return event.getEntityType();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityChangeBlockEvent event) {
                return event.getEntity();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("data", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityChangeBlockEvent event) {
                return event.getData();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityChangeBlockEvent event) {
                return event.getEventName();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityChangeBlockEvent event) {
                return event.getBlock();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityChangeBlockEvent event) {
                return event.getTo();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityDamageScopeUnit = light.registerEvent(EntityDamageEvent.class, "entity damage");
        entityDamageScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getEntityType();
            }
        });
        entityDamageScopeUnit.registerArgument("original damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE);
            }
        });
        entityDamageScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getEntity();
            }
        });
        entityDamageScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getEventName();
            }
        });
        entityDamageScopeUnit.registerArgument("final damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getFinalDamage();
            }
        });
        entityDamageScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getCause();
            }
        });
        entityDamageScopeUnit.registerArgument("damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityDamageEvent event) {
                return event.getDamage();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityExplodeScopeUnit = light.registerEvent(EntityExplodeEvent.class, "entity explode");
        entityExplodeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityExplodeEvent event) {
                return event.getEntityType();
            }
        });
        entityExplodeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityExplodeEvent event) {
                return event.getEntity();
            }
        });
        entityExplodeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityExplodeEvent event) {
                return event.getEventName();
            }
        });
        entityExplodeScopeUnit.registerArgument("yield", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityExplodeEvent event) {
                return event.getYield();
            }
        });
        entityExplodeScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityExplodeEvent event) {
                return event.getLocation();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerLeashEntityScopeUnit = light.registerEvent(PlayerLeashEntityEvent.class, "player leash entity");
        playerLeashEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLeashEntityEvent event) {
                return event.getEntity();
            }
        });
        playerLeashEntityScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLeashEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerLeashEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLeashEntityEvent event) {
                return event.getEventName();
            }
        });
        playerLeashEntityScopeUnit.registerArgument("leash holder", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLeashEntityEvent event) {
                return event.getLeashHolder();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit sheepRegrowWoolScopeUnit = light.registerEvent(SheepRegrowWoolEvent.class, "sheep regrow wool");
        sheepRegrowWoolScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepRegrowWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepRegrowWoolEvent event) {
                return event.getEntityType();
            }
        });
        sheepRegrowWoolScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepRegrowWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepRegrowWoolEvent event) {
                return event.getEntity();
            }
        });
        sheepRegrowWoolScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<SheepRegrowWoolEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, SheepRegrowWoolEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit explosionPrimeScopeUnit = light.registerEvent(ExplosionPrimeEvent.class, "explosion prime");
        explosionPrimeScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExplosionPrimeEvent event) {
                return event.getEntityType();
            }
        });
        explosionPrimeScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExplosionPrimeEvent event) {
                return event.getEntity();
            }
        });
        explosionPrimeScopeUnit.registerArgument("radius", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExplosionPrimeEvent event) {
                return event.getRadius();
            }
        });
        explosionPrimeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExplosionPrimeEvent event) {
                return event.getEventName();
            }
        });
        explosionPrimeScopeUnit.registerArgument("fire", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExplosionPrimeEvent event) {
                return event.getFire();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityToggleGlideScopeUnit = light.registerEvent(EntityToggleGlideEvent.class, "entity toggle glide");
        entityToggleGlideScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityToggleGlideEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityToggleGlideEvent event) {
                return event.getEntityType();
            }
        });
        entityToggleGlideScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityToggleGlideEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityToggleGlideEvent event) {
                return event.getEntity();
            }
        });
        entityToggleGlideScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityToggleGlideEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityToggleGlideEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit expBottleScopeUnit = light.registerEvent(ExpBottleEvent.class, "exp bottle");
        expBottleScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExpBottleEvent event) {
                return event.getEntityType();
            }
        });
        expBottleScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExpBottleEvent event) {
                return event.getEntity();
            }
        });
        expBottleScopeUnit.registerArgument("experience", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExpBottleEvent event) {
                return event.getExperience();
            }
        });
        expBottleScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExpBottleEvent event) {
                return event.getEventName();
            }
        });
        expBottleScopeUnit.registerArgument("show effect", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ExpBottleEvent event) {
                return event.getShowEffect();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityTeleportScopeUnit = light.registerEvent(EntityTeleportEvent.class, "entity teleport");
        entityTeleportScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTeleportEvent event) {
                return event.getEntityType();
            }
        });
        entityTeleportScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTeleportEvent event) {
                return event.getEntity();
            }
        });
        entityTeleportScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTeleportEvent event) {
                return event.getTo();
            }
        });
        entityTeleportScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTeleportEvent event) {
                return event.getEventName();
            }
        });
        entityTeleportScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityTeleportEvent event) {
                return event.getFrom();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit itemSpawnScopeUnit = light.registerEvent(ItemSpawnEvent.class, "item spawn");
        itemSpawnScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemSpawnEvent event) {
                return event.getEntityType();
            }
        });
        itemSpawnScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemSpawnEvent event) {
                return event.getEntity();
            }
        });
        itemSpawnScopeUnit.registerArgument("location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemSpawnEvent event) {
                return event.getLocation();
            }
        });
        itemSpawnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ItemSpawnEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit entityPortalExitScopeUnit = light.registerEvent(EntityPortalExitEvent.class, "entity portal exit");
        entityPortalExitScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getEntityType();
            }
        });
        entityPortalExitScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getEntity();
            }
        });
        entityPortalExitScopeUnit.registerArgument("before", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getBefore();
            }
        });
        entityPortalExitScopeUnit.registerArgument("after", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getAfter();
            }
        });
        entityPortalExitScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getTo();
            }
        });
        entityPortalExitScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getEventName();
            }
        });
        entityPortalExitScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EntityPortalExitEvent event) {
                return event.getFrom();
            }
        });

    }

}
