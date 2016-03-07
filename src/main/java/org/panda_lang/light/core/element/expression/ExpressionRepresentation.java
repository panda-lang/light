package org.panda_lang.light.core.element.expression;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.util.Representation;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.lang.ObjectEssence;

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

    public Essence getValue(Ray ray) {
        Object value = expression.getValue(ray);
        if (value instanceof Essence) {
            return (Essence) value;
        }
        return new ObjectEssence(value);
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
