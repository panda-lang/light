package net.dzikoysk.moonlight;

import net.dzikoysk.moonlight.core.BukkitLoader;
import net.dzikoysk.moonlight.lang.BukkitBasis;
import org.panda_lang.moonlight.core.memory.Variables;

import java.io.File;

public class MoonlightInitializer implements Runnable {

    private final Moonlight moonlight;

    public MoonlightInitializer(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void run() {
        BukkitBasis bukkitBasis = new BukkitBasis(moonlight);
        bukkitBasis.registerBukkitElements();

        Variables variables = moonlight.getMoonlightCore().getVariables();
        File variablesFile = new File(moonlight.getDataFolder(), "variables.db");
        variables.getFollowed().getStorage().initializeDatabase(variablesFile);
        variables.load();

        File scriptsDirectory = new File("scripts");
        BukkitLoader bukkitLoader = new BukkitLoader(scriptsDirectory);
        bukkitLoader.load();


    }

    public Moonlight getMoonlight() {
        return moonlight;
    }

}
