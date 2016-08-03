package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.inventory.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class InventoryEvents implements BukkitElements {

    private final Moonlight moonlight;

    public InventoryEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit brewScopeUnit = moonlight.registerEvent(BrewEvent.class, "brew");
        brewScopeUnit.registerArgument("block", new ArgumentInitializer<BrewEvent>() {
            @Override
            public Object get(Ray ray, BrewEvent event) {
                return event.getBlock();
            }
        });
        brewScopeUnit.registerArgument("contents", new ArgumentInitializer<BrewEvent>() {
            @Override
            public Object get(Ray ray, BrewEvent event) {
                return event.getContents();
            }
        });
        brewScopeUnit.registerArgument("event name", new ArgumentInitializer<BrewEvent>() {
            @Override
            public Object get(Ray ray, BrewEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit inventoryDragScopeUnit = moonlight.registerEvent(InventoryDragEvent.class, "inventory drag");
        inventoryDragScopeUnit.registerArgument("new items", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getNewItems();
            }
        });
        inventoryDragScopeUnit.registerArgument("cursor", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getCursor();
            }
        });
        inventoryDragScopeUnit.registerArgument("old cursor", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getOldCursor();
            }
        });
        inventoryDragScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getViewers();
            }
        });
        inventoryDragScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getEventName();
            }
        });
        inventoryDragScopeUnit.registerArgument("who clicked", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryDragScopeUnit.registerArgument("result", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getResult();
            }
        });
        inventoryDragScopeUnit.registerArgument("inventory slots", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getInventorySlots();
            }
        });
        inventoryDragScopeUnit.registerArgument("raw slots", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getRawSlots();
            }
        });
        inventoryDragScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getView();
            }
        });
        inventoryDragScopeUnit.registerArgument("type", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getType();
            }
        });
        inventoryDragScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryDragEvent>() {
            @Override
            public Object get(Ray ray, InventoryDragEvent event) {
                return event.getInventory();
            }
        });

        ScopeUnit prepareItemCraftScopeUnit = moonlight.registerEvent(PrepareItemCraftEvent.class, "prepare item craft");
        prepareItemCraftScopeUnit.registerArgument("recipe", new ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemCraftEvent event) {
                return event.getRecipe();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("inventory", new ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemCraftEvent event) {
                return event.getInventory();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("viewers", new ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemCraftEvent event) {
                return event.getViewers();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("event name", new ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemCraftEvent event) {
                return event.getEventName();
            }
        });
        prepareItemCraftScopeUnit.registerArgument("view", new ArgumentInitializer<PrepareItemCraftEvent>() {
            @Override
            public Object get(Ray ray, PrepareItemCraftEvent event) {
                return event.getView();
            }
        });

        ScopeUnit inventoryClickScopeUnit = moonlight.registerEvent(InventoryClickEvent.class, "inventory click");
        inventoryClickScopeUnit.registerArgument("action", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getAction();
            }
        });
        inventoryClickScopeUnit.registerArgument("cursor", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getCursor();
            }
        });
        inventoryClickScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getViewers();
            }
        });
        inventoryClickScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getEventName();
            }
        });
        inventoryClickScopeUnit.registerArgument("who clicked", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryClickScopeUnit.registerArgument("result", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getResult();
            }
        });
        inventoryClickScopeUnit.registerArgument("slot", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getSlot();
            }
        });
        inventoryClickScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getView();
            }
        });
        inventoryClickScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getInventory();
            }
        });
        inventoryClickScopeUnit.registerArgument("clicked inventory", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getClickedInventory();
            }
        });
        inventoryClickScopeUnit.registerArgument("hotbar button", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getHotbarButton();
            }
        });
        inventoryClickScopeUnit.registerArgument("slot type", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getSlotType();
            }
        });
        inventoryClickScopeUnit.registerArgument("raw slot", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getRawSlot();
            }
        });
        inventoryClickScopeUnit.registerArgument("click", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getClick();
            }
        });
        inventoryClickScopeUnit.registerArgument("current item", new ArgumentInitializer<InventoryClickEvent>() {
            @Override
            public Object get(Ray ray, InventoryClickEvent event) {
                return event.getCurrentItem();
            }
        });

        ScopeUnit furnaceSmeltScopeUnit = moonlight.registerEvent(FurnaceSmeltEvent.class, "furnace smelt");
        furnaceSmeltScopeUnit.registerArgument("event name", new ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(Ray ray, FurnaceSmeltEvent event) {
                return event.getEventName();
            }
        });
        furnaceSmeltScopeUnit.registerArgument("source", new ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(Ray ray, FurnaceSmeltEvent event) {
                return event.getSource();
            }
        });
        furnaceSmeltScopeUnit.registerArgument("block", new ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(Ray ray, FurnaceSmeltEvent event) {
                return event.getBlock();
            }
        });
        furnaceSmeltScopeUnit.registerArgument("result", new ArgumentInitializer<FurnaceSmeltEvent>() {
            @Override
            public Object get(Ray ray, FurnaceSmeltEvent event) {
                return event.getResult();
            }
        });

        ScopeUnit inventoryCloseScopeUnit = moonlight.registerEvent(InventoryCloseEvent.class, "inventory close");
        inventoryCloseScopeUnit.registerArgument("player", new ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(Ray ray, InventoryCloseEvent event) {
                return event.getPlayer();
            }
        });
        inventoryCloseScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(Ray ray, InventoryCloseEvent event) {
                return event.getView();
            }
        });
        inventoryCloseScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(Ray ray, InventoryCloseEvent event) {
                return event.getInventory();
            }
        });
        inventoryCloseScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(Ray ray, InventoryCloseEvent event) {
                return event.getViewers();
            }
        });
        inventoryCloseScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryCloseEvent>() {
            @Override
            public Object get(Ray ray, InventoryCloseEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit inventoryInteractScopeUnit = moonlight.registerEvent(InventoryInteractEvent.class, "inventory interact");
        inventoryInteractScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(Ray ray, InventoryInteractEvent event) {
                return event.getViewers();
            }
        });
        inventoryInteractScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(Ray ray, InventoryInteractEvent event) {
                return event.getEventName();
            }
        });
        inventoryInteractScopeUnit.registerArgument("who clicked", new ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(Ray ray, InventoryInteractEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryInteractScopeUnit.registerArgument("result", new ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(Ray ray, InventoryInteractEvent event) {
                return event.getResult();
            }
        });
        inventoryInteractScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(Ray ray, InventoryInteractEvent event) {
                return event.getView();
            }
        });
        inventoryInteractScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryInteractEvent>() {
            @Override
            public Object get(Ray ray, InventoryInteractEvent event) {
                return event.getInventory();
            }
        });

        ScopeUnit prepareAnvilScopeUnit = moonlight.registerEvent(PrepareAnvilEvent.class, "prepare anvil");
        prepareAnvilScopeUnit.registerArgument("result", new ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(Ray ray, PrepareAnvilEvent event) {
                return event.getResult();
            }
        });
        prepareAnvilScopeUnit.registerArgument("inventory", new ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(Ray ray, PrepareAnvilEvent event) {
                return event.getInventory();
            }
        });
        prepareAnvilScopeUnit.registerArgument("viewers", new ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(Ray ray, PrepareAnvilEvent event) {
                return event.getViewers();
            }
        });
        prepareAnvilScopeUnit.registerArgument("event name", new ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(Ray ray, PrepareAnvilEvent event) {
                return event.getEventName();
            }
        });
        prepareAnvilScopeUnit.registerArgument("view", new ArgumentInitializer<PrepareAnvilEvent>() {
            @Override
            public Object get(Ray ray, PrepareAnvilEvent event) {
                return event.getView();
            }
        });

        ScopeUnit furnaceBurnScopeUnit = moonlight.registerEvent(FurnaceBurnEvent.class, "furnace burn");
        furnaceBurnScopeUnit.registerArgument("event name", new ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(Ray ray, FurnaceBurnEvent event) {
                return event.getEventName();
            }
        });
        furnaceBurnScopeUnit.registerArgument("burn time", new ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(Ray ray, FurnaceBurnEvent event) {
                return event.getBurnTime();
            }
        });
        furnaceBurnScopeUnit.registerArgument("block", new ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(Ray ray, FurnaceBurnEvent event) {
                return event.getBlock();
            }
        });
        furnaceBurnScopeUnit.registerArgument("fuel", new ArgumentInitializer<FurnaceBurnEvent>() {
            @Override
            public Object get(Ray ray, FurnaceBurnEvent event) {
                return event.getFuel();
            }
        });

        ScopeUnit craftItemScopeUnit = moonlight.registerEvent(CraftItemEvent.class, "craft item");
        craftItemScopeUnit.registerArgument("action", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getAction();
            }
        });
        craftItemScopeUnit.registerArgument("recipe", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getRecipe();
            }
        });
        craftItemScopeUnit.registerArgument("inventory", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getInventory();
            }
        });
        craftItemScopeUnit.registerArgument("cursor", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getCursor();
            }
        });
        craftItemScopeUnit.registerArgument("viewers", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getViewers();
            }
        });
        craftItemScopeUnit.registerArgument("event name", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getEventName();
            }
        });
        craftItemScopeUnit.registerArgument("who clicked", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getWhoClicked();
            }
        });
        craftItemScopeUnit.registerArgument("result", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getResult();
            }
        });
        craftItemScopeUnit.registerArgument("slot", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getSlot();
            }
        });
        craftItemScopeUnit.registerArgument("view", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getView();
            }
        });
        craftItemScopeUnit.registerArgument("clicked inventory", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getClickedInventory();
            }
        });
        craftItemScopeUnit.registerArgument("hotbar button", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getHotbarButton();
            }
        });
        craftItemScopeUnit.registerArgument("slot type", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getSlotType();
            }
        });
        craftItemScopeUnit.registerArgument("raw slot", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getRawSlot();
            }
        });
        craftItemScopeUnit.registerArgument("click", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getClick();
            }
        });
        craftItemScopeUnit.registerArgument("current item", new ArgumentInitializer<CraftItemEvent>() {
            @Override
            public Object get(Ray ray, CraftItemEvent event) {
                return event.getCurrentItem();
            }
        });

        ScopeUnit furnaceExtractScopeUnit = moonlight.registerEvent(FurnaceExtractEvent.class, "furnace extract");
        furnaceExtractScopeUnit.registerArgument("exp to drop", new ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(Ray ray, FurnaceExtractEvent event) {
                return event.getExpToDrop();
            }
        });
        furnaceExtractScopeUnit.registerArgument("player", new ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(Ray ray, FurnaceExtractEvent event) {
                return event.getPlayer();
            }
        });
        furnaceExtractScopeUnit.registerArgument("item amount", new ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(Ray ray, FurnaceExtractEvent event) {
                return event.getItemAmount();
            }
        });
        furnaceExtractScopeUnit.registerArgument("block", new ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(Ray ray, FurnaceExtractEvent event) {
                return event.getBlock();
            }
        });
        furnaceExtractScopeUnit.registerArgument("item type", new ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(Ray ray, FurnaceExtractEvent event) {
                return event.getItemType();
            }
        });
        furnaceExtractScopeUnit.registerArgument("event name", new ArgumentInitializer<FurnaceExtractEvent>() {
            @Override
            public Object get(Ray ray, FurnaceExtractEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit inventoryScopeUnit = moonlight.registerEvent(InventoryEvent.class, "inventory");
        inventoryScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(Ray ray, InventoryEvent event) {
                return event.getView();
            }
        });
        inventoryScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(Ray ray, InventoryEvent event) {
                return event.getInventory();
            }
        });
        inventoryScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(Ray ray, InventoryEvent event) {
                return event.getViewers();
            }
        });
        inventoryScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryEvent>() {
            @Override
            public Object get(Ray ray, InventoryEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit inventoryPickupItemScopeUnit = moonlight.registerEvent(InventoryPickupItemEvent.class, "inventory pickup item");
        inventoryPickupItemScopeUnit.registerArgument("item", new ArgumentInitializer<InventoryPickupItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryPickupItemEvent event) {
                return event.getItem();
            }
        });
        inventoryPickupItemScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryPickupItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryPickupItemEvent event) {
                return event.getEventName();
            }
        });
        inventoryPickupItemScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryPickupItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryPickupItemEvent event) {
                return event.getInventory();
            }
        });

        ScopeUnit inventoryCreativeScopeUnit = moonlight.registerEvent(InventoryCreativeEvent.class, "inventory creative");
        inventoryCreativeScopeUnit.registerArgument("action", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getAction();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("cursor", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getCursor();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getViewers();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getEventName();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("who clicked", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getWhoClicked();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("result", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getResult();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("slot", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getSlot();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getView();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getInventory();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("clicked inventory", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getClickedInventory();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("hotbar button", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getHotbarButton();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("slot type", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getSlotType();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("raw slot", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getRawSlot();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("click", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getClick();
            }
        });
        inventoryCreativeScopeUnit.registerArgument("current item", new ArgumentInitializer<InventoryCreativeEvent>() {
            @Override
            public Object get(Ray ray, InventoryCreativeEvent event) {
                return event.getCurrentItem();
            }
        });

        ScopeUnit inventoryMoveItemScopeUnit = moonlight.registerEvent(InventoryMoveItemEvent.class, "inventory move item");
        inventoryMoveItemScopeUnit.registerArgument("source", new ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryMoveItemEvent event) {
                return event.getSource();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryMoveItemEvent event) {
                return event.getEventName();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("destination", new ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryMoveItemEvent event) {
                return event.getDestination();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("item", new ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryMoveItemEvent event) {
                return event.getItem();
            }
        });
        inventoryMoveItemScopeUnit.registerArgument("initiator", new ArgumentInitializer<InventoryMoveItemEvent>() {
            @Override
            public Object get(Ray ray, InventoryMoveItemEvent event) {
                return event.getInitiator();
            }
        });

        ScopeUnit inventoryOpenScopeUnit = moonlight.registerEvent(InventoryOpenEvent.class, "inventory open");
        inventoryOpenScopeUnit.registerArgument("viewers", new ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(Ray ray, InventoryOpenEvent event) {
                return event.getViewers();
            }
        });
        inventoryOpenScopeUnit.registerArgument("event name", new ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(Ray ray, InventoryOpenEvent event) {
                return event.getEventName();
            }
        });
        inventoryOpenScopeUnit.registerArgument("player", new ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(Ray ray, InventoryOpenEvent event) {
                return event.getPlayer();
            }
        });
        inventoryOpenScopeUnit.registerArgument("view", new ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(Ray ray, InventoryOpenEvent event) {
                return event.getView();
            }
        });
        inventoryOpenScopeUnit.registerArgument("inventory", new ArgumentInitializer<InventoryOpenEvent>() {
            @Override
            public Object get(Ray ray, InventoryOpenEvent event) {
                return event.getInventory();
            }
        });


    }

}
