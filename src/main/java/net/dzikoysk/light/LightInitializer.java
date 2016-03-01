package net.dzikoysk.light;

import net.dzikoysk.light.lang.BukkitBasis;
import org.panda_lang.light.core.memory.Variables;

import java.io.File;

public class LightInitializer implements Runnable {

    private final LightPlugin lightPlugin;

    public LightInitializer(LightPlugin lightPlugin) {
        this.lightPlugin = lightPlugin;
    }

    @Override
    public void run() {
        BukkitBasis bukkitBasis = new BukkitBasis(lightPlugin.getLight().getLightCore());
        bukkitBasis.registerDefaultElements();

        Variables variables = lightPlugin.getLight().getLightCore().getVariables();
        File variablesFile = new File(lightPlugin.getDataFolder(), "variables.db");
        variables.getFollowed().getStorage().initializeDatabase(variablesFile);
        variables.load();

        File scriptsDirectory = new File("scripts");
        DefaultLoader defaultLoader = new DefaultLoader(scriptsDirectory);
        defaultLoader.load();
    }

    public LightPlugin getLightPlugin() {
        return lightPlugin;
    }

}
