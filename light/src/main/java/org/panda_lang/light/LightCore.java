package org.panda_lang.light;

import org.panda_lang.light.lang.*;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.ParserLayout;

import java.util.ArrayList;
import java.util.Collection;

public class LightCore {

    private final Panda panda;
    private final LightLoader lightLoader;
    private final Collection<LightScript> scripts;
    private final org.panda_lang.light.core.memory.Variables variables;

    private final org.panda_lang.light.core.element.scope.ScopeCenter scopeCenter;

    private final org.panda_lang.light.core.element.type.TypeCenter typeCenter;
    private final org.panda_lang.light.core.element.phrase.PhraseCenter phraseCenter;
    private final org.panda_lang.light.core.element.expression.ExpressionCenter expressionCenter;
    private final org.panda_lang.light.lang.scope.event.EventCenter eventCenter;

    public LightCore() {
        this.panda = new Panda();
        this.lightLoader = new LightLoader(this);
        this.scripts = new ArrayList<>();

        this.scopeCenter = new org.panda_lang.light.core.element.scope.ScopeCenter(this);

        this.typeCenter = new org.panda_lang.light.core.element.type.TypeCenter();
        this.phraseCenter = new org.panda_lang.light.core.element.phrase.PhraseCenter();
        this.expressionCenter = new org.panda_lang.light.core.element.expression.ExpressionCenter();
        this.eventCenter = new org.panda_lang.light.lang.scope.event.EventCenter();

        this.variables = new org.panda_lang.light.core.memory.Variables(this);
    }

    protected void initialize() {
        LightBasis lightBasis = getLightBasis();
        lightBasis.loadParsers();

        Scopes scopes = new Scopes(this);
        scopes.registerDefaultElements();

        Arguments arguments = new Arguments(this);
        arguments.registerDefaultElements();

        Types types = new Types(this);
        types.registerDefaultElements();

        Expressions expressions = new Expressions(this);
        expressions.registerDefaultElements();

        Phrases phrases = new Phrases(this);
        phrases.registerDefaultElements();
    }

    public void registerScript(LightScript lightScript) {
        scripts.add(lightScript);
    }

    public void registerParser(ParserLayout parserLayout) {
        panda.getPandaCore().registerParser(parserLayout);
    }

    public void registerScope(org.panda_lang.light.core.element.scope.ScopeRepresentation scopeRepresentation) {
        scopeCenter.registerElement(scopeRepresentation);
    }

    public void registerType(org.panda_lang.light.core.element.type.TypeRepresentation typeRepresentation) {
        typeCenter.registerType(typeRepresentation);
    }

    public void registerPhrase(org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation) {
        phraseCenter.registerElement(phraseRepresentation);
    }

    public void registerExpression(org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation) {
        expressionCenter.registerElement(expressionRepresentation);
    }

    public void registerStructure(org.panda_lang.light.core.element.Structure structure) {
        structure.initialize(this);
        structure.registerRepresentations(this);
    }

    public void initializeDefaultElements() {
        initialize();
    }

    public org.panda_lang.light.lang.scope.event.EventCenter getEventCenter() {
        return eventCenter;
    }

    public org.panda_lang.light.core.element.expression.ExpressionCenter getExpressionCenter() {
        return expressionCenter;
    }

    public org.panda_lang.light.core.element.phrase.PhraseCenter getPhraseCenter() {
        return phraseCenter;
    }

    public org.panda_lang.light.core.element.scope.ScopeCenter getScopeCenter() {
        return scopeCenter;
    }

    public org.panda_lang.light.core.element.type.TypeCenter getTypeCenter() {
        return typeCenter;
    }

    public org.panda_lang.light.core.memory.Variables getVariables() {
        return variables;
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

    public Panda getPanda() {
        return panda;
    }

}
