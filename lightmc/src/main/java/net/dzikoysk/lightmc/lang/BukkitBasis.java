package net.dzikoysk.lightmc.lang;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.util.BukkitElements;

public class BukkitBasis implements BukkitElements {

    private final Light light;

    public BukkitBasis(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        BukkitScopes bukkitScopes = new BukkitScopes(light);
        bukkitScopes.registerBukkitElements();

        BukkitEvents bukkitEvents = new BukkitEvents(light);
        bukkitEvents.registerBukkitElements();

        BukkitStructures bukkitStructures = new BukkitStructures(light);
        bukkitStructures.registerBukkitElements();

        BukkitPhrases bukkitPhrases = new BukkitPhrases(light);
        bukkitPhrases.registerBukkitElements();
    }

}
