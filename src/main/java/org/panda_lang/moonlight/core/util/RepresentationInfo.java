package org.panda_lang.moonlight.core.util;

import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;

public class RepresentationInfo {

    private PhraseRepresentation phraseRepresentation;
    private ExpressionRepresentation expressionRepresentation;

    public ExpressionRepresentation getExpressionRepresentation() {
        return expressionRepresentation;
    }

    public void setExpressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        this.expressionRepresentation = expressionRepresentation;
    }

    public PhraseRepresentation getPhraseRepresentation() {
        return phraseRepresentation;
    }

    public void setPhraseRepresentation(PhraseRepresentation phraseRepresentation) {
        this.phraseRepresentation = phraseRepresentation;
    }

}
