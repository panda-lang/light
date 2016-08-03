package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.Difficulty;
import org.bukkit.World;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class WorldStructure extends org.panda_lang.light.core.element.Structure<World> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(World.class);

        addExpressionRepresentation("world allow monsters", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getAllowMonsters();
            }
        });

        addExpressionRepresentation("world game rules", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getGameRules();
            }
        });

        addExpressionRepresentation("world u i d", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getUID();
            }
        });

        addExpressionRepresentation("world auto save", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setAutoSave(value);
                }
            }
        });

        addExpressionRepresentation("world seed", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getSeed();
            }
        });

        addExpressionRepresentation("world living entities", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getLivingEntities();
            }
        });

        addExpressionRepresentation("world spawn location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getSpawnLocation();
            }
        });

        addExpressionRepresentation("world keep spawn in memory", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setKeepSpawnInMemory(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getKeepSpawnInMemory();
            }
        });

        addExpressionRepresentation("world ticks per animal spawns", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksPerAnimalSpawns(value);
                }
            }
        });

        addExpressionRepresentation("world generator", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getGenerator();
            }
        });

        addExpressionRepresentation("world ticks per monster spawns", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksPerMonsterSpawns(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getTicksPerMonsterSpawns();
            }
        });

        addExpressionRepresentation("world ambient spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setAmbientSpawnLimit(value);
                }
            }
        });

        addExpressionRepresentation("world world folder", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getWorldFolder();
            }
        });

        addExpressionRepresentation("world populators", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getPopulators();
            }
        });

        addExpressionRepresentation("world water animal spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setWaterAnimalSpawnLimit(value);
                }
            }
        });

        addExpressionRepresentation("world thunder duration", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setThunderDuration(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getThunderDuration();
            }
        });

        addExpressionRepresentation("world world type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getWorldType();
            }
        });

        addExpressionRepresentation("world listening plugin channels", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getListeningPluginChannels();
            }
        });

        addExpressionRepresentation("world animal spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setAnimalSpawnLimit(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getAnimalSpawnLimit();
            }
        });

        addExpressionRepresentation("world storm", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setStorm(value);
                }
            }
        });

        addExpressionRepresentation("world loaded chunks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getLoadedChunks();
            }
        });

        addExpressionRepresentation("world world border", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getWorldBorder();
            }
        });

        addExpressionRepresentation("world max height", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getMaxHeight();
            }
        });

        addExpressionRepresentation("world players", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getPlayers();
            }
        });

        addExpressionRepresentation("world thundering", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setThundering(value);
                }
            }
        });

        addExpressionRepresentation("world p v p", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setPVP(value);
                }
            }
        });

        addExpressionRepresentation("world allow animals", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getAllowAnimals();
            }
        });

        addExpressionRepresentation("world full time", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    long value = ray.getExpressionValue(1);
                    object.setFullTime(value);
                }
            }
        });

        addExpressionRepresentation("world difficulty", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    Difficulty value = ray.getExpressionValue(1);
                    object.setDifficulty(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getDifficulty();
            }
        });

        addExpressionRepresentation("world environment", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getEnvironment();
            }
        });

        addExpressionRepresentation("world weather duration", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setWeatherDuration(value);
                }
            }
        });

        addExpressionRepresentation("world entities", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getEntities();
            }
        });

        addExpressionRepresentation("world name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("world time", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    long value = ray.getExpressionValue(1);
                    object.setTime(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getTime();
            }
        });

        addExpressionRepresentation("world sea level", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getSeaLevel();
            }
        });

        addExpressionRepresentation("world monster spawn limit", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    World object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMonsterSpawnLimit(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                World object = ray.getExpressionValue(0);
                return object.getMonsterSpawnLimit();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, World object) throws IOException {

    }

    @Override
    public World deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(World object) {
        return object.toString();
    }

}
