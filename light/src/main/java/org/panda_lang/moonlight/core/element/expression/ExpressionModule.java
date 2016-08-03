package org.panda_lang.moonlight.core.element.expression;

import java.util.List;

public class ExpressionModule {

    private ExpressionRepresentation expressionRepresentation;
    private List<ExpressionRuntime> expressionRuntimes;

    public List<ExpressionRuntime> getExpressionRuntimes() {
        return expressionRuntimes;
    }

    public void setExpressionRuntimes(List<ExpressionRuntime> expressionRuntimes) {
        this.expressionRuntimes = expressionRuntimes;
    }

    public ExpressionRepresentation getExpressionRepresentation() {
        return expressionRepresentation;
    }

    public void setExpressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        this.expressionRepresentation = expressionRepresentation;
    }

}
