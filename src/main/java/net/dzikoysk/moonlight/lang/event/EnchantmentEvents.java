package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class EnchantmentEvents implements BukkitElements {

    private final Moonlight moonlight;

    public EnchantmentEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit enchantItemScopeUnit = moonlight.registerEvent(EnchantItemEvent.class, "enchant item");
        enchantItemScopeUnit.registerArgument("enchanter", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getEnchanter();
            }
        });
        enchantItemScopeUnit.registerArgument("item", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getItem();
            }
        });
        enchantItemScopeUnit.registerArgument("enchant block", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getEnchantBlock();
            }
        });
        enchantItemScopeUnit.registerArgument("viewers", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getViewers();
            }
        });
        enchantItemScopeUnit.registerArgument("event name", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getEventName();
            }
        });
        enchantItemScopeUnit.registerArgument("enchants to add", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getEnchantsToAdd();
            }
        });
        enchantItemScopeUnit.registerArgument("view", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getView();
            }
        });
        enchantItemScopeUnit.registerArgument("exp level cost", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getExpLevelCost();
            }
        });
        enchantItemScopeUnit.registerArgument("inventory", new ArgumentInitializer<EnchantItemEvent>() {
            @Override
            public Object get(Ray ray, EnchantItemEvent event) {
                return event.getInventory();
            }
        });

        ScopeUnit prepareItemEnchantScopeUnit = moonlight.registerEvent(PrepareItemEnchantEvent.class, "prepare item enchant");
        prepareItemEnchantScopeUnit.registerArgument("exp level costs offered", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getExpLevelCostsOffered();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("item", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getItem();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("enchantment bonus", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getEnchantmentBonus();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("enchanter", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getEnchanter();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("enchant block", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getEnchantBlock();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("viewers", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getViewers();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("event name", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getEventName();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("view", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getView();
            }
        });
        prepareItemEnchantScopeUnit.registerArgument("inventory", new ArgumentInitializer<PrepareItemEnchantEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemEnchantEvent event) {
                return event.getInventory();
            }
        });


    }

}
