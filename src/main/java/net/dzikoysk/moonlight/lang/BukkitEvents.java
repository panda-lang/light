package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.player.PlayerJoinEvent;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class BukkitEvents implements BukkitElements {

    private final Moonlight moonlight;
    private final MoonlightCore moonlightCore;

    public BukkitEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
        this.moonlightCore = moonlight.getMoonlightCore();
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit joinScopeUnit = moonlight.registerEvent(PlayerJoinEvent.class, "join");
        joinScopeUnit.registerArgument("player", new ArgumentInitializer<PlayerJoinEvent>() {
            @Override
            public Object get(Ray ray, PlayerJoinEvent event) {
                return event.getPlayer();
            }
        });
    }

}
