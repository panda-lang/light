package org.panda_lang.light;

import org.panda_lang.light.core.element.Structure;
import org.panda_lang.light.core.element.StructureCenter;
import org.panda_lang.light.core.element.expression.ExpressionCenter;
import org.panda_lang.light.core.element.expression.ExpressionRepresentation;
import org.panda_lang.light.core.element.phrase.PhraseCenter;
import org.panda_lang.light.core.element.phrase.PhraseRepresentation;
import org.panda_lang.light.core.element.type.TypeCenter;
import org.panda_lang.light.core.element.type.TypeRepresentation;
import org.panda_lang.light.core.memory.Variables;
import org.panda_lang.light.lang.Expressions;
import org.panda_lang.light.lang.Phrases;
import org.panda_lang.light.lang.Types;
import org.panda_lang.panda.Panda;

public class LightCore {

    private final Panda panda;
    private final Light light;
    private final Variables variables;
    private final TypeCenter typeCenter;
    private final PhraseCenter phraseCenter;
    private final ExpressionCenter expressionCenter;
    private final StructureCenter structureCenter;

    public LightCore(Panda panda, Light light) {
        this.panda = panda;
        this.light = light;

        this.typeCenter = new TypeCenter();
        this.phraseCenter = new PhraseCenter();
        this.expressionCenter = new ExpressionCenter();
        this.structureCenter = new StructureCenter();

        this.variables = new Variables(this);
    }

    public void initialize() {
        LightBasis lightBasis = light.getLightBasis();
        lightBasis.loadParsers();
        lightBasis.loadBlocks();

        Types types = new Types(this);
        types.registerDefaultTypes();

        Phrases phrases = new Phrases(this);
        phrases.registerDefaultPhrases();

        Expressions expressions = new Expressions(this);
        expressions.registerDefaultExpressions();
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

    public Light getLight() {
        return light;
    }

    public Panda getPanda() {
        return panda;
    }

}
