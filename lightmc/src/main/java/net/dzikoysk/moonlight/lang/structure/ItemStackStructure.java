package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.moonlight.core.util.ModificationType;

import java.io.IOException;

public class ItemStackStructure extends Structure<ItemStack> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
        hookClass(ItemStack.class);

        addExpressionRepresentation("itemstack amount", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setAmount(value);
                }
            }
        });

        addExpressionRepresentation("itemstack type id", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTypeId(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getTypeId();
            }
        });

        addExpressionRepresentation("itemstack data", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    MaterialData value = ray.getExpressionValue(1);
                    object.setData(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getData();
            }
        });

        addExpressionRepresentation("itemstack item meta", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    ItemMeta value = ray.getExpressionValue(1);
                    object.setItemMeta(value);
                }
            }
        });

        addExpressionRepresentation("itemstack durability", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    short value = ray.getExpressionValue(1);
                    object.setDurability(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getDurability();
            }
        });

        addExpressionRepresentation("itemstack type", new Expression() {
            @Override
            public void modify(Modification modification) {
                Ray ray = modification.getRay();
                if (modification.getType() == ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    Material value = ray.getExpressionValue(1);
                    object.setType(value);
                }
            }

            @Override
            public Object getValue(Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("itemstack enchantments", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getEnchantments();
            }
        });

        addExpressionRepresentation("itemstack max stack size", new Expression() {
            @Override
            public Object getValue(Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getMaxStackSize();
            }
        });

    }

    @Override
    public void serialize(DataSerializer dataSerializer, ItemStack object) throws IOException {

    }

    @Override
    public ItemStack deserialize(DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(ItemStack object) {
        return object.toString();
    }

}
