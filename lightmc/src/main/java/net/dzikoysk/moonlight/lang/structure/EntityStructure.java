package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class EntityStructure extends Structure<Entity> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Entity.class);

        addExpressionRepresentation("entity's fall distance", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setFallDistance(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getFallDistance();
            }
        });

        addExpressionRepresentation("entity's server", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getServer();
            }
        });

        addExpressionRepresentation("entity's op", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setOp(value);
                }
            }
        });

        addExpressionRepresentation("entity's entity id", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getEntityId();
            }
        });

        addExpressionRepresentation("entity's unique id", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getUniqueId();
            }
        });

        addExpressionRepresentation("entity's max fire ticks", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getMaxFireTicks();
            }
        });

        addExpressionRepresentation("entity's custom name", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setCustomName(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getCustomName();
            }
        });

        addExpressionRepresentation("entity's effective permissions", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getEffectivePermissions();
            }
        });

        addExpressionRepresentation("entity's last damage cause", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    EntityDamageEvent value = ray.getExpressionValue(1);
                    object.setLastDamageCause(value);
                }
            }
        });

        addExpressionRepresentation("entity's velocity", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    Vector value = ray.getExpressionValue(1);
                    object.setVelocity(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getVelocity();
            }
        });

        addExpressionRepresentation("entity's type", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("entity's ticks lived", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksLived(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getTicksLived();
            }
        });

        addExpressionRepresentation("entity's vehicle", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getVehicle();
            }
        });

        addExpressionRepresentation("entity's custom name visible", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCustomNameVisible(value);
                }
            }
        });

        addExpressionRepresentation("entity's invulnerable", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setInvulnerable(value);
                }
            }
        });

        addExpressionRepresentation("entity's fire ticks", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setFireTicks(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getFireTicks();
            }
        });

        addExpressionRepresentation("entity's world", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getWorld();
            }
        });

        addExpressionRepresentation("entity's glowing", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setGlowing(value);
                }
            }
        });

        addExpressionRepresentation("entity's passenger", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setPassenger(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getPassenger();
            }
        });

        addExpressionRepresentation("entity's name", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("entity's location", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Entity object) throws IOException {

    }

    @Override
    public Entity deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Entity object) {
        return object.toString();
    }

}
