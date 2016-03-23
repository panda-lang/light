package net.dzikoysk.luminosity.util.metrics;

import net.dzikoysk.luminosity.Luminosity;
import org.bukkit.Bukkit;

public class MetricsCollector implements Runnable {

    private final Luminosity luminosity;
    private final Metrics metrics;

    public MetricsCollector(Luminosity luminosity) {
        this.luminosity = luminosity;
        this.metrics = new Metrics(luminosity);
    }

    public void start() {
        Bukkit.getScheduler().runTaskLaterAsynchronously(luminosity, this, 20L);
    }

    @Override
    public void run() {
        Metrics.Graph global = metrics.createGraph("Scripts");
        global.addPlotter(new Metrics.Plotter("Scripts") {
            @Override
            public int getValue() {
                return luminosity.getMoonlight().getScripts().size();
            }
        });
        metrics.start();
    }

}
