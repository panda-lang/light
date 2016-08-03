package net.dzikoysk.moonlight.lang.event;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.bukkit.event.server.*;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;

public class ServerEvents implements BukkitElements {

    private final Moonlight moonlight;

    public ServerEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        ScopeUnit mapInitializeScopeUnit = moonlight.registerEvent(MapInitializeEvent.class, "map initialize");
        mapInitializeScopeUnit.registerArgument("map", new ArgumentInitializer<MapInitializeEvent>() {
            @Override
            public Object get(Ray ray, MapInitializeEvent event) {
                return event.getMap();
            }
        });
        mapInitializeScopeUnit.registerArgument("event name", new ArgumentInitializer<MapInitializeEvent>() {
            @Override
            public Object get(Ray ray, MapInitializeEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit serviceUnregisterScopeUnit = moonlight.registerEvent(ServiceUnregisterEvent.class, "service unregister");
        serviceUnregisterScopeUnit.registerArgument("provider", new ArgumentInitializer<ServiceUnregisterEvent>() {
            @Override
            public Object get(Ray ray, ServiceUnregisterEvent event) {
                return event.getProvider();
            }
        });
        serviceUnregisterScopeUnit.registerArgument("event name", new ArgumentInitializer<ServiceUnregisterEvent>() {
            @Override
            public Object get(Ray ray, ServiceUnregisterEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit remoteServerCommandScopeUnit = moonlight.registerEvent(RemoteServerCommandEvent.class, "remote server command");
        remoteServerCommandScopeUnit.registerArgument("sender", new ArgumentInitializer<RemoteServerCommandEvent>() {
            @Override
            public Object get(Ray ray, RemoteServerCommandEvent event) {
                return event.getSender();
            }
        });
        remoteServerCommandScopeUnit.registerArgument("event name", new ArgumentInitializer<RemoteServerCommandEvent>() {
            @Override
            public Object get(Ray ray, RemoteServerCommandEvent event) {
                return event.getEventName();
            }
        });
        remoteServerCommandScopeUnit.registerArgument("command", new ArgumentInitializer<RemoteServerCommandEvent>() {
            @Override
            public Object get(Ray ray, RemoteServerCommandEvent event) {
                return event.getCommand();
            }
        });

        ScopeUnit serverListPingScopeUnit = moonlight.registerEvent(ServerListPingEvent.class, "server list ping");
        serverListPingScopeUnit.registerArgument("address", new ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(Ray ray, ServerListPingEvent event) {
                return event.getAddress();
            }
        });
        serverListPingScopeUnit.registerArgument("event name", new ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(Ray ray, ServerListPingEvent event) {
                return event.getEventName();
            }
        });
        serverListPingScopeUnit.registerArgument("num players", new ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(Ray ray, ServerListPingEvent event) {
                return event.getNumPlayers();
            }
        });
        serverListPingScopeUnit.registerArgument("max players", new ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(Ray ray, ServerListPingEvent event) {
                return event.getMaxPlayers();
            }
        });
        serverListPingScopeUnit.registerArgument("motd", new ArgumentInitializer<ServerListPingEvent>() {
            @Override
            public Object get(Ray ray, ServerListPingEvent event) {
                return event.getMotd();
            }
        });

        ScopeUnit serverScopeUnit = moonlight.registerEvent(ServerEvent.class, "server");
        serverScopeUnit.registerArgument("event name", new ArgumentInitializer<ServerEvent>() {
            @Override
            public Object get(Ray ray, ServerEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit serviceRegisterScopeUnit = moonlight.registerEvent(ServiceRegisterEvent.class, "service register");
        serviceRegisterScopeUnit.registerArgument("provider", new ArgumentInitializer<ServiceRegisterEvent>() {
            @Override
            public Object get(Ray ray, ServiceRegisterEvent event) {
                return event.getProvider();
            }
        });
        serviceRegisterScopeUnit.registerArgument("event name", new ArgumentInitializer<ServiceRegisterEvent>() {
            @Override
            public Object get(Ray ray, ServiceRegisterEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit serverCommandScopeUnit = moonlight.registerEvent(ServerCommandEvent.class, "server command");
        serverCommandScopeUnit.registerArgument("command", new ArgumentInitializer<ServerCommandEvent>() {
            @Override
            public Object get(Ray ray, ServerCommandEvent event) {
                return event.getCommand();
            }
        });
        serverCommandScopeUnit.registerArgument("sender", new ArgumentInitializer<ServerCommandEvent>() {
            @Override
            public Object get(Ray ray, ServerCommandEvent event) {
                return event.getSender();
            }
        });
        serverCommandScopeUnit.registerArgument("event name", new ArgumentInitializer<ServerCommandEvent>() {
            @Override
            public Object get(Ray ray, ServerCommandEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit serviceScopeUnit = moonlight.registerEvent(ServiceEvent.class, "service");
        serviceScopeUnit.registerArgument("provider", new ArgumentInitializer<ServiceEvent>() {
            @Override
            public Object get(Ray ray, ServiceEvent event) {
                return event.getProvider();
            }
        });
        serviceScopeUnit.registerArgument("event name", new ArgumentInitializer<ServiceEvent>() {
            @Override
            public Object get(Ray ray, ServiceEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit pluginEnableScopeUnit = moonlight.registerEvent(PluginEnableEvent.class, "plugin enable");
        pluginEnableScopeUnit.registerArgument("plugin", new ArgumentInitializer<PluginEnableEvent>() {
            @Override
            public Object get(Ray ray, PluginEnableEvent event) {
                return event.getPlugin();
            }
        });
        pluginEnableScopeUnit.registerArgument("event name", new ArgumentInitializer<PluginEnableEvent>() {
            @Override
            public Object get(Ray ray, PluginEnableEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit pluginDisableScopeUnit = moonlight.registerEvent(PluginDisableEvent.class, "plugin disable");
        pluginDisableScopeUnit.registerArgument("plugin", new ArgumentInitializer<PluginDisableEvent>() {
            @Override
            public Object get(Ray ray, PluginDisableEvent event) {
                return event.getPlugin();
            }
        });
        pluginDisableScopeUnit.registerArgument("event name", new ArgumentInitializer<PluginDisableEvent>() {
            @Override
            public Object get(Ray ray, PluginDisableEvent event) {
                return event.getEventName();
            }
        });

        ScopeUnit pluginScopeUnit = moonlight.registerEvent(PluginEvent.class, "plugin");
        pluginScopeUnit.registerArgument("plugin", new ArgumentInitializer<PluginEvent>() {
            @Override
            public Object get(Ray ray, PluginEvent event) {
                return event.getPlugin();
            }
        });
        pluginScopeUnit.registerArgument("event name", new ArgumentInitializer<PluginEvent>() {
            @Override
            public Object get(Ray ray, PluginEvent event) {
                return event.getEventName();
            }
        });


    }

}
