package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.core.command.BukkitCommandInfo;
import net.dzikoysk.moonlight.lang.scope.CommandScope;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;

public class BukkitScopes implements BukkitElements {

    private final MoonlightCore moonlightCore;

    public BukkitScopes(Moonlight moonlight) {
        this.moonlightCore = moonlight.getMoonlightCore();
    }

    @Override
    public void registerBukkitElements() {
        ScopeRepresentation commandScope = new ScopeRepresentation("command", CommandScope.class, moonlightCore);
        commandScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String commandName = flash.getSpecifiers().get(0);
                return new CommandScope(commandName.substring(1, commandName.length()));
            }
        });
        commandScope.registerArgument("arguments", new ArgumentInitializer<BukkitCommandInfo>() {
            @Override
            public Object get(Ray ray, BukkitCommandInfo bukkitCommandInfo) {
                return bukkitCommandInfo.getArguments();
            }
        });
        commandScope.registerArgument("arg-*", new ArgumentInitializer<BukkitCommandInfo>() {
            @Override
            public Object get(Ray ray, BukkitCommandInfo bukkitCommandInfo) {
                String[] arguments = bukkitCommandInfo.getArguments();
                String hollow = ray.getHollows().get(0);
                int index = Integer.parseInt(hollow) - 1;
                return index < arguments.length ? arguments[index] : null;
            }
        });
        moonlightCore.registerScope(commandScope);
    }

}
