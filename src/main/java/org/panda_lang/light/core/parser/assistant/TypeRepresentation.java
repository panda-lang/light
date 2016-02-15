package org.panda_lang.light.core.parser.assistant;

import org.panda_lang.light.core.Type;
import org.panda_lang.panda.core.syntax.Essence;

public class TypeRepresentation extends Representation<Type> {

    private final Class<? extends Essence> clazz;

    public TypeRepresentation(Class<? extends Essence> clazz, Type representation) {
        super(representation);
        this.clazz = clazz;
    }

    public Class<? extends Essence> getClazz() {
        return clazz;
    }

}
