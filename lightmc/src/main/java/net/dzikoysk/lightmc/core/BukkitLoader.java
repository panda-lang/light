package net.dzikoysk.lightmc.core;

import net.dzikoysk.lightmc.Light;
import org.panda_lang.light.LightCore;

import java.io.File;

public class BukkitLoader {

    private final Light light;
    private final File directory;

    public BukkitLoader(Light light, File directory) {
        this.light = light;
        this.directory = directory;
    }

    public void load() {
        if (!directory.exists()) {
            directory.mkdir();
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        LightCore lightCore = light.getLightCore();
        LightLoader lightLoader = lightCore.getLightLoader();

        for (File file : files) {
            LightScript lightScript = lightLoader.load(file);
            lightCore.registerScript(lightScript);
        }
    }

    public File getDirectory() {
        return directory;
    }

}
