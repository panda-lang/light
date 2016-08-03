package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.player.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class PlayerEvents implements BukkitElements {

    private final Moonlight moonlight;

    public PlayerEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit playerDropItemScopeUnit = moonlight.registerEvent(PlayerDropItemEvent.class, "player drop item");
        playerDropItemScopeUnit.registerArgument("item drop", new ArgumentInitializer<PlayerDropItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerDropItemEvent event) {
                return event.getItemDrop();
            }
        });
        playerDropItemScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerDropItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerDropItemEvent event) {
                return event.getPlayer();
            }
        });
        playerDropItemScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerDropItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerDropItemEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerBedLeaveScopeUnit = moonlight.registerEvent(PlayerBedLeaveEvent.class, "player bed leave");
        playerBedLeaveScopeUnit.registerArgument("bed", new ArgumentInitializer<PlayerBedLeaveEvent>() {
            @Override
            public Object get(Ray ray, PlayerBedLeaveEvent event) {
                return event.getBed();
            }
        });
        playerBedLeaveScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerBedLeaveEvent>() {
            @Override
            public Object get(Ray ray, PlayerBedLeaveEvent event) {
                return event.getPlayer();
            }
        });
        playerBedLeaveScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerBedLeaveEvent>() {
            @Override
            public Object get(Ray ray, PlayerBedLeaveEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerMoveScopeUnit = moonlight.registerEvent(PlayerMoveEvent.class, "player move");
        playerMoveScopeUnit.registerArgument("to", new ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(Ray ray, PlayerMoveEvent event) {
                return event.getTo();
            }
        });
        playerMoveScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(Ray ray, PlayerMoveEvent event) {
                return event.getEventName();
            }
        });
        playerMoveScopeUnit.registerArgument("from", new ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(Ray ray, PlayerMoveEvent event) {
                return event.getFrom();
            }
        });
        playerMoveScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerMoveEvent>() {
            @Override
            public Object get(Ray ray, PlayerMoveEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerEditBookScopeUnit = moonlight.registerEvent(PlayerEditBookEvent.class, "player edit book");
        playerEditBookScopeUnit.registerArgument("new book meta", new ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(Ray ray, PlayerEditBookEvent event) {
                return event.getNewBookMeta();
            }
        });
        playerEditBookScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(Ray ray, PlayerEditBookEvent event) {
                return event.getEventName();
            }
        });
        playerEditBookScopeUnit.registerArgument("previous book meta", new ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(Ray ray, PlayerEditBookEvent event) {
                return event.getPreviousBookMeta();
            }
        });
        playerEditBookScopeUnit.registerArgument("slot", new ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(Ray ray, PlayerEditBookEvent event) {
                return event.getSlot();
            }
        });
        playerEditBookScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerEditBookEvent>() {
            @Override
            public Object get(Ray ray, PlayerEditBookEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerToggleSprintScopeUnit = moonlight.registerEvent(PlayerToggleSprintEvent.class, "player toggle sprint");
        playerToggleSprintScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerToggleSprintEvent>() {
            @Override
            public Object get(Ray ray, PlayerToggleSprintEvent event) {
                return event.getPlayer();
            }
        });
        playerToggleSprintScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerToggleSprintEvent>() {
            @Override
            public Object get(Ray ray, PlayerToggleSprintEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerCommandPreprocessScopeUnit = moonlight.registerEvent(PlayerCommandPreprocessEvent.class, "player command preprocess");
        playerCommandPreprocessScopeUnit.registerArgument("format", new ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getFormat();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("recipients", new ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getRecipients();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getEventName();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("message", new ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getMessage();
            }
        });
        playerCommandPreprocessScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerCommandPreprocessEvent>() {
            @Override
            public Object get(Ray ray, PlayerCommandPreprocessEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerPickupItemScopeUnit = moonlight.registerEvent(PlayerPickupItemEvent.class, "player pickup item");
        playerPickupItemScopeUnit.registerArgument("item", new ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupItemEvent event) {
                return event.getItem();
            }
        });
        playerPickupItemScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupItemEvent event) {
                return event.getPlayer();
            }
        });
        playerPickupItemScopeUnit.registerArgument("remaining", new ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupItemEvent event) {
                return event.getRemaining();
            }
        });
        playerPickupItemScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerPickupItemEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupItemEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit asyncPlayerPreLoginScopeUnit = moonlight.registerEvent(AsyncPlayerPreLoginEvent.class, "async player pre login");
        asyncPlayerPreLoginScopeUnit.registerArgument("result", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getResult();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("address", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getAddress();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("login result", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getLoginResult();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("event name", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getEventName();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("name", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getName();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("kick message", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getKickMessage();
            }
        });
        asyncPlayerPreLoginScopeUnit.registerArgument("unique id", new ArgumentInitializer<AsyncPlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerPreLoginEvent event) {
                return event.getUniqueId();
            }
        });

        ScopeUnit playerAnimationScopeUnit = moonlight.registerEvent(PlayerAnimationEvent.class, "player animation");
        playerAnimationScopeUnit.registerArgument("animation type", new ArgumentInitializer<PlayerAnimationEvent>() {
            @Override
            public Object get(Ray ray, PlayerAnimationEvent event) {
                return event.getAnimationType();
            }
        });
        playerAnimationScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerAnimationEvent>() {
            @Override
            public Object get(Ray ray, PlayerAnimationEvent event) {
                return event.getPlayer();
            }
        });
        playerAnimationScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerAnimationEvent>() {
            @Override
            public Object get(Ray ray, PlayerAnimationEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerChatScopeUnit = moonlight.registerEvent(PlayerChatEvent.class, "player chat");
        playerChatScopeUnit.registerArgument("message", new ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatEvent event) {
                return event.getMessage();
            }
        });
        playerChatScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatEvent event) {
                return event.getEventName();
            }
        });
        playerChatScopeUnit.registerArgument("recipients", new ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatEvent event) {
                return event.getRecipients();
            }
        });
        playerChatScopeUnit.registerArgument("format", new ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatEvent event) {
                return event.getFormat();
            }
        });
        playerChatScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerChatEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerBucketEmptyScopeUnit = moonlight.registerEvent(PlayerBucketEmptyEvent.class, "player bucket empty");
        playerBucketEmptyScopeUnit.registerArgument("item stack", new ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEmptyEvent event) {
                return event.getItemStack();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("block face", new ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEmptyEvent event) {
                return event.getBlockFace();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("bucket", new ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEmptyEvent event) {
                return event.getBucket();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEmptyEvent event) {
                return event.getEventName();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("block clicked", new ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEmptyEvent event) {
                return event.getBlockClicked();
            }
        });
        playerBucketEmptyScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerBucketEmptyEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEmptyEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerFishScopeUnit = moonlight.registerEvent(PlayerFishEvent.class, "player fish");
        playerFishScopeUnit.registerArgument("caught", new ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(Ray ray, PlayerFishEvent event) {
                return event.getCaught();
            }
        });
        playerFishScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(Ray ray, PlayerFishEvent event) {
                return event.getEventName();
            }
        });
        playerFishScopeUnit.registerArgument("exp to drop", new ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(Ray ray, PlayerFishEvent event) {
                return event.getExpToDrop();
            }
        });
        playerFishScopeUnit.registerArgument("hook", new ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(Ray ray, PlayerFishEvent event) {
                return event.getHook();
            }
        });
        playerFishScopeUnit.registerArgument("state", new ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(Ray ray, PlayerFishEvent event) {
                return event.getState();
            }
        });
        playerFishScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerFishEvent>() {
            @Override
            public Object get(Ray ray, PlayerFishEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerItemHeldScopeUnit = moonlight.registerEvent(PlayerItemHeldEvent.class, "player item held");
        playerItemHeldScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemHeldEvent event) {
                return event.getPlayer();
            }
        });
        playerItemHeldScopeUnit.registerArgument("previous slot", new ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemHeldEvent event) {
                return event.getPreviousSlot();
            }
        });
        playerItemHeldScopeUnit.registerArgument("new slot", new ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemHeldEvent event) {
                return event.getNewSlot();
            }
        });
        playerItemHeldScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerItemHeldEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemHeldEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerToggleSneakScopeUnit = moonlight.registerEvent(PlayerToggleSneakEvent.class, "player toggle sneak");
        playerToggleSneakScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerToggleSneakEvent>() {
            @Override
            public Object get(Ray ray, PlayerToggleSneakEvent event) {
                return event.getPlayer();
            }
        });
        playerToggleSneakScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerToggleSneakEvent>() {
            @Override
            public Object get(Ray ray, PlayerToggleSneakEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerJoinScopeUnit = moonlight.registerEvent(PlayerJoinEvent.class, "player join");
        playerJoinScopeUnit.registerArgument("join message", new ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(Ray ray, PlayerJoinEvent event) {
                return event.getJoinMessage();
            }
        });
        playerJoinScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(Ray ray, PlayerJoinEvent event) {
                return event.getPlayer();
            }
        });
        playerJoinScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(Ray ray, PlayerJoinEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit asyncPlayerChatScopeUnit = moonlight.registerEvent(AsyncPlayerChatEvent.class, "async player chat");
        asyncPlayerChatScopeUnit.registerArgument("format", new ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerChatEvent event) {
                return event.getFormat();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("recipients", new ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerChatEvent event) {
                return event.getRecipients();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("event name", new ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerChatEvent event) {
                return event.getEventName();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("message", new ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerChatEvent event) {
                return event.getMessage();
            }
        });
        asyncPlayerChatScopeUnit.registerArgument("player", new ArgumentInitializer<AsyncPlayerChatEvent>() {
            @Override
            public Object get(Ray ray, AsyncPlayerChatEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerLevelChangeScopeUnit = moonlight.registerEvent(PlayerLevelChangeEvent.class, "player level change");
        playerLevelChangeScopeUnit.registerArgument("old level", new ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerLevelChangeEvent event) {
                return event.getOldLevel();
            }
        });
        playerLevelChangeScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerLevelChangeEvent event) {
                return event.getPlayer();
            }
        });
        playerLevelChangeScopeUnit.registerArgument("new level", new ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerLevelChangeEvent event) {
                return event.getNewLevel();
            }
        });
        playerLevelChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerLevelChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerLevelChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerInteractScopeUnit = moonlight.registerEvent(PlayerInteractEvent.class, "player interact");
        playerInteractScopeUnit.registerArgument("clicked block", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getClickedBlock();
            }
        });
        playerInteractScopeUnit.registerArgument("material", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getMaterial();
            }
        });
        playerInteractScopeUnit.registerArgument("block face", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getBlockFace();
            }
        });
        playerInteractScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getEventName();
            }
        });
        playerInteractScopeUnit.registerArgument("item", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getItem();
            }
        });
        playerInteractScopeUnit.registerArgument("action", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getAction();
            }
        });
        playerInteractScopeUnit.registerArgument("hand", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getHand();
            }
        });
        playerInteractScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerInteractEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerInteractAtEntityScopeUnit = moonlight.registerEvent(PlayerInteractAtEntityEvent.class, "player interact at entity");
        playerInteractAtEntityScopeUnit.registerArgument("hand", new ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getHand();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("right clicked", new ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getRightClicked();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getEventName();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("clicked position", new ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getClickedPosition();
            }
        });
        playerInteractAtEntityScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerInteractAtEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractAtEntityEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerInteractEntityScopeUnit = moonlight.registerEvent(PlayerInteractEntityEvent.class, "player interact entity");
        playerInteractEntityScopeUnit.registerArgument("hand", new ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEntityEvent event) {
                return event.getHand();
            }
        });
        playerInteractEntityScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerInteractEntityScopeUnit.registerArgument("right clicked", new ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEntityEvent event) {
                return event.getRightClicked();
            }
        });
        playerInteractEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerInteractEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerInteractEntityEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerItemBreakScopeUnit = moonlight.registerEvent(PlayerItemBreakEvent.class, "player item break");
        playerItemBreakScopeUnit.registerArgument("broken item", new ArgumentInitializer<PlayerItemBreakEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemBreakEvent event) {
                return event.getBrokenItem();
            }
        });
        playerItemBreakScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerItemBreakEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemBreakEvent event) {
                return event.getPlayer();
            }
        });
        playerItemBreakScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerItemBreakEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemBreakEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerRegisterChannelScopeUnit = moonlight.registerEvent(PlayerRegisterChannelEvent.class, "player register channel");
        playerRegisterChannelScopeUnit.registerArgument("channel", new ArgumentInitializer<PlayerRegisterChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerRegisterChannelEvent event) {
                return event.getChannel();
            }
        });
        playerRegisterChannelScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerRegisterChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerRegisterChannelEvent event) {
                return event.getPlayer();
            }
        });
        playerRegisterChannelScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerRegisterChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerRegisterChannelEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerScopeUnit = moonlight.registerEvent(PlayerEvent.class, "player");
        playerScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerEvent>() {
            @Override
            public Object get(Ray ray, PlayerEvent event) {
                return event.getPlayer();
            }
        });
        playerScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerEvent>() {
            @Override
            public Object get(Ray ray, PlayerEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerChannelScopeUnit = moonlight.registerEvent(PlayerChannelEvent.class, "player channel");
        playerChannelScopeUnit.registerArgument("channel", new ArgumentInitializer<PlayerChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerChannelEvent event) {
                return event.getChannel();
            }
        });
        playerChannelScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerChannelEvent event) {
                return event.getPlayer();
            }
        });
        playerChannelScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerChannelEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerTeleportScopeUnit = moonlight.registerEvent(PlayerTeleportEvent.class, "player teleport");
        playerTeleportScopeUnit.registerArgument("to", new ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(Ray ray, PlayerTeleportEvent event) {
                return event.getTo();
            }
        });
        playerTeleportScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(Ray ray, PlayerTeleportEvent event) {
                return event.getEventName();
            }
        });
        playerTeleportScopeUnit.registerArgument("from", new ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(Ray ray, PlayerTeleportEvent event) {
                return event.getFrom();
            }
        });
        playerTeleportScopeUnit.registerArgument("cause", new ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(Ray ray, PlayerTeleportEvent event) {
                return event.getCause();
            }
        });
        playerTeleportScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerTeleportEvent>() {
            @Override
            public Object get(Ray ray, PlayerTeleportEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerAchievementAwardedScopeUnit = moonlight.registerEvent(PlayerAchievementAwardedEvent.class, "player achievement awarded");
        playerAchievementAwardedScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerAchievementAwardedEvent>() {
            @Override
            public Object get(Ray ray, PlayerAchievementAwardedEvent event) {
                return event.getPlayer();
            }
        });
        playerAchievementAwardedScopeUnit.registerArgument("achievement", new ArgumentInitializer<PlayerAchievementAwardedEvent>() {
            @Override
            public Object get(Ray ray, PlayerAchievementAwardedEvent event) {
                return event.getAchievement();
            }
        });
        playerAchievementAwardedScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerAchievementAwardedEvent>() {
            @Override
            public Object get(Ray ray, PlayerAchievementAwardedEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerKickScopeUnit = moonlight.registerEvent(PlayerKickEvent.class, "player kick");
        playerKickScopeUnit.registerArgument("leave message", new ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(Ray ray, PlayerKickEvent event) {
                return event.getLeaveMessage();
            }
        });
        playerKickScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(Ray ray, PlayerKickEvent event) {
                return event.getEventName();
            }
        });
        playerKickScopeUnit.registerArgument("reason", new ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(Ray ray, PlayerKickEvent event) {
                return event.getReason();
            }
        });
        playerKickScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerKickEvent>() {
            @Override
            public Object get(Ray ray, PlayerKickEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerResourcePackStatusScopeUnit = moonlight.registerEvent(PlayerResourcePackStatusEvent.class, "player resource pack status");
        playerResourcePackStatusScopeUnit.registerArgument("status", new ArgumentInitializer<PlayerResourcePackStatusEvent>() {
            @Override
            public Object get(Ray ray, PlayerResourcePackStatusEvent event) {
                return event.getStatus();
            }
        });
        playerResourcePackStatusScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerResourcePackStatusEvent>() {
            @Override
            public Object get(Ray ray, PlayerResourcePackStatusEvent event) {
                return event.getPlayer();
            }
        });
        playerResourcePackStatusScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerResourcePackStatusEvent>() {
            @Override
            public Object get(Ray ray, PlayerResourcePackStatusEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerLoginScopeUnit = moonlight.registerEvent(PlayerLoginEvent.class, "player login");
        playerLoginScopeUnit.registerArgument("real address", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getRealAddress();
            }
        });
        playerLoginScopeUnit.registerArgument("kick message", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getKickMessage();
            }
        });
        playerLoginScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getEventName();
            }
        });
        playerLoginScopeUnit.registerArgument("result", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getResult();
            }
        });
        playerLoginScopeUnit.registerArgument("hostname", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getHostname();
            }
        });
        playerLoginScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getPlayer();
            }
        });
        playerLoginScopeUnit.registerArgument("address", new ArgumentInitializer<PlayerLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerLoginEvent event) {
                return event.getAddress();
            }
        });

        ScopeUnit playerItemDamageScopeUnit = moonlight.registerEvent(PlayerItemDamageEvent.class, "player item damage");
        playerItemDamageScopeUnit.registerArgument("damage", new ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemDamageEvent event) {
                return event.getDamage();
            }
        });
        playerItemDamageScopeUnit.registerArgument("item", new ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemDamageEvent event) {
                return event.getItem();
            }
        });
        playerItemDamageScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemDamageEvent event) {
                return event.getEventName();
            }
        });
        playerItemDamageScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerItemDamageEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemDamageEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerExpChangeScopeUnit = moonlight.registerEvent(PlayerExpChangeEvent.class, "player exp change");
        playerExpChangeScopeUnit.registerArgument("amount", new ArgumentInitializer<PlayerExpChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerExpChangeEvent event) {
                return event.getAmount();
            }
        });
        playerExpChangeScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerExpChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerExpChangeEvent event) {
                return event.getPlayer();
            }
        });
        playerExpChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerExpChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerExpChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerPortalScopeUnit = moonlight.registerEvent(PlayerPortalEvent.class, "player portal");
        playerPortalScopeUnit.registerArgument("portal travel agent", new ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(Ray ray, PlayerPortalEvent event) {
                return event.getPortalTravelAgent();
            }
        });
        playerPortalScopeUnit.registerArgument("to", new ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(Ray ray, PlayerPortalEvent event) {
                return event.getTo();
            }
        });
        playerPortalScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(Ray ray, PlayerPortalEvent event) {
                return event.getEventName();
            }
        });
        playerPortalScopeUnit.registerArgument("from", new ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(Ray ray, PlayerPortalEvent event) {
                return event.getFrom();
            }
        });
        playerPortalScopeUnit.registerArgument("cause", new ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(Ray ray, PlayerPortalEvent event) {
                return event.getCause();
            }
        });
        playerPortalScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerPortalEvent>() {
            @Override
            public Object get(Ray ray, PlayerPortalEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerBucketScopeUnit = moonlight.registerEvent(PlayerBucketEvent.class, "player bucket");
        playerBucketScopeUnit.registerArgument("item stack", new ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEvent event) {
                return event.getItemStack();
            }
        });
        playerBucketScopeUnit.registerArgument("block face", new ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEvent event) {
                return event.getBlockFace();
            }
        });
        playerBucketScopeUnit.registerArgument("bucket", new ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEvent event) {
                return event.getBucket();
            }
        });
        playerBucketScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEvent event) {
                return event.getEventName();
            }
        });
        playerBucketScopeUnit.registerArgument("block clicked", new ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEvent event) {
                return event.getBlockClicked();
            }
        });
        playerBucketScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerBucketEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerGameModeChangeScopeUnit = moonlight.registerEvent(PlayerGameModeChangeEvent.class, "player game mode change");
        playerGameModeChangeScopeUnit.registerArgument("new game mode", new ArgumentInitializer<PlayerGameModeChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerGameModeChangeEvent event) {
                return event.getNewGameMode();
            }
        });
        playerGameModeChangeScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerGameModeChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerGameModeChangeEvent event) {
                return event.getPlayer();
            }
        });
        playerGameModeChangeScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerGameModeChangeEvent>() {
            @Override
            public Object get(Ray ray, PlayerGameModeChangeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerChangedWorldScopeUnit = moonlight.registerEvent(PlayerChangedWorldEvent.class, "player changed world");
        playerChangedWorldScopeUnit.registerArgument("from", new ArgumentInitializer<PlayerChangedWorldEvent>() {
            @Override
            public Object get(Ray ray, PlayerChangedWorldEvent event) {
                return event.getFrom();
            }
        });
        playerChangedWorldScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerChangedWorldEvent>() {
            @Override
            public Object get(Ray ray, PlayerChangedWorldEvent event) {
                return event.getPlayer();
            }
        });
        playerChangedWorldScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerChangedWorldEvent>() {
            @Override
            public Object get(Ray ray, PlayerChangedWorldEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerBucketFillScopeUnit = moonlight.registerEvent(PlayerBucketFillEvent.class, "player bucket fill");
        playerBucketFillScopeUnit.registerArgument("item stack", new ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketFillEvent event) {
                return event.getItemStack();
            }
        });
        playerBucketFillScopeUnit.registerArgument("block face", new ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketFillEvent event) {
                return event.getBlockFace();
            }
        });
        playerBucketFillScopeUnit.registerArgument("bucket", new ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketFillEvent event) {
                return event.getBucket();
            }
        });
        playerBucketFillScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketFillEvent event) {
                return event.getEventName();
            }
        });
        playerBucketFillScopeUnit.registerArgument("block clicked", new ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketFillEvent event) {
                return event.getBlockClicked();
            }
        });
        playerBucketFillScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerBucketFillEvent>() {
            @Override
            public Object get(Ray ray, PlayerBucketFillEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerSwapHandItemsScopeUnit = moonlight.registerEvent(PlayerSwapHandItemsEvent.class, "player swap hand items");
        playerSwapHandItemsScopeUnit.registerArgument("off hand item", new ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getOffHandItem();
            }
        });
        playerSwapHandItemsScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getEventName();
            }
        });
        playerSwapHandItemsScopeUnit.registerArgument("main hand item", new ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getMainHandItem();
            }
        });
        playerSwapHandItemsScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerSwapHandItemsEvent>() {
            @Override
            public Object get(Ray ray, PlayerSwapHandItemsEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerToggleFlightScopeUnit = moonlight.registerEvent(PlayerToggleFlightEvent.class, "player toggle flight");
        playerToggleFlightScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerToggleFlightEvent>() {
            @Override
            public Object get(Ray ray, PlayerToggleFlightEvent event) {
                return event.getPlayer();
            }
        });
        playerToggleFlightScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerToggleFlightEvent>() {
            @Override
            public Object get(Ray ray, PlayerToggleFlightEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerBedEnterScopeUnit = moonlight.registerEvent(PlayerBedEnterEvent.class, "player bed enter");
        playerBedEnterScopeUnit.registerArgument("bed", new ArgumentInitializer<PlayerBedEnterEvent>() {
            @Override
            public Object get(Ray ray, PlayerBedEnterEvent event) {
                return event.getBed();
            }
        });
        playerBedEnterScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerBedEnterEvent>() {
            @Override
            public Object get(Ray ray, PlayerBedEnterEvent event) {
                return event.getPlayer();
            }
        });
        playerBedEnterScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerBedEnterEvent>() {
            @Override
            public Object get(Ray ray, PlayerBedEnterEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerEggThrowScopeUnit = moonlight.registerEvent(PlayerEggThrowEvent.class, "player egg throw");
        playerEggThrowScopeUnit.registerArgument("num hatches", new ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerEggThrowEvent event) {
                return event.getNumHatches();
            }
        });
        playerEggThrowScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerEggThrowEvent event) {
                return event.getEventName();
            }
        });
        playerEggThrowScopeUnit.registerArgument("egg", new ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerEggThrowEvent event) {
                return event.getEgg();
            }
        });
        playerEggThrowScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerEggThrowEvent event) {
                return event.getPlayer();
            }
        });
        playerEggThrowScopeUnit.registerArgument("hatching type", new ArgumentInitializer<PlayerEggThrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerEggThrowEvent event) {
                return event.getHatchingType();
            }
        });

        ScopeUnit playerRespawnScopeUnit = moonlight.registerEvent(PlayerRespawnEvent.class, "player respawn");
        playerRespawnScopeUnit.registerArgument("respawn location", new ArgumentInitializer<PlayerRespawnEvent>() {
            @Override
            public Object get(Ray ray, PlayerRespawnEvent event) {
                return event.getRespawnLocation();
            }
        });
        playerRespawnScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerRespawnEvent>() {
            @Override
            public Object get(Ray ray, PlayerRespawnEvent event) {
                return event.getPlayer();
            }
        });
        playerRespawnScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerRespawnEvent>() {
            @Override
            public Object get(Ray ray, PlayerRespawnEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerItemConsumeScopeUnit = moonlight.registerEvent(PlayerItemConsumeEvent.class, "player item consume");
        playerItemConsumeScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerItemConsumeEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemConsumeEvent event) {
                return event.getPlayer();
            }
        });
        playerItemConsumeScopeUnit.registerArgument("item", new ArgumentInitializer<PlayerItemConsumeEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemConsumeEvent event) {
                return event.getItem();
            }
        });
        playerItemConsumeScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerItemConsumeEvent>() {
            @Override
            public Object get(Ray ray, PlayerItemConsumeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerPickupArrowScopeUnit = moonlight.registerEvent(PlayerPickupArrowEvent.class, "player pickup arrow");
        playerPickupArrowScopeUnit.registerArgument("arrow", new ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupArrowEvent event) {
                return event.getArrow();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("item", new ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupArrowEvent event) {
                return event.getItem();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("remaining", new ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupArrowEvent event) {
                return event.getRemaining();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupArrowEvent event) {
                return event.getEventName();
            }
        });
        playerPickupArrowScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerPickupArrowEvent>() {
            @Override
            public Object get(Ray ray, PlayerPickupArrowEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerInventoryScopeUnit = moonlight.registerEvent(PlayerInventoryEvent.class, "player inventory");
        playerInventoryScopeUnit.registerArgument("inventory", new ArgumentInitializer<PlayerInventoryEvent>() {
            @Override
            public Object get(Ray ray, PlayerInventoryEvent event) {
                return event.getInventory();
            }
        });
        playerInventoryScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerInventoryEvent>() {
            @Override
            public Object get(Ray ray, PlayerInventoryEvent event) {
                return event.getPlayer();
            }
        });
        playerInventoryScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerInventoryEvent>() {
            @Override
            public Object get(Ray ray, PlayerInventoryEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerChatTabCompleteScopeUnit = moonlight.registerEvent(PlayerChatTabCompleteEvent.class, "player chat tab complete");
        playerChatTabCompleteScopeUnit.registerArgument("chat message", new ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getChatMessage();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("tab completions", new ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getTabCompletions();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("last token", new ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getLastToken();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getPlayer();
            }
        });
        playerChatTabCompleteScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerChatTabCompleteEvent>() {
            @Override
            public Object get(Ray ray, PlayerChatTabCompleteEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerQuitScopeUnit = moonlight.registerEvent(PlayerQuitEvent.class, "player quit");
        playerQuitScopeUnit.registerArgument("quit message", new ArgumentInitializer<PlayerQuitEvent>() {
            @Override
            public Object get(Ray ray, PlayerQuitEvent event) {
                return event.getQuitMessage();
            }
        });
        playerQuitScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerQuitEvent>() {
            @Override
            public Object get(Ray ray, PlayerQuitEvent event) {
                return event.getPlayer();
            }
        });
        playerQuitScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerQuitEvent>() {
            @Override
            public Object get(Ray ray, PlayerQuitEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerVelocityScopeUnit = moonlight.registerEvent(PlayerVelocityEvent.class, "player velocity");
        playerVelocityScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerVelocityEvent>() {
            @Override
            public Object get(Ray ray, PlayerVelocityEvent event) {
                return event.getPlayer();
            }
        });
        playerVelocityScopeUnit.registerArgument("velocity", new ArgumentInitializer<PlayerVelocityEvent>() {
            @Override
            public Object get(Ray ray, PlayerVelocityEvent event) {
                return event.getVelocity();
            }
        });
        playerVelocityScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerVelocityEvent>() {
            @Override
            public Object get(Ray ray, PlayerVelocityEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerArmorStandManipulateScopeUnit = moonlight.registerEvent(PlayerArmorStandManipulateEvent.class, "player armor stand manipulate");
        playerArmorStandManipulateScopeUnit.registerArgument("slot", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getSlot();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("hand", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getHand();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("right clicked", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getRightClicked();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getEventName();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("player item", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getPlayerItem();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getPlayer();
            }
        });
        playerArmorStandManipulateScopeUnit.registerArgument("armor stand item", new ArgumentInitializer<PlayerArmorStandManipulateEvent>() {
            @Override
            public Object get(Ray ray, PlayerArmorStandManipulateEvent event) {
                return event.getArmorStandItem();
            }
        });

        ScopeUnit playerUnregisterChannelScopeUnit = moonlight.registerEvent(PlayerUnregisterChannelEvent.class, "player unregister channel");
        playerUnregisterChannelScopeUnit.registerArgument("channel", new ArgumentInitializer<PlayerUnregisterChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnregisterChannelEvent event) {
                return event.getChannel();
            }
        });
        playerUnregisterChannelScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerUnregisterChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnregisterChannelEvent event) {
                return event.getPlayer();
            }
        });
        playerUnregisterChannelScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerUnregisterChannelEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnregisterChannelEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerUnleashEntityScopeUnit = moonlight.registerEvent(PlayerUnleashEntityEvent.class, "player unleash entity");
        playerUnleashEntityScopeUnit.registerArgument("entity type", new ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnleashEntityEvent event) {
                return event.getEntityType();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("reason", new ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnleashEntityEvent event) {
                return event.getReason();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnleashEntityEvent event) {
                return event.getEntity();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnleashEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerUnleashEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerUnleashEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerUnleashEntityEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit playerPreLoginScopeUnit = moonlight.registerEvent(PlayerPreLoginEvent.class, "player pre login");
        playerPreLoginScopeUnit.registerArgument("result", new ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerPreLoginEvent event) {
                return event.getResult();
            }
        });
        playerPreLoginScopeUnit.registerArgument("address", new ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerPreLoginEvent event) {
                return event.getAddress();
            }
        });
        playerPreLoginScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerPreLoginEvent event) {
                return event.getEventName();
            }
        });
        playerPreLoginScopeUnit.registerArgument("name", new ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerPreLoginEvent event) {
                return event.getName();
            }
        });
        playerPreLoginScopeUnit.registerArgument("kick message", new ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerPreLoginEvent event) {
                return event.getKickMessage();
            }
        });
        playerPreLoginScopeUnit.registerArgument("unique id", new ArgumentInitializer<PlayerPreLoginEvent>() {
            @Override
            public Object get(Ray ray, PlayerPreLoginEvent event) {
                return event.getUniqueId();
            }
        });

        ScopeUnit playerStatisticIncrementScopeUnit = moonlight.registerEvent(PlayerStatisticIncrementEvent.class, "player statistic increment");
        playerStatisticIncrementScopeUnit.registerArgument("entity type", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getEntityType();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("new value", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getNewValue();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("statistic", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getStatistic();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getEventName();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("material", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getMaterial();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("previous value", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getPreviousValue();
            }
        });
        playerStatisticIncrementScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerStatisticIncrementEvent>() {
            @Override
            public Object get(Ray ray, PlayerStatisticIncrementEvent event) {
                return event.getPlayer();
            }
        });

        ScopeUnit playerShearEntityScopeUnit = moonlight.registerEvent(PlayerShearEntityEvent.class, "player shear entity");
        playerShearEntityScopeUnit.registerArgument("entity", new ArgumentInitializer<PlayerShearEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerShearEntityEvent event) {
                return event.getEntity();
            }
        });
        playerShearEntityScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerShearEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerShearEntityEvent event) {
                return event.getPlayer();
            }
        });
        playerShearEntityScopeUnit.registerArgument("event name", new ArgumentInitializer<PlayerShearEntityEvent>() {
            @Override
            public Object get(Ray ray, PlayerShearEntityEvent event) {
                return event.getEventName();
            }
        });
    }

}
