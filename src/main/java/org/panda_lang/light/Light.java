package org.panda_lang.light;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.block.*;
import org.panda_lang.light.core.parser.util.PhraseRepresentation;
import org.panda_lang.panda.Panda;

public class Light {

    private final Panda panda;
    private final LightCore lightCore;
    private final LightLoader lightLoader;

    private final EventsCollector eventsCollector;
    private final CommandsCollector commandsCollector;
    private final FunctionsCollector functionsCollector;

    public Light() {
        this.panda = new Panda();
        this.lightCore = new LightCore(panda, this);
        this.lightLoader = new LightLoader(lightCore);

        this.eventsCollector = new EventsCollector();
        this.commandsCollector = new CommandsCollector();
        this.functionsCollector = new FunctionsCollector();
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

    public FunctionsCollector getFunctionsCollector() {
        return functionsCollector;
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
