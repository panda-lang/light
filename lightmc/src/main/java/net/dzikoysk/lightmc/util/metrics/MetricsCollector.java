package net.dzikoysk.lightmc.util.metrics;

import net.dzikoysk.lightmc.Light;
import org.bukkit.Bukkit;

public class MetricsCollector implements Runnable {

    private final Light light;
    private final Metrics metrics;

    public MetricsCollector(Light light) {
        this.light = light;
        this.metrics = new Metrics(light);
    }

    public void start() {
        Bukkit.getScheduler().runTaskLaterAsynchronously(light, this, 20L);
    }

    @Override
    public void run() {
        Metrics.Graph global = metrics.createGraph("Scripts");
        global.addPlotter(new Metrics.Plotter("Scripts") {
            @Override
            public int getValue() {
                return light.getLightCore().getScripts().size();
            }
        });
        metrics.start();
    }

}
