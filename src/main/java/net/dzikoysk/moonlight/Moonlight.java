package net.dzikoysk.moonlight;

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

    public Moonlight() {
        moonlight = this;
        moonlightCore = new MoonlightCore();
    }

    public static Moonlight getInstance() {
        return moonlight;
    }

    @Override
    public void onEnable() {
        moonlightCore.initializeDefaultElements();
        moonlightCore.getVariables().load();

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new MoonlightInitializer(this));

        MetricsCollector metricsCollector = new MetricsCollector(this);
        metricsCollector.start();
    }

    @Override
    public void onDisable() {
        moonlightCore.getVariables().save();
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

    public ScopeUnit registerEvent(Class<? extends Event> eventClass, String eventName) {
        ScopeUnit scopeUnit = new ScopeUnit();
        return scopeUnit;
    }

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

}
