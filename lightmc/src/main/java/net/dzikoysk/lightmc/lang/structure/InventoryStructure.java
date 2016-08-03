package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class InventoryStructure extends org.panda_lang.light.core.element.Structure<Inventory> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Inventory.class);

        addExpressionRepresentation("inventory viewers", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getViewers();
            }
        });

        addExpressionRepresentation("inventory size", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getSize();
            }
        });

        addExpressionRepresentation("inventory contents", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Inventory object = ray.getExpressionValue(0);
                    ItemStack[] value = ray.getExpressionValue(1);
                    object.setContents(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getContents();
            }
        });

        addExpressionRepresentation("inventory name", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("inventory location", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

        addExpressionRepresentation("inventory holder", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getHolder();
            }
        });

        addExpressionRepresentation("inventory title", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getTitle();
            }
        });

        addExpressionRepresentation("inventory type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("inventory max stack size", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Inventory object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMaxStackSize(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getMaxStackSize();
            }
        });

        addExpressionRepresentation("inventory storage contents", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    Inventory object = ray.getExpressionValue(0);
                    ItemStack[] value = ray.getExpressionValue(1);
                    object.setStorageContents(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getStorageContents();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, Inventory object) throws IOException {

    }

    @Override
    public Inventory deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Inventory object) {
        return object.toString();
    }

}
