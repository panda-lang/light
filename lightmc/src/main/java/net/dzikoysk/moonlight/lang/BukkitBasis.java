package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.util.BukkitElements;

public class BukkitBasis implements BukkitElements {

    private final Moonlight moonlight;

    public BukkitBasis(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        BukkitScopes bukkitScopes = new BukkitScopes(moonlight);
        bukkitScopes.registerBukkitElements();

        BukkitEvents bukkitEvents = new BukkitEvents(moonlight);
        bukkitEvents.registerBukkitElements();

        BukkitStructures bukkitStructures = new BukkitStructures(moonlight);
        bukkitStructures.registerBukkitElements();

        BukkitPhrases bukkitPhrases = new BukkitPhrases(moonlight);
        bukkitPhrases.registerBukkitElements();
    }

}
