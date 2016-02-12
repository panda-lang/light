package org.panda_lang.light.core.parser.essential;

import org.panda_lang.light.core.parser.essential.assistant.ExpressionRepresentation;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionCenter {

    private final Collection<ExpressionRepresentation> expressions;

    public ExpressionCenter() {
        this.expressions = new ArrayList<>();
    }

    public void registerExpression(ExpressionRepresentation expressionRepresentation) {
        this.expressions.add(expressionRepresentation);
    }

    public Collection<ExpressionRepresentation> getExpressions() {
        return expressions;
    }

}
