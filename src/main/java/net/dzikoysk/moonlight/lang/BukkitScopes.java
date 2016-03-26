package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.lang.scope.CommandScope;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;

public class BukkitScopes implements BukkitElements {

    private final Moonlight moonlight;
    private final MoonlightCore moonlightCore;

    public BukkitScopes(Moonlight moonlight) {
        this.moonlight = moonlight;
        this.moonlightCore = moonlight.getMoonlightCore();
    }

    @Override
    public void registerBukkitElements() {
        ScopeRepresentation commandScope = new ScopeRepresentation("command", CommandScope.class, moonlightCore);
        commandScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String commandName = flash.getSpecifiers().get(0);
                return new CommandScope(commandName);
            }
        });
        moonlightCore.registerScope(commandScope);
    }

}
