package net.dzikoysk.luminosity;

import net.dzikoysk.luminosity.lang.BukkitBasis;
import org.panda_lang.moonlight.core.memory.Variables;

import java.io.File;

public class LuminosityInitializer implements Runnable {

    private final Luminosity luminosity;

    public LuminosityInitializer(Luminosity luminosity) {
        this.luminosity = luminosity;
    }

    @Override
    public void run() {
        BukkitBasis bukkitBasis = new BukkitBasis(luminosity.getMoonlight().getMoonlightCore());
        bukkitBasis.registerDefaultElements();

        Variables variables = luminosity.getMoonlight().getMoonlightCore().getVariables();
        File variablesFile = new File(luminosity.getDataFolder(), "variables.db");
        variables.getFollowed().getStorage().initializeDatabase(variablesFile);
        variables.load();

        File scriptsDirectory = new File("scripts");
        LuminosityLoader luminosityLoader = new LuminosityLoader(scriptsDirectory);
        luminosityLoader.load();


    }

    public Luminosity getLuminosity() {
        return luminosity;
    }

}
