package org.panda_lang.light.core.element.type;

import org.panda_lang.panda.core.Inst;

import java.util.ArrayList;
import java.util.Collection;

public class TypeRepresentation {

    private final Class<?> clazz;
    private final Type type;
    private final Collection<org.panda_lang.light.core.element.expression.ExpressionRepresentation> expressionRepresentations;

    public TypeRepresentation(Class<?> clazz, Type type) {
        this.clazz = clazz;
        this.type = type;
        this.expressionRepresentations = new ArrayList<>();
    }

    public void registerExpressionRepresentation(org.panda_lang.light.core.element.expression.ExpressionRepresentation expressionRepresentation) {
        expressionRepresentations.add(expressionRepresentation);
    }

    public Collection<org.panda_lang.light.core.element.expression.ExpressionRepresentation> getExpressionRepresentations() {
        return expressionRepresentations;
    }

    public Type<Inst> getType() {
        return type;
    }

    public Class<?> getClazz() {
        return clazz;
    }

}
