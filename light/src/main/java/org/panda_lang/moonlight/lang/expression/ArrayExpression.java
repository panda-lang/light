package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;

public class ArrayExpression extends Expression {

    @Override
    public Object getValue(Ray ray) {
        int i = ray.getExpressionValue(0);
        Object[] array = ray.getExpressionValue(1);

        i = i > 0 ? i - 1 : i;
        return i < array.length ? array[i] : null;
    }

}
