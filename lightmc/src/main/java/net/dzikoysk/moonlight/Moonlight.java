package net.dzikoysk.moonlight;

import net.dzikoysk.moonlight.core.command.BukkitCommandCenter;
import net.dzikoysk.moonlight.core.event.BukkitEventCenter;
import net.dzikoysk.moonlight.lang.BukkitBasis;
import net.dzikoysk.moonlight.util.metrics.MetricsCollector;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;

public class Moonlight extends JavaPlugin {

    private static Moonlight moonlight;
    private final MoonlightCore moonlightCore;
    private final MoonlightInitializer moonlightInitializer;

    private final BukkitEventCenter bukkitEventCenter;
    private final BukkitCommandCenter bukkitCommandCenter;

    public Moonlight() {
        this.moonlightCore = new MoonlightCore();
        this.moonlightInitializer = new MoonlightInitializer(this);

        this.bukkitEventCenter = new BukkitEventCenter(this);
        this.bukkitCommandCenter = new BukkitCommandCenter(this);
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
        moonlightCore.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        moonlightCore.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        moonlightCore.registerExpression(expressionRepresentation);
    }

    public ScopeUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        return bukkitEventCenter.registerEvent(eventClass, eventName);
    }

    @Override
    public void onDisable() {
        moonlightCore.getVariables().save();
    }

    public BukkitCommandCenter getBukkitCommandCenter() {
        return bukkitCommandCenter;
    }

    public BukkitEventCenter getBukkitEventCenter() {
        return bukkitEventCenter;
    }

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

    public static Moonlight getInstance() {
        return moonlight;
    }

}
