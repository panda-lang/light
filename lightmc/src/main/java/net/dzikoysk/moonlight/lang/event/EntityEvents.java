package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.entity.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class EntityEvents implements BukkitElements {

    private final Moonlight moonlight;

    public EntityEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit entityBreakDoorScopeUnit = moonlight.registerEvent(EntityBreakDoorEvent.class, "entity break door");
        entityBreakDoorScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(Ray ray, EntityBreakDoorEvent event) {
                return event.getEntityType();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(Ray ray, EntityBreakDoorEvent event) {
                return event.getEntity();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("data", new ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(Ray ray, EntityBreakDoorEvent event) {
                return event.getData();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(Ray ray, EntityBreakDoorEvent event) {
                return event.getEventName();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("block", new ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(Ray ray, EntityBreakDoorEvent event) {
                return event.getBlock();
            }
        });
        entityBreakDoorScopeUnit.registerArgument("to", new ArgumentInitializer<EntityBreakDoorEvent>() {
            @Override
            public Object get(Ray ray, EntityBreakDoorEvent event) {
                return event.getTo();
            }
        });

        ScopeUnit potionSplashScopeUnit = moonlight.registerEvent(PotionSplashEvent.class, "potion splash");
        potionSplashScopeUnit.registerArgument("potion", new ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(Ray ray, PotionSplashEvent event) {
                return event.getPotion();
            }
        });
        potionSplashScopeUnit.registerArgument("entity type", new ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(Ray ray, PotionSplashEvent event) {
                return event.getEntityType();
            }
        });
        potionSplashScopeUnit.registerArgument("entity", new ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(Ray ray, PotionSplashEvent event) {
                return event.getEntity();
            }
        });
        potionSplashScopeUnit.registerArgument("intensity", new ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(Ray ray, PotionSplashEvent event) {
                return 1.0;
            }
        });
        potionSplashScopeUnit.registerArgument("event name", new ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(Ray ray, PotionSplashEvent event) {
                return event.getEventName();
            }
        });
        potionSplashScopeUnit.registerArgument("affected entities", new ArgumentInitializer<PotionSplashEvent>() {
            @Override
            public Object get(Ray ray, PotionSplashEvent event) {
                return event.getAffectedEntities();
            }
        });

        ScopeUnit entityScopeUnit = moonlight.registerEvent(EntityEvent.class, "entity");
        entityScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityEvent>() {
            @Override
            public Object get(Ray ray, EntityEvent event) {
                return event.getEntityType();
            }
        });
        entityScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityEvent>() {
            @Override
            public Object get(Ray ray, EntityEvent event) {
                return event.getEntity();
            }
        });
        entityScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityEvent>() {
            @Override
            public Object get(Ray ray, EntityEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit villagerAcquireTradeScopeUnit = moonlight.registerEvent(VillagerAcquireTradeEvent.class, "villager acquire trade");
        villagerAcquireTradeScopeUnit.registerArgument("entity type", new ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerAcquireTradeEvent event) {
                return event.getEntityType();
            }
        });
        villagerAcquireTradeScopeUnit.registerArgument("entity", new ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerAcquireTradeEvent event) {
                return event.getEntity();
            }
        });
        villagerAcquireTradeScopeUnit.registerArgument("recipe", new ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerAcquireTradeEvent event) {
                return event.getRecipe();
            }
        });
        villagerAcquireTradeScopeUnit.registerArgument("event name", new ArgumentInitializer<VillagerAcquireTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerAcquireTradeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit foodLevelChangeScopeUnit = moonlight.registerEvent(FoodLevelChangeEvent.class, "food level change");
        foodLevelChangeScopeUnit.registerArgument("entity type", new ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, FoodLevelChangeEvent event) {
                return event.getEntityType();
            }
        });
        foodLevelChangeScopeUnit.registerArgument("entity", new ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, FoodLevelChangeEvent event) {
                return event.getEntity();
            }
        });
        foodLevelChangeScopeUnit.registerArgument("food level", new ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, FoodLevelChangeEvent event) {
                return event.getFoodLevel();
            }
        });
        foodLevelChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<FoodLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, FoodLevelChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit sheepDyeWoolScopeUnit = moonlight.registerEvent(SheepDyeWoolEvent.class, "sheep dye wool");
        sheepDyeWoolScopeUnit.registerArgument("entity", new ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepDyeWoolEvent event) {
                return event.getEntity();
            }
        });
        sheepDyeWoolScopeUnit.registerArgument("entity type", new ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepDyeWoolEvent event) {
                return event.getEntityType();
            }
        });
        sheepDyeWoolScopeUnit.registerArgument("color", new ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepDyeWoolEvent event) {
                return event.getColor();
            }
        });
        sheepDyeWoolScopeUnit.registerArgument("event name", new ArgumentInitializer<SheepDyeWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepDyeWoolEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit itemMergeScopeUnit = moonlight.registerEvent(ItemMergeEvent.class, "item merge");
        itemMergeScopeUnit.registerArgument("target", new ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(Ray ray, ItemMergeEvent event) {
                return event.getTarget();
            }
        });
        itemMergeScopeUnit.registerArgument("entity type", new ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(Ray ray, ItemMergeEvent event) {
                return event.getEntityType();
            }
        });
        itemMergeScopeUnit.registerArgument("entity", new ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(Ray ray, ItemMergeEvent event) {
                return event.getEntity();
            }
        });
        itemMergeScopeUnit.registerArgument("event name", new ArgumentInitializer<ItemMergeEvent>() {
            @Override
            public Object get(Ray ray, ItemMergeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit villagerReplenishTradeScopeUnit = moonlight.registerEvent(VillagerReplenishTradeEvent.class, "villager replenish trade");
        villagerReplenishTradeScopeUnit.registerArgument("entity type", new ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerReplenishTradeEvent event) {
                return event.getEntityType();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("recipe", new ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerReplenishTradeEvent event) {
                return event.getRecipe();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("bonus", new ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerReplenishTradeEvent event) {
                return event.getBonus();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("entity", new ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerReplenishTradeEvent event) {
                return event.getEntity();
            }
        });
        villagerReplenishTradeScopeUnit.registerArgument("event name", new ArgumentInitializer<VillagerReplenishTradeEvent>() {
            @Override
            public Object get(Ray ray, VillagerReplenishTradeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityTargetScopeUnit = moonlight.registerEvent(EntityTargetEvent.class, "entity target");
        entityTargetScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetEvent event) {
                return event.getEntityType();
            }
        });
        entityTargetScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetEvent event) {
                return event.getEntity();
            }
        });
        entityTargetScopeUnit.registerArgument("reason", new ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetEvent event) {
                return event.getReason();
            }
        });
        entityTargetScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetEvent event) {
                return event.getEventName();
            }
        });
        entityTargetScopeUnit.registerArgument("target", new ArgumentInitializer<EntityTargetEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetEvent event) {
                return event.getTarget();
            }
        });

        ScopeUnit entityCreatePortalScopeUnit = moonlight.registerEvent(EntityCreatePortalEvent.class, "entity create portal");
        entityCreatePortalScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(Ray ray, EntityCreatePortalEvent event) {
                return event.getEntityType();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("portal type", new ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(Ray ray, EntityCreatePortalEvent event) {
                return event.getPortalType();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(Ray ray, EntityCreatePortalEvent event) {
                return event.getEntity();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(Ray ray, EntityCreatePortalEvent event) {
                return event.getEventName();
            }
        });
        entityCreatePortalScopeUnit.registerArgument("blocks", new ArgumentInitializer<EntityCreatePortalEvent>() {
            @Override
            public Object get(Ray ray, EntityCreatePortalEvent event) {
                return event.getBlocks();
            }
        });

        ScopeUnit creeperPowerScopeUnit = moonlight.registerEvent(CreeperPowerEvent.class, "creeper power");
        creeperPowerScopeUnit.registerArgument("entity type", new ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(Ray ray, CreeperPowerEvent event) {
                return event.getEntityType();
            }
        });
        creeperPowerScopeUnit.registerArgument("entity", new ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(Ray ray, CreeperPowerEvent event) {
                return event.getEntity();
            }
        });
        creeperPowerScopeUnit.registerArgument("cause", new ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(Ray ray, CreeperPowerEvent event) {
                return event.getCause();
            }
        });
        creeperPowerScopeUnit.registerArgument("lightning", new ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(Ray ray, CreeperPowerEvent event) {
                return event.getLightning();
            }
        });
        creeperPowerScopeUnit.registerArgument("event name", new ArgumentInitializer<CreeperPowerEvent>() {
            @Override
            public Object get(Ray ray, CreeperPowerEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityTargetLivingEntityScopeUnit = moonlight.registerEvent(EntityTargetLivingEntityEvent.class, "entity target living entity");
        entityTargetLivingEntityScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getEntityType();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getEntity();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("reason", new ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getReason();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getEventName();
            }
        });
        entityTargetLivingEntityScopeUnit.registerArgument("target", new ArgumentInitializer<EntityTargetLivingEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityTargetLivingEntityEvent event) {
                return event.getTarget();
            }
        });

        ScopeUnit entityPortalEnterScopeUnit = moonlight.registerEvent(EntityPortalEnterEvent.class, "entity portal enter");
        entityPortalEnterScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEnterEvent event) {
                return event.getEntityType();
            }
        });
        entityPortalEnterScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEnterEvent event) {
                return event.getEntity();
            }
        });
        entityPortalEnterScopeUnit.registerArgument("location", new ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEnterEvent event) {
                return event.getLocation();
            }
        });
        entityPortalEnterScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityPortalEnterEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEnterEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityPortalScopeUnit = moonlight.registerEvent(EntityPortalEvent.class, "entity portal");
        entityPortalScopeUnit.registerArgument("portal travel agent", new ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEvent event) {
                return event.getPortalTravelAgent();
            }
        });
        entityPortalScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEvent event) {
                return event.getEntityType();
            }
        });
        entityPortalScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEvent event) {
                return event.getEntity();
            }
        });
        entityPortalScopeUnit.registerArgument("to", new ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEvent event) {
                return event.getTo();
            }
        });
        entityPortalScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEvent event) {
                return event.getEventName();
            }
        });
        entityPortalScopeUnit.registerArgument("from", new ArgumentInitializer<EntityPortalEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalEvent event) {
                return event.getFrom();
            }
        });

        ScopeUnit entityUnleashScopeUnit = moonlight.registerEvent(EntityUnleashEvent.class, "entity unleash");
        entityUnleashScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(Ray ray, EntityUnleashEvent event) {
                return event.getEntityType();
            }
        });
        entityUnleashScopeUnit.registerArgument("reason", new ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(Ray ray, EntityUnleashEvent event) {
                return event.getReason();
            }
        });
        entityUnleashScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(Ray ray, EntityUnleashEvent event) {
                return event.getEntity();
            }
        });
        entityUnleashScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityUnleashEvent>() {
            @Override
            public Object get(Ray ray, EntityUnleashEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit slimeSplitScopeUnit = moonlight.registerEvent(SlimeSplitEvent.class, "slime split");
        slimeSplitScopeUnit.registerArgument("entity type", new ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(Ray ray, SlimeSplitEvent event) {
                return event.getEntityType();
            }
        });
        slimeSplitScopeUnit.registerArgument("entity", new ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(Ray ray, SlimeSplitEvent event) {
                return event.getEntity();
            }
        });
        slimeSplitScopeUnit.registerArgument("event name", new ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(Ray ray, SlimeSplitEvent event) {
                return event.getEventName();
            }
        });
        slimeSplitScopeUnit.registerArgument("count", new ArgumentInitializer<SlimeSplitEvent>() {
            @Override
            public Object get(Ray ray, SlimeSplitEvent event) {
                return event.getCount();
            }
        });

        ScopeUnit itemDespawnScopeUnit = moonlight.registerEvent(ItemDespawnEvent.class, "item despawn");
        itemDespawnScopeUnit.registerArgument("entity type", new ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(Ray ray, ItemDespawnEvent event) {
                return event.getEntityType();
            }
        });
        itemDespawnScopeUnit.registerArgument("entity", new ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(Ray ray, ItemDespawnEvent event) {
                return event.getEntity();
            }
        });
        itemDespawnScopeUnit.registerArgument("event name", new ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(Ray ray, ItemDespawnEvent event) {
                return event.getEventName();
            }
        });
        itemDespawnScopeUnit.registerArgument("location", new ArgumentInitializer<ItemDespawnEvent>() {
            @Override
            public Object get(Ray ray, ItemDespawnEvent event) {
                return event.getLocation();
            }
        });

        ScopeUnit projectileHitScopeUnit = moonlight.registerEvent(ProjectileHitEvent.class, "projectile hit");
        projectileHitScopeUnit.registerArgument("entity type", new ArgumentInitializer<ProjectileHitEvent>() {
            @Override
            public Object get(Ray ray, ProjectileHitEvent event) {
                return event.getEntityType();
            }
        });
        projectileHitScopeUnit.registerArgument("entity", new ArgumentInitializer<ProjectileHitEvent>() {
            @Override
            public Object get(Ray ray, ProjectileHitEvent event) {
                return event.getEntity();
            }
        });
        projectileHitScopeUnit.registerArgument("event name", new ArgumentInitializer<ProjectileHitEvent>() {
            @Override
            public Object get(Ray ray, ProjectileHitEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit fireworkExplodeScopeUnit = moonlight.registerEvent(FireworkExplodeEvent.class, "firework explode");
        fireworkExplodeScopeUnit.registerArgument("entity type", new ArgumentInitializer<FireworkExplodeEvent>() {
            @Override
            public Object get(Ray ray, FireworkExplodeEvent event) {
                return event.getEntityType();
            }
        });
        fireworkExplodeScopeUnit.registerArgument("entity", new ArgumentInitializer<FireworkExplodeEvent>() {
            @Override
            public Object get(Ray ray, FireworkExplodeEvent event) {
                return event.getEntity();
            }
        });
        fireworkExplodeScopeUnit.registerArgument("event name", new ArgumentInitializer<FireworkExplodeEvent>() {
            @Override
            public Object get(Ray ray, FireworkExplodeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit projectileLaunchScopeUnit = moonlight.registerEvent(ProjectileLaunchEvent.class, "projectile launch");
        projectileLaunchScopeUnit.registerArgument("entity type", new ArgumentInitializer<ProjectileLaunchEvent>() {
            @Override
            public Object get(Ray ray, ProjectileLaunchEvent event) {
                return event.getEntityType();
            }
        });
        projectileLaunchScopeUnit.registerArgument("entity", new ArgumentInitializer<ProjectileLaunchEvent>() {
            @Override
            public Object get(Ray ray, ProjectileLaunchEvent event) {
                return event.getEntity();
            }
        });
        projectileLaunchScopeUnit.registerArgument("event name", new ArgumentInitializer<ProjectileLaunchEvent>() {
            @Override
            public Object get(Ray ray, ProjectileLaunchEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit areaEffectCloudApplyScopeUnit = moonlight.registerEvent(AreaEffectCloudApplyEvent.class, "area effect cloud apply");
        areaEffectCloudApplyScopeUnit.registerArgument("affected entities", new ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getAffectedEntities();
            }
        });
        areaEffectCloudApplyScopeUnit.registerArgument("entity type", new ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getEntityType();
            }
        });
        areaEffectCloudApplyScopeUnit.registerArgument("entity", new ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getEntity();
            }
        });
        areaEffectCloudApplyScopeUnit.registerArgument("event name", new ArgumentInitializer<AreaEffectCloudApplyEvent>() {
            @Override
            public Object get(Ray ray, AreaEffectCloudApplyEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entitySpawnScopeUnit = moonlight.registerEvent(EntitySpawnEvent.class, "entity spawn");
        entitySpawnScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(Ray ray, EntitySpawnEvent event) {
                return event.getEntityType();
            }
        });
        entitySpawnScopeUnit.registerArgument("entity", new ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(Ray ray, EntitySpawnEvent event) {
                return event.getEntity();
            }
        });
        entitySpawnScopeUnit.registerArgument("location", new ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(Ray ray, EntitySpawnEvent event) {
                return event.getLocation();
            }
        });
        entitySpawnScopeUnit.registerArgument("event name", new ArgumentInitializer<EntitySpawnEvent>() {
            @Override
            public Object get(Ray ray, EntitySpawnEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityTameScopeUnit = moonlight.registerEvent(EntityTameEvent.class, "entity tame");
        entityTameScopeUnit.registerArgument("owner", new ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(Ray ray, EntityTameEvent event) {
                return event.getOwner();
            }
        });
        entityTameScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(Ray ray, EntityTameEvent event) {
                return event.getEntity();
            }
        });
        entityTameScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(Ray ray, EntityTameEvent event) {
                return event.getEntityType();
            }
        });
        entityTameScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityTameEvent>() {
            @Override
            public Object get(Ray ray, EntityTameEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityRegainHealthScopeUnit = moonlight.registerEvent(EntityRegainHealthEvent.class, "entity regain health");
        entityRegainHealthScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(Ray ray, EntityRegainHealthEvent event) {
                return event.getEntityType();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(Ray ray, EntityRegainHealthEvent event) {
                return event.getEntity();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(Ray ray, EntityRegainHealthEvent event) {
                return event.getEventName();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("regain reason", new ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(Ray ray, EntityRegainHealthEvent event) {
                return event.getRegainReason();
            }
        });
        entityRegainHealthScopeUnit.registerArgument("amount", new ArgumentInitializer<EntityRegainHealthEvent>() {
            @Override
            public Object get(Ray ray, EntityRegainHealthEvent event) {
                return event.getAmount();
            }
        });

        ScopeUnit entityDamageByBlockScopeUnit = moonlight.registerEvent(EntityDamageByBlockEvent.class, "entity damage by block");
        entityDamageByBlockScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getEntityType();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("original damage", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE);
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getEntity();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("damager", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getDamager();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getEventName();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("final damage", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getFinalDamage();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("cause", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getCause();
            }
        });
        entityDamageByBlockScopeUnit.registerArgument("damage", new ArgumentInitializer<EntityDamageByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByBlockEvent event) {
                return event.getDamage();
            }
        });

        ScopeUnit entityDamageByEntityScopeUnit = moonlight.registerEvent(EntityDamageByEntityEvent.class, "entity damage by entity");
        entityDamageByEntityScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getEntityType();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("original damage", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE);
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("damager", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getDamager();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getEntity();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getEventName();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("final damage", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getFinalDamage();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("cause", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getCause();
            }
        });
        entityDamageByEntityScopeUnit.registerArgument("damage", new ArgumentInitializer<EntityDamageByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageByEntityEvent event) {
                return event.getDamage();
            }
        });

        ScopeUnit horseJumpScopeUnit = moonlight.registerEvent(HorseJumpEvent.class, "horse jump");
        horseJumpScopeUnit.registerArgument("entity type", new ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(Ray ray, HorseJumpEvent event) {
                return event.getEntityType();
            }
        });
        horseJumpScopeUnit.registerArgument("entity", new ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(Ray ray, HorseJumpEvent event) {
                return event.getEntity();
            }
        });
        horseJumpScopeUnit.registerArgument("event name", new ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(Ray ray, HorseJumpEvent event) {
                return event.getEventName();
            }
        });
        horseJumpScopeUnit.registerArgument("power", new ArgumentInitializer<HorseJumpEvent>() {
            @Override
            public Object get(Ray ray, HorseJumpEvent event) {
                return event.getPower();
            }
        });

        ScopeUnit enderDragonChangePhaseScopeUnit = moonlight.registerEvent(EnderDragonChangePhaseEvent.class, "ender dragon change phase");
        enderDragonChangePhaseScopeUnit.registerArgument("entity type", new ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getEntityType();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("entity", new ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getEntity();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("new phase", new ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getNewPhase();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("event name", new ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getEventName();
            }
        });
        enderDragonChangePhaseScopeUnit.registerArgument("current phase", new ArgumentInitializer<EnderDragonChangePhaseEvent>() {
            @Override
            public Object get(Ray ray, EnderDragonChangePhaseEvent event) {
                return event.getCurrentPhase();
            }
        });

        ScopeUnit entityShootBowScopeUnit = moonlight.registerEvent(EntityShootBowEvent.class, "entity shoot bow");
        entityShootBowScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(Ray ray, EntityShootBowEvent event) {
                return event.getEntityType();
            }
        });
        entityShootBowScopeUnit.registerArgument("force", new ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(Ray ray, EntityShootBowEvent event) {
                return event.getForce();
            }
        });
        entityShootBowScopeUnit.registerArgument("bow", new ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(Ray ray, EntityShootBowEvent event) {
                return event.getBow();
            }
        });
        entityShootBowScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(Ray ray, EntityShootBowEvent event) {
                return event.getEntity();
            }
        });
        entityShootBowScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(Ray ray, EntityShootBowEvent event) {
                return event.getEventName();
            }
        });
        entityShootBowScopeUnit.registerArgument("projectile", new ArgumentInitializer<EntityShootBowEvent>() {
            @Override
            public Object get(Ray ray, EntityShootBowEvent event) {
                return event.getProjectile();
            }
        });

        ScopeUnit playerDeathScopeUnit = moonlight.registerEvent(PlayerDeathEvent.class, "player death");
        playerDeathScopeUnit.registerArgument("dropped exp", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getDroppedExp();
            }
        });
        playerDeathScopeUnit.registerArgument("entity type", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getEntityType();
            }
        });
        playerDeathScopeUnit.registerArgument("keep inventory", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getKeepInventory();
            }
        });
        playerDeathScopeUnit.registerArgument("entity", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getEntity();
            }
        });
        playerDeathScopeUnit.registerArgument("keep level", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getKeepLevel();
            }
        });
        playerDeathScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getEventName();
            }
        });
        playerDeathScopeUnit.registerArgument("death message", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getDeathMessage();
            }
        });
        playerDeathScopeUnit.registerArgument("new total exp", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getNewTotalExp();
            }
        });
        playerDeathScopeUnit.registerArgument("new level", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getNewLevel();
            }
        });
        playerDeathScopeUnit.registerArgument("drops", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getDrops();
            }
        });
        playerDeathScopeUnit.registerArgument("new exp", new ArgumentInitializer<PlayerDeathEvent>() {
            @Override
            public Object get(Ray ray, PlayerDeathEvent event) {
                return event.getNewExp();
            }
        });

        ScopeUnit entityCombustScopeUnit = moonlight.registerEvent(EntityCombustEvent.class, "entity combust");
        entityCombustScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustEvent event) {
                return event.getEntityType();
            }
        });
        entityCombustScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustEvent event) {
                return event.getEntity();
            }
        });
        entityCombustScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustEvent event) {
                return event.getEventName();
            }
        });
        entityCombustScopeUnit.registerArgument("duration", new ArgumentInitializer<EntityCombustEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustEvent event) {
                return event.getDuration();
            }
        });

        ScopeUnit entityCombustByEntityScopeUnit = moonlight.registerEvent(EntityCombustByEntityEvent.class, "entity combust by entity");
        entityCombustByEntityScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByEntityEvent event) {
                return event.getEntityType();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByEntityEvent event) {
                return event.getEntity();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByEntityEvent event) {
                return event.getEventName();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("duration", new ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByEntityEvent event) {
                return event.getDuration();
            }
        });
        entityCombustByEntityScopeUnit.registerArgument("combuster", new ArgumentInitializer<EntityCombustByEntityEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByEntityEvent event) {
                return event.getCombuster();
            }
        });

        ScopeUnit entityInteractScopeUnit = moonlight.registerEvent(EntityInteractEvent.class, "entity interact");
        entityInteractScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(Ray ray, EntityInteractEvent event) {
                return event.getEntityType();
            }
        });
        entityInteractScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(Ray ray, EntityInteractEvent event) {
                return event.getEntity();
            }
        });
        entityInteractScopeUnit.registerArgument("block", new ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(Ray ray, EntityInteractEvent event) {
                return event.getBlock();
            }
        });
        entityInteractScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityInteractEvent>() {
            @Override
            public Object get(Ray ray, EntityInteractEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit creatureSpawnScopeUnit = moonlight.registerEvent(CreatureSpawnEvent.class, "creature spawn");
        creatureSpawnScopeUnit.registerArgument("entity type", new ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(Ray ray, CreatureSpawnEvent event) {
                return event.getEntityType();
            }
        });
        creatureSpawnScopeUnit.registerArgument("entity", new ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(Ray ray, CreatureSpawnEvent event) {
                return event.getEntity();
            }
        });
        creatureSpawnScopeUnit.registerArgument("location", new ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(Ray ray, CreatureSpawnEvent event) {
                return event.getLocation();
            }
        });
        creatureSpawnScopeUnit.registerArgument("spawn reason", new ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(Ray ray, CreatureSpawnEvent event) {
                return event.getSpawnReason();
            }
        });
        creatureSpawnScopeUnit.registerArgument("event name", new ArgumentInitializer<CreatureSpawnEvent>() {
            @Override
            public Object get(Ray ray, CreatureSpawnEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit spawnerSpawnScopeUnit = moonlight.registerEvent(SpawnerSpawnEvent.class, "spawner spawn");
        spawnerSpawnScopeUnit.registerArgument("entity type", new ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(Ray ray, SpawnerSpawnEvent event) {
                return event.getEntityType();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("entity", new ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(Ray ray, SpawnerSpawnEvent event) {
                return event.getEntity();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("location", new ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(Ray ray, SpawnerSpawnEvent event) {
                return event.getLocation();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("event name", new ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(Ray ray, SpawnerSpawnEvent event) {
                return event.getEventName();
            }
        });
        spawnerSpawnScopeUnit.registerArgument("spawner", new ArgumentInitializer<SpawnerSpawnEvent>() {
            @Override
            public Object get(Ray ray, SpawnerSpawnEvent event) {
                return event.getSpawner();
            }
        });

        ScopeUnit entityDeathScopeUnit = moonlight.registerEvent(EntityDeathEvent.class, "entity death");
        entityDeathScopeUnit.registerArgument("dropped exp", new ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(Ray ray, EntityDeathEvent event) {
                return event.getDroppedExp();
            }
        });
        entityDeathScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(Ray ray, EntityDeathEvent event) {
                return event.getEntityType();
            }
        });
        entityDeathScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(Ray ray, EntityDeathEvent event) {
                return event.getEntity();
            }
        });
        entityDeathScopeUnit.registerArgument("drops", new ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(Ray ray, EntityDeathEvent event) {
                return event.getDrops();
            }
        });
        entityDeathScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityDeathEvent>() {
            @Override
            public Object get(Ray ray, EntityDeathEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit lingeringPotionSplashScopeUnit = moonlight.registerEvent(LingeringPotionSplashEvent.class, "lingering potion splash");
        lingeringPotionSplashScopeUnit.registerArgument("entity type", new ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(Ray ray, LingeringPotionSplashEvent event) {
                return event.getEntityType();
            }
        });
        lingeringPotionSplashScopeUnit.registerArgument("entity", new ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(Ray ray, LingeringPotionSplashEvent event) {
                return event.getEntity();
            }
        });
        lingeringPotionSplashScopeUnit.registerArgument("event name", new ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(Ray ray, LingeringPotionSplashEvent event) {
                return event.getEventName();
            }
        });
        lingeringPotionSplashScopeUnit.registerArgument("area effect cloud", new ArgumentInitializer<LingeringPotionSplashEvent>() {
            @Override
            public Object get(Ray ray, LingeringPotionSplashEvent event) {
                return event.getAreaEffectCloud();
            }
        });

        ScopeUnit entityCombustByBlockScopeUnit = moonlight.registerEvent(EntityCombustByBlockEvent.class, "entity combust by block");
        entityCombustByBlockScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByBlockEvent event) {
                return event.getEntityType();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByBlockEvent event) {
                return event.getEntity();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByBlockEvent event) {
                return event.getEventName();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("duration", new ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByBlockEvent event) {
                return event.getDuration();
            }
        });
        entityCombustByBlockScopeUnit.registerArgument("combuster", new ArgumentInitializer<EntityCombustByBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityCombustByBlockEvent event) {
                return event.getCombuster();
            }
        });

        ScopeUnit pigZapScopeUnit = moonlight.registerEvent(PigZapEvent.class, "pig zap");
        pigZapScopeUnit.registerArgument("entity type", new ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(Ray ray, PigZapEvent event) {
                return event.getEntityType();
            }
        });
        pigZapScopeUnit.registerArgument("entity", new ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(Ray ray, PigZapEvent event) {
                return event.getEntity();
            }
        });
        pigZapScopeUnit.registerArgument("event name", new ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(Ray ray, PigZapEvent event) {
                return event.getEventName();
            }
        });
        pigZapScopeUnit.registerArgument("pig zombie", new ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(Ray ray, PigZapEvent event) {
                return event.getPigZombie();
            }
        });
        pigZapScopeUnit.registerArgument("lightning", new ArgumentInitializer<PigZapEvent>() {
            @Override
            public Object get(Ray ray, PigZapEvent event) {
                return event.getLightning();
            }
        });

        ScopeUnit entityChangeBlockScopeUnit = moonlight.registerEvent(EntityChangeBlockEvent.class, "entity change block");
        entityChangeBlockScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityChangeBlockEvent event) {
                return event.getEntityType();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityChangeBlockEvent event) {
                return event.getEntity();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("data", new ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityChangeBlockEvent event) {
                return event.getData();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityChangeBlockEvent event) {
                return event.getEventName();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("block", new ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityChangeBlockEvent event) {
                return event.getBlock();
            }
        });
        entityChangeBlockScopeUnit.registerArgument("to", new ArgumentInitializer<EntityChangeBlockEvent>() {
            @Override
            public Object get(Ray ray, EntityChangeBlockEvent event) {
                return event.getTo();
            }
        });

        ScopeUnit entityDamageScopeUnit = moonlight.registerEvent(EntityDamageEvent.class, "entity damage");
        entityDamageScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getEntityType();
            }
        });
        entityDamageScopeUnit.registerArgument("original damage", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE);
            }
        });
        entityDamageScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getEntity();
            }
        });
        entityDamageScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getEventName();
            }
        });
        entityDamageScopeUnit.registerArgument("final damage", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getFinalDamage();
            }
        });
        entityDamageScopeUnit.registerArgument("cause", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getCause();
            }
        });
        entityDamageScopeUnit.registerArgument("damage", new ArgumentInitializer<EntityDamageEvent>() {
            @Override
            public Object get(Ray ray, EntityDamageEvent event) {
                return event.getDamage();
            }
        });

        ScopeUnit entityExplodeScopeUnit = moonlight.registerEvent(EntityExplodeEvent.class, "entity explode");
        entityExplodeScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(Ray ray, EntityExplodeEvent event) {
                return event.getEntityType();
            }
        });
        entityExplodeScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(Ray ray, EntityExplodeEvent event) {
                return event.getEntity();
            }
        });
        entityExplodeScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(Ray ray, EntityExplodeEvent event) {
                return event.getEventName();
            }
        });
        entityExplodeScopeUnit.registerArgument("yield", new ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(Ray ray, EntityExplodeEvent event) {
                return event.getYield();
            }
        });
        entityExplodeScopeUnit.registerArgument("location", new ArgumentInitializer<EntityExplodeEvent>() {
            @Override
            public Object get(Ray ray, EntityExplodeEvent event) {
                return event.getLocation();
            }
        });

        ScopeUnit playerLeashEntityScopeUnit = moonlight.registerEvent(PlayerLeashEntityEvent.class, "player leash entity");
        playerLeashEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerLeashEntityEvent event) {
                return event.getEntity();
            }
        });
        playerLeashEntityScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerLeashEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerLeashEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerLeashEntityEvent event) {
                return event.getEventName();
            }
        });
        playerLeashEntityScopeUnit.registerArgument("leash holder", new ArgumentInitializer<PlayerLeashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerLeashEntityEvent event) {
                return event.getLeashHolder();
            }
        });

        ScopeUnit sheepRegrowWoolScopeUnit = moonlight.registerEvent(SheepRegrowWoolEvent.class, "sheep regrow wool");
        sheepRegrowWoolScopeUnit.registerArgument("entity type", new ArgumentInitializer<SheepRegrowWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepRegrowWoolEvent event) {
                return event.getEntityType();
            }
        });
        sheepRegrowWoolScopeUnit.registerArgument("entity", new ArgumentInitializer<SheepRegrowWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepRegrowWoolEvent event) {
                return event.getEntity();
            }
        });
        sheepRegrowWoolScopeUnit.registerArgument("event name", new ArgumentInitializer<SheepRegrowWoolEvent>() {
            @Override
            public Object get(Ray ray, SheepRegrowWoolEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit explosionPrimeScopeUnit = moonlight.registerEvent(ExplosionPrimeEvent.class, "explosion prime");
        explosionPrimeScopeUnit.registerArgument("entity type", new ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(Ray ray, ExplosionPrimeEvent event) {
                return event.getEntityType();
            }
        });
        explosionPrimeScopeUnit.registerArgument("entity", new ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(Ray ray, ExplosionPrimeEvent event) {
                return event.getEntity();
            }
        });
        explosionPrimeScopeUnit.registerArgument("radius", new ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(Ray ray, ExplosionPrimeEvent event) {
                return event.getRadius();
            }
        });
        explosionPrimeScopeUnit.registerArgument("event name", new ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(Ray ray, ExplosionPrimeEvent event) {
                return event.getEventName();
            }
        });
        explosionPrimeScopeUnit.registerArgument("fire", new ArgumentInitializer<ExplosionPrimeEvent>() {
            @Override
            public Object get(Ray ray, ExplosionPrimeEvent event) {
                return event.getFire();
            }
        });

        ScopeUnit entityToggleGlideScopeUnit = moonlight.registerEvent(EntityToggleGlideEvent.class, "entity toggle glide");
        entityToggleGlideScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityToggleGlideEvent>() {
            @Override
            public Object get(Ray ray, EntityToggleGlideEvent event) {
                return event.getEntityType();
            }
        });
        entityToggleGlideScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityToggleGlideEvent>() {
            @Override
            public Object get(Ray ray, EntityToggleGlideEvent event) {
                return event.getEntity();
            }
        });
        entityToggleGlideScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityToggleGlideEvent>() {
            @Override
            public Object get(Ray ray, EntityToggleGlideEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit expBottleScopeUnit = moonlight.registerEvent(ExpBottleEvent.class, "exp bottle");
        expBottleScopeUnit.registerArgument("entity type", new ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(Ray ray, ExpBottleEvent event) {
                return event.getEntityType();
            }
        });
        expBottleScopeUnit.registerArgument("entity", new ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(Ray ray, ExpBottleEvent event) {
                return event.getEntity();
            }
        });
        expBottleScopeUnit.registerArgument("experience", new ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(Ray ray, ExpBottleEvent event) {
                return event.getExperience();
            }
        });
        expBottleScopeUnit.registerArgument("event name", new ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(Ray ray, ExpBottleEvent event) {
                return event.getEventName();
            }
        });
        expBottleScopeUnit.registerArgument("show effect", new ArgumentInitializer<ExpBottleEvent>() {
            @Override
            public Object get(Ray ray, ExpBottleEvent event) {
                return event.getShowEffect();
            }
        });

        ScopeUnit entityTeleportScopeUnit = moonlight.registerEvent(EntityTeleportEvent.class, "entity teleport");
        entityTeleportScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(Ray ray, EntityTeleportEvent event) {
                return event.getEntityType();
            }
        });
        entityTeleportScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(Ray ray, EntityTeleportEvent event) {
                return event.getEntity();
            }
        });
        entityTeleportScopeUnit.registerArgument("to", new ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(Ray ray, EntityTeleportEvent event) {
                return event.getTo();
            }
        });
        entityTeleportScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(Ray ray, EntityTeleportEvent event) {
                return event.getEventName();
            }
        });
        entityTeleportScopeUnit.registerArgument("from", new ArgumentInitializer<EntityTeleportEvent>() {
            @Override
            public Object get(Ray ray, EntityTeleportEvent event) {
                return event.getFrom();
            }
        });

        ScopeUnit itemSpawnScopeUnit = moonlight.registerEvent(ItemSpawnEvent.class, "item spawn");
        itemSpawnScopeUnit.registerArgument("entity type", new ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(Ray ray, ItemSpawnEvent event) {
                return event.getEntityType();
            }
        });
        itemSpawnScopeUnit.registerArgument("entity", new ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(Ray ray, ItemSpawnEvent event) {
                return event.getEntity();
            }
        });
        itemSpawnScopeUnit.registerArgument("location", new ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(Ray ray, ItemSpawnEvent event) {
                return event.getLocation();
            }
        });
        itemSpawnScopeUnit.registerArgument("event name", new ArgumentInitializer<ItemSpawnEvent>() {
            @Override
            public Object get(Ray ray, ItemSpawnEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit entityPortalExitScopeUnit = moonlight.registerEvent(EntityPortalExitEvent.class, "entity portal exit");
        entityPortalExitScopeUnit.registerArgument("entity type", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getEntityType();
            }
        });
        entityPortalExitScopeUnit.registerArgument("entity", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getEntity();
            }
        });
        entityPortalExitScopeUnit.registerArgument("before", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getBefore();
            }
        });
        entityPortalExitScopeUnit.registerArgument("after", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getAfter();
            }
        });
        entityPortalExitScopeUnit.registerArgument("to", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getTo();
            }
        });
        entityPortalExitScopeUnit.registerArgument("event name", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getEventName();
            }
        });
        entityPortalExitScopeUnit.registerArgument("from", new ArgumentInitializer<EntityPortalExitEvent>() {
            @Override
            public Object get(Ray ray, EntityPortalExitEvent event) {
                return event.getFrom();
            }
        });

    }

}
