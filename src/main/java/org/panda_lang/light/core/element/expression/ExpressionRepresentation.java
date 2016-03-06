package org.panda_lang.light.core.element.expression;

import org.panda_lang.light.core.util.Representation;

public class ExpressionRepresentation extends Representation<Expression> {

    private Expression expression;
    private ExpressionInitializer expressionInitializer;
    private IndividualExpression individualExpression;

    public ExpressionRepresentation(Expression expression) {
        this.expression = expression;
    }

    public ExpressionRepresentation(ExpressionInitializer expressionInitializer) {
        this.expressionInitializer = expressionInitializer;
    }

    public ExpressionRepresentation(IndividualExpression individualExpression) {
        this.individualExpression = individualExpression;
    }

    public Expression getExpression() {
        return expression;
    }

}
