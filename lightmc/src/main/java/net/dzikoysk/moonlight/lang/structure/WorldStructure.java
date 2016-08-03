package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Difficulty;
import org.bukkit.World;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class WorldStructure extends Structure<World> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(World.class);

        addExpressionRepresentation("world allow monsters", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getAllowMonsters();
            }
        });

        addExpressionRepresentation("world game rules", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getGameRules();
            }
        });

        addExpressionRepresentation("world u i d", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getUID();
            }
        });

        addExpressionRepresentation("world auto save", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setAutoSave(value);
                }
            }
        });

        addExpressionRepresentation("world seed", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getSeed();
            }
        });

        addExpressionRepresentation("world living entities", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getLivingEntities();
            }
        });

        addExpressionRepresentation("world spawn location", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getSpawnLocation();
            }
        });

        addExpressionRepresentation("world keep spawn in memory", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setKeepSpawnInMemory(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getKeepSpawnInMemory();
            }
        });

        addExpressionRepresentation("world ticks per animal spawns", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksPerAnimalSpawns(value);
                }
            }
        });

        addExpressionRepresentation("world generator", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getGenerator();
            }
        });

        addExpressionRepresentation("world ticks per monster spawns", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksPerMonsterSpawns(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getTicksPerMonsterSpawns();
            }
        });

        addExpressionRepresentation("world ambient spawn limit", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setAmbientSpawnLimit(value);
                }
            }
        });

        addExpressionRepresentation("world world folder", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getWorldFolder();
            }
        });

        addExpressionRepresentation("world populators", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getPopulators();
            }
        });

        addExpressionRepresentation("world water animal spawn limit", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setWaterAnimalSpawnLimit(value);
                }
            }
        });

        addExpressionRepresentation("world thunder duration", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setThunderDuration(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getThunderDuration();
            }
        });

        addExpressionRepresentation("world world type", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getWorldType();
            }
        });

        addExpressionRepresentation("world listening plugin channels", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getListeningPluginChannels();
            }
        });

        addExpressionRepresentation("world animal spawn limit", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setAnimalSpawnLimit(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getAnimalSpawnLimit();
            }
        });

        addExpressionRepresentation("world storm", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setStorm(value);
                }
            }
        });

        addExpressionRepresentation("world loaded chunks", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getLoadedChunks();
            }
        });

        addExpressionRepresentation("world world border", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getWorldBorder();
            }
        });

        addExpressionRepresentation("world max height", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getMaxHeight();
            }
        });

        addExpressionRepresentation("world players", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getPlayers();
            }
        });

        addExpressionRepresentation("world thundering", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setThundering(value);
                }
            }
        });

        addExpressionRepresentation("world p v p", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setPVP(value);
                }
            }
        });

        addExpressionRepresentation("world allow animals", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getAllowAnimals();
            }
        });

        addExpressionRepresentation("world full time", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    long value = ray.getExpressionValue(1);
                    object.setFullTime(value);
                }
            }
        });

        addExpressionRepresentation("world difficulty", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    Difficulty value = ray.getExpressionValue(1);
                    object.setDifficulty(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getDifficulty();
            }
        });

        addExpressionRepresentation("world environment", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getEnvironment();
            }
        });

        addExpressionRepresentation("world weather duration", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setWeatherDuration(value);
                }
            }
        });

        addExpressionRepresentation("world entities", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getEntities();
            }
        });

        addExpressionRepresentation("world name", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("world time", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    long value = ray.getExpressionValue(1);
                    object.setTime(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getTime();
            }
        });

        addExpressionRepresentation("world sea level", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getSeaLevel();
            }
        });

        addExpressionRepresentation("world monster spawn limit", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMonsterSpawnLimit(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getMonsterSpawnLimit();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, World object) throws IOException {

    }

    @Override
    public World deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(World object) {
        return object.toString();
    }

}
