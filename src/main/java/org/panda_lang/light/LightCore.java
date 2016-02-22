package org.panda_lang.light;

import org.panda_lang.light.core.memory.Variables;
import org.panda_lang.light.core.parser.ExpressionCenter;
import org.panda_lang.light.core.parser.PhraseCenter;
import org.panda_lang.light.core.parser.TypeCenter;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.light.lang.Expressions;
import org.panda_lang.light.lang.Phrases;
import org.panda_lang.panda.Panda;

public class LightCore {

    private final Panda panda;
    private final Light light;
    private final Variables variables;
    private final TypeCenter typeCenter;
    private final PhraseCenter phraseCenter;
    private final ExpressionCenter expressionCenter;

    public LightCore(Panda panda, Light light) {
        this.panda = panda;
        this.light = light;

        this.variables = new Variables(this);
        this.typeCenter = new TypeCenter();
        this.phraseCenter = new PhraseCenter();
        this.expressionCenter = new ExpressionCenter();
    }

    public void initialize() {
        LightBasis lightBasis = light.getLightBasis();
        lightBasis.loadParsers();
        lightBasis.loadBlocks();

        Phrases phrases = new Phrases(this);
        phrases.registerDefaultPhrases();

        Expressions expressions = new Expressions(this);
        expressions.registerDefaultExpressions();
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        typeCenter.registerType(typeRepresentation);
    }

    public void registerPhrase(PhraseRepresentation phraseRepresentation) {
        phraseCenter.registerPhrase(phraseRepresentation);
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        expressionCenter.registerExpression(expressionRepresentation);
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
