package org.panda_lang.light.core.element.expression;

import java.util.List;

public class ExpressionModule {

    private ExpressionRepresentation expressionRepresentation;
    private List<ExpressionRuntime> expressionRuntimes;

    public void setExpressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        this.expressionRepresentation = expressionRepresentation;
    }

    public void setExpressionRuntimes(List<ExpressionRuntime> expressionRuntimes) {
        this.expressionRuntimes = expressionRuntimes;
    }

    public List<ExpressionRuntime> getExpressionRuntimes() {
        return expressionRuntimes;
    }

    public ExpressionRepresentation getExpressionRepresentation() {
        return expressionRepresentation;
    }

}
