package org.panda_lang.light;

import org.panda_lang.light.core.block.CommandsCollector;
import org.panda_lang.light.core.block.EventsCollector;
import org.panda_lang.light.core.block.FunctionsCollector;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;

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

    public void registerParser(ParserLayout parserLayout) {
        panda.getPandaCore().registerParser(parserLayout);
    }

    public void registerBlock(BlockLayout blockLayout) {
        panda.getPandaCore().registerBlock(blockLayout);
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        lightCore.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        lightCore.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        lightCore.registerExpression(expressionRepresentation);
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
