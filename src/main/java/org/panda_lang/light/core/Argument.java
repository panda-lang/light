package org.panda_lang.light.core;

public class Argument {

    private final Type type;
    private final Object object;

    public Argument(Type type, Object object) {
        this.type = type;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public Type getType() {
        return type;
    }

}
