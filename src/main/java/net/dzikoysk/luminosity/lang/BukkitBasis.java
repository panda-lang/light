package net.dzikoysk.luminosity.lang;

import org.panda_lang.moonlight.MoonlightCore;

public class BukkitBasis {

    private final MoonlightCore moonlightCore;

    public BukkitBasis(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    public void registerDefaultElements() {
        BukkitStructures bukkitStructures = new BukkitStructures(moonlightCore);
        bukkitStructures.registerDefaultElements();
    }

    public MoonlightCore getLightPlugin() {
        return moonlightCore;
    }

}
