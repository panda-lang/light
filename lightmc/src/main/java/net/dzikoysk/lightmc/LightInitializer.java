package net.dzikoysk.lightmc;

import net.dzikoysk.lightmc.core.BukkitLoader;
import net.dzikoysk.lightmc.core.command.BukkitCommandCenter;
import net.dzikoysk.lightmc.core.event.BukkitEventCenter;
import org.panda_lang.light.LightCore;
import org.panda_lang.light.LightScript;

import java.io.File;
import java.util.Collection;

public class LightInitializer implements Runnable {

    private final Light light;

    public LightInitializer(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        LightCore lightCore = light.getLightCore();

        org.panda_lang.light.core.memory.Variables variables = lightCore.getVariables();
        File variablesFile = new File(light.getDataFolder(), "variables.db");
        variables.getFollowed().getStorage().initializeDatabase(variablesFile);
        variables.load();

        File scriptsDirectory = new File("scripts");
        BukkitLoader bukkitLoader = new BukkitLoader(light, scriptsDirectory);
        bukkitLoader.load();

        BukkitEventCenter bukkitEventCenter = light.getBukkitEventCenter();
        bukkitEventCenter.registerListeners();

        BukkitCommandCenter bukkitCommandCenter = light.getBukkitCommandCenter();
        bukkitCommandCenter.registerCommands();

        Collection<LightScript> lightScripts = lightCore.getScripts();
        for (LightScript lightScript : lightScripts) {
            lightScript.callEvent("load", null);
        }
    }

    public Light getLight() {
        return light;
    }

}
