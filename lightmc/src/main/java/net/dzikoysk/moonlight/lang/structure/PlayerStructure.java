package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;
import org.panda_lang.panda.core.parser.essential.util.Numeric;

import java.io.IOException;

public class PlayerStructure extends Structure<Player> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Player.class);

        addExpressionRepresentation("*'s resource pack", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setResourcePack(value);
                }
            }
        });

        addExpressionRepresentation("*'s last played", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLastPlayed();
            }
        });

        addExpressionRepresentation("*'s total experience", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTotalExperience(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getTotalExperience();
            }
        });

        addExpressionRepresentation("*'s health scaled", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setHealthScaled(value);
                }
            }
        });

        addExpressionRepresentation("*'s leash holder", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setLeashHolder(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLeashHolder();
            }
        });

        addExpressionRepresentation("*'s ender chest", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEnderChest();
            }
        });

        addExpressionRepresentation("*'s last damage cause", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    EntityDamageEvent value = ray.getExpressionValue(1);
                    object.setLastDamageCause(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLastDamageCause();
            }
        });

        addExpressionRepresentation("*'s type", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("*'s remove when far away", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setRemoveWhenFarAway(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getRemoveWhenFarAway();
            }
        });

        addExpressionRepresentation("*'s player weather", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    WeatherType value = ray.getExpressionValue(1);
                    object.setPlayerWeather(value);
                }
            }
        });

        addExpressionRepresentation("*'s custom name visible", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCustomNameVisible(value);
                }
            }
        });

        addExpressionRepresentation("*'s can pickup items", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCanPickupItems(value);
                }
            }
        });

        addExpressionRepresentation("*'s open inventory", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getOpenInventory();
            }
        });

        addExpressionRepresentation("*'s saturation", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setSaturation(value);
                }
            }
        });

        addExpressionRepresentation("*'s player time", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    long value = ray.getExpressionValue(1);
                    object.setPlayerTime(value, true);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayerTime();
            }
        });

        addExpressionRepresentation("*'s fire ticks", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setFireTicks(value);
                }
            }
        });

        addExpressionRepresentation("*'s texture pack", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setTexturePack(value);
                }
            }
        });

        addExpressionRepresentation("*'s compass target", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Location value = ray.getExpressionValue(1);
                    object.setCompassTarget(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getCompassTarget();
            }
        });

        addExpressionRepresentation("*'s sleep ticks", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getSleepTicks();
            }
        });

        addExpressionRepresentation("*'s killer", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getKiller();
            }
        });

        addExpressionRepresentation("*'s scoreboard", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Scoreboard value = ray.getExpressionValue(1);
                    object.setScoreboard(value);
                }
            }
        });

        addExpressionRepresentation("*'s exp", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setExp(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getExp();
            }
        });

        addExpressionRepresentation("*'s listening plugin channels", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getListeningPluginChannels();
            }
        });

        addExpressionRepresentation("*'s game mode", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    GameMode value = ray.getExpressionValue(1);
                    object.setGameMode(value);
                }
            }
        });

        addExpressionRepresentation("*'s statistic", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Statistic value = ray.getExpressionValue(1);
                    object.setStatistic(value, 0);
                }
            }
        });

        addExpressionRepresentation("*'s sleeping ignored", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setSleepingIgnored(value);
                }
            }
        });

        addExpressionRepresentation("*'s entity id", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEntityId();
            }
        });

        addExpressionRepresentation("*'s unique id", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getUniqueId();
            }
        });

        addExpressionRepresentation("*'s max health", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Numeric value = (Numeric) modification.getValue().get(ray);
                    object.setMaxHealth(value.getDouble());
                }
            }
        });

        addExpressionRepresentation("*'s level", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setLevel(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLevel();
            }
        });

        addExpressionRepresentation("*'s equipment", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEquipment();
            }
        });

        addExpressionRepresentation("*'s item in hand", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    ItemStack value = ray.getExpressionValue(1);
                    object.setItemInHand(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getItemInHand();
            }
        });

        addExpressionRepresentation("*'s no damage ticks", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setNoDamageTicks(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getNoDamageTicks();
            }
        });

        addExpressionRepresentation("*'s maximum air", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMaximumAir(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMaximumAir();
            }
        });

        addExpressionRepresentation("*'s item on cursor", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    ItemStack value = ray.getExpressionValue(1);
                    object.setItemOnCursor(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getItemOnCursor();
            }
        });

        addExpressionRepresentation("*'s allow flight", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setAllowFlight(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getAllowFlight();
            }
        });

        addExpressionRepresentation("*'s sprinting", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setSprinting(value);
                }
            }
        });

        addExpressionRepresentation("*'s last damage", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setLastDamage(value);
                }
            }
        });

        addExpressionRepresentation("*'s passenger", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setPassenger(value);
                }
            }
        });

        addExpressionRepresentation("*'s spectator target", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setSpectatorTarget(value);
                }
            }
        });

        addExpressionRepresentation("*'s flying", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setFlying(value);
                }
            }
        });

        addExpressionRepresentation("*'s name", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("*'s player time offset", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayerTimeOffset();
            }
        });

        addExpressionRepresentation("*'s sneaking", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setSneaking(value);
                }
            }
        });

        addExpressionRepresentation("*'s fall distance", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setFallDistance(value);
                }
            }
        });

        addExpressionRepresentation("*'s health scale", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setHealthScale(value);
                }
            }
        });

        addExpressionRepresentation("*'s server", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getServer();
            }
        });

        addExpressionRepresentation("*'s gliding", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setGliding(value);
                }
            }
        });

        addExpressionRepresentation("*'s eye location", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEyeLocation();
            }
        });

        addExpressionRepresentation("*'s max fire ticks", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMaxFireTicks();
            }
        });

        addExpressionRepresentation("*'s custom name", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setCustomName(value);
                }
            }
        });

        addExpressionRepresentation("*'s player list name", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setPlayerListName(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayerListName();
            }
        });

        addExpressionRepresentation("*'s effective permissions", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEffectivePermissions();
            }
        });

        addExpressionRepresentation("*'s inventory", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getInventory();
            }
        });

        addExpressionRepresentation("*'s ticks lived", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksLived(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getTicksLived();
            }
        });

        addExpressionRepresentation("*'s vehicle", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getVehicle();
            }
        });

        addExpressionRepresentation("*'s exp to level", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getExpToLevel();
            }
        });

        addExpressionRepresentation("*'s maximum no damage ticks", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMaximumNoDamageTicks(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMaximumNoDamageTicks();
            }
        });

        addExpressionRepresentation("*'s invulnerable", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setInvulnerable(value);
                }
            }
        });

        addExpressionRepresentation("*'s world", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getWorld();
            }
        });

        addExpressionRepresentation("*'s window property", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    InventoryView.Property value = ray.getExpressionValue(1);
                    object.setWindowProperty(value, 0);
                }
            }
        });

        addExpressionRepresentation("*'s first played", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getFirstPlayed();
            }
        });

        addExpressionRepresentation("*'s active potion effects", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getActivePotionEffects();
            }
        });

        addExpressionRepresentation("*'s banned", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setBanned(value);
                }
            }
        });

        addExpressionRepresentation("*'s eye height", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEyeHeight();
            }
        });

        addExpressionRepresentation("*'s walk speed", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setWalkSpeed(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getWalkSpeed();
            }
        });

        addExpressionRepresentation("*'s player", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayer();
            }
        });

        addExpressionRepresentation("*'s op", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setOp(value);
                }
            }
        });

        addExpressionRepresentation("*'s fly speed", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setFlySpeed(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getFlySpeed();
            }
        });

        addExpressionRepresentation("*'s address", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getAddress();
            }
        });

        addExpressionRepresentation("*'s display name", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setDisplayName(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getDisplayName();
            }
        });

        addExpressionRepresentation("*'s exhaustion", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setExhaustion(value);
                }
            }
        });

        addExpressionRepresentation("*'s health", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setHealth(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getHealth();
            }
        });

        addExpressionRepresentation("*'s a i", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setAI(value);
                }
            }
        });

        addExpressionRepresentation("*'s velocity", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Vector value = ray.getExpressionValue(1);
                    object.setVelocity(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getVelocity();
            }
        });

        addExpressionRepresentation("*'s collidable", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCollidable(value);
                }
            }
        });

        addExpressionRepresentation("*'s glowing", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setGlowing(value);
                }
            }
        });

        addExpressionRepresentation("*'s remaining air", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setRemainingAir(value);
                }
            }
        });

        addExpressionRepresentation("*'s location", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

        addExpressionRepresentation("*'s main hand", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMainHand();
            }
        });

        addExpressionRepresentation("*'s whitelisted", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setWhitelisted(value);
                }
            }
        });

        addExpressionRepresentation("*'s bed spawn location", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Location value = ray.getExpressionValue(1);
                    object.setBedSpawnLocation(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getBedSpawnLocation();
            }
        });

        addExpressionRepresentation("*'s food level", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setFoodLevel(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getFoodLevel();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Player object) throws IOException {

    }

    @Override
    public Player deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Player object) {
        return object.toString();
    }

}

/*
    @Override
    public void serialize(DataSerializer dataSerializer, Player object) throws IOException {
        dataSerializer.writeUTF(object.getUniqueId().toString());
    }

    @Override
    public Player deserialize(DataSerializer dataSerializer) throws IOException {
        UUID uuid = UUID.fromString(dataSerializer.readUTF());
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public String toString(Player object) {
        return object.getName();
    }
*/