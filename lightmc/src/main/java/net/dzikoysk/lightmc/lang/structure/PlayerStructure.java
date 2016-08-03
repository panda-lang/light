package net.dzikoysk.lightmc.lang.structure;

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
import org.panda_lang.light.LightCore;
import org.panda_lang.panda.core.parser.essential.util.Numeric;

import java.io.IOException;

public class PlayerStructure extends org.panda_lang.light.core.element.Structure<Player> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Player.class);

        addExpressionRepresentation("*'s resource pack", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setResourcePack(value);
                }
            }
        });

        addExpressionRepresentation("*'s last played", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLastPlayed();
            }
        });

        addExpressionRepresentation("*'s total experience", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTotalExperience(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getTotalExperience();
            }
        });

        addExpressionRepresentation("*'s health scaled", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setHealthScaled(value);
                }
            }
        });

        addExpressionRepresentation("*'s leash holder", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setLeashHolder(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLeashHolder();
            }
        });

        addExpressionRepresentation("*'s ender chest", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEnderChest();
            }
        });

        addExpressionRepresentation("*'s last damage cause", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    EntityDamageEvent value = ray.getExpressionValue(1);
                    object.setLastDamageCause(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLastDamageCause();
            }
        });

        addExpressionRepresentation("*'s type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("*'s remove when far away", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setRemoveWhenFarAway(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getRemoveWhenFarAway();
            }
        });

        addExpressionRepresentation("*'s player weather", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    WeatherType value = ray.getExpressionValue(1);
                    object.setPlayerWeather(value);
                }
            }
        });

        addExpressionRepresentation("*'s custom name visible", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCustomNameVisible(value);
                }
            }
        });

        addExpressionRepresentation("*'s can pickup items", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCanPickupItems(value);
                }
            }
        });

        addExpressionRepresentation("*'s open inventory", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getOpenInventory();
            }
        });

        addExpressionRepresentation("*'s saturation", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setSaturation(value);
                }
            }
        });

        addExpressionRepresentation("*'s player time", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    long value = ray.getExpressionValue(1);
                    object.setPlayerTime(value, true);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayerTime();
            }
        });

        addExpressionRepresentation("*'s fire ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setFireTicks(value);
                }
            }
        });

        addExpressionRepresentation("*'s texture pack", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setTexturePack(value);
                }
            }
        });

        addExpressionRepresentation("*'s compass target", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Location value = ray.getExpressionValue(1);
                    object.setCompassTarget(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getCompassTarget();
            }
        });

        addExpressionRepresentation("*'s sleep ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getSleepTicks();
            }
        });

        addExpressionRepresentation("*'s killer", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getKiller();
            }
        });

        addExpressionRepresentation("*'s scoreboard", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Scoreboard value = ray.getExpressionValue(1);
                    object.setScoreboard(value);
                }
            }
        });

        addExpressionRepresentation("*'s exp", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setExp(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getExp();
            }
        });

        addExpressionRepresentation("*'s listening plugin channels", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getListeningPluginChannels();
            }
        });

        addExpressionRepresentation("*'s game mode", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    GameMode value = ray.getExpressionValue(1);
                    object.setGameMode(value);
                }
            }
        });

        addExpressionRepresentation("*'s statistic", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Statistic value = ray.getExpressionValue(1);
                    object.setStatistic(value, 0);
                }
            }
        });

        addExpressionRepresentation("*'s sleeping ignored", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setSleepingIgnored(value);
                }
            }
        });

        addExpressionRepresentation("*'s entity id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEntityId();
            }
        });

        addExpressionRepresentation("*'s unique id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getUniqueId();
            }
        });

        addExpressionRepresentation("*'s max health", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Numeric value = (Numeric) modification.getValue().get(ray);
                    object.setMaxHealth(value.getDouble());
                }
            }
        });

        addExpressionRepresentation("*'s level", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setLevel(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLevel();
            }
        });

        addExpressionRepresentation("*'s equipment", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEquipment();
            }
        });

        addExpressionRepresentation("*'s item in hand", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    ItemStack value = ray.getExpressionValue(1);
                    object.setItemInHand(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getItemInHand();
            }
        });

        addExpressionRepresentation("*'s no damage ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setNoDamageTicks(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getNoDamageTicks();
            }
        });

        addExpressionRepresentation("*'s maximum air", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMaximumAir(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMaximumAir();
            }
        });

        addExpressionRepresentation("*'s item on cursor", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    ItemStack value = ray.getExpressionValue(1);
                    object.setItemOnCursor(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getItemOnCursor();
            }
        });

        addExpressionRepresentation("*'s allow flight", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setAllowFlight(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getAllowFlight();
            }
        });

        addExpressionRepresentation("*'s sprinting", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setSprinting(value);
                }
            }
        });

        addExpressionRepresentation("*'s last damage", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setLastDamage(value);
                }
            }
        });

        addExpressionRepresentation("*'s passenger", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setPassenger(value);
                }
            }
        });

        addExpressionRepresentation("*'s spectator target", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setSpectatorTarget(value);
                }
            }
        });

        addExpressionRepresentation("*'s flying", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setFlying(value);
                }
            }
        });

        addExpressionRepresentation("*'s name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("*'s player time offset", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayerTimeOffset();
            }
        });

        addExpressionRepresentation("*'s sneaking", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setSneaking(value);
                }
            }
        });

        addExpressionRepresentation("*'s fall distance", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setFallDistance(value);
                }
            }
        });

        addExpressionRepresentation("*'s health scale", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setHealthScale(value);
                }
            }
        });

        addExpressionRepresentation("*'s server", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getServer();
            }
        });

        addExpressionRepresentation("*'s gliding", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setGliding(value);
                }
            }
        });

        addExpressionRepresentation("*'s eye location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEyeLocation();
            }
        });

        addExpressionRepresentation("*'s max fire ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMaxFireTicks();
            }
        });

        addExpressionRepresentation("*'s custom name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setCustomName(value);
                }
            }
        });

        addExpressionRepresentation("*'s player list name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setPlayerListName(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayerListName();
            }
        });

        addExpressionRepresentation("*'s effective permissions", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEffectivePermissions();
            }
        });

        addExpressionRepresentation("*'s inventory", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getInventory();
            }
        });

        addExpressionRepresentation("*'s ticks lived", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksLived(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getTicksLived();
            }
        });

        addExpressionRepresentation("*'s vehicle", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getVehicle();
            }
        });

        addExpressionRepresentation("*'s exp to level", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getExpToLevel();
            }
        });

        addExpressionRepresentation("*'s maximum no damage ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMaximumNoDamageTicks(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMaximumNoDamageTicks();
            }
        });

        addExpressionRepresentation("*'s invulnerable", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setInvulnerable(value);
                }
            }
        });

        addExpressionRepresentation("*'s world", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getWorld();
            }
        });

        addExpressionRepresentation("*'s window property", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    InventoryView.Property value = ray.getExpressionValue(1);
                    object.setWindowProperty(value, 0);
                }
            }
        });

        addExpressionRepresentation("*'s first played", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getFirstPlayed();
            }
        });

        addExpressionRepresentation("*'s active potion effects", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getActivePotionEffects();
            }
        });

        addExpressionRepresentation("*'s banned", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setBanned(value);
                }
            }
        });

        addExpressionRepresentation("*'s eye height", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getEyeHeight();
            }
        });

        addExpressionRepresentation("*'s walk speed", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setWalkSpeed(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getWalkSpeed();
            }
        });

        addExpressionRepresentation("*'s player", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getPlayer();
            }
        });

        addExpressionRepresentation("*'s op", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setOp(value);
                }
            }
        });

        addExpressionRepresentation("*'s fly speed", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setFlySpeed(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getFlySpeed();
            }
        });

        addExpressionRepresentation("*'s address", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getAddress();
            }
        });

        addExpressionRepresentation("*'s display name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setDisplayName(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getDisplayName();
            }
        });

        addExpressionRepresentation("*'s exhaustion", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setExhaustion(value);
                }
            }
        });

        addExpressionRepresentation("*'s health", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setHealth(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getHealth();
            }
        });

        addExpressionRepresentation("*'s a i", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setAI(value);
                }
            }
        });

        addExpressionRepresentation("*'s velocity", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Vector value = ray.getExpressionValue(1);
                    object.setVelocity(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getVelocity();
            }
        });

        addExpressionRepresentation("*'s collidable", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCollidable(value);
                }
            }
        });

        addExpressionRepresentation("*'s glowing", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setGlowing(value);
                }
            }
        });

        addExpressionRepresentation("*'s remaining air", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setRemainingAir(value);
                }
            }
        });

        addExpressionRepresentation("*'s location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

        addExpressionRepresentation("*'s main hand", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getMainHand();
            }
        });

        addExpressionRepresentation("*'s whitelisted", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setWhitelisted(value);
                }
            }
        });

        addExpressionRepresentation("*'s bed spawn location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    Location value = ray.getExpressionValue(1);
                    object.setBedSpawnLocation(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getBedSpawnLocation();
            }
        });

        addExpressionRepresentation("*'s food level", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Player object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setFoodLevel(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Player object = ray.getExpressionValue(0);
                return object.getFoodLevel();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Player object) throws IOException {

    }

    @Override
    public Player deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
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