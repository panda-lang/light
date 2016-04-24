package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class BlockStructure extends Structure<Block> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Block.class);

        addExpressionRepresentation("block data", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    byte value = ray.getExpressionValue(1);
                    object.setData(value);
                }
            }
        });

        addExpressionRepresentation("block type id", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTypeId(value);
                }
            }
        });

        addExpressionRepresentation("block light from blocks", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLightFromBlocks();
            }
        });

        addExpressionRepresentation("block chunk", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getChunk();
            }
        });

        addExpressionRepresentation("block light from sky", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLightFromSky();
            }
        });

        addExpressionRepresentation("block type", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    Material value = ray.getExpressionValue(1);
                    object.setType(value);
                }
            }
        });

        addExpressionRepresentation("block piston move reaction", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getPistonMoveReaction();
            }
        });

        addExpressionRepresentation("block block power", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getBlockPower();
            }
        });

        addExpressionRepresentation("block drops", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getDrops();
            }
        });

        addExpressionRepresentation("block world", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getWorld();
            }
        });

        addExpressionRepresentation("block biome", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    Biome value = ray.getExpressionValue(1);
                    object.setBiome(value);
                }
            }
        });

        addExpressionRepresentation("block light level", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLightLevel();
            }
        });

        addExpressionRepresentation("block x", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getX();
            }
        });

        addExpressionRepresentation("block temperature", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getTemperature();
            }
        });

        addExpressionRepresentation("block y", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getY();
            }
        });

        addExpressionRepresentation("block humidity", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getHumidity();
            }
        });

        addExpressionRepresentation("block location", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

        addExpressionRepresentation("block z", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getZ();
            }
        });

        addExpressionRepresentation("block state", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getState();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Block object) throws IOException {

    }

    @Override
    public Block deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Block object) {
        return object.toString();
    }

}
