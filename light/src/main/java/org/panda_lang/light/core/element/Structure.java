package org.panda_lang.light.core.element;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Structure<T> extends Documentation implements org.panda_lang.light.core.element.type.Type<T> {

    protected final Collection<org.panda_lang.light.core.element.phrase.PhraseRepresentation> phraseRepresentations = new ArrayList<>();
    protected final Collection<org.panda_lang.light.core.element.expression.ExpressionRepresentation> expressionRepresentations = new ArrayList<>();
    protected org.panda_lang.light.core.element.type.TypeRepresentation typeRepresentation;

    public abstract void initialize(LightCore lightCore);

    public void hookClass(Class<?> clazz) {
        typeRepresentation = new org.panda_lang.light.core.element.type.TypeRepresentation(clazz, this);
    }

    public void addPhraseRepresentation(org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation) {
        phraseRepresentations.add(phraseRepresentation);
    }

    public void addExpressionRepresentation(org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation) {
        expressionRepresentations.add(expressionRepresentation);
    }

    public void addExpressionRepresentation(String pattern, org.panda_lang.light.core.element.expression.Expression expression) {
        org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation = new org.panda_lang.light.core.element.expression.ExpressionRepresentation(expression);
        expressionRepresentation.pattern(pattern);
        addExpressionRepresentation(expressionRepresentation);
    }

    public void registerRepresentations(LightCore lightCore) {
        lightCore.registerType(typeRepresentation);
        for (org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation : phraseRepresentations) {
            lightCore.registerPhrase(phraseRepresentation);
        }
        for (org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation : expressionRepresentations) {
            lightCore.registerExpression(expressionRepresentation);
        }
    }

    public Collection<org.panda_lang.light.core.element.expression.ExpressionRepresentation> getExpressionRepresentations() {
        return expressionRepresentations;
    }

    public Collection<org.panda_lang.light.core.element.phrase.PhraseRepresentation> getPhraseRepresentations() {
        return phraseRepresentations;
    }

    public org.panda_lang.light.core.element.type.TypeRepresentation getTypeRepresentation() {
        return typeRepresentation;
    }

}
