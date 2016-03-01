package net.dzikoysk.light.lang;

import org.panda_lang.light.LightCore;

public class BukkitBasis {

    private final LightCore lightCore;

    public BukkitBasis(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultElements() {
        BukkitStructures bukkitStructures = new BukkitStructures(lightCore);
        bukkitStructures.registerDefaultElements();
    }

    public LightCore getLightPlugin() {
        return lightCore;
    }

}
