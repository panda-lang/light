package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.lang.structure.PlayerStructure;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.panda_lang.moonlight.MoonlightCore;

public class BukkitStructures implements BukkitElements {

    private final Moonlight moonlight;
    private final MoonlightCore moonlightCore;

    public BukkitStructures(Moonlight moonlight) {
        this.moonlight = moonlight;
        this.moonlightCore = moonlight.getMoonlightCore();
    }

    @Override
    public void registerBukkitElements() {
        PlayerStructure playerStructure = new PlayerStructure();
        moonlightCore.registerStructure(playerStructure);
    }

}
