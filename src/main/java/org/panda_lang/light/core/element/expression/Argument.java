package org.panda_lang.light.core.element.expression;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.type.Type;
import org.panda_lang.panda.core.syntax.Essence;

public class Argument extends Expression {

    private final Type type;
    private final Object object;

    public Argument(Type type, Object object) {
        this.type = type;
        this.object = object;
    }

    @Override
    public Essence getValue(Ray ray) {
        return super.getValue(ray);
    }

    public Object getObject() {
        return object;
    }

    public Type getType() {
        return type;
    }

}
