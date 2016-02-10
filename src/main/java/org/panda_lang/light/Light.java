package org.panda_lang.light;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.block.CommandBlock;
import org.panda_lang.light.core.block.EventBlock;
import org.panda_lang.light.core.parser.util.PhraseRepresentation;
import org.panda_lang.light.core.block.CommandsCollector;
import org.panda_lang.light.core.block.EventsCollector;
import org.panda_lang.panda.Panda;

public class Light {

    private final Panda panda;
    private final LightCore lightCore;
    private final LightLoader lightLoader;

    private final EventsCollector eventsCollector;
    private final CommandsCollector commandsCollector;

    public Light() {
        this.panda = new Panda();
        this.lightCore = new LightCore(panda, this);
        this.lightLoader = new LightLoader(lightCore);

        this.eventsCollector = new EventsCollector();
        this.commandsCollector = new CommandsCollector();
    }

    public void registerPhrase(PhraseRepresentation phrase) {
        lightCore.registerPhrase(phrase);
    }

    public void registerEvent(EventBlock eventBlock) {

    }

    public void registerCommand(CommandBlock commandBlock) {

    }

    public void initializeDefaultElements() {
        this.lightCore.initialize();
    }

    public CommandsCollector getCommandsCollector() {
        return commandsCollector;
    }

    public EventsCollector getEventsCollector() {
        return eventsCollector;
    }

    public LightBasis getLightBasis() {
        return new LightBasis(this);
    }

    public LightLoader getLightLoader() {
        return lightLoader;
    }

    public LightCore getLightCore() {
        return lightCore;
    }

    public Panda getPanda() {
        return panda;
    }

}
