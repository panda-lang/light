package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class EntityStructure extends org.panda_lang.light.core.element.Structure<Entity> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Entity.class);

        addExpressionRepresentation("entity's fall distance", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setFallDistance(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getFallDistance();
            }
        });

        addExpressionRepresentation("entity's server", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getServer();
            }
        });

        addExpressionRepresentation("entity's op", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setOp(value);
                }
            }
        });

        addExpressionRepresentation("entity's entity id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getEntityId();
            }
        });

        addExpressionRepresentation("entity's unique id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getUniqueId();
            }
        });

        addExpressionRepresentation("entity's max fire ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getMaxFireTicks();
            }
        });

        addExpressionRepresentation("entity's custom name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    String value = ray.getExpressionValue(1);
                    object.setCustomName(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getCustomName();
            }
        });

        addExpressionRepresentation("entity's effective permissions", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getEffectivePermissions();
            }
        });

        addExpressionRepresentation("entity's last damage cause", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    EntityDamageEvent value = ray.getExpressionValue(1);
                    object.setLastDamageCause(value);
                }
            }
        });

        addExpressionRepresentation("entity's velocity", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    Vector value = ray.getExpressionValue(1);
                    object.setVelocity(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getVelocity();
            }
        });

        addExpressionRepresentation("entity's type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("entity's ticks lived", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTicksLived(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getTicksLived();
            }
        });

        addExpressionRepresentation("entity's vehicle", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getVehicle();
            }
        });

        addExpressionRepresentation("entity's custom name visible", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setCustomNameVisible(value);
                }
            }
        });

        addExpressionRepresentation("entity's invulnerable", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setInvulnerable(value);
                }
            }
        });

        addExpressionRepresentation("entity's fire ticks", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setFireTicks(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getFireTicks();
            }
        });

        addExpressionRepresentation("entity's world", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getWorld();
            }
        });

        addExpressionRepresentation("entity's glowing", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    boolean value = ray.getExpressionValue(1);
                    object.setGlowing(value);
                }
            }
        });

        addExpressionRepresentation("entity's passenger", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Entity object = ray.getExpressionValue(0);
                    Entity value = ray.getExpressionValue(1);
                    object.setPassenger(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getPassenger();
            }
        });

        addExpressionRepresentation("entity's name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("entity's location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Entity object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Entity object) throws IOException {

    }

    @Override
    public Entity deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Entity object) {
        return object.toString();
    }

}
