package org.panda_lang.light.core.parser;

import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.panda.core.syntax.Essence;

import java.util.HashMap;
import java.util.Map;

public class TypeCenter {

    private final Map<Class<? extends Essence>, TypeRepresentation> types;

    public TypeCenter() {
        this.types = new HashMap<>();
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        types.put(typeRepresentation.getClazz(), typeRepresentation);
    }

    public Map<Class<? extends Essence>, TypeRepresentation> getTypes() {
        return types;
    }

}
