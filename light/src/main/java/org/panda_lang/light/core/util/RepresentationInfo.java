package org.panda_lang.light.core.util;

public class RepresentationInfo {

    private org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation;
    private org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation;

    public org.panda_lang.light.core.element.expression.ExpressionRepresentation getExpressionRepresentation() {
        return expressionRepresentation;
    }

    public void setExpressionRepresentation(org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation) {
        this.expressionRepresentation = expressionRepresentation;
    }

    public org.panda_lang.light.core.element.phrase.PhraseRepresentation getPhraseRepresentation() {
        return phraseRepresentation;
    }

    public void setPhraseRepresentation(org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation) {
        this.phraseRepresentation = phraseRepresentation;
    }

}
