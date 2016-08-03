package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.util.Vector;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class VectorStructure extends org.panda_lang.light.core.element.Structure<VectorStructure> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(VectorStructure.class);

        addExpressionRepresentation("vector epsilon", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Vector.getEpsilon();
            }
        });

        addExpressionRepresentation("vector random", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                return Vector.getRandom();
            }
        });

        addExpressionRepresentation("vector x", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Vector object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setX(value);
                }
            }
        });

        addExpressionRepresentation("vector y", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Vector object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setY(value);
                }
            }
        });

        addExpressionRepresentation("vector z", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Vector object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setZ(value);
                }
            }
        });

        addExpressionRepresentation("vector block x", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Vector object = ray.getExpressionValue(0);
                return object.getBlockX();
            }
        });

        addExpressionRepresentation("vector block y", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Vector object = ray.getExpressionValue(0);
                return object.getBlockY();
            }
        });

        addExpressionRepresentation("vector block z", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Vector object = ray.getExpressionValue(0);
                return object.getBlockZ();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, VectorStructure object) throws IOException {

    }

    @Override
    public VectorStructure deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(VectorStructure object) {
        return object.toString();
    }

}
