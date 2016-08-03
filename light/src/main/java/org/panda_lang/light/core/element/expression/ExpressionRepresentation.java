package org.panda_lang.light.core.element.expression;

import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.lang.ObjectInst;

public class ExpressionRepresentation extends org.panda_lang.light.core.util.Representation<Expression> {

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

    public Inst getValue(org.panda_lang.light.core.Ray ray) {
        Object value = expression.getValue(ray);
        if (value instanceof Inst) {
            return (Inst) value;
        }
        return new ObjectInst(value);
    }

    public ExpressionType getExpressionType() {
        if (expression != null) {
            return ExpressionType.DEFAULT;
        }
        else if (expressionInitializer != null) {
            return ExpressionType.INITIALIZABLE;
        }
        else if (individualExpression != null) {
            return ExpressionType.INDIVIDUAL;
        }
        return null;
    }

    public IndividualExpression getIndividualExpression() {
        return individualExpression;
    }

    public ExpressionInitializer getExpressionInitializer() {
        return expressionInitializer;
    }

    public Expression getExpression() {
        return expression;
    }

}
