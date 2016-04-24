package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.lang.structure.*;
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
        BlockStructure blockStructure = new BlockStructure();
        moonlightCore.registerStructure(blockStructure);

        BukkitStructure bukkitStructure = new BukkitStructure();
        moonlightCore.registerStructure(bukkitStructure);

        EntityStructure entityStructure = new EntityStructure();
        moonlightCore.registerStructure(entityStructure);

        InventoryStructure inventoryStructure = new InventoryStructure();
        moonlightCore.registerStructure(inventoryStructure);

        ItemStackStructure itemStackStructure = new ItemStackStructure();
        moonlightCore.registerStructure(itemStackStructure);

        LocationStructure locationStructure = new LocationStructure();
        moonlightCore.registerStructure(locationStructure);

        MaterialStructure materialStructure = new MaterialStructure();
        moonlightCore.registerStructure(materialStructure);

        PlayerStructure playerStructure = new PlayerStructure();
        moonlightCore.registerStructure(playerStructure);

        VectorStructure vectorStructure = new VectorStructure();
        moonlightCore.registerStructure(vectorStructure);

        WorldStructure worldStructure = new WorldStructure();
        moonlightCore.registerStructure(worldStructure);
    }

}
