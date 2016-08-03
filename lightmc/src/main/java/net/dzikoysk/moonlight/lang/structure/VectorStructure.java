package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.util.Vector;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class VectorStructure extends Structure<VectorStructure> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(VectorStructure.class);

        addExpressionRepresentation("vector epsilon", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Vector.getEpsilon();
            }
        });

        addExpressionRepresentation("vector random", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                return Vector.getRandom();
            }
        });

        addExpressionRepresentation("vector x", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Vector object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setX(value);
                }
            }
        });

        addExpressionRepresentation("vector y", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Vector object = ray.getExpressionValue(0);
                    float value = ray.getExpressionValue(1);
                    object.setY(value);
                }
            }
        });

        addExpressionRepresentation("vector z", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Vector object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setZ(value);
                }
            }
        });

        addExpressionRepresentation("vector block x", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Vector object = ray.getExpressionValue(0);
                return object.getBlockX();
            }
        });

        addExpressionRepresentation("vector block y", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Vector object = ray.getExpressionValue(0);
                return object.getBlockY();
            }
        });

        addExpressionRepresentation("vector block z", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Vector object = ray.getExpressionValue(0);
                return object.getBlockZ();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, VectorStructure object) throws IOException {

    }

    @Override
    public VectorStructure deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(VectorStructure object) {
        return object.toString();
    }

}
