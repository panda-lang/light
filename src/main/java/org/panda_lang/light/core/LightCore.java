package org.panda_lang.light.core;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightBasis;
import org.panda_lang.light.core.parser.essential.ExpressionCenter;
import org.panda_lang.light.core.parser.essential.PhraseCenter;
import org.panda_lang.light.core.parser.essential.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.essential.assistant.PhraseRepresentation;
import org.panda_lang.light.lang.Phrases;
import org.panda_lang.panda.Panda;

public class LightCore {

    private final Panda panda;
    private final Light light;
    private final PhraseCenter phraseCenter;
    private final ExpressionCenter expressionCenter;

    public LightCore(Panda panda, Light light) {
        this.panda = panda;
        this.light = light;
        this.phraseCenter = new PhraseCenter();
        this.expressionCenter = new ExpressionCenter();
    }

    public void initialize() {
        LightBasis lightBasis = light.getLightBasis();
        lightBasis.loadParsers();
        lightBasis.loadBlocks();

        Phrases phrases = new Phrases(this);
        phrases.registerDefaultPhrases();
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

    public Light getLight() {
        return light;
    }

    public Panda getPanda() {
        return panda;
    }

}
