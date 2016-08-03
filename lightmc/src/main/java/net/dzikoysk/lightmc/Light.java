package net.dzikoysk.lightmc;

import net.dzikoysk.lightmc.core.command.BukkitCommandCenter;
import net.dzikoysk.lightmc.core.event.BukkitEventCenter;
import net.dzikoysk.lightmc.lang.BukkitBasis;
import net.dzikoysk.lightmc.util.metrics.MetricsCollector;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.light.LightCore;

public class Light extends JavaPlugin {

    private static Light light;
    private final LightCore lightCore;
    private final LightInitializer lightInitializer;

    private final BukkitEventCenter bukkitEventCenter;
    private final BukkitCommandCenter bukkitCommandCenter;

    public Light() {
        this.lightCore = new LightCore();
        this.lightInitializer = new LightInitializer(this);

        this.bukkitEventCenter = new BukkitEventCenter(this);
        this.bukkitCommandCenter = new BukkitCommandCenter(this);
    }

    @Override
    public void onLoad() {
        light = this;
        lightCore.initializeDefaultElements();
    }

    @Override
    public void onEnable() {
        BukkitBasis bukkitBasis = new BukkitBasis(this);
        bukkitBasis.registerBukkitElements();

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, lightInitializer);

        MetricsCollector metricsCollector = new MetricsCollector(this);
        metricsCollector.start();
    }

    public void registerType(org.panda_lang.light.core.element.type.TypeRepresentation typeRepresentation) {
        lightCore.registerType(typeRepresentation);
    }

    public void registerPhrase(org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation) {
        lightCore.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation) {
        lightCore.registerExpression(expressionRepresentation);
    }

    public org.panda_lang.light.core.element.scope.ScopeUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        return bukkitEventCenter.registerEvent(eventClass, eventName);
    }

    @Override
    public void onDisable() {
        lightCore.getVariables().save();
    }

    public BukkitCommandCenter getBukkitCommandCenter() {
        return bukkitCommandCenter;
    }

    public BukkitEventCenter getBukkitEventCenter() {
        return bukkitEventCenter;
    }

    public LightCore getLightCore() {
        return lightCore;
    }

    public static Light getInstance() {
        return light;
    }

}
