package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.player.*;

public class PlayerEvents implements BukkitElements {

    private final Light light;

    public PlayerEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit playerDropItemScopeUnit = light.registerEvent(PlayerDropItemEvent.class, "player drop item");
        playerDropItemScopeUnit.registerArgument("item drop", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDropItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDropItemEvent event) {
                return event.getItemDrop();
            }
        });
        playerDropItemScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDropItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDropItemEvent event) {
                return event.getPlayer();
            }
        });
        playerDropItemScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerDropItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerDropItemEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerBedLeaveScopeUnit = light.registerEvent(PlayerBedLeaveEvent.class, "player bed leave");
        playerBedLeaveScopeUnit.registerArgument("bed", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBedLeaveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBedLeaveEvent event) {
                return event.getBed();
            }
        });
        playerBedLeaveScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBedLeaveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBedLeaveEvent event) {
                return event.getPlayer();
            }
        });
        playerBedLeaveScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBedLeaveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBedLeaveEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerMoveScopeUnit = light.registerEvent(PlayerMoveEvent.class, "player move");
        playerMoveScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerMoveEvent event) {
                return event.getTo();
            }
        });
        playerMoveScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerMoveEvent event) {
                return event.getEventName();
            }
        });
        playerMoveScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerMoveEvent event) {
                return event.getFrom();
            }
        });
        playerMoveScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerMoveEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerEditBookScopeUnit = light.registerEvent(PlayerEditBookEvent.class, "player edit book");
        playerEditBookScopeUnit.registerArgument("new book meta", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEditBookEvent event) {
                return event.getNewBookMeta();
            }
        });
        playerEditBookScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEditBookEvent event) {
                return event.getEventName();
            }
        });
        playerEditBookScopeUnit.registerArgument("previous book meta", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEditBookEvent event) {
                return event.getPreviousBookMeta();
            }
        });
        playerEditBookScopeUnit.registerArgument("slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEditBookEvent event) {
                return event.getSlot();
            }
        });
        playerEditBookScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEditBookEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerToggleSprintScopeUnit = light.registerEvent(PlayerToggleSprintEvent.class, "player toggle sprint");
        playerToggleSprintScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerToggleSprintEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerToggleSprintEvent event) {
                return event.getPlayer();
            }
        });
        playerToggleSprintScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerToggleSprintEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerToggleSprintEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerCommandPreprocessScopeUnit = light.registerEvent(PlayerCommandPreprocessEvent.class, "player command preprocess");
        playerCommandPreprocessScopeUnit.registerArgument("format", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getFormat();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("recipients", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getRecipients();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getEventName();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getMessage();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerPickupItemScopeUnit = light.registerEvent(PlayerPickupItemEvent.class, "player pickup item");
        playerPickupItemScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupItemEvent event) {
                return event.getItem();
            }
        });
        playerPickupItemScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupItemEvent event) {
                return event.getPlayer();
            }
        });
        playerPickupItemScopeUnit.registerArgument("remaining", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupItemEvent event) {
                return event.getRemaining();
            }
        });
        playerPickupItemScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupItemEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit asyncPlayerPreLoginScopeUnit = light.registerEvent(AsyncPlayerPreLoginEvent.class, "async player pre login");
        asyncPlayerPreLoginScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getResult();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("address", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getAddress();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("login result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getLoginResult();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getEventName();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getName();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("kick message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getKickMessage();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("unique id", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getUniqueId();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerAnimationScopeUnit = light.registerEvent(PlayerAnimationEvent.class, "player animation");
        playerAnimationScopeUnit.registerArgument("animation type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerAnimationEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerAnimationEvent event) {
                return event.getAnimationType();
            }
        });
        playerAnimationScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerAnimationEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerAnimationEvent event) {
                return event.getPlayer();
            }
        });
        playerAnimationScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerAnimationEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerAnimationEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerChatScopeUnit = light.registerEvent(PlayerChatEvent.class, "player chat");
        playerChatScopeUnit.registerArgument("message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatEvent event) {
                return event.getMessage();
            }
        });
        playerChatScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatEvent event) {
                return event.getEventName();
            }
        });
        playerChatScopeUnit.registerArgument("recipients", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatEvent event) {
                return event.getRecipients();
            }
        });
        playerChatScopeUnit.registerArgument("format", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatEvent event) {
                return event.getFormat();
            }
        });
        playerChatScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerBucketEmptyScopeUnit = light.registerEvent(PlayerBucketEmptyEvent.class, "player bucket empty");
        playerBucketEmptyScopeUnit.registerArgument("item stack", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEmptyEvent event) {
                return event.getItemStack();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("block face", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEmptyEvent event) {
                return event.getBlockFace();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("bucket", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEmptyEvent event) {
                return event.getBucket();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEmptyEvent event) {
                return event.getEventName();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("block clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEmptyEvent event) {
                return event.getBlockClicked();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEmptyEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerFishScopeUnit = light.registerEvent(PlayerFishEvent.class, "player fish");
        playerFishScopeUnit.registerArgument("caught", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerFishEvent event) {
                return event.getCaught();
            }
        });
        playerFishScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerFishEvent event) {
                return event.getEventName();
            }
        });
        playerFishScopeUnit.registerArgument("exp to drop", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerFishEvent event) {
                return event.getExpToDrop();
            }
        });
        playerFishScopeUnit.registerArgument("hook", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerFishEvent event) {
                return event.getHook();
            }
        });
        playerFishScopeUnit.registerArgument("state", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerFishEvent event) {
                return event.getState();
            }
        });
        playerFishScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerFishEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerItemHeldScopeUnit = light.registerEvent(PlayerItemHeldEvent.class, "player item held");
        playerItemHeldScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemHeldEvent event) {
                return event.getPlayer();
            }
        });
        playerItemHeldScopeUnit.registerArgument("previous slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemHeldEvent event) {
                return event.getPreviousSlot();
            }
        });
        playerItemHeldScopeUnit.registerArgument("new slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemHeldEvent event) {
                return event.getNewSlot();
            }
        });
        playerItemHeldScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemHeldEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerToggleSneakScopeUnit = light.registerEvent(PlayerToggleSneakEvent.class, "player toggle sneak");
        playerToggleSneakScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerToggleSneakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerToggleSneakEvent event) {
                return event.getPlayer();
            }
        });
        playerToggleSneakScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerToggleSneakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerToggleSneakEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerJoinScopeUnit = light.registerEvent(PlayerJoinEvent.class, "player join");
        playerJoinScopeUnit.registerArgument("join message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerJoinEvent event) {
                return event.getJoinMessage();
            }
        });
        playerJoinScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerJoinEvent event) {
                return event.getPlayer();
            }
        });
        playerJoinScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerJoinEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit asyncPlayerChatScopeUnit = light.registerEvent(AsyncPlayerChatEvent.class, "async player chat");
        asyncPlayerChatScopeUnit.registerArgument("format", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerChatEvent event) {
                return event.getFormat();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("recipients", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerChatEvent event) {
                return event.getRecipients();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerChatEvent event) {
                return event.getEventName();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerChatEvent event) {
                return event.getMessage();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, AsyncPlayerChatEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerLevelChangeScopeUnit = light.registerEvent(PlayerLevelChangeEvent.class, "player level change");
        playerLevelChangeScopeUnit.registerArgument("old level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLevelChangeEvent event) {
                return event.getOldLevel();
            }
        });
        playerLevelChangeScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLevelChangeEvent event) {
                return event.getPlayer();
            }
        });
        playerLevelChangeScopeUnit.registerArgument("new level", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLevelChangeEvent event) {
                return event.getNewLevel();
            }
        });
        playerLevelChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLevelChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerInteractScopeUnit = light.registerEvent(PlayerInteractEvent.class, "player interact");
        playerInteractScopeUnit.registerArgument("clicked block", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getClickedBlock();
            }
        });
        playerInteractScopeUnit.registerArgument("material", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getMaterial();
            }
        });
        playerInteractScopeUnit.registerArgument("block face", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getBlockFace();
            }
        });
        playerInteractScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getEventName();
            }
        });
        playerInteractScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getItem();
            }
        });
        playerInteractScopeUnit.registerArgument("action", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getAction();
            }
        });
        playerInteractScopeUnit.registerArgument("hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getHand();
            }
        });
        playerInteractScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerInteractAtEntityScopeUnit = light.registerEvent(PlayerInteractAtEntityEvent.class, "player interact at entity");
        playerInteractAtEntityScopeUnit.registerArgument("hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getHand();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("right clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getRightClicked();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getEventName();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("clicked position", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getClickedPosition();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerInteractEntityScopeUnit = light.registerEvent(PlayerInteractEntityEvent.class, "player interact entity");
        playerInteractEntityScopeUnit.registerArgument("hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEntityEvent event) {
                return event.getHand();
            }
        });
        playerInteractEntityScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerInteractEntityScopeUnit.registerArgument("right clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEntityEvent event) {
                return event.getRightClicked();
            }
        });
        playerInteractEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInteractEntityEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerItemBreakScopeUnit = light.registerEvent(PlayerItemBreakEvent.class, "player item break");
        playerItemBreakScopeUnit.registerArgument("broken item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemBreakEvent event) {
                return event.getBrokenItem();
            }
        });
        playerItemBreakScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemBreakEvent event) {
                return event.getPlayer();
            }
        });
        playerItemBreakScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemBreakEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemBreakEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerRegisterChannelScopeUnit = light.registerEvent(PlayerRegisterChannelEvent.class, "player register channel");
        playerRegisterChannelScopeUnit.registerArgument("channel", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerRegisterChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerRegisterChannelEvent event) {
                return event.getChannel();
            }
        });
        playerRegisterChannelScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerRegisterChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerRegisterChannelEvent event) {
                return event.getPlayer();
            }
        });
        playerRegisterChannelScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerRegisterChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerRegisterChannelEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerScopeUnit = light.registerEvent(PlayerEvent.class, "player");
        playerScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEvent event) {
                return event.getPlayer();
            }
        });
        playerScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerChannelScopeUnit = light.registerEvent(PlayerChannelEvent.class, "player channel");
        playerChannelScopeUnit.registerArgument("channel", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChannelEvent event) {
                return event.getChannel();
            }
        });
        playerChannelScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChannelEvent event) {
                return event.getPlayer();
            }
        });
        playerChannelScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChannelEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerTeleportScopeUnit = light.registerEvent(PlayerTeleportEvent.class, "player teleport");
        playerTeleportScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerTeleportEvent event) {
                return event.getTo();
            }
        });
        playerTeleportScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerTeleportEvent event) {
                return event.getEventName();
            }
        });
        playerTeleportScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerTeleportEvent event) {
                return event.getFrom();
            }
        });
        playerTeleportScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerTeleportEvent event) {
                return event.getCause();
            }
        });
        playerTeleportScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerTeleportEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerAchievementAwardedScopeUnit = light.registerEvent(PlayerAchievementAwardedEvent.class, "player achievement awarded");
        playerAchievementAwardedScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerAchievementAwardedEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerAchievementAwardedEvent event) {
                return event.getPlayer();
            }
        });
        playerAchievementAwardedScopeUnit.registerArgument("achievement", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerAchievementAwardedEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerAchievementAwardedEvent event) {
                return event.getAchievement();
            }
        });
        playerAchievementAwardedScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerAchievementAwardedEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerAchievementAwardedEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerKickScopeUnit = light.registerEvent(PlayerKickEvent.class, "player kick");
        playerKickScopeUnit.registerArgument("leave message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerKickEvent event) {
                return event.getLeaveMessage();
            }
        });
        playerKickScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerKickEvent event) {
                return event.getEventName();
            }
        });
        playerKickScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerKickEvent event) {
                return event.getReason();
            }
        });
        playerKickScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerKickEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerResourcePackStatusScopeUnit = light.registerEvent(PlayerResourcePackStatusEvent.class, "player resource pack status");
        playerResourcePackStatusScopeUnit.registerArgument("status", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerResourcePackStatusEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerResourcePackStatusEvent event) {
                return event.getStatus();
            }
        });
        playerResourcePackStatusScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerResourcePackStatusEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerResourcePackStatusEvent event) {
                return event.getPlayer();
            }
        });
        playerResourcePackStatusScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerResourcePackStatusEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerResourcePackStatusEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerLoginScopeUnit = light.registerEvent(PlayerLoginEvent.class, "player login");
        playerLoginScopeUnit.registerArgument("real address", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getRealAddress();
            }
        });
        playerLoginScopeUnit.registerArgument("kick message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getKickMessage();
            }
        });
        playerLoginScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getEventName();
            }
        });
        playerLoginScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getResult();
            }
        });
        playerLoginScopeUnit.registerArgument("hostname", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getHostname();
            }
        });
        playerLoginScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getPlayer();
            }
        });
        playerLoginScopeUnit.registerArgument("address", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerLoginEvent event) {
                return event.getAddress();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerItemDamageScopeUnit = light.registerEvent(PlayerItemDamageEvent.class, "player item damage");
        playerItemDamageScopeUnit.registerArgument("damage", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemDamageEvent event) {
                return event.getDamage();
            }
        });
        playerItemDamageScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemDamageEvent event) {
                return event.getItem();
            }
        });
        playerItemDamageScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemDamageEvent event) {
                return event.getEventName();
            }
        });
        playerItemDamageScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemDamageEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerExpChangeScopeUnit = light.registerEvent(PlayerExpChangeEvent.class, "player exp change");
        playerExpChangeScopeUnit.registerArgument("amount", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerExpChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerExpChangeEvent event) {
                return event.getAmount();
            }
        });
        playerExpChangeScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerExpChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerExpChangeEvent event) {
                return event.getPlayer();
            }
        });
        playerExpChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerExpChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerExpChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerPortalScopeUnit = light.registerEvent(PlayerPortalEvent.class, "player portal");
        playerPortalScopeUnit.registerArgument("portal travel agent", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPortalEvent event) {
                return event.getPortalTravelAgent();
            }
        });
        playerPortalScopeUnit.registerArgument("to", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPortalEvent event) {
                return event.getTo();
            }
        });
        playerPortalScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPortalEvent event) {
                return event.getEventName();
            }
        });
        playerPortalScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPortalEvent event) {
                return event.getFrom();
            }
        });
        playerPortalScopeUnit.registerArgument("cause", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPortalEvent event) {
                return event.getCause();
            }
        });
        playerPortalScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPortalEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerBucketScopeUnit = light.registerEvent(PlayerBucketEvent.class, "player bucket");
        playerBucketScopeUnit.registerArgument("item stack", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEvent event) {
                return event.getItemStack();
            }
        });
        playerBucketScopeUnit.registerArgument("block face", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEvent event) {
                return event.getBlockFace();
            }
        });
        playerBucketScopeUnit.registerArgument("bucket", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEvent event) {
                return event.getBucket();
            }
        });
        playerBucketScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEvent event) {
                return event.getEventName();
            }
        });
        playerBucketScopeUnit.registerArgument("block clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEvent event) {
                return event.getBlockClicked();
            }
        });
        playerBucketScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerGameModeChangeScopeUnit = light.registerEvent(PlayerGameModeChangeEvent.class, "player game mode change");
        playerGameModeChangeScopeUnit.registerArgument("new game mode", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerGameModeChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerGameModeChangeEvent event) {
                return event.getNewGameMode();
            }
        });
        playerGameModeChangeScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerGameModeChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerGameModeChangeEvent event) {
                return event.getPlayer();
            }
        });
        playerGameModeChangeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerGameModeChangeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerGameModeChangeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerChangedWorldScopeUnit = light.registerEvent(PlayerChangedWorldEvent.class, "player changed world");
        playerChangedWorldScopeUnit.registerArgument("from", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChangedWorldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChangedWorldEvent event) {
                return event.getFrom();
            }
        });
        playerChangedWorldScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChangedWorldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChangedWorldEvent event) {
                return event.getPlayer();
            }
        });
        playerChangedWorldScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChangedWorldEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChangedWorldEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerBucketFillScopeUnit = light.registerEvent(PlayerBucketFillEvent.class, "player bucket fill");
        playerBucketFillScopeUnit.registerArgument("item stack", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketFillEvent event) {
                return event.getItemStack();
            }
        });
        playerBucketFillScopeUnit.registerArgument("block face", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketFillEvent event) {
                return event.getBlockFace();
            }
        });
        playerBucketFillScopeUnit.registerArgument("bucket", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketFillEvent event) {
                return event.getBucket();
            }
        });
        playerBucketFillScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketFillEvent event) {
                return event.getEventName();
            }
        });
        playerBucketFillScopeUnit.registerArgument("block clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketFillEvent event) {
                return event.getBlockClicked();
            }
        });
        playerBucketFillScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBucketFillEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerSwapHandItemsScopeUnit = light.registerEvent(PlayerSwapHandItemsEvent.class, "player swap hand items");
        playerSwapHandItemsScopeUnit.registerArgument("off hand item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getOffHandItem();
            }
        });
        playerSwapHandItemsScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getEventName();
            }
        });
        playerSwapHandItemsScopeUnit.registerArgument("main hand item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getMainHandItem();
            }
        });
        playerSwapHandItemsScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerToggleFlightScopeUnit = light.registerEvent(PlayerToggleFlightEvent.class, "player toggle flight");
        playerToggleFlightScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerToggleFlightEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerToggleFlightEvent event) {
                return event.getPlayer();
            }
        });
        playerToggleFlightScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerToggleFlightEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerToggleFlightEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerBedEnterScopeUnit = light.registerEvent(PlayerBedEnterEvent.class, "player bed enter");
        playerBedEnterScopeUnit.registerArgument("bed", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBedEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBedEnterEvent event) {
                return event.getBed();
            }
        });
        playerBedEnterScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBedEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBedEnterEvent event) {
                return event.getPlayer();
            }
        });
        playerBedEnterScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerBedEnterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerBedEnterEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerEggThrowScopeUnit = light.registerEvent(PlayerEggThrowEvent.class, "player egg throw");
        playerEggThrowScopeUnit.registerArgument("num hatches", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEggThrowEvent event) {
                return event.getNumHatches();
            }
        });
        playerEggThrowScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEggThrowEvent event) {
                return event.getEventName();
            }
        });
        playerEggThrowScopeUnit.registerArgument("egg", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEggThrowEvent event) {
                return event.getEgg();
            }
        });
        playerEggThrowScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEggThrowEvent event) {
                return event.getPlayer();
            }
        });
        playerEggThrowScopeUnit.registerArgument("hatching type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerEggThrowEvent event) {
                return event.getHatchingType();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerRespawnScopeUnit = light.registerEvent(PlayerRespawnEvent.class, "player respawn");
        playerRespawnScopeUnit.registerArgument("respawn location", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerRespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerRespawnEvent event) {
                return event.getRespawnLocation();
            }
        });
        playerRespawnScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerRespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerRespawnEvent event) {
                return event.getPlayer();
            }
        });
        playerRespawnScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerRespawnEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerRespawnEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerItemConsumeScopeUnit = light.registerEvent(PlayerItemConsumeEvent.class, "player item consume");
        playerItemConsumeScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemConsumeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemConsumeEvent event) {
                return event.getPlayer();
            }
        });
        playerItemConsumeScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemConsumeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemConsumeEvent event) {
                return event.getItem();
            }
        });
        playerItemConsumeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerItemConsumeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerItemConsumeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerPickupArrowScopeUnit = light.registerEvent(PlayerPickupArrowEvent.class, "player pickup arrow");
        playerPickupArrowScopeUnit.registerArgument("arrow", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupArrowEvent event) {
                return event.getArrow();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupArrowEvent event) {
                return event.getItem();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("remaining", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupArrowEvent event) {
                return event.getRemaining();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupArrowEvent event) {
                return event.getEventName();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPickupArrowEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerInventoryScopeUnit = light.registerEvent(PlayerInventoryEvent.class, "player inventory");
        playerInventoryScopeUnit.registerArgument("inventory", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInventoryEvent event) {
                return event.getInventory();
            }
        });
        playerInventoryScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInventoryEvent event) {
                return event.getPlayer();
            }
        });
        playerInventoryScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerInventoryEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerInventoryEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerChatTabCompleteScopeUnit = light.registerEvent(PlayerChatTabCompleteEvent.class, "player chat tab complete");
        playerChatTabCompleteScopeUnit.registerArgument("chat message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getChatMessage();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("tab completions", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getTabCompletions();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("last token", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getLastToken();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getPlayer();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerQuitScopeUnit = light.registerEvent(PlayerQuitEvent.class, "player quit");
        playerQuitScopeUnit.registerArgument("quit message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerQuitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerQuitEvent event) {
                return event.getQuitMessage();
            }
        });
        playerQuitScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerQuitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerQuitEvent event) {
                return event.getPlayer();
            }
        });
        playerQuitScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerQuitEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerQuitEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerVelocityScopeUnit = light.registerEvent(PlayerVelocityEvent.class, "player velocity");
        playerVelocityScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerVelocityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerVelocityEvent event) {
                return event.getPlayer();
            }
        });
        playerVelocityScopeUnit.registerArgument("velocity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerVelocityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerVelocityEvent event) {
                return event.getVelocity();
            }
        });
        playerVelocityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerVelocityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerVelocityEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerArmorStandManipulateScopeUnit = light.registerEvent(PlayerArmorStandManipulateEvent.class, "player armor stand manipulate");
        playerArmorStandManipulateScopeUnit.registerArgument("slot", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getSlot();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("hand", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getHand();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("right clicked", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getRightClicked();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getEventName();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("player item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getPlayerItem();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getPlayer();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("armor stand item", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getArmorStandItem();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerUnregisterChannelScopeUnit = light.registerEvent(PlayerUnregisterChannelEvent.class, "player unregister channel");
        playerUnregisterChannelScopeUnit.registerArgument("channel", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnregisterChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnregisterChannelEvent event) {
                return event.getChannel();
            }
        });
        playerUnregisterChannelScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnregisterChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnregisterChannelEvent event) {
                return event.getPlayer();
            }
        });
        playerUnregisterChannelScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnregisterChannelEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnregisterChannelEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerUnleashEntityScopeUnit = light.registerEvent(PlayerUnleashEntityEvent.class, "player unleash entity");
        playerUnleashEntityScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnleashEntityEvent event) {
                return event.getEntityType();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("reason", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnleashEntityEvent event) {
                return event.getReason();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnleashEntityEvent event) {
                return event.getEntity();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnleashEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerUnleashEntityEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerPreLoginScopeUnit = light.registerEvent(PlayerPreLoginEvent.class, "player pre login");
        playerPreLoginScopeUnit.registerArgument("result", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPreLoginEvent event) {
                return event.getResult();
            }
        });
        playerPreLoginScopeUnit.registerArgument("address", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPreLoginEvent event) {
                return event.getAddress();
            }
        });
        playerPreLoginScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPreLoginEvent event) {
                return event.getEventName();
            }
        });
        playerPreLoginScopeUnit.registerArgument("name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPreLoginEvent event) {
                return event.getName();
            }
        });
        playerPreLoginScopeUnit.registerArgument("kick message", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPreLoginEvent event) {
                return event.getKickMessage();
            }
        });
        playerPreLoginScopeUnit.registerArgument("unique id", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerPreLoginEvent event) {
                return event.getUniqueId();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerStatisticIncrementScopeUnit = light.registerEvent(PlayerStatisticIncrementEvent.class, "player statistic increment");
        playerStatisticIncrementScopeUnit.registerArgument("entity type", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getEntityType();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("new value", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getNewValue();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("statistic", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getStatistic();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getEventName();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("material", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getMaterial();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("previous value", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getPreviousValue();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getPlayer();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit playerShearEntityScopeUnit = light.registerEvent(PlayerShearEntityEvent.class, "player shear entity");
        playerShearEntityScopeUnit.registerArgument("entity", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerShearEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerShearEntityEvent event) {
                return event.getEntity();
            }
        });
        playerShearEntityScopeUnit.registerArgument("player", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerShearEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerShearEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerShearEntityScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PlayerShearEntityEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PlayerShearEntityEvent event) {
                return event.getEventName();
            }
        });
    }

}
