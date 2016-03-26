package net.dzikoysk.moonlight.util.metrics;

import net.dzikoysk.moonlight.Moonlight;
import org.bukkit.Bukkit;

public class MetricsCollector implements Runnable {

    private final Moonlight moonlight;
    private final Metrics metrics;

    public MetricsCollector(Moonlight moonlight) {
        this.moonlight = moonlight;
        this.metrics = new Metrics(moonlight);
    }

    public void start() {
        Bukkit.getScheduler().runTaskLaterAsynchronously(moonlight, this, 20L);
    }

    @Override
    public void run() {
        Metrics.Graph global = metrics.createGraph("Scripts");
        global.addPlotter(new Metrics.Plotter("Scripts") {
            @Override
            public int getValue() {
                return moonlight.getMoonlightCore().getScripts().size();
            }
        });
        metrics.start();
    }

}
