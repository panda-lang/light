package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class EnchantmentEvents implements BukkitElements {

    private final Light light;

    public EnchantmentEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit enchantItemScopeUnit = light.registerEvent(EnchantItemEvent.class, "enchant item");
        enchantItemScopeUnit.registerArgument("enchanter", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getEnchanter();
            }
        });
        enchantItemScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getItem();
            }
        });
        enchantItemScopeUnit.registerArgument("enchant block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getEnchantBlock();
            }
        });
        enchantItemScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getViewers();
            }
        });
        enchantItemScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getEventName();
            }
        });
        enchantItemScopeUnit.registerArgument("enchants to add", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getEnchantsToAdd();
            }
        });
        enchantItemScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getView();
            }
        });
        enchantItemScopeUnit.registerArgument("exp level cost", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getExpLevelCost();
            }
        });
        enchantItemScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, EnchantItemEvent event) {
                return event.getInventory();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit prepareItemEnchantScopeUnit = light.registerEvent(PrepareItemEnchantEvent.class, "prepare item enchant");
        prepareItemEnchantScopeUnit.registerArgument("exp level costs offered", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getExpLevelCostsOffered();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getItem();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("enchantment bonus", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getEnchantmentBonus();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("enchanter", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getEnchanter();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("enchant block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getEnchantBlock();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getViewers();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getEventName();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getView();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemEnchantEvent event) {
                return event.getInventory();
            }
        });


    }

}
