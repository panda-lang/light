package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class LocationStructure extends org.panda_lang.light.core.element.Structure<Location> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Location.class);

        addExpressionRepresentation("location world", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    World value = ray.getExpressionValue(1);
                    object.setWorld(value);
                }
            }
        });

        addExpressionRepresentation("location x", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setX(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getX();
            }
        });

        addExpressionRepresentation("location y", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setY(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getY();
            }
        });

        addExpressionRepresentation("location chunk", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getChunk();
            }
        });

        addExpressionRepresentation("location z", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setZ(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getZ();
            }
        });

        addExpressionRepresentation("location block", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlock();
            }
        });

        addExpressionRepresentation("location pitch", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setPitch(value);
                }
            }
        });

        addExpressionRepresentation("location block x", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlockX();
            }
        });

        addExpressionRepresentation("location block y", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlockY();
            }
        });

        addExpressionRepresentation("location yaw", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setYaw(value);
                }
            }
        });

        addExpressionRepresentation("location block z", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlockZ();
            }
        });

        addExpressionRepresentation("location direction", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    Vector value = ray.getExpressionValue(1);
                    object.setDirection(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getDirection();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Location object) throws IOException {

    }

    @Override
    public Location deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Location object) {
        return object.toString();
    }

}
