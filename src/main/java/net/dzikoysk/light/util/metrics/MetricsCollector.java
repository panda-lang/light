package net.dzikoysk.light.util.metrics;

import net.dzikoysk.light.LightPlugin;
import org.bukkit.Bukkit;

public class MetricsCollector implements Runnable {

    private final LightPlugin lightPlugin;
    private final Metrics metrics;

    public MetricsCollector(LightPlugin lightPlugin) {
        this.lightPlugin = lightPlugin;
        this.metrics = new Metrics(lightPlugin);
    }

    public void start() {
        Bukkit.getScheduler().runTaskLaterAsynchronously(lightPlugin, this, 20L);
    }

    @Override
    public void run() {
        Metrics.Graph global = metrics.createGraph("Scripts");
        global.addPlotter(new Metrics.Plotter("Scripts") {
            @Override
            public int getValue() {
                return lightPlugin.getLight().getScripts().size();
            }
        });
        metrics.start();
    }

}
