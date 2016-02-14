package org.panda_lang.light.core.parser.assistant;

import org.panda_lang.light.core.Type;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.util.documentation.Documentation;

public class TypeRepresentation {

    private final Type type;
    private final Class<? extends Essence> clazz;
    private final Documentation documentation;

    public TypeRepresentation(Class<? extends Essence> clazz, Type type) {
        this.type = type;
        this.clazz = clazz;
        this.documentation = new Documentation();
    }

    public Documentation documentation() {
        return documentation;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public Class<? extends Essence> getClazz() {
        return clazz;
    }

    public Type getType() {
        return type;
    }

}
