package net.dzikoysk.lightmc.lang.event;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.bukkit.event.server.*;

public class ServerEvents implements BukkitElements {

    private final Light light;

    public ServerEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.scope.ScopeUnit mapInitializeScopeUnit = light.registerEvent(MapInitializeEvent.class, "map initialize");
        mapInitializeScopeUnit.registerArgument("map", new org.panda_lang.light.core.element.argument.ArgumentInitializer<MapInitializeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, MapInitializeEvent event) {
                return event.getMap();
            }
        });
        mapInitializeScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<MapInitializeEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, MapInitializeEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit serviceUnregisterScopeUnit = light.registerEvent(ServiceUnregisterEvent.class, "service unregister");
        serviceUnregisterScopeUnit.registerArgument("provider", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServiceUnregisterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServiceUnregisterEvent event) {
                return event.getProvider();
            }
        });
        serviceUnregisterScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServiceUnregisterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServiceUnregisterEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit remoteServerCommandScopeUnit = light.registerEvent(RemoteServerCommandEvent.class, "remote server command");
        remoteServerCommandScopeUnit.registerArgument("sender", new org.panda_lang.light.core.element.argument.ArgumentInitializer<RemoteServerCommandEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, RemoteServerCommandEvent event) {
                return event.getSender();
            }
        });
        remoteServerCommandScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<RemoteServerCommandEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, RemoteServerCommandEvent event) {
                return event.getEventName();
            }
        });
        remoteServerCommandScopeUnit.registerArgument("command", new org.panda_lang.light.core.element.argument.ArgumentInitializer<RemoteServerCommandEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, RemoteServerCommandEvent event) {
                return event.getCommand();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit serverListPingScopeUnit = light.registerEvent(ServerListPingEvent.class, "server list ping");
        serverListPingScopeUnit.registerArgument("address", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerListPingEvent event) {
                return event.getAddress();
            }
        });
        serverListPingScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerListPingEvent event) {
                return event.getEventName();
            }
        });
        serverListPingScopeUnit.registerArgument("num players", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerListPingEvent event) {
                return event.getNumPlayers();
            }
        });
        serverListPingScopeUnit.registerArgument("max players", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerListPingEvent event) {
                return event.getMaxPlayers();
            }
        });
        serverListPingScopeUnit.registerArgument("motd", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerListPingEvent event) {
                return event.getMotd();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit serverScopeUnit = light.registerEvent(ServerEvent.class, "server");
        serverScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit serviceRegisterScopeUnit = light.registerEvent(ServiceRegisterEvent.class, "service register");
        serviceRegisterScopeUnit.registerArgument("provider", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServiceRegisterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServiceRegisterEvent event) {
                return event.getProvider();
            }
        });
        serviceRegisterScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServiceRegisterEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServiceRegisterEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit serverCommandScopeUnit = light.registerEvent(ServerCommandEvent.class, "server command");
        serverCommandScopeUnit.registerArgument("command", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerCommandEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerCommandEvent event) {
                return event.getCommand();
            }
        });
        serverCommandScopeUnit.registerArgument("sender", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerCommandEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerCommandEvent event) {
                return event.getSender();
            }
        });
        serverCommandScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServerCommandEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServerCommandEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit serviceScopeUnit = light.registerEvent(ServiceEvent.class, "service");
        serviceScopeUnit.registerArgument("provider", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServiceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServiceEvent event) {
                return event.getProvider();
            }
        });
        serviceScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<ServiceEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, ServiceEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit pluginEnableScopeUnit = light.registerEvent(PluginEnableEvent.class, "plugin enable");
        pluginEnableScopeUnit.registerArgument("plugin", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PluginEnableEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PluginEnableEvent event) {
                return event.getPlugin();
            }
        });
        pluginEnableScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PluginEnableEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PluginEnableEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit pluginDisableScopeUnit = light.registerEvent(PluginDisableEvent.class, "plugin disable");
        pluginDisableScopeUnit.registerArgument("plugin", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PluginDisableEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PluginDisableEvent event) {
                return event.getPlugin();
            }
        });
        pluginDisableScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PluginDisableEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PluginDisableEvent event) {
                return event.getEventName();
            }
        });

        org.panda_lang.light.core.element.scope.ScopeUnit pluginScopeUnit = light.registerEvent(PluginEvent.class, "plugin");
        pluginScopeUnit.registerArgument("plugin", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PluginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PluginEvent event) {
                return event.getPlugin();
            }
        });
        pluginScopeUnit.registerArgument("event name", new org.panda_lang.light.core.element.argument.ArgumentInitializer<PluginEvent>() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, PluginEvent event) {
                return event.getEventName();
            }
        });


    }

}
