package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;
import org.panda_lang.moonlight.core.memory.Variables;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.ParserLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Moonlight {

    private final Panda panda;
    private final MoonlightCore moonlightCore;
    private final MoonlightLoader moonlightLoader;
    private final Collection<MoonlightScript> scripts;

    public Moonlight() {
        this.panda = new Panda();
        this.moonlightCore = new MoonlightCore(panda, this);
        this.moonlightLoader = new MoonlightLoader(moonlightCore);
        this.scripts = new ArrayList<>();
    }

    public static void main(String[] args) {
        Moonlight moonlight = new Moonlight();
        moonlight.initializeDefaultElements();

        Variables variables = moonlight.getMoonlightCore().getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File script = new File(args[0]);
        MoonlightScript moonlightScript = moonlight.getMoonlightLoader().load(script);

        moonlightScript.callEvent("load", null);
        moonlight.getMoonlightCore().getVariables().save();
    }

    public void registerScript(MoonlightScript moonlightScript) {
        scripts.add(moonlightScript);
    }

    public void registerParser(ParserLayout parserLayout) {
        panda.getPandaCore().registerParser(parserLayout);
    }

    public void registerScope(ScopeRepresentation scopeRepresentation) {
        moonlightCore.registerScope(scopeRepresentation);
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        moonlightCore.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        moonlightCore.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        moonlightCore.registerExpression(expressionRepresentation);
    }

    public void registerStructure(Structure structure) {
        moonlightCore.registerStructure(structure);
    }

    public void initializeDefaultElements() {
        this.moonlightCore.initialize();
    }

    public MoonlightBasis getLightBasis() {
        return new MoonlightBasis(this);
    }

    public Collection<MoonlightScript> getScripts() {
        return scripts;
    }

    public MoonlightLoader getMoonlightLoader() {
        return moonlightLoader;
    }

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

    public Panda getPanda() {
        return panda;
    }

}
