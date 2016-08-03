package net.dzikoysk.lightmc.lang;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.lang.event.*;
import net.dzikoysk.lightmc.util.BukkitElements;

public class BukkitEvents implements BukkitElements {

    private final Light light;

    public BukkitEvents(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        BlockEvents blockEvents = new BlockEvents(light);
        blockEvents.registerBukkitElements();

        EnchantmentEvents enchantmentEvents = new EnchantmentEvents(light);
        enchantmentEvents.registerBukkitElements();

        EntityEvents entityEvents = new EntityEvents(light);
        entityEvents.registerBukkitElements();

        HangingEvents hangingEvents = new HangingEvents(light);
        hangingEvents.registerBukkitElements();

        InventoryEvents inventoryEvents = new InventoryEvents(light);
        inventoryEvents.registerBukkitElements();

        PlayerEvents playerEvents = new PlayerEvents(light);
        playerEvents.registerBukkitElements();

        ServerEvents serverEvents = new ServerEvents(light);
        serverEvents.registerBukkitElements();

        VehicleEvents vehicleEvents = new VehicleEvents(light);
        vehicleEvents.registerBukkitElements();

        WeatherEvents weatherEvents = new WeatherEvents(light);
        weatherEvents.registerBukkitElements();

        WorldEvents worldEvents = new WorldEvents(light);
        worldEvents.registerBukkitElements();
    }

}
