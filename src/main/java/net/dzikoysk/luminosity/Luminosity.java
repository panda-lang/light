package net.dzikoysk.luminosity;

import net.dzikoysk.luminosity.util.metrics.MetricsCollector;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.moonlight.Moonlight;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;

public class Luminosity extends JavaPlugin {

    private static Luminosity luminosity;
    private final Moonlight moonlight;

    public Luminosity() {
        luminosity = this;

        this.moonlight = new Moonlight();
    }

    @Override
    public void onEnable() {
        moonlight.initializeDefaultElements();
        moonlight.getMoonlightCore().getVariables().load();

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new LuminosityInitializer(this));

        MetricsCollector metricsCollector = new MetricsCollector(this);
        metricsCollector.start();
    }

    @Override
    public void onDisable() {
        moonlight.getMoonlightCore().getVariables().save();
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        moonlight.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        moonlight.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        moonlight.registerExpression(expressionRepresentation);
    }

    public void registerEvent(Class<? extends Event> eventClass, String eventName) {

    }

    public Moonlight getMoonlight() {
        return moonlight;
    }

    public static Luminosity getInstance() {
        return luminosity;
    }

}
