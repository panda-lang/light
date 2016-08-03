package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.Material;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class MaterialStructure extends org.panda_lang.light.core.element.Structure<Material> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Material.class);

        addExpressionRepresentation("material data", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getData();
            }
        });

        addExpressionRepresentation("material declaring class", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getDeclaringClass();
            }
        });

        addExpressionRepresentation("material id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getId();
            }
        });

        addExpressionRepresentation("material max durability", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getMaxDurability();
            }
        });

        addExpressionRepresentation("material max stack size", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getMaxStackSize();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Material object) throws IOException {

    }

    @Override
    public Material deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Material object) {
        return object.toString();
    }

}
