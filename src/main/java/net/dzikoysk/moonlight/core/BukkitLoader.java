package net.dzikoysk.moonlight.core;

import net.dzikoysk.moonlight.Moonlight;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.MoonlightLoader;
import org.panda_lang.moonlight.MoonlightScript;

import java.io.File;

public class BukkitLoader {

    private final Moonlight moonlight;
    private final File directory;

    public BukkitLoader(Moonlight moonlight, File directory) {
        this.moonlight = moonlight;
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

        MoonlightCore moonlightCore = moonlight.getMoonlightCore();
        MoonlightLoader moonlightLoader = moonlightCore.getMoonlightLoader();

        for (File file : files) {
            MoonlightScript moonlightScript = moonlightLoader.load(file);
            moonlightCore.registerScript(moonlightScript);
        }
    }

    public File getDirectory() {
        return directory;
    }

}
