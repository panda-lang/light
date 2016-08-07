package net.dzikoysk.lightmc;

import net.dzikoysk.lightmc.core.command.BukkitCommandCenter;
import net.dzikoysk.lightmc.util.metrics.MetricsCollector;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Light extends JavaPlugin {

    private static Light light;
    private final LightInitializer lightInitializer;

    private final BukkitCommandCenter bukkitCommandCenter;

    public Light() {
        this.lightInitializer = new LightInitializer(this);
        this.bukkitCommandCenter = new BukkitCommandCenter(this);
    }

    @Override
    public void onLoad() {
        light = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, lightInitializer);

        MetricsCollector metricsCollector = new MetricsCollector(this);
        metricsCollector.start();
    }

    @Override
    public void onDisable() {
    }

    public BukkitCommandCenter getBukkitCommandCenter() {
        return bukkitCommandCenter;
    }

    public static Light getInstance() {
        return light;
    }

}
