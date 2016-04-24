package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Material;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;

import java.io.IOException;

public class MaterialStructure extends Structure<Material> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Material.class);

        addExpressionRepresentation("material data", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getData();
            }
        });

        addExpressionRepresentation("material declaring class", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getDeclaringClass();
            }
        });

        addExpressionRepresentation("material id", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getId();
            }
        });

        addExpressionRepresentation("material max durability", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getMaxDurability();
            }
        });

        addExpressionRepresentation("material max stack size", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Material object = ray.getExpressionValue(0);
                return object.getMaxStackSize();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Material object) throws IOException {

    }

    @Override
    public Material deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Material object) {
        return object.toString();
    }

}
