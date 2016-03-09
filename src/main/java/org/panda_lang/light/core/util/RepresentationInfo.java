package org.panda_lang.light.core.util;

import org.panda_lang.light.core.element.expression.ExpressionRepresentation;
import org.panda_lang.light.core.element.phrase.PhraseRepresentation;

public class RepresentationInfo {

    private PhraseRepresentation phraseRepresentation;
    private ExpressionRepresentation expressionRepresentation;

    public void setPhraseRepresentation(PhraseRepresentation phraseRepresentation) {
        this.phraseRepresentation = phraseRepresentation;
    }

    public void setExpressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        this.expressionRepresentation = expressionRepresentation;
    }

    public ExpressionRepresentation getExpressionRepresentation() {
        return expressionRepresentation;
    }

    public PhraseRepresentation getPhraseRepresentation() {
        return phraseRepresentation;
    }

}
