package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.lang.structure.PlayerStructure;
import org.panda_lang.moonlight.MoonlightCore;

public class BukkitStructures {

    private final MoonlightCore moonlightCore;

    public BukkitStructures(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    public void registerDefaultElements() {
        PlayerStructure playerStructure = new PlayerStructure();
        moonlightCore.registerStructure(playerStructure);
    }

}
