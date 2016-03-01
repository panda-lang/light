package net.dzikoysk.light.lang;

import net.dzikoysk.light.lang.structure.PlayerStructure;
import org.panda_lang.light.LightCore;

public class BukkitStructures {

    private final LightCore lightCore;

    public BukkitStructures(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultElements() {
        PlayerStructure playerStructure = new PlayerStructure();
        lightCore.registerStructure(playerStructure);
    }

}
