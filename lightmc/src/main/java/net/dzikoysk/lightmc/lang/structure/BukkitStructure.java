package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class BukkitStructure extends org.panda_lang.light.core.element.Structure<Bukkit> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Bukkit.class);

        addExpressionRepresentation("bukkit server name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getServerName();
            }
        });

        addExpressionRepresentation("bukkit logger", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getLogger();
            }
        });

        addExpressionRepresentation("bukkit ticks per animal spawns", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getTicksPerAnimalSpawns();
            }
        });

        addExpressionRepresentation("bukkit update folder file", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getUpdateFolderFile();
            }
        });

        addExpressionRepresentation("bukkit world container", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getWorldContainer();
            }
        });

        addExpressionRepresentation("bukkit ticks per monster spawns", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getTicksPerMonsterSpawns();
            }
        });

        addExpressionRepresentation("bukkit allow end", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getAllowEnd();
            }
        });

        addExpressionRepresentation("bukkit generate structures", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getGenerateStructures();
            }
        });

        addExpressionRepresentation("bukkit idle timeout", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    int value = ray.getExpressionValue(1);
                    Bukkit.setIdleTimeout(value);
                }
            }
        });

        addExpressionRepresentation("bukkit online players", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getOnlinePlayers();
            }
        });

        addExpressionRepresentation("bukkit animal spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getAnimalSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit motd", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getMotd();
            }
        });

        addExpressionRepresentation("bukkit server id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getServerId();
            }
        });

        addExpressionRepresentation("bukkit banned players", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getBannedPlayers();
            }
        });

        addExpressionRepresentation("bukkit ip", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getIp();
            }
        });

        addExpressionRepresentation("bukkit help map", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getHelpMap();
            }
        });

        addExpressionRepresentation("bukkit whitelist", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    boolean value = ray.getExpressionValue(1);
                    Bukkit.setWhitelist(value);
                }
            }
        });

        addExpressionRepresentation("bukkit version", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getVersion();
            }
        });

        addExpressionRepresentation("bukkit command aliases", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getCommandAliases();
            }
        });

        addExpressionRepresentation("bukkit allow flight", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getAllowFlight();
            }
        });

        addExpressionRepresentation("bukkit shutdown message", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getShutdownMessage();
            }
        });

        addExpressionRepresentation("bukkit warning state", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getWarningState();
            }
        });

        addExpressionRepresentation("bukkit port", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getPort();
            }
        });

        addExpressionRepresentation("bukkit name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getName();
            }
        });

        addExpressionRepresentation("bukkit plugin manager", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getPluginManager();
            }
        });

        addExpressionRepresentation("bukkit i p bans", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getIPBans();
            }
        });

        addExpressionRepresentation("bukkit connection throttle", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getConnectionThrottle();
            }
        });

        addExpressionRepresentation("bukkit spawn radius", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    int value = ray.getExpressionValue(1);
                    Bukkit.setSpawnRadius(value);
                }
            }
        });

        addExpressionRepresentation("bukkit server", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Server value = ray.getExpressionValue(1);
                    Bukkit.setServer(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getServer();
            }
        });

        addExpressionRepresentation("bukkit whitelisted players", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getWhitelistedPlayers();
            }
        });

        addExpressionRepresentation("bukkit scoreboard manager", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getScoreboardManager();
            }
        });

        addExpressionRepresentation("bukkit default game mode", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    GameMode value = ray.getExpressionValue(1);
                    Bukkit.setDefaultGameMode(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getDefaultGameMode();
            }
        });

        addExpressionRepresentation("bukkit worlds", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getWorlds();
            }
        });

        addExpressionRepresentation("bukkit offline players", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getOfflinePlayers();
            }
        });

        addExpressionRepresentation("bukkit bukkit version", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getBukkitVersion();
            }
        });

        addExpressionRepresentation("bukkit unsafe", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getUnsafe();
            }
        });

        addExpressionRepresentation("bukkit view distance", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getViewDistance();
            }
        });

        addExpressionRepresentation("bukkit scheduler", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getScheduler();
            }
        });

        addExpressionRepresentation("bukkit ambient spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getAmbientSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit operators", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getOperators();
            }
        });

        addExpressionRepresentation("bukkit item factory", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getItemFactory();
            }
        });

        addExpressionRepresentation("bukkit water animal spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getWaterAnimalSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit world type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getWorldType();
            }
        });

        addExpressionRepresentation("bukkit services manager", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getServicesManager();
            }
        });

        addExpressionRepresentation("bukkit update folder", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getUpdateFolder();
            }
        });

        addExpressionRepresentation("bukkit console sender", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getConsoleSender();
            }
        });

        addExpressionRepresentation("bukkit allow nether", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getAllowNether();
            }
        });

        addExpressionRepresentation("bukkit max players", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getMaxPlayers();
            }
        });

        addExpressionRepresentation("bukkit messenger", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getMessenger();
            }
        });

        addExpressionRepresentation("bukkit server icon", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getServerIcon();
            }
        });

        addExpressionRepresentation("bukkit monster spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getMonsterSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit online mode", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Bukkit.getOnlineMode();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Bukkit object) throws IOException {

    }

    @Override
    public Bukkit deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Bukkit object) {
        return object.toString();
    }

}
