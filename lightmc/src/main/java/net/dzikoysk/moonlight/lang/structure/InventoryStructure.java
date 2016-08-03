package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class InventoryStructure extends Structure<Inventory> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(Inventory.class);

        addExpressionRepresentation("inventory viewers", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getViewers();
            }
        });

        addExpressionRepresentation("inventory size", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getSize();
            }
        });

        addExpressionRepresentation("inventory contents", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Inventory object = ray.getExpressionValue(0);
                    ItemStack[] value = ray.getExpressionValue(1);
                    object.setContents(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getContents();
            }
        });

        addExpressionRepresentation("inventory name", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getName();
            }
        });

        addExpressionRepresentation("inventory location", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getLocation();
            }
        });

        addExpressionRepresentation("inventory holder", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getHolder();
            }
        });

        addExpressionRepresentation("inventory title", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getTitle();
            }
        });

        addExpressionRepresentation("inventory type", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("inventory max stack size", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Inventory object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setMaxStackSize(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getMaxStackSize();
            }
        });

        addExpressionRepresentation("inventory storage contents", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    Inventory object = ray.getExpressionValue(0);
                    ItemStack[] value = ray.getExpressionValue(1);
                    object.setStorageContents(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                Inventory object = ray.getExpressionValue(0);
                return object.getStorageContents();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, Inventory object) throws IOException {

    }

    @Override
    public Inventory deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(Inventory object) {
        return object.toString();
    }

}
