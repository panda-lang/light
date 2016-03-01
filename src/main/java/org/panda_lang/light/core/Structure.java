package org.panda_lang.light.core;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Structure<T> extends Documentation implements Type<T> {

    protected final Collection<PhraseRepresentation> phraseRepresentations = new ArrayList<>();
    protected final Collection<ExpressionRepresentation> expressionRepresentations = new ArrayList<>();
    protected TypeRepresentation typeRepresentation;

    public abstract void initialize(LightCore lightCore);

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
