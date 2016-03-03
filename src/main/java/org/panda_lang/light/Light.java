package org.panda_lang.light;

import org.panda_lang.light.core.element.Structure;
import org.panda_lang.light.lang.block.collector.CommandsCollector;
import org.panda_lang.light.lang.block.collector.EventsCollector;
import org.panda_lang.light.lang.block.collector.FunctionsCollector;
import org.panda_lang.light.core.memory.Variables;
import org.panda_lang.light.core.element.expression.ExpressionRepresentation;
import org.panda_lang.light.core.element.phrase.PhraseRepresentation;
import org.panda_lang.light.core.element.type.TypeRepresentation;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Light {

    private final Panda panda;
    private final LightCore lightCore;
    private final LightLoader lightLoader;
    private final Collection<LightScript> scripts;

    private final EventsCollector eventsCollector;
    private final CommandsCollector commandsCollector;
    private final FunctionsCollector functionsCollector;

    public Light() {
        this.panda = new Panda();
        this.lightCore = new LightCore(panda, this);
        this.lightLoader = new LightLoader(lightCore);
        this.scripts = new ArrayList<>();

        this.eventsCollector = new EventsCollector();
        this.commandsCollector = new CommandsCollector();
        this.functionsCollector = new FunctionsCollector();
    }

    public void registerScript(LightScript lightScript) {
        scripts.add(lightScript);
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

    public void registerStructure(Structure structure) {
        lightCore.registerStructure(structure);
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

    public Collection<LightScript> getScripts() {
        return scripts;
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


    public static void main(String[] args) {
        Light light = new Light();
        light.initializeDefaultElements();

        Variables variables = light.getLightCore().getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File script = new File(args[0]);
        LightScript lightScript = light.getLightLoader().load(script);

        lightScript.callEvent("load");
        light.getLightCore().getVariables().save();
    }

}
