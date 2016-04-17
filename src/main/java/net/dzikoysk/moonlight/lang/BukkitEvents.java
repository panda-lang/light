package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.player.PlayerJoinEvent;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class BukkitEvents implements BukkitElements {

    private final Moonlight moonlight;

    public BukkitEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
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
