package net.dzikoysk.light;

import net.dzikoysk.light.util.metrics.MetricsCollector;
import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.light.Light;
import org.panda_lang.light.core.memory.Variables;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;

import java.io.File;

public class LightPlugin extends JavaPlugin {

    private final Light light;

    public LightPlugin() {
        this.light = new Light();
    }

    @Override
    public void onEnable() {
        light.initializeDefaultElements();
        light.getLightCore().getVariables().load();

        Variables variables = light.getLightCore().getVariables();
        File file = new File(getDataFolder() + File.separator + "variables.db");
        variables.getFollowed().getStorage().initializeDatabase(file);
        variables.load();

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
