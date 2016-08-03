package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.inventory.*;

public class InventoryEvents implements BukkitElements {

    private final Light light;

    public InventoryEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit brewScopeUnit = light.registerEvent(BrewEvent.class, "brew");
        brewScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BrewEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BrewEvent event) {
                return event.getBlock();
            }
        });
        brewScopeUnit.registerArgument("contents", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BrewEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BrewEvent event) {
                return event.getContents();
            }
        });
        brewScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BrewEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BrewEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryDragScopeUnit = light.registerEvent(InventoryDragEvent.class, "inventory drag");
        inventoryDragScopeUnit.registerArgument("new items", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getNewItems();
            }
        });
        inventoryDragScopeUnit.registerArgument("cursor", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getCursor();
            }
        });
        inventoryDragScopeUnit.registerArgument("old cursor", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getOldCursor();
            }
        });
        inventoryDragScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getViewers();
            }
        });
        inventoryDragScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getEventName();
            }
        });
        inventoryDragScopeUnit.registerArgument("who clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryDragScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getResult();
            }
        });
        inventoryDragScopeUnit.registerArgument("inventory slots", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getInventorySlots();
            }
        });
        inventoryDragScopeUnit.registerArgument("raw slots", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getRawSlots();
            }
        });
        inventoryDragScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getView();
            }
        });
        inventoryDragScopeUnit.registerArgument("type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getType();
            }
        });
        inventoryDragScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryDragEvent event) {
                return event.getInventory();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit prepareItemCraftScopeUnit = light.registerEvent(PrepareItemCraftEvent.class, "prepare item craft");
        prepareItemCraftScopeUnit.registerArgument("recipe", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemCraftEvent event) {
                return event.getRecipe();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemCraftEvent event) {
                return event.getInventory();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemCraftEvent event) {
                return event.getViewers();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemCraftEvent event) {
                return event.getEventName();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareItemCraftEvent event) {
                return event.getView();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryClickScopeUnit = light.registerEvent(InventoryClickEvent.class, "inventory click");
        inventoryClickScopeUnit.registerArgument("action", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getAction();
            }
        });
        inventoryClickScopeUnit.registerArgument("cursor", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getCursor();
            }
        });
        inventoryClickScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getViewers();
            }
        });
        inventoryClickScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getEventName();
            }
        });
        inventoryClickScopeUnit.registerArgument("who clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryClickScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getResult();
            }
        });
        inventoryClickScopeUnit.registerArgument("slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getSlot();
            }
        });
        inventoryClickScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getView();
            }
        });
        inventoryClickScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getInventory();
            }
        });
        inventoryClickScopeUnit.registerArgument("clicked inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getClickedInventory();
            }
        });
        inventoryClickScopeUnit.registerArgument("hotbar button", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getHotbarButton();
            }
        });
        inventoryClickScopeUnit.registerArgument("slot type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getSlotType();
            }
        });
        inventoryClickScopeUnit.registerArgument("raw slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getRawSlot();
            }
        });
        inventoryClickScopeUnit.registerArgument("click", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getClick();
            }
        });
        inventoryClickScopeUnit.registerArgument("current item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryClickEvent event) {
                return event.getCurrentItem();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit furnaceSmeltScopeUnit = light.registerEvent(FurnaceSmeltEvent.class, "furnace smelt");
        furnaceSmeltScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceSmeltEvent event) {
                return event.getEventName();
            }
        });
        furnaceSmeltScopeUnit.registerArgument("source", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceSmeltEvent event) {
                return event.getSource();
            }
        });
        furnaceSmeltScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceSmeltEvent event) {
                return event.getBlock();
            }
        });
        furnaceSmeltScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceSmeltEvent event) {
                return event.getResult();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryCloseScopeUnit = light.registerEvent(InventoryCloseEvent.class, "inventory close");
        inventoryCloseScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCloseEvent event) {
                return event.getPlayer();
            }
        });
        inventoryCloseScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCloseEvent event) {
                return event.getView();
            }
        });
        inventoryCloseScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCloseEvent event) {
                return event.getInventory();
            }
        });
        inventoryCloseScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCloseEvent event) {
                return event.getViewers();
            }
        });
        inventoryCloseScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCloseEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryInteractScopeUnit = light.registerEvent(InventoryInteractEvent.class, "inventory interact");
        inventoryInteractScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryInteractEvent event) {
                return event.getViewers();
            }
        });
        inventoryInteractScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryInteractEvent event) {
                return event.getEventName();
            }
        });
        inventoryInteractScopeUnit.registerArgument("who clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryInteractEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryInteractScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryInteractEvent event) {
                return event.getResult();
            }
        });
        inventoryInteractScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryInteractEvent event) {
                return event.getView();
            }
        });
        inventoryInteractScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryInteractEvent event) {
                return event.getInventory();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit prepareAnvilScopeUnit = light.registerEvent(PrepareAnvilEvent.class, "prepare anvil");
        prepareAnvilScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareAnvilEvent event) {
                return event.getResult();
            }
        });
        prepareAnvilScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareAnvilEvent event) {
                return event.getInventory();
            }
        });
        prepareAnvilScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareAnvilEvent event) {
                return event.getViewers();
            }
        });
        prepareAnvilScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareAnvilEvent event) {
                return event.getEventName();
            }
        });
        prepareAnvilScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PrepareAnvilEvent event) {
                return event.getView();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit furnaceBurnScopeUnit = light.registerEvent(FurnaceBurnEvent.class, "furnace burn");
        furnaceBurnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceBurnEvent event) {
                return event.getEventName();
            }
        });
        furnaceBurnScopeUnit.registerArgument("burn time", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceBurnEvent event) {
                return event.getBurnTime();
            }
        });
        furnaceBurnScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceBurnEvent event) {
                return event.getBlock();
            }
        });
        furnaceBurnScopeUnit.registerArgument("fuel", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceBurnEvent event) {
                return event.getFuel();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit craftItemScopeUnit = light.registerEvent(CraftItemEvent.class, "craft item");
        craftItemScopeUnit.registerArgument("action", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getAction();
            }
        });
        craftItemScopeUnit.registerArgument("recipe", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getRecipe();
            }
        });
        craftItemScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getInventory();
            }
        });
        craftItemScopeUnit.registerArgument("cursor", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getCursor();
            }
        });
        craftItemScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getViewers();
            }
        });
        craftItemScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getEventName();
            }
        });
        craftItemScopeUnit.registerArgument("who clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getWhoClicked();
            }
        });
        craftItemScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getResult();
            }
        });
        craftItemScopeUnit.registerArgument("slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getSlot();
            }
        });
        craftItemScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getView();
            }
        });
        craftItemScopeUnit.registerArgument("clicked inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getClickedInventory();
            }
        });
        craftItemScopeUnit.registerArgument("hotbar button", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getHotbarButton();
            }
        });
        craftItemScopeUnit.registerArgument("slot type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getSlotType();
            }
        });
        craftItemScopeUnit.registerArgument("raw slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getRawSlot();
            }
        });
        craftItemScopeUnit.registerArgument("click", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getClick();
            }
        });
        craftItemScopeUnit.registerArgument("current item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, CraftItemEvent event) {
                return event.getCurrentItem();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit furnaceExtractScopeUnit = light.registerEvent(FurnaceExtractEvent.class, "furnace extract");
        furnaceExtractScopeUnit.registerArgument("exp to drop", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceExtractEvent event) {
                return event.getExpToDrop();
            }
        });
        furnaceExtractScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceExtractEvent event) {
                return event.getPlayer();
            }
        });
        furnaceExtractScopeUnit.registerArgument("item amount", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceExtractEvent event) {
                return event.getItemAmount();
            }
        });
        furnaceExtractScopeUnit.registerArgument("block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceExtractEvent event) {
                return event.getBlock();
            }
        });
        furnaceExtractScopeUnit.registerArgument("item type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceExtractEvent event) {
                return event.getItemType();
            }
        });
        furnaceExtractScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, FurnaceExtractEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryScopeUnit = light.registerEvent(InventoryEvent.class, "inventory");
        inventoryScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryEvent event) {
                return event.getView();
            }
        });
        inventoryScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryEvent event) {
                return event.getInventory();
            }
        });
        inventoryScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryEvent event) {
                return event.getViewers();
            }
        });
        inventoryScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryPickupItemScopeUnit = light.registerEvent(InventoryPickupItemEvent.class, "inventory pickup item");
        inventoryPickupItemScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryPickupItemEvent event) {
                return event.getItem();
            }
        });
        inventoryPickupItemScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryPickupItemEvent event) {
                return event.getEventName();
            }
        });
        inventoryPickupItemScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryPickupItemEvent event) {
                return event.getInventory();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryCreativeScopeUnit = light.registerEvent(InventoryCreativeEvent.class, "inventory creative");
        inventoryCreativeScopeUnit.registerArgument("action", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getAction();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("cursor", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getCursor();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getViewers();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getEventName();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("who clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getResult();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getSlot();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getView();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getInventory();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("clicked inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getClickedInventory();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("hotbar button", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getHotbarButton();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("slot type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getSlotType();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("raw slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getRawSlot();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("click", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getClick();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("current item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryCreativeEvent event) {
                return event.getCurrentItem();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryMoveItemScopeUnit = light.registerEvent(InventoryMoveItemEvent.class, "inventory move item");
        inventoryMoveItemScopeUnit.registerArgument("source", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryMoveItemEvent event) {
                return event.getSource();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryMoveItemEvent event) {
                return event.getEventName();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("destination", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryMoveItemEvent event) {
                return event.getDestination();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryMoveItemEvent event) {
                return event.getItem();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("initiator", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryMoveItemEvent event) {
                return event.getInitiator();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit inventoryOpenScopeUnit = light.registerEvent(InventoryOpenEvent.class, "inventory open");
        inventoryOpenScopeUnit.registerArgument("viewers", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryOpenEvent event) {
                return event.getViewers();
            }
        });
        inventoryOpenScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryOpenEvent event) {
                return event.getEventName();
            }
        });
        inventoryOpenScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryOpenEvent event) {
                return event.getPlayer();
            }
        });
        inventoryOpenScopeUnit.registerArgument("view", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryOpenEvent event) {
                return event.getView();
            }
        });
        inventoryOpenScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, InventoryOpenEvent event) {
                return event.getInventory();
            }
        });


    }

}
