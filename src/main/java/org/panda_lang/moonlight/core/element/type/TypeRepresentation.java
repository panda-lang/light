package org.panda_lang.moonlight.core.element.type;

import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.panda.core.Essence;

import java.util.ArrayList;
import java.util.Collection;

public class TypeRepresentation {

    private final Class<?> clazz;
    private final Type type;
    private final Collection<ExpressionRepresentation> expressionRepresentations;

    public TypeRepresentation(Class<?> clazz, Type type) {
        this.clazz = clazz;
        this.type = type;
        this.expressionRepresentations = new ArrayList<>();
    }

    public void registerExpressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        expressionRepresentations.add(expressionRepresentation);
    }

    public Collection<ExpressionRepresentation> getExpressionRepresentations() {
        return expressionRepresentations;
    }

    public Type<Essence> getType() {
        return type;
    }

    public Class<?> getClazz() {
        return clazz;
    }

}
