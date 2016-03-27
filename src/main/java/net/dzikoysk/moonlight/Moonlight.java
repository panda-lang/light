package net.dzikoysk.moonlight;

import net.dzikoysk.moonlight.core.event.BukkitEventsCenter;
import net.dzikoysk.moonlight.lang.BukkitBasis;
import net.dzikoysk.moonlight.util.metrics.MetricsCollector;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.lang.scope.event.EventUnit;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;

public class Moonlight extends JavaPlugin {

    private static Moonlight moonlight;
    private final MoonlightCore moonlightCore;
    private final MoonlightInitializer moonlightInitializer;
    private final BukkitEventsCenter bukkitEventsCenter;

    public Moonlight() {
        this.moonlightCore = new MoonlightCore();
        this.moonlightInitializer = new MoonlightInitializer(this);
        this.bukkitEventsCenter = new BukkitEventsCenter();
    }

    @Override
    public void onLoad() {
        moonlight = this;
        moonlightCore.initializeDefaultElements();
    }

    @Override
    public void onEnable() {
        BukkitBasis bukkitBasis = new BukkitBasis(this);
        bukkitBasis.registerBukkitElements();

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, moonlightInitializer);

        MetricsCollector metricsCollector = new MetricsCollector(this);
        metricsCollector.start();
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

    public EventUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        return bukkitEventsCenter.registerEvent(eventClass, eventName);
    }

    @Override
    public void onDisable() {
        moonlightCore.getVariables().save();
    }

    public BukkitEventsCenter getBukkitEventsCenter() {
        return bukkitEventsCenter;
    }

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

    public static Moonlight getInstance() {
        return moonlight;
    }

}
