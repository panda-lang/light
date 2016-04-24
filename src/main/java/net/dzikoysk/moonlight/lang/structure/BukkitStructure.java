package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class BukkitStructure extends Structure<Bukkit> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Bukkit.class);

        addExpressionRepresentation("bukkit server name", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getServerName();
            }
        });

        addExpressionRepresentation("bukkit logger", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getLogger();
            }
        });

        addExpressionRepresentation("bukkit ticks per animal spawns", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getTicksPerAnimalSpawns();
            }
        });

        addExpressionRepresentation("bukkit update folder file", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getUpdateFolderFile();
            }
        });

        addExpressionRepresentation("bukkit world container", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getWorldContainer();
            }
        });

        addExpressionRepresentation("bukkit ticks per monster spawns", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getTicksPerMonsterSpawns();
            }
        });

        addExpressionRepresentation("bukkit allow end", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getAllowEnd();
            }
        });

        addExpressionRepresentation("bukkit generate structures", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getGenerateStructures();
            }
        });

        addExpressionRepresentation("bukkit idle timeout", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    int value = ray.getExpressionValue(1);
                    Bukkit.setIdleTimeout(value);
                }
            }
        });

        addExpressionRepresentation("bukkit online players", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getOnlinePlayers();
            }
        });

        addExpressionRepresentation("bukkit animal spawn limit", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getAnimalSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit motd", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getMotd();
            }
        });

        addExpressionRepresentation("bukkit server id", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getServerId();
            }
        });

        addExpressionRepresentation("bukkit banned players", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getBannedPlayers();
            }
        });

        addExpressionRepresentation("bukkit ip", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getIp();
            }
        });

        addExpressionRepresentation("bukkit help map", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getHelpMap();
            }
        });

        addExpressionRepresentation("bukkit whitelist", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    boolean value = ray.getExpressionValue(1);
                    Bukkit.setWhitelist(value);
                }
            }
        });

        addExpressionRepresentation("bukkit version", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getVersion();
            }
        });

        addExpressionRepresentation("bukkit command aliases", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getCommandAliases();
            }
        });

        addExpressionRepresentation("bukkit allow flight", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getAllowFlight();
            }
        });

        addExpressionRepresentation("bukkit shutdown message", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getShutdownMessage();
            }
        });

        addExpressionRepresentation("bukkit warning state", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getWarningState();
            }
        });

        addExpressionRepresentation("bukkit port", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getPort();
            }
        });

        addExpressionRepresentation("bukkit name", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getName();
            }
        });

        addExpressionRepresentation("bukkit plugin manager", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getPluginManager();
            }
        });

        addExpressionRepresentation("bukkit i p bans", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getIPBans();
            }
        });

        addExpressionRepresentation("bukkit connection throttle", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getConnectionThrottle();
            }
        });

        addExpressionRepresentation("bukkit spawn radius", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    int value = ray.getExpressionValue(1);
                    Bukkit.setSpawnRadius(value);
                }
            }
        });

        addExpressionRepresentation("bukkit server", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Server value = ray.getExpressionValue(1);
                    Bukkit.setServer(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getServer();
            }
        });

        addExpressionRepresentation("bukkit whitelisted players", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getWhitelistedPlayers();
            }
        });

        addExpressionRepresentation("bukkit scoreboard manager", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getScoreboardManager();
            }
        });

        addExpressionRepresentation("bukkit default game mode", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    GameMode value = ray.getExpressionValue(1);
                    Bukkit.setDefaultGameMode(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getDefaultGameMode();
            }
        });

        addExpressionRepresentation("bukkit worlds", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getWorlds();
            }
        });

        addExpressionRepresentation("bukkit offline players", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getOfflinePlayers();
            }
        });

        addExpressionRepresentation("bukkit bukkit version", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getBukkitVersion();
            }
        });

        addExpressionRepresentation("bukkit unsafe", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getUnsafe();
            }
        });

        addExpressionRepresentation("bukkit view distance", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getViewDistance();
            }
        });

        addExpressionRepresentation("bukkit scheduler", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getScheduler();
            }
        });

        addExpressionRepresentation("bukkit ambient spawn limit", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getAmbientSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit operators", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getOperators();
            }
        });

        addExpressionRepresentation("bukkit item factory", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getItemFactory();
            }
        });

        addExpressionRepresentation("bukkit water animal spawn limit", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getWaterAnimalSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit world type", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getWorldType();
            }
        });

        addExpressionRepresentation("bukkit services manager", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getServicesManager();
            }
        });

        addExpressionRepresentation("bukkit update folder", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getUpdateFolder();
            }
        });

        addExpressionRepresentation("bukkit console sender", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getConsoleSender();
            }
        });

        addExpressionRepresentation("bukkit allow nether", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getAllowNether();
            }
        });

        addExpressionRepresentation("bukkit max players", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getMaxPlayers();
            }
        });

        addExpressionRepresentation("bukkit messenger", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getMessenger();
            }
        });

        addExpressionRepresentation("bukkit server icon", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getServerIcon();
            }
        });

        addExpressionRepresentation("bukkit monster spawn limit", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getMonsterSpawnLimit();
            }
        });

        addExpressionRepresentation("bukkit online mode", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Bukkit.getOnlineMode();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Bukkit object) throws IOException {

    }

    @Override
    public Bukkit deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Bukkit object) {
        return object.toString();
    }

}
