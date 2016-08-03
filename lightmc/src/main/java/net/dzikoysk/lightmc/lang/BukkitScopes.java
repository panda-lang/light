package net.dzikoysk.lightmc.lang;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.core.command.BukkitCommandInfo;
import net.dzikoysk.lightmc.lang.scope.CommandScope;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.panda_lang.light.LightCore;

public class BukkitScopes implements BukkitElements {

    private final LightCore lightCore;

    public BukkitScopes(Light light) {
        this.lightCore = light.getLightCore();
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeRepresentation commandScope = new org.panda_lang.light.core.element.scope.ScopeRepresentation("command", CommandScope.class, lightCore);
        commandScope.initializer(new org.panda_lang.light.core.element.scope.ScopeInitializer() {
            @Override
            public org.panda_lang.light.core.element.scope.Scope initialize(org.panda_lang.light.core.Flash flash) {
                String commandName = flash.getSpecifiers().get(0);
                return new CommandScope(commandName.substring(1, commandName.length()));
            }
        });
        commandScope.registerArgument("arguments", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BukkitCommandInfo>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BukkitCommandInfo bukkitCommandInfo) {
                return bukkitCommandInfo.getArguments();
            }
        });
        commandScope.registerArgument("arg-*", new org.panda_lang.light.core.element.argument.ArgumentInitializer<BukkitCommandInfo>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BukkitCommandInfo bukkitCommandInfo) {
                String[] arguments = bukkitCommandInfo.getArguments();
                String hollow = ray.getHollows().get(0);
                int index = Integer.parseInt(hollow) - 1;
                return index < arguments.length ? arguments[index] : null;
            }
        });
        commandScope.registerArgument(new org.panda_lang.light.core.element.argument.ArgumentInitializer<BukkitCommandInfo>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, BukkitCommandInfo bukkitCommandInfo) {
                return bukkitCommandInfo.getCommandSender();
            }
        }, "player", "command sender");
        lightCore.registerScope(commandScope);
    }

}
