package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.lang.event.*;
import net.dzikoysk.moonlight.util.BukkitElements;

public class BukkitEvents implements BukkitElements {

    private final Moonlight moonlight;

    public BukkitEvents(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        BlockEvents blockEvents = new BlockEvents(moonlight);
        blockEvents.registerBukkitElements();

        EnchantmentEvents enchantmentEvents = new EnchantmentEvents(moonlight);
        enchantmentEvents.registerBukkitElements();

        EntityEvents entityEvents = new EntityEvents(moonlight);
        entityEvents.registerBukkitElements();

        HangingEvents hangingEvents = new HangingEvents(moonlight);
        hangingEvents.registerBukkitElements();

        InventoryEvents inventoryEvents = new InventoryEvents(moonlight);
        inventoryEvents.registerBukkitElements();

        PlayerEvents playerEvents = new PlayerEvents(moonlight);
        playerEvents.registerBukkitElements();

        ServerEvents serverEvents = new ServerEvents(moonlight);
        serverEvents.registerBukkitElements();

        VehicleEvents vehicleEvents = new VehicleEvents(moonlight);
        vehicleEvents.registerBukkitElements();

        WeatherEvents weatherEvents = new WeatherEvents(moonlight);
        weatherEvents.registerBukkitElements();

        WorldEvents worldEvents = new WorldEvents(moonlight);
        worldEvents.registerBukkitElements();
    }

}
