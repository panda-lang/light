package org.panda_lang.moonlight.core.element.type;

import org.panda_lang.panda.core.syntax.Essence;

public class TypeRepresentation {

    private final Class<?> clazz;
    private final Type type;

    public TypeRepresentation(Class<?> clazz, Type type) {
        this.clazz = clazz;
        this.type = type;
    }

    public Type<Essence> getType() {
        return type;
    }

    public Class<?> getClazz() {
        return clazz;
    }

}
