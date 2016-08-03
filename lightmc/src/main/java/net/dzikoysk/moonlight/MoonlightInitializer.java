package net.dzikoysk.moonlight;

import net.dzikoysk.moonlight.core.BukkitLoader;
import net.dzikoysk.moonlight.core.command.BukkitCommandCenter;
import net.dzikoysk.moonlight.core.event.BukkitEventCenter;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.memory.Variables;

import java.io.File;
import java.util.Collection;

public class MoonlightInitializer implements Runnable {

    private final Moonlight moonlight;

    public MoonlightInitializer(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void run() {
        MoonlightCore moonlightCore = moonlight.getMoonlightCore();

        Variables variables = moonlightCore.getVariables();
        File variablesFile = new File(moonlight.getDataFolder(), "variables.db");
        variables.getFollowed().getStorage().initializeDatabase(variablesFile);
        variables.load();

        File scriptsDirectory = new File("scripts");
        BukkitLoader bukkitLoader = new BukkitLoader(moonlight, scriptsDirectory);
        bukkitLoader.load();

        BukkitEventCenter bukkitEventCenter = moonlight.getBukkitEventCenter();
        bukkitEventCenter.registerListeners();

        BukkitCommandCenter bukkitCommandCenter = moonlight.getBukkitCommandCenter();
        bukkitCommandCenter.registerCommands();

        Collection<MoonlightScript> moonlightScripts = moonlightCore.getScripts();
        for (MoonlightScript moonlightScript : moonlightScripts) {
            moonlightScript.callEvent("load", null);
        }
    }

    public Moonlight getMoonlight() {
        return moonlight;
    }

}
