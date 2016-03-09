package org.panda_lang.light.core.element.type;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.Expression;

public class Argument extends Expression {

    private final Type type;
    private final Object object;

    public Argument(Type type, Object object) {
        this.type = type;
        this.object = object;
    }

    @Override
    public Object getValue(Ray ray) {
        return getObject();
    }

    public Object getObject() {
        return object;
    }

    public Type getType() {
        return type;
    }

}
