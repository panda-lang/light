package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class BlockStructure extends org.panda_lang.light.core.element.Structure<Block> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Block.class);

        addExpressionRepresentation("block data", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    byte value = ray.getExpressionValue(1);
                    object.setData(value);
                }
            }
        });

        addExpressionRepresentation("block type id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTypeId(value);
                }
            }
        });

        addExpressionRepresentation("block light from blocks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLightFromBlocks();
            }
        });

        addExpressionRepresentation("block chunk", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getChunk();
            }
        });

        addExpressionRepresentation("block light from sky", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLightFromSky();
            }
        });

        addExpressionRepresentation("block type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    Material value = ray.getExpressionValue(1);
                    object.setType(value);
                }
            }
        });

        addExpressionRepresentation("block piston move reaction", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getPistonMoveReaction();
            }
        });

        addExpressionRepresentation("block block power", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getBlockPower();
            }
        });

        addExpressionRepresentation("block drops", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getDrops();
            }
        });

        addExpressionRepresentation("block world", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getWorld();
            }
        });

        addExpressionRepresentation("block biome", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Block object = ray.getExpressionValue(0);
                    Biome value = ray.getExpressionValue(1);
                    object.setBiome(value);
                }
            }
        });

        addExpressionRepresentation("block light level", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLightLevel();
            }
        });

        addExpressionRepresentation("block x", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getX();
            }
        });

        addExpressionRepresentation("block temperature", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getTemperature();
            }
        });

        addExpressionRepresentation("block y", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getY();
            }
        });

        addExpressionRepresentation("block humidity", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getHumidity();
            }
        });

        addExpressionRepresentation("block location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

        addExpressionRepresentation("block z", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getZ();
            }
        });

        addExpressionRepresentation("block state", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Block object = ray.getExpressionValue(0);
                return object.getState();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Block object) throws IOException {

    }

    @Override
    public Block deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Block object) {
        return object.toString();
    }

}
