package net.dzikoysk.light;

import net.dzikoysk.light.util.metrics.MetricsCollector;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.light.Light;
import org.panda_lang.light.core.element.expression.ExpressionRepresentation;
import org.panda_lang.light.core.element.phrase.PhraseRepresentation;
import org.panda_lang.light.core.element.type.TypeRepresentation;

public class LightPlugin extends JavaPlugin {

    private static LightPlugin lightPlugin;
    private final Light light;

    public LightPlugin() {
        lightPlugin = this;

        this.light = new Light();
    }

    public static LightPlugin getInstance() {
        return lightPlugin;
    }

    @Override
    public void onEnable() {
        light.initializeDefaultElements();
        light.getLightCore().getVariables().load();

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new LightInitializer(this));

        MetricsCollector metricsCollector = new MetricsCollector(this);
        metricsCollector.start();
    }

    @Override
    public void onDisable() {
        light.getLightCore().getVariables().save();
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        light.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        light.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        light.registerExpression(expressionRepresentation);
    }

    public Light getLight() {
        return light;
    }

}
