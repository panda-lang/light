package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class LocationStructure extends Structure<Location> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Location.class);

        addExpressionRepresentation("location world", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    World value = ray.getExpressionValue(1);
                    object.setWorld(value);
                }
            }
        });

        addExpressionRepresentation("location x", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setX(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getX();
            }
        });

        addExpressionRepresentation("location y", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setY(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getY();
            }
        });

        addExpressionRepresentation("location chunk", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getChunk();
            }
        });

        addExpressionRepresentation("location z", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    double value = ray.getExpressionValue(1);
                    object.setZ(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getZ();
            }
        });

        addExpressionRepresentation("location block", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlock();
            }
        });

        addExpressionRepresentation("location pitch", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setPitch(value);
                }
            }
        });

        addExpressionRepresentation("location block x", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlockX();
            }
        });

        addExpressionRepresentation("location block y", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlockY();
            }
        });

        addExpressionRepresentation("location yaw", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setYaw(value);
                }
            }
        });

        addExpressionRepresentation("location block z", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getBlockZ();
            }
        });

        addExpressionRepresentation("location direction", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Location object = ray.getExpressionValue(0);
                    Vector value = ray.getExpressionValue(1);
                    object.setDirection(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Location object = ray.getExpressionValue(0);
                return object.getDirection();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Location object) throws IOException {

    }

    @Override
    public Location deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Location object) {
        return object.toString();
    }

}
