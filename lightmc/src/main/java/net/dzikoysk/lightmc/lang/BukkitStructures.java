package net.dzikoysk.lightmc.lang;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.lang.structure.*;
import net.dzikoysk.lightmc.util.BukkitElements;
import org.panda_lang.light.LightCore;

public class BukkitStructures implements BukkitElements {

    private final Light light;
    private final LightCore lightCore;

    public BukkitStructures(Light light) {
        this.light = light;
        this.lightCore = light.getLightCore();
    }

    @Override
    public void registerBukkitElements() {
        BlockStructure blockStructure = new BlockStructure();
        lightCore.registerStructure(blockStructure);

        BukkitStructure bukkitStructure = new BukkitStructure();
        lightCore.registerStructure(bukkitStructure);

        EntityStructure entityStructure = new EntityStructure();
        lightCore.registerStructure(entityStructure);

        InventoryStructure inventoryStructure = new InventoryStructure();
        lightCore.registerStructure(inventoryStructure);

        ItemStackStructure itemStackStructure = new ItemStackStructure();
        lightCore.registerStructure(itemStackStructure);

        LocationStructure locationStructure = new LocationStructure();
        lightCore.registerStructure(locationStructure);

        MaterialStructure materialStructure = new MaterialStructure();
        lightCore.registerStructure(materialStructure);

        PlayerStructure playerStructure = new PlayerStructure();
        lightCore.registerStructure(playerStructure);

        VectorStructure vectorStructure = new VectorStructure();
        lightCore.registerStructure(vectorStructure);

        WorldStructure worldStructure = new WorldStructure();
        lightCore.registerStructure(worldStructure);
    }

}
