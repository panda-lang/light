package net.dzikoysk.lightmc.lang.structure;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.panda_lang.light.LightCore;

import java.io.IOException;

public class ItemStackStructure extends org.panda_lang.light.core.element.Structure<ItemStack> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(ItemStack.class);

        addExpressionRepresentation("itemstack amount", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setAmount(value);
                }
            }
        });

        addExpressionRepresentation("itemstack type id", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    int value = ray.getExpressionValue(1);
                    object.setTypeId(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getTypeId();
            }
        });

        addExpressionRepresentation("itemstack data", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    MaterialData value = ray.getExpressionValue(1);
                    object.setData(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getData();
            }
        });

        addExpressionRepresentation("itemstack item meta", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    ItemMeta value = ray.getExpressionValue(1);
                    object.setItemMeta(value);
                }
            }
        });

        addExpressionRepresentation("itemstack durability", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    short value = ray.getExpressionValue(1);
                    object.setDurability(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getDurability();
            }
        });

        addExpressionRepresentation("itemstack type", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public void modify(org.panda_lang.light.core.util.Modification modification) {
                org.panda_lang.light.core.Ray ray = modification.getRay();
                if (modification.getType() == org.panda_lang.light.core.util.ModificationType.SET) {
                    ItemStack object = ray.getExpressionValue(0);
                    Material value = ray.getExpressionValue(1);
                    object.setType(value);
                }
            }

            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getType();
            }
        });

        addExpressionRepresentation("itemstack enchantments", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getEnchantments();
            }
        });

        addExpressionRepresentation("itemstack max stack size", new org.panda_lang.light.core.element.expression.Expression() {
            @Override
            public Object getValue(org.panda_lang.light.core.Ray ray) {
                ItemStack object = ray.getExpressionValue(0);
                return object.getMaxStackSize();
            }
        });

    }

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, ItemStack object) throws IOException {

    }

    @Override
    public ItemStack deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return null;
    }

    @Override
    public String toString(ItemStack object) {
        return object.toString();
    }

}
