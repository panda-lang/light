package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.StructureCenter;
import org.panda_lang.moonlight.core.element.expression.ExpressionCenter;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseCenter;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.moonlight.core.element.type.TypeCenter;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;
import org.panda_lang.moonlight.core.memory.Variables;
import org.panda_lang.moonlight.lang.*;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.ParserLayout;

import java.util.ArrayList;
import java.util.Collection;

public class MoonlightCore {

    private final Panda panda;
    private final MoonlightLoader moonlightLoader;
    private final Collection<MoonlightScript> scripts;

    private final Variables variables;
    private final TypeCenter typeCenter;
    private final PhraseCenter phraseCenter;
    private final ExpressionCenter expressionCenter;
    private final StructureCenter structureCenter;

    public MoonlightCore() {
        this.panda = new Panda();
        this.moonlightLoader = new MoonlightLoader(this);
        this.scripts = new ArrayList<>();

        this.typeCenter = new TypeCenter();
        this.phraseCenter = new PhraseCenter();
        this.expressionCenter = new ExpressionCenter();
        this.structureCenter = new StructureCenter();

        this.variables = new Variables(this);
    }

    protected void initialize() {
        MoonlightBasis moonlightBasis = getMoonlightBasis();
        moonlightBasis.loadParsers();

        Scopes scopes = new Scopes(this);
        scopes.registerDefaultElements();

        Arguments arguments = new Arguments(this);
        arguments.registerDefaultElements();

        Types types = new Types(this);
        types.registerDefaultTypes();

        Expressions expressions = new Expressions(this);
        expressions.registerDefaultExpressions();

        Phrases phrases = new Phrases(this);
        phrases.registerDefaultPhrases();
    }

    public void registerScript(MoonlightScript moonlightScript) {
        scripts.add(moonlightScript);
    }

    public void registerParser(ParserLayout parserLayout) {
        panda.getPandaCore().registerParser(parserLayout);
    }

    public void registerScope(ScopeRepresentation scopeRepresentation) {
        panda.getPandaCore().registerBlock(scopeRepresentation.getBlockLayout());
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        typeCenter.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        phraseCenter.registerElement(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        expressionCenter.registerElement(expressionRepresentation);
    }

    public void registerStructure(Structure structure) {
        structureCenter.registerElement(structure);
        structure.initialize(this);
    }

    public void initializeDefaultElements() {
        initialize();
    }

    public StructureCenter getStructureCenter() {
        return structureCenter;
    }

    public ExpressionCenter getExpressionCenter() {
        return expressionCenter;
    }

    public PhraseCenter getPhraseCenter() {
        return phraseCenter;
    }

    public TypeCenter getTypeCenter() {
        return typeCenter;
    }

    public Variables getVariables() {
        return variables;
    }

    public MoonlightBasis getMoonlightBasis() {
        return new MoonlightBasis(this);
    }

    public Collection<MoonlightScript> getScripts() {
        return scripts;
    }

    public MoonlightLoader getMoonlightLoader() {
        return moonlightLoader;
    }

    public Panda getPanda() {
        return panda;
    }

}
