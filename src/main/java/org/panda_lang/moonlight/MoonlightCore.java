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

public class MoonlightCore {

    private final Panda panda;
    private final Moonlight moonlight;
    private final Variables variables;
    private final TypeCenter typeCenter;
    private final PhraseCenter phraseCenter;
    private final ExpressionCenter expressionCenter;
    private final StructureCenter structureCenter;

    public MoonlightCore(Panda panda, Moonlight moonlight) {
        this.panda = panda;
        this.moonlight = moonlight;

        this.typeCenter = new TypeCenter();
        this.phraseCenter = new PhraseCenter();
        this.expressionCenter = new ExpressionCenter();
        this.structureCenter = new StructureCenter();

        this.variables = new Variables(this);
    }

    public void initialize() {
        MoonlightBasis moonlightBasis = moonlight.getLightBasis();
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

    public Moonlight getMoonlight() {
        return moonlight;
    }

    public Panda getPanda() {
        return panda;
    }

}
