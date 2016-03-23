package org.panda_lang.moonlight.core.element;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.core.element.type.Type;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Structure<T> extends Documentation implements Type<T> {

    protected final Collection<PhraseRepresentation> phraseRepresentations = new ArrayList<>();
    protected final Collection<ExpressionRepresentation> expressionRepresentations = new ArrayList<>();
    protected TypeRepresentation typeRepresentation;

    public abstract void initialize(MoonlightCore moonlightCore);

    public void hookClass(Class<?> clazz) {
        typeRepresentation = new TypeRepresentation(clazz, this);
    }

    public void addPhraseRepresentation(PhraseRepresentation phraseRepresentation) {
        phraseRepresentations.add(phraseRepresentation);
    }

    public void addExpressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        expressionRepresentations.add(expressionRepresentation);
    }

    public Collection<ExpressionRepresentation> getExpressionRepresentations() {
        return expressionRepresentations;
    }

    public Collection<PhraseRepresentation> getPhraseRepresentations() {
        return phraseRepresentations;
    }

    public TypeRepresentation getTypeRepresentation() {
        return typeRepresentation;
    }

}
