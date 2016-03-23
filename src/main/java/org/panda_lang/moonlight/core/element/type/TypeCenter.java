package org.panda_lang.moonlight.core.element.type;

import java.util.HashMap;
import java.util.Map;

public class TypeCenter {

    private final Map<Class, TypeRepresentation> types;

    public TypeCenter() {
        this.types = new HashMap<>();
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        types.put(typeRepresentation.getClazz(), typeRepresentation);
    }

    public TypeRepresentation get(Class clazz) {
        return types.get(clazz);
    }

    public Map<Class, TypeRepresentation> getTypes() {
        return types;
    }

}
