package org.panda_lang.light.core.element.argument;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.Expression;

public class Argument extends Expression {

    private final Object object;

    public Argument(Object object) {
        this.object = object;
    }

    @Override
    public Object getValue(Ray ray) {
        return getObject();
    }

    public Object getObject() {
        return object;
    }

}
