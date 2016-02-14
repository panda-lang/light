package net.dzikoysk.light;

import org.bukkit.plugin.java.JavaPlugin;
import org.panda_lang.light.Light;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;

public class LightPlugin extends JavaPlugin {

    private final Light light;

    public LightPlugin() {
        this.light = new Light();
    }

    @Override
    public void onEnable() {

    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        light.registerPhrase(phraseRepresentation);
    }

    public void registerExpression() {

    }

    public Light getLight() {
        return light;
    }

}
