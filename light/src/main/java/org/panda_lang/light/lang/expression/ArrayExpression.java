package org.panda_lang.light.lang.expression;

public class ArrayExpression extends org.panda_lang.light.core.element.expression.Expression {

    @Override
    public Object getValue(org.panda_lang.light.core.Ray ray) {
        int i = ray.getExpressionValue(0);
        Object[] array = ray.getExpressionValue(1);

        i = i > 0 ? i - 1 : i;
        return i < array.length ? array[i] : null;
    }

}
